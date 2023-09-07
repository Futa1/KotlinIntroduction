package com.example.kotlinpractice

/**
 * 継承可能なクラスPerson
 */
open class Person(var name:String = "名無権兵衛"){
    open fun show():String{
        return "私は${this.name}です。"
    }
}

/**
 * Personを継承
 */
class BusinessPerson(name:String, var depart:String):Person(name){
    // show methodのオーバーライド
    override fun show():String{
        return "${super.show()} 部署は${this.depart}です。"
    }
}

/**
 * 抽象クラス
 */
abstract class Figure(var width:Double, var height:Double){
    // 図形の面積を求める
    abstract fun getArea():Double
}

/**
 * 抽象クラスを継承＋定義
 */
class Triangle(width:Double, height:Double):Figure(width, height){
    override fun getArea(): Double {
        return this.width * this.height / 2
    }
}

fun main(){
    val bp = BusinessPerson("山田太郎", "営業")
    println(bp.show())
    println("--------------------")
    val t = Triangle(10.0, 20.0)
    println(t.getArea())
    println("--------------------")

}