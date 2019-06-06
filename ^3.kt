import java.lang.Math.pow
import java.lang.Math.sqrt
import kotlin.math.sqrt
import kotlin.math.pow

fun main(args: Array<String>){
    val answers: Array<Int> = emptyArray()
    var a: Int
    var b: Int
    var c: Int
    var d: Int
    thirdDegree(1, -3, 3, -1)
}
fun secondDegree(b: Int,c: Int, d: Int){
    print("secondDegree")
}
fun thirdDegree(a: Int, b: Int,c: Int, d: Int): Int{
    var w: Double = 3.toDouble()
    var w2 : Double
    var w3:Double
    var d1 = 0
    var d2 = 0
    var d3 = 0
    var c = 0
    var u: Double
    var n: Double
    var x = 0
    if (a == 0){
        secondDegree(b,c, d)
    } else {
        if (d == 0) {
            print("0 является корнем")
            secondDegree(a,b,c)
        }
        else{
            d1 = b*b - 3 * a * c
            d2 = 2 * b * b - 9 * a * b + 27 * a * a * d
            d3 = (d2 * d2 - 4 * d1 * d1 * d1) / (-27 * (a * a))
            w2 = (((d2 * d2 - 4 * d1 * d1 * d1 ) + d2)/2).toDouble()
            c = pow(w2, (1/3).toDouble()).toInt()
            c.toDouble()
            w3 = sqrt(w)
            u = (-1 + w3) / 2
            for (n in 1..3) {
                x = (-(b + pow(u, n) * c + d1 / (pow(u, n) * c)) / (3 * a))
                if (a * x * x * x + b * x * x + c * x + d) {
                    print("$x является корнем")
                }

            }
        }
    }
}
}
