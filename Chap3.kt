package com.example.kotlinpractice

/**
 * 演算子/制御構文
 */
fun main() {
    val CHAP = 2

    when (CHAP) {
        1 -> {
            /*
            連続する値を表す範囲演算子
             */
            val i = 10
            if (i in 1..20) {
                println("iは1~20の範囲にあります")
            }
        }
        2 -> {
            /*
            分岐命令
             */
            val x = 108
            if (x == 5) {
                println("x = 5")
            } else if (x == 10) {
                println("x = 10")
            } else {
                println("x != 5 and != 10")
            }
        }
        3 -> {
            /*
            if式で値を返せる
            このとき、elseは省略できない
            (デフォルト値がないとnullになるため)
             */
            val x = 108
            val msg = if (x == 5) {
                "x is 5"
            } else if (x == 10) {
                "x is 10"
            } else {
                "x is not 5 and not 10"
            }
            println(msg)
        }
        4 -> {
            /*
            条件の指定方法
             */
            val point = 75
            val rst = when (point) {
                100, 99           -> "合格！素晴らしい！"
                in 70..98   -> "合格です！"
                in 50..69   -> "不合格ですが、もう少し……"
                !in 50..100 -> "頑張りましょう"
                else              -> "不明な値です"
            }
            println(rst)
        }
        else -> {
            println("defaultの挙動")
        }
    }
}

