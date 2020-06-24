package basic

/**
 * 在 kotlin 中 if when 是支持返回值的
 */
class DemoIf {
    // 在 kotlin 中 if 表达式可以 返回一个值,
    // java 中是没有这种语法的
    val a = 1
    val b = 2
    val max = if (a > b) a else b
    // if 可以有代码块展开的, 最后一行是返回值
    val hasPint = if( a > b) {
        println(" a is max: $a")
        a
    } else {
        println(" b is max: $b")
        b
    }
    fun test() {
        println("if value: $hasPint")
    }
}

class DemoWhen {
    val index = 3
    val indexFlag = when(index) {
        1 -> "first"
        2 -> "second"
        3 -> "Third"
        4 -> "fourth"
        5 -> "fifth"
        else -> "over fifth"
    }
    fun test(){
        println("when value: $indexFlag")
    }
}

fun main() {
    DemoIf().test() // out
    DemoWhen().test()
}