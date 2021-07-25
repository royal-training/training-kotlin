package `class`

// 继承中的 覆盖
// kotlin 中 如果你想要一个函数可以被 继承， 那么你需要在 父类 和 子类都进行声明

open class ExtendsSuper {
    //父类中 使用 open 来显示声明 可以被覆盖
    open fun draw() {}
    open var name : String = "super"
}


class ExtendsSon : ExtendsSuper() {
    // 子类中 需要 override 关键子 显式的是覆盖函数
    override fun draw() {
        super.draw()
    }

    override var name: String = "son"
}

// 多重覆盖
open class Rectangle {
    open fun draw(){}
}

// 接口的 默认是 open  函数也是
interface Polygon {
    fun draw() {}
}

class Square : Rectangle(), Polygon {
    override fun draw() {
        super<Polygon>.draw() // 通过泛型指定 使用哪个基类
        super<Rectangle>.draw()
    }
}

