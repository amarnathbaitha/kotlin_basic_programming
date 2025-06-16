package com.example.myspecial.application

import androidx.compose.ui.res.stringResource
import org.junit.Test

fun isEven(a:Int):String{
    return if (a % 2 == 0) "It's event" else "It's odd"
}

fun stringToInt(x:String):Int{
   return try {
        x.toInt()
    }catch (e: NumberFormatException){
        0
    }
}
class ExpressionTest{

    @Test
    fun ifAsExpressionTest(){
        println(isEven(2))
        println(isEven(3))
    }

    @Test
    fun tryCatchExpression(){
        println(stringToInt("5"))
        println(stringToInt("Amar"))
    }

}