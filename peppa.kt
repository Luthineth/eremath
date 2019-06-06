fun main(){
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val e = readLine()!!.toInt()
    val f = readLine()!!.toInt()
    val y = (d*c - f*a) / (-a*e+b*d)
    val x = (c - b*y) / a
    println("$y $x")
}