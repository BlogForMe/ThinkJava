fun main() {
    val total  = "Mississippi".count()
    //通过匿名函数给标准函数 制定规则
    val totalS = "Mississippi".count({letter-> //letter变量
        letter =='s'//函数体
    })

    val totalS1 = "Mississippi".count{letter-> //letter变量
        letter =='s'//函数体
    }
    println(total)
    println(totalS)

    //变量的类型是一个匿名函数,一个函数类型的变量
    val helloFunction:()->String //任意函数 无传入参数，返回类型String ,都可以 =helloFunction
    helloFunction = {
        val greet = " how  is going. "
        "hello girl , $greet "  //默认返回这行语句的结果
    }

    val helloFunction1:()->String = {//任意函数 无传入参数，返回类型String ,都可以 =helloFunction
        val greet = " how is going. "
        val hah = "haha"
        "hello beauty girl, $greet " //默认返回这行语句的结果
    }

    println(helloFunction())
    println(helloFunction1())

    /**
     * 匿名函数参数
     */
    val helloFunction2:(String)->String = {name->   // name传入参数,String参数类型
        val hah = "haha"
        "hello beauty girl, I am ${name} " //默认返回这行语句的结果
    }
    println(helloFunction2("Jon"))


    val helloFunction3:(String)->String = {   // name传入参数,String参数类型, 只有一个参数name可以省略，用it替代
        val hah = "haha"
        "hello beauty girl, I am ${it} " //默认返回这行语句的结果
    }
    println(helloFunction3("John"))


    val helloFunction4 = {
        val holiday = "New Year"
        "Happy $holiday"
    }
    println(helloFunction4())



    val helloFunction5:(String,Int) -> String = {name,year ->
        val holiday = "New Year"
        "$name  Happy $holiday $year"
    }
    println(helloFunction5("jon",2023))

    //使用类型推断
    val helloFunction6  = {name:String,year:Int ->
        val holiday = "New Year"
        "$name  Happy $holiday $year"
    }
    println(helloFunction6("jon",2023))





}