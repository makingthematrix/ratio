package io.github.makingthematrix.ratio

class RatioSuite extends munit.FunSuite:
	test("Create a rational out of two integers") {
		val r = Ratio(3, 4)
		assertEquals(r.toDouble, 0.75, 0.0001)
	}
	
	test("Create a rational out of one long") {
		val r = Ratio(5L)
		assertEquals(r.toDouble, 5.0, 0.0001)
	}
	
	test("Create a rational out of one int") {
		val r = Ratio(5)
		assertEquals(r.toDouble, 5.0, 0.0001)
	}
	
	// Addition tests
	test("Addition of two rationals") {
		val r1 = Ratio(1, 2)
		val r2 = Ratio(1, 3)
		val result = r1 + r2
		assertEquals(result.toDouble, 5.0/6.0, 0.0001)
	}
	
	test("Addition of rational and long") {
		val r = Ratio(1, 2)
		val result = r + 2L
		assertEquals(result.toDouble, 2.5, 0.0001)
	}
	
	test("Addition of rational and int") {
		val r = Ratio(1, 2)
		val result = r + 2
		assertEquals(result.toDouble, 2.5, 0.0001)
	}
	
	// Subtraction tests
	test("Subtraction of two rationals") {
		val r1 = Ratio(3, 4)
		val r2 = Ratio(1, 4)
		val result = r1 - r2
		assertEquals(result.toDouble, 0.5, 0.0001)
	}
	
	test("Subtraction of rational and long") {
		val r = Ratio(5, 2)
		val result = r - 2L
		assertEquals(result.toDouble, 0.5, 0.0001)
	}
	
	test("Subtraction of rational and int") {
		val r = Ratio(5, 2)
		val result = r - 2
		assertEquals(result.toDouble, 0.5, 0.0001)
	}
	
	// Multiplication tests
	test("Multiplication of two rationals") {
		val r1 = Ratio(2, 3)
		val r2 = Ratio(3, 4)
		val result = r1 * r2
		assertEquals(result.toDouble, 0.5, 0.0001)
	}
	
	test("Multiplication of rational and long") {
		val r = Ratio(2, 3)
		val result = r * 3L
		assertEquals(result.toDouble, 2.0, 0.0001)
	}
	
	test("Multiplication of rational and int") {
		val r = Ratio(2, 3)
		val result = r * 3
		assertEquals(result.toDouble, 2.0, 0.0001)
	}
	
	// Division tests
	test("Division of two rationals") {
		val r1 = Ratio(2, 3)
		val r2 = Ratio(3, 4)
		val result = r1 / r2
		assertEquals(result.toDouble, (2.0/3.0)/(3.0/4.0), 0.0001)
	}
	
	test("Division of rational and long") {
		val r = Ratio(2, 3)
		val result = r / 2L
		assertEquals(result.toDouble, 2.0/3.0, 0.0001)
	}
	
	test("Division of rational and int") {
		val r = Ratio(2, 3)
		val result = r / 2
		assertEquals(result.toDouble, 2.0/3.0, 0.0001)
	}
	
	// Unary minus test
	test("Unary minus") {
		val r = Ratio(2, 3)
		val result = -r
		assertEquals(result.toDouble, -2.0/3.0, 0.0001)
	}
	
	// Comparison tests
	test("Equality comparison") {
		val r1 = Ratio(2, 3)
		val r2 = Ratio(2, 3)
		val r3 = Ratio(1, 2)
		val r4 = Ratio(2, 4)
		val res = r3 === r4
		assert(r1 === r2)
		assert(r1 !== r3)
		assert(r3 === r4)
	}
	
	test("Less than comparison") {
		val r1 = Ratio(1, 3)
		val r2 = Ratio(1, 2)
		assert(r1 < r2)
		assert(!(r2 < r1))
	}
	
	test("Greater than comparison") {
		val r1 = Ratio(2, 3)
		val r2 = Ratio(1, 3)
		assert(r1 > r2)
		assert(!(r2 > r1))
	}
	
	test("Less than or equal comparison") {
		val r1 = Ratio(1, 3)
		val r2 = Ratio(1, 2)
		val r3 = Ratio(1, 3)
		assert(r1 <= r2)
		assert(r1 <= r3)
		assert(!(r2 <= r1))
	}
	
	test("Greater than or equal comparison") {
		val r1 = Ratio(2, 3)
		val r2 = Ratio(1, 3)
		val r3 = Ratio(2, 3)
		assert(r1 >= r2)
		assert(r1 >= r3)
		assert(!(r2 >= r1))
	}
	
	// Conversion tests
	test("toDouble conversion") {
		val r = Ratio(1, 2)
		assertEquals(r.toDouble, 0.5, 0.0001)
	}
	
	test("toInt conversion") {
		val r1 = Ratio(5, 2)
		val r2 = Ratio(1, 2)
		assertEquals(r1.toInt, 2)
		assertEquals(r2.toInt, 0)
	}
	
	test("toLong conversion") {
		val r1 = Ratio(5, 2)
		val r2 = Ratio(1, 2)
		assertEquals(r1.toLong, 2L)
		assertEquals(r2.toLong, 0L)
	}
	
	// Reduce test
	test("reduce method") {
		val r1 = Ratio(4, 8)
		val reduced: Ratio = r1.reduce
		assertEquals(reduced.numerator, 1L)
		assertEquals(reduced.denominator, 2L)
		assert(reduced === r1)
		assertEquals(reduced.toDouble, 0.5, 0.0001)
		
		val r2 = Ratio(15, 25)
		val reduced2 = r2.reduce
		assertEquals(reduced2.numerator, 3L)
		assertEquals(reduced2.denominator, 5L)
		assert(reduced2 === r2)
		assertEquals(reduced2.toDouble, 0.6, 0.0001)
	}
	
	// Ratio.from tests
	test("from method with default precision") {
		val r = Ratio.from(0.75)
		assertEquals(r.toDouble, 0.75, 0.0001)
	}
	
	test("from method with custom precision") {
		val r = Ratio.from(0.3333, 4)
		assertEquals(r.toDouble, 0.3333, 0.0001)
	}
	
	// Ratio.str test
	test("str method") {
		val r = Ratio(3, 4)
		assertEquals(Ratio.str(r), "3/4")
		
		val r2 = Ratio(5, 1)
		assertEquals(Ratio.str(r2), "5/1")
	}
	
	// Ratio.gcd tests
	test("gcd method with two longs") {
		assertEquals(Ratio.gcd(12L, 8L), 4L)
		assertEquals(Ratio.gcd(17L, 5L), 1L)
		assertEquals(Ratio.gcd(0L, 5L), 5L)
	}
	
	test("gcd method with Ratio") {
		val r = Ratio(12, 8)
		assertEquals(Ratio.gcd(r), 4L)
		
		val r2 = Ratio(17, 5)
		assertEquals(Ratio.gcd(r2), 1L)
	}
	
	// Ratio.lcm tests
	test("lcm method with two longs") {
		assertEquals(Ratio.lcm(4L, 6L), 12L)
		assertEquals(Ratio.lcm(5L, 7L), 35L)
	}
	
	test("lcm method with Ratio") {
		val r = Ratio(4, 6)
		assertEquals(Ratio.lcm(r), 12L)
		
		val r2 = Ratio(5, 7)
		assertEquals(Ratio.lcm(r2), 35L)
	}
	
	// Ratio.unapply test
	test("unapply method for pattern matching") {
		val r = Ratio(3, 4)
		
		// Use pattern matching with Ratio extractor
		val Ratio(num, denom) = r
		
		// Verify extracted values
		assertEquals(num, 3L)
		assertEquals(denom, 4L)
		
		// Test with different values
		val r2 = Ratio(5, 7)
		val Ratio(num2, denom2) = r2
		
		assertEquals(num2, 5L)
		assertEquals(denom2, 7L)
	}
