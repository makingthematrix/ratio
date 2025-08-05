package io.github.makingthematrix.ratio

import scala.annotation.tailrec

opaque type Ratio = (p: Long, q: Long)

extension (r: Ratio)
  inline def numerator: Long = r.p
  inline def denominator: Long = r.q

  inline def +(s: Ratio): Ratio = if r.q == s.q then (p = r.p + s.p, q = r.q) else (p = r.p * s.q + s.p * r.q, q = r.q * s.q)
  inline def +(s: Long) : Ratio = (p = r.p + s * r.q, q = r.q)
  inline def +(s: Int)  : Ratio = (p = r.p + s * r.q, q = r.q)
  inline def -(s: Ratio): Ratio = if r.q == s.q then (p = r.p - s.p, q = r.q) else (p = r.p * s.q - s.p * r.q, q = r.q * s.q)
  inline def -(s: Long) : Ratio = (p = r.p - s * r.q, q = r.q)
  inline def -(s: Int)  : Ratio = (p = r.p - s * r.q, q = r.q)
  inline def *(s: Ratio): Ratio = (p = r.p * s.p, q = r.q * s.q)
  inline def *(s: Long) : Ratio = (p = r.p * s, q = r.q)
  inline def *(s: Int)  : Ratio = (p = r.p * s, q = r.q)
  inline def /(s: Ratio): Ratio = (p = r.p * s.q, q = r.q * s.p)
  inline def /(s: Long) : Ratio = (p = r.p, q = r.q * s)
  inline def /(s: Int)  : Ratio = (p = r.p, q = r.q * s)
  inline def unary_-    : Ratio = (p = -r.p, q = r.q)

  inline def ===(s: Ratio): Boolean = (r.p == s.p && r.q == s.q) || (r.p * s.q == s.p * r.q)
  inline def !==(s: Ratio): Boolean = !(r === s)
  inline def <(s: Ratio)  : Boolean = if r.q == s.q then r.p < s.p else r.p * s.q < s.p * r.q
  inline def >(s: Ratio)  : Boolean = if r.q == s.q then r.p > s.p else r.p * s.q > s.p * r.q
  inline def <=(s: Ratio) : Boolean = if r.q == s.q then r.p <= s.p else r.p * s.q <= s.p * r.q
  inline def >=(s: Ratio) : Boolean = if r.q == s.q then r.p >= s.p else r.p * s.q >= s.p * r.q

  inline def toDouble: Double = r.p.toDouble / r.q
  inline def toLong  : Long   = r.p / r.q
  inline def toInt   : Int    = toLong.toInt

  def reduce: Ratio =
    val g = Ratio.gcd(r)
    (r.p / g, r.q / g)

object Ratio:
  inline def apply(p: Long, q: Long): Ratio = (p, q)
  inline def apply(p: Long): Ratio = (p, 1L)
  inline def apply(p: Int): Ratio = (p.toLong, 1L)
  inline def unapply(r: Ratio): (Long, Long) = (r.p, r.q)
  def from(d: Double, precision: Int = 8): Ratio =
    val x = if precision < pOf10.length then pOf10(precision) else pOf10.last
    val p = (d * x.toDouble).toLong
    val g = gcd(p, x)
    (p / g, x / g)

  inline def str(r: Ratio): String = s"${r.p}/${r.q}"

  @tailrec def gcd(a: Long, b: Long): Long = if b == 0 then a else gcd(b, a % b)
  inline def gcd(a: Ratio): Long = gcd(a.p, a.q)

  inline def lcm(a: Long, b: Long): Long = a * b / gcd(a, b)
  inline def lcm(a: Ratio): Long = lcm(a.p, a.q)

  private val pOf10: Array[Long] = Array(
		1L,
		10L,
		100L,
		1000L,
		10000L,
		100000L,
		1000000L,
		10000000L,
		100000000L,
		1000000000L,
		10000000000L,
		100000000000L,
		1000000000000L,
		10000000000000L,
		100000000000000L,
		1000000000000000L,
		10000000000000000L,
		100000000000000000L,
		1000000000000000000L
	)
