fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val e = readLine()!!.toInt()
    val f = readLine()!!.toInt()
    println("(${(a * e - b * d)}x^2 + ${(2 * a * f - 2 * c * d)}x + ${(b * f - c * e)})/($d*x^2 + $e*x + $f)^2")
}