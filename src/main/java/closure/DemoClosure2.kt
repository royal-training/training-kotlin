package closure


//斐波那契数列
fun fibonacci():()->Long{
    var first = 0L
    var second = 1L
    return fun():Long{ //返回返回值为Long类型的函数
        val result = second
        second += first
        first = second - first
        return result
    }
}

fun main() {
    val fibo = fibonacci() //此时，这个返回的函数fibo持有fibonnacci()函数内部变量的状态
    println(fibo())
    println(fibo())
    println(fibo())
    println(fibo())
    println(fibo())
}