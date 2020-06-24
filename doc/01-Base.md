
# 1. return 
在Java 中的 return 是直接返回函数的，在 Kotlin 由于有了匿名函数和lambda 如果我们只是想返回 lambda 和 匿名函数呢？
使用 label 功能来指定 return 到什么地方，注意 这里的return 并不是 break 功能（没有退出 foreach）

## return lambda
```Kotlin
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
```

## return foreach

```Kotlin
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
```