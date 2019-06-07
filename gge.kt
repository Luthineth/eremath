import java.lang.Math.sqrt

fun main(args: Array<String>) {
    fun seconddegree (a: Double, b: Double, c: Double) {
        if (a.equals(0.0)) {
            if (b.equals(0.0)) {if (c.equals(0.0)) {println("any number")} else {println("no roots")}}
            else {val x1=(-c)/b; println(x1)}
        }
        else
        {val k=b*b-4*a*c
            val d = sqrt(k)
            if (k.equals(0.0)) {val x=-c;println(x)} else{
                if (k<0) {
                    println("no roots")} else {
                    val x1 = (-b + d) / (2 * a)
                    val x2 = (-b - d) / (2 * a)
                    if (x1.equals(x2)) {println(x1)} else {println(x1); println(x2)}
                }}
        }}
    val a=readLine()!!.toDouble()
    val b=readLine()!!.toDouble()
    val c=readLine()!!.toDouble()
    println(seconddegree(a,b,c))
}
