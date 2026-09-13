package main.java

import java.text.SimpleDateFormat
import java.util.*

fun main() {
    formatTitle(1636160690225045)
}
fun formatTitle(time: Long): String{
    val cal = Calendar.getInstance()
    println("cal:" + cal.timeInMillis)
    cal.timeInMillis = time.div(1000)

    val sm = SimpleDateFormat("YYMMddHHmmssSSSS")
    val re = sm.format(cal.time)
    print("$time = format: $re")
    return re
}

fun formatTime(str: String): Long{
    val sm = SimpleDateFormat("YYYY/MM/dd HH:mm:ss")
    val time = sm.parse(str)
    println("$str = parse: ${time.time}")
    return time.time
}
class CalendarDemo {
}