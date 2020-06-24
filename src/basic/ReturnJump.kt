package basic

/**
 * 要注意 return 在 lambda 和匿名函数中的应用，之后返回 到 lambda 或者匿名函数的调用者。
 */
class DemoReturn {
    // return 默认 从 直接 包围他的函数或者 匿名函数返回的
    fun normalReturn() {
        arrayOf(1, 2, 34, 5, 6, 89).forEach {
            println("$it normal Return")
            if (it == 2) {
                return // 直接返回 normalReturn 调用， foreach 后面的不会执行了，是不会返回到 foreach lambda 的
            }
        }
        println("end normal Return")
    }

    fun forEachReturn() {
        arrayOf(1, 2, 34, 5, 6, 89).forEach {
            println("$it forEachReturn")
            if (it == 2) {
                //  这里的 return 是 返回到 lambda 的调用者，也就是 foreach ,
                //  所以 foreach 还是会继续执行， 仅仅只是当前 it == 2 的 lambda 返回了。
                return@forEach //
            }
        }
        println("end forEachReturn")
        /**
         * out
        1 forEachReturn
        2 forEachReturn
        34 forEachReturn
        5 forEachReturn
        6 forEachReturn
        89 forEachReturn
        end forEachReturn
         */

    }

    fun forEachReturnWithLoop() {
        arrayOf(1, 2, 34, 5, 6, 89).forEach loop@{
            println("$it forEachReturnWithLoop")
            if (it == 2) {
                // 这里使用了@forEach 可自定义 loop
                return@loop // 直接返回 normalReturn 调用， foreach 后面的不会执行了，是不会返回到 foreach lambda 的
            }
        }
        println("end forEachReturnWithLoop")

    }

    fun forEachReturnAnonymous() {
        arrayOf(1, 2, 34, 5, 6, 89).forEach(fun(it: Int) {
            println("$it forEachReturnAnonymous")
            if (it == 2) {
                //  这里的 return 是 返回到 匿名函数 的调用者，也就是 foreach ,
                //  所以 foreach 还是会继续执行， 仅仅只是当前 it == 2 的 匿名函数 返回了。
                return //
            }

        })
        println("end forEachReturnAnonymous")

    }

    // 很多场景下我们想直接 return 到 foreach 完成，可以用以下方法完成，也可以自己重新 forEach
    fun forEachReturnOut() {
        run loop@{
            arrayOf(1, 2, 34, 5, 6, 89).forEach(fun(it: Int) {
                println("$it forEachReturnOut")
                if (it == 2) {
                    //  这里的 return 是 返回到 匿名函数 的调用者，也就是 foreach ,
                    //  所以 foreach 还是会继续执行， 仅仅只是当前 it == 2 的 匿名函数 返回了。
                    return@loop//
                }

            })
        }
        println("end forEachReturnOut")
        // out
        // 1 forEachReturnOut
        //2 forEachReturnOut
        //end forEachReturnOut
    }

}

class DemoBreak {

    fun forLambda() {
        val intArray = arrayOf(1, 2, 34, 5, 6, 89)

        intArray.forEach {
            if (it == 5) {
                println(" $it is five")
                // 这里的forEach 是一个高级函数，参数 类型：action: (T) -> Unit  ，这里面 return 是 返回 lambda 的
            } else {
                println(" $it not five")
            }
        }

        // 可以单独定义 action
        val action: (Int) -> Unit = {
            if (it == 5) {
                println("action $it is five")
            } else {
                println("action: $it not five")
            }
        }

        intArray.forEach(action)

        // 有没有发现我们只能 return 外层函数 无法 contiue 或者 break ,因为 action 算不上 loop
        // 这里可以改写一下 foreach 实现
        intArray.forEachBreak {
            if (it == 5) {
                println("break $it is five")
                true
            } else {
                println("break: $it not five")
                false
            }
        }
    }

    fun breakLabel() {
        first@ for (i in 1..10) {
            println(" first: $i")
            for (j in 1..10) {
                println(" second: $i")
                if (j == 2) {
                    break@first
                }
            }
        }
        // 如果不加 label 定义，break 只能 break second
        println(" end breakLabel ")
    }


}

inline fun <T> Array<out T>.forEachBreak(action: (T) -> Boolean): Unit {
    for (el in this) {
        if (action(el)) {
            break
        }
    }
}

fun main() {
    DemoBreak().run {
        forLambda()
        breakLabel()
    }
    DemoReturn().run {
        normalReturn()
        forEachReturn()
        // forEachReturnWithLoop() //
        // forEachReturnAnonymous()//
        forEachReturnOut()
    }
}