package com.example.kotlinpractice

fun main() {
    val p = Person()
    p.show()
    //p.age = -20 // setterの例外発生
    p.age = 20
    println(p.isAdult)
}

/**
 * Personクラス
 * @property[name] 名前
 * @property[age] 年齢
 */
class Person() {
    var name = "名無権兵衛"
        private set // クラス内からのみ値を変えたいとき
    var age = 10
        // setterを定義
        set(value) {
            if (value <= 0) {
                throw IllegalArgumentException("ageは正の値で指定してください。")
            }
            field = value // バッキングフィールドでプロパティ値を渡す
        }
    val isAdult
        get() = age >= 20 // getterのみ設定し、読み取り専用
    /**
     * クラスの表示
     */
    fun show() {
        println("私は${name}です。${age}歳です。")
    }
}