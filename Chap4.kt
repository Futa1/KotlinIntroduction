package com.example.kotlinpractice

fun main() {
    println(getTriangleArea(5.0, 10.0))

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

