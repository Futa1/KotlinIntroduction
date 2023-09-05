package com.example.kotlinpractice

fun main() {
    println("--------------------------------------")
    println(getTriangleArea(5.0, 10.0))
    println("--------------------------------------")
    println(getTriangleArea2())
    println(getTriangleArea2(5.0, 10.0))
    println("--------------------------------------")
    println(product(5, 2, 4, 3))
    println("--------------------------------------")
    var list = intArrayOf(5, 2, 4, 3)
    println(product(*list)) // スプレッド演算子*によりarrayを渡せる
    println(product(2, *list, -1)) // 途中に入れることも可能
    println("--------------------------------------")
    val (sum:Int, avg:Double) = getSumAverage(58,75,98,82,89)
    val (_, avg2:Double) = getSumAverage(58,75,98,82,89) // sumが不要な時
    println("sum: ${sum}, avg: ${avg}, avg2: ${avg2}")
    println("--------------------------------------")
    // 高階関数の利用
    val list2 = intArrayOf(1, 2, 3, 4)
    list.forEach( {num:Int -> println(num)} ) // ラムダ式を活用して、メソッドに関数を与える
    // 以下、省略記法
    // list.forEach( {num -> println(num)} )
    // list.forEach() { num -> println(num) }
    // list.forEach { num -> println(num) }
    // list.forEach { println(it) } // 暗黙の引数itで受ける
    println("--------------------------------------")
    // ラムダ式でのreturn
    /* ラムダ式でのreturnは直上の関数(ここではmain関数)を抜ける
    list2.forEach {
        if (it > 3) return
        println(it)
    }
    println("終了しました")
    */

    list2.forEach loop@{
        if (it > 3) return@loop
        println(it)
    }
    println("終了しました")

    list2.forEach {
        if (it > 3) return@forEach
        println(it)
    }
    println("終了しました")
    println("--------------------------------------")
    val time = bechmark {
        var x = 1
        for (i in 1..10_000_000_000) {
            x++
        }
    }
    println("処理時間: ${time} ms")
    println("--------------------------------------")
}

/**
 * 三角形の面積を求める
 *
 * @param[width] 三角形の底辺の長さ
 * @param[height] 三角形の高さ
 * @return 面積の値
 */
fun getTriangleArea(width: Double, height: Double): Double {
    return width * height / 2
}
// 関数の本体が1行のみなら次のような省略も可能
// fun getTriangleArea(width: Double, height: Double): Double = width * height / 2
// fun getTriangleArea(width: Double. height: Double) = width * height / 2

/**
 * 引数に規定値アリの三角形の面積算出
 *
 * @param[width] 三角形の底辺の長さ
 * @param[height] 高さ
 * @return 面積
 */
fun getTriangleArea2(width:Double = 1.0, height:Double = 2.0):Double {
    return getTriangleArea(width=width, height=height)
}

/**
 * 可変長引数のサンプル関数
 * 引数[values]の要素valueの積を返す
 */
fun product(vararg values:Int):Int {
    var result = 1
    for (value in values) {
        result *= value
    }
    return result
}

/**
 * 複数の戻り値を与えるパターン
 * 引数[values]の総和と平均を返す
 */
fun getSumAverage(vararg values:Int):Pair<Int,Double> {
    var count:Double = 0.0
    var result:Int = 0
    for (value in values) {
        result += value
        count++
    }

    return Pair(result, result/count)
}

/**
 * 高階関数の自作
 * [action]で与える関数の処理時間を計測する
 */
fun bechmark(action:()->Unit):Long {
    val start = System.currentTimeMillis()
    action()
    val end = System.currentTimeMillis()
    return end - start
}