package closure


//这是一个返回值为一个函数的高阶函数
fun makeFun():()->Unit{
    var conut = 0
    return { //返回一个匿名函数，这个函数持有count的状态
        println(++conut)
    }
}
fun main() {
    // 函数调用，返回一个函数
    val make = makeFun()
    make() // out: 1
    make() // out: 2
    make() // out: 3

    val makeDouble = makeFun()
    makeDouble() // out: 1
    makeDouble() // out: 2
    makeDouble() // out: 3
}

