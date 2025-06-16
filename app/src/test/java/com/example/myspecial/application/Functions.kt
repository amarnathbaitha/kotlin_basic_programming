package com.example.myspecial.application


import org.junit.Test

fun multiply(a: Int,b: Int = 2):Int{
    return a * b
}
class FunctionsTest{

    // print the result of multiply
    @Test
    fun functionCreation(){
       println(multiply(2,3))
        // print the result of multiplication with named parameter
        println(multiply(a=2,b=4))
    }


    @Test
    fun functionDefaultValue(){
       // print the result of default parameter
        println(multiply( 5))
        // print the result of multiply function of default named parameter
        println(multiply(a=3))
    }
}