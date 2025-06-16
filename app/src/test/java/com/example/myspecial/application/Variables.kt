package com.example.myspecial.application

import org.junit.Test

class VariableTest{

    @Test
    fun readOnly(){
        val name = "Amar"
        //name = "Honey"
        println(name)
    }

    @Test
    fun mutable(){
        var name = "Amar"
        name = "Honey"
        println(name)
    }
}