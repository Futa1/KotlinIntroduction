package com.example.kotlinpractice

fun main() {
    val p = Person()
    p.show()
    //p.age = -20 // setterの例外発生
    p.age = 20
    println(p.isAdult)
    println("--------------------------")
    val p2 = Person2("山田太郎", 18)
    p2.show()
    println("--------------------------")
    val p4 = Person4()
    val p44 = Person4(name="名無し")
    val p444 = Person4(age=35)
    p4.show()
    p44.show()
    p444.show()
    println("--------------------------")
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

/**
 * コンストラクタの確認用クラス
 */
class Person2 constructor(name:String, age:Int) {
    // プロパティ定義
    var name:String
    var age:Int
    // initialization
    init {
        this.name = name
        this.age = age
    }

    fun show() {
        println("私は${this.name}です。${this.age}歳です。")
    }
}

/**
 * 初期化コードの簡易化＋セカンダリコンストラクタ
 */
class Person3(var name:String, var age:Int) {
    // セカンダリコンストラクタ
    constructor(name:String):this(name,16){}
    fun show() {
        println("私は${name}です。${age}歳です。")
    }
}

/**
 * 引数の既定値ありのコンストラクタ
 */
class Person4(var name:String = "山田太郎", var age:Int = 10) {
    fun show() {
        println("私は${name}です。${age}歳です。")
    }
}