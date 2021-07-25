package `class`

// 扩展是静态解析的
open class ExtensionShape
class ExtensionRectangle : ExtensionShape()

fun ExtensionShape.getName() = "Share"
fun ExtensionRectangle.getName() = "Rectangle"

// 我们想强调的是扩展函数是静态分发的，即他们不是根据接收者类型的虚方法。 这意味着调用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的
fun printClassName(s: ExtensionShape) {
    println(s.getName())
}

fun main(){
    printClassName(ExtensionRectangle())
    // out shape
    // 因为调用的扩展函数只取决于参数 s 的声明类型，该类型是 Shape 类
}