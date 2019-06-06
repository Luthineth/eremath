fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val e = readLine()!!.toInt()
    val f = readLine()!!.toInt()
    println("${(4 * a * d)}x^3 + ${(3 * (a * e + b * d))}x^2 + ${(2 * (a * f + b * e + d * c))}x + ${(b * f + c * e)}")
}