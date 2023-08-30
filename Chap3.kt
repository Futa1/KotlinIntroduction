package com.example.kotlinpractice

/**
 * 演算子/制御構文
 */
fun main() {
    val CHAP = 7

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
        5 -> {
            /*
            型による分岐
             */
            val obj: Any = "ホげほげ"
            when (obj) {
                is String -> println(obj[0])
                is Int -> println(Math.abs(obj))
                else -> println("?")
            }
        }
        6 -> {
            /*
            引数を取らないwhen
             */
            val x = 10
            val y = 5
            when {
                x >= 10             -> println("x >= 10")
                x < 10 && y > 10    -> println("x < 10 && y > 10")
                else                -> println("else")
            }
        }
        7 -> {
            /*
            配列、コレクションの繰り返し処理
             */
            val arr = arrayOf("花鳥風月", "山紫水明", "百花繚乱")
            for (item in arr) {
                println(item)
            }
            // mapの受け取り
            val map = mapOf("1月" to "睦月", "2月" to "如月")
            for ((key, value) in map) {
                println("${key}: ${value}")
            }
            // 配列のインデックス受け取り
            for ((index, value) in arr.withIndex()) {
                println("${index}: ${value}")
            }
            // インデックスのみの取り出し
            for (index in arr.indices) {
                println(index)
            }

            // 指定回数の繰り返し
            for (i in 1..10) {
                println(i) // 1, 2, 3, ..., 10
            }
            // 末尾を含めない
            for (i in 1 until 10) {
                println(i) // 1, 2, 3, ..., 9
            }
            // デクリメント
            for (i in 10 downTo 1) {
                println(i) // 10, 9, ..., 1
            }
            // 増分
            for (i in 1..10 step 3) {
                println(i) // 1, 4, 7, 10
            }

            // ループの抜け出し
            var rst = 1
            val list = listOf(1, 5, 0, 10)
            for (item in list) {
                rst *= if (item != 0) {
                    item
                } else {
                    continue
                }
            }
            println(rst) // 50

            // 入れ子のループを抜ける(label)
            for (i in 1..9) {
                for (j in 1..9) {
                    if (i * j > 30) {
                        break
                    }
                    print("${i * j} ")
                }
                println()
            }
            outer@for (i in 1..9) {
                for (j in 1..9) {
                    if (i * j >30) {
                        break@outer
                    }
                    print("${i * j} ")
                }
                println()
            }
        }
        else -> {
            println("defaultの挙動")
        }
    }
}

