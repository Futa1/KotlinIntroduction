package com.example.kotlinpractice

fun main(){
    val TRY_NUM = 5
    /*
    // 変数宣言方法を確認する
    var num1:Int = 108
    num1 = 100
    // 任意の型で変数宣言する
    var num2:Any = 108
    num2 = 100

    // 結果の表示
    println("num1: ${num1}")
    println("num2: ${num2}")


    // 文字列リテラル
    var msg = """
        >「Kotlin」は「コトリン」と読みます。
        >JetBrainsが開発したオブジェクト指向言語です。
        >Android Studio 3でサポートされます。
    """
    println(msg)
    println(msg.trimMargin(">"))

    // 文字列テンプレート
    var value = 10
    var data = arrayOf(100, 200, 300)
    println("value: ${value}")
    println("end of data: ${data[2]}")
    println("size of data: ${data.size}")
     */

    if (TRY_NUM == 1) {
        // null許容型
        var str:String? = "Hoge"
        str = null

        // セーフコール演算子
        trySafeCall(str)
        str = "あいうえお"
        trySafeCall(str)
    }

    // 明示的な型変換
    if (TRY_NUM == 2) {
        var i = 10
        var j: Long = i.toLong()
        println(i::class)
        println(j::class)
    }

    // 配列
    if (TRY_NUM == 3) {
        var data = arrayOf(1, 2, 3)
        var data2 = intArrayOf(1, 2, 3)
        // 空の配列を宣言
        var data3: Array<String?> = arrayOfNulls(5)
        // 配列要素を動的に生成するArrayコンストラクタ
        var data4 = Array(5, {i -> i * 3})
        // 配列要素の表示
        println(data[0])
        data[1] = 15
        println(data[1])
        data.forEach({ println(it) }) // itはラムダ式の予約語
        // data.forEach( {i -> println(i)} )と同じ
    }

    // コレクション
    if (TRY_NUM == 4) {
        // リスト
        var list: List<Int> = listOf(1, 2, 3)
        println(list)
        // Set
        var set: Set<String> = setOf("B", "C", "A", "B", "C")
        println(set)
        // Map
        var map: Map<String, Int> = mapOf("First" to 1, "Second" to 2, "Third" to 3)
        println(map)

        // 書き換え可能コレクション
        var list_mutable = mutableListOf(100, 500, 1000)
        list_mutable[2] = 0
        println(list_mutable)
    }

    // 定数
    // varではなくvalを使う
    if (TRY_NUM == 5) {
        val author = "WINGS Project"
        // author = "HogeHoge"は定数なのでエラー
        val arr = arrayOf(10, 20, 30)
        arr[0] = 1 // val宣言だが、配列要素の書き換えは可能
        arr.forEach( { println(it) } )
    }

}

/**
 * セーフコール演算子
 */
fun trySafeCall(str:String?):Unit {
    println(str?.length ?: 0) // ?:でnullでの値を設定
}
