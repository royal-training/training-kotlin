package closure


//这是一个返回值为一个函数的高阶函数
fun makeFun():()->Unit{
    var conut = 0
    return fun(){ //返回一个匿名函数，这个函数持有count的状态
        println(++conut)
    }
}

fun main() {
    val makeFun = makeFun() //函数调用，返回一个函数
    makeFun() //调用这个返回的函数，此时makeFun持有makeFun()内部变量的状态
    makeFun()
    makeFun()
}

