package app1.win.app1.win.sport1.win1.win.india1.xbet.win


import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import java.util.*


internal class adaptGame(
    private val contextViews: Context,
    private val Calls: Int,
    private val Random: Int
) :
    BaseAdapter() {
    private val PageView // массив картинок
            : ArrayList<String?>
    private val PC // Префикс набора картинок
            : String
    private val getRes // Ресурсы приложени
            : Resources

    private enum class Status {
        opens, close, delete
    }

    private val checkStatusImg // состояние ячеек
            : ArrayList<Status>

    init {
        PageView = ArrayList()
        checkStatusImg = ArrayList()

        PC = "sport"

        getRes = contextViews.resources

        postImg()

        checCloseImg()
    }

    private fun postImg() {
        PageView.clear()
        for (i in 0 until Calls * Random / 2) {
            PageView.add(PC + Integer.toString(i))
            PageView.add(PC + Integer.toString(i))
        }
        Collections.shuffle(PageView)
    }

    private fun checCloseImg() {
        checkStatusImg.clear()
        for (i in 0 until Calls * Random) checkStatusImg.add(Status.close)
    }

    override fun getCount(): Int {
        return Calls * Random
    }

    override fun getItem(position: Int): Any? {
        // TODO Auto-generated method stub
        return null
    }

    override fun getItemId(position: Int): Long {
        // TODO Auto-generated method stub
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: ImageView =
            if (convertView == null) ImageView(contextViews) else convertView as ImageView // выводиться у нас будет картинка
        when (checkStatusImg[position]) {
            Status.opens -> {
                // Получаем идентификатор ресурса для картинки, которая находится в векторе vecPict на позиции position
                val drawableId =
                    getRes.getIdentifier(PageView[position], "drawable", contextViews.packageName)
                view.setImageResource(drawableId)
            }
            Status.close -> view.setImageResource(R.drawable.closecard)
            else -> view.setImageResource(R.drawable.delete)
        }
        return view
    }

    fun checkedstatposition() {
        val one = checkStatusImg.indexOf(Status.opens)
        val two = checkStatusImg.lastIndexOf(Status.opens)
        if (one == two) return
        if (PageView[one] == PageView[two]) {
            checkStatusImg[one] = Status.delete
            checkStatusImg[two] = Status.delete
        } else {
            checkStatusImg[one] = Status.close
            checkStatusImg[two] = Status.close
        }
        return
    }

    fun positionOpen(position: Int): Boolean {
        if (checkStatusImg[position] === Status.delete || checkStatusImg[position] === Status.opens) return false
        if (checkStatusImg[position] !== Status.delete) checkStatusImg[position] = Status.opens
        notifyDataSetChanged()
        return true
    }

    fun gmovers(): Boolean {
        return if (checkStatusImg.indexOf(Status.close) < 0) true else false
    }
}