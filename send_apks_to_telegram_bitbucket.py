import os
import sys
import json
import argparse
import requests
from time import sleep
from pathlib import Path
from dataclasses import dataclass


@dataclass
class PullrequestArgs:
    author: str
    title: str
    description: str
    url: str


parser = argparse.ArgumentParser()
parser.add_argument("-token", type=str, required=True)
parser.add_argument("-names_ids", type=str, required=True)

# Необязательно
parser.add_argument("-pr_id", type=str, required=False)
parser.add_argument("-branch", type=str, required=False)
parser.add_argument("-tag", type=str, required=False)

parser.add_argument("-workspace", type=str, required=False)
parser.add_argument("-repo_slug", type=str, required=False)
parser.add_argument("-app_login", type=str, required=False)
parser.add_argument("-app_password", type=str, required=False)

print(f"args: {sys.argv}")
args = parser.parse_args()
print(f"parsed args: {args}")

telegram_names_ids = json.loads(args.names_ids)

folder = Path(__file__).parent

files = [
    folder / "app/build/outputs/bundle/release/app-release.aab",
    folder / "app/build/outputs/apk/release/app-release.apk",
    folder / "app/build/outputs/apk/debug/app-debug.apk",
]

def get_telegram_message_from_pr(pr_id):
    pr_args = get_pullrequest_args(pr_id)
    if pr_args.description:
        pr_description = pr_args.description.replace("\r", "").replace("\n\n", "\n")
        pr_description = f"---\n{pr_description}\n---\n"
    else:
        pr_description = ""
    msg = f"\n{pr_args.title} [{pr_id}]\n{pr_description}Author: {pr_args.author}"

    return f"{args.repo_slug}: pull request\n" + msg


def get_telegram_message_from_tag(tag):

    # Есть тэг, получить его анотацию по API
    auth = requests.auth.HTTPBasicAuth(
        args.app_login,
        args.app_password,
    )
    # В запросе API указать имя искомого тэга: q=name = "{tag}"
    url = f"https://api.bitbucket.org/2.0/repositories/{args.workspace}/{args.repo_slug}/refs/tags?q=name+%3D+%22{tag}%22"

    response = requests.request("GET", url, auth=auth)
    print(json.dumps(json.loads(response.text), sort_keys=True, indent=4, separators=(",", ": ")))
    result = response.json()
    items = [i for i in result["values"] if i["name"] == tag]
    if items:
        annotation = items[0]["message"]
    else:
        annotation = f"Аннотация для тэга {tag} не найдена"

    return f"{args.repo_slug}: tag [{tag}]\n{annotation}"


def get_telegram_message_from_branch(branch):
    return f"{args.repo_slug}:\n\nBranch: {branch}\n"


def get_telegram_message_default():
    return f"{args.repo_slug}:\n\nФайлы:\n"


def send(file_path, chat_id):
    with open(file_path, "rb") as f:
        res = requests.post(
            f"https://api.telegram.org/bot{args.token}/sendDocument",
            data={
                "chat_id": chat_id,
            },
            files={"document": f},
        )
        print(res.status_code)
        print(res.text)


def get_pullrequest_args(pr_id):

    auth = requests.auth.HTTPBasicAuth(
        args.app_login,
        args.app_password,
    )
    url = f"https://api.bitbucket.org/2.0/repositories/{args.workspace}/{args.repo_slug}/pullrequests/{pr_id}"
    response = requests.request("GET", url, auth=auth)
    print(json.dumps(json.loads(response.text), sort_keys=True, indent=4, separators=(",", ": ")))
    result = response.json()

    pr_args = PullrequestArgs(
        author=result["author"]["nickname"],
        title=result["title"],
        description=result["description"],
        url=f"https://bitbucket.org/{args.workspace}/{args.repo_slug}/pull-requests/{pr_id}",
    )

    return pr_args


if args.pr_id:
    telegram_message = get_telegram_message_from_pr(args.pr_id)
elif args.tag:
    telegram_message = get_telegram_message_from_tag(args.tag)
elif args.branch:
    telegram_message = get_telegram_message_from_branch(args.branch)
else:
    telegram_message = get_telegram_message_default()

for name, chat_id in telegram_names_ids.items():
    res = requests.post(
        f"https://api.telegram.org/bot{args.token}/sendMessage",
        json={"chat_id": chat_id, "text": telegram_message[:4096]},
    )
    for file_path in files:
        if os.path.exists(file_path):
            print(f"File path {file_path} exists. Sending to {name} [{chat_id}]")
            try:
                send(file_path, chat_id)
            except Exception as e:
                print(f"Exception: {e}. Retrying")
                sleep(1)
                send(file_path, chat_id)
