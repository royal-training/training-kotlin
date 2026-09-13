package function



fun interface SAMInterface {
    fun workHard(s: String, a: Int): Boolean
}

fun buildSAM(sam: SAMInterface) {
    sam.workHard("a", 10)
}

interface SingleMethodInterface {
    fun bye(hello: String)
}
 fun setListener(it: SingleMethodInterface){
    it.bye("back")
}

inline fun setKotlinBlock(back: (String)->Unit){
    back.invoke("block bye")
}

fun main() {
    buildSAM { a, b ->
        print("do work hard ")
        true
    }
    setListener(object : SingleMethodInterface{
        override fun bye(hello: String) {
            print("param:$hello")
        }
    })

    // 1. 直接传入 block
    setKotlinBlock {
        print("param:$it")
    }

    // 2. 使用 Function1 函数
    setKotlinBlock(object : Function1<String,Unit>{
        override fun invoke(p1: String) {
            print("param:$p1")
        }

    })

}