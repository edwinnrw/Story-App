package id.edwinnurwansyah.telkomcase.presentation.util

import android.view.View
import java.text.SimpleDateFormat
import java.util.*

const val DETAIL_REQUEST = 1

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}
fun changeFormatDate(milisSecond:Long) :String{

    val simple = SimpleDateFormat("dd MMM yyyy")

    val result = Date(milisSecond*1000)

    return simple.format(result)
}