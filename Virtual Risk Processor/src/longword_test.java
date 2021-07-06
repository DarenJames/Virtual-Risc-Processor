
public class longword_test {

	public static void main(String[] args) {
		/*System.out.println("Bit tests");
		bit_test.runTests();*/
		System.out.println("Longword tests");
		runTest();
	}
	
	public static void runTest() {
		testGetBit(new longword(0));
		testSetBit(new longword(0));
		testSet(new longword(0));
		testNot(new longword(0));
		testOr(new longword(0));
		testXor(new longword(0));
		testAnd(new longword(0));
		testCopy(new longword(0));
		testLeftShift(new longword(0));
		testRightShift(new longword(0));
		testGetUnsigned(new longword(0));
		testToString(new longword(0));
		testGetSigned(new longword(0));
	}
	
	public static void testGetBit(longword test) {
		bit bit_zero = new bit(0);
		bit bit_one = new bit(1);
		test.setBit(0, bit_zero);
		test.setBit(1, bit_one);
		test.setBit(2, bit_one);
		test.setBit(3, bit_zero);
		
		System.out.println("bit getBit(int i) test: ");
		System.out.println("Expected bit: 0 | Actual bit: " + test.getBit(0).getValue());
		System.out.println("Expected bit: 1 | Actual bit: " + test.getBit(1).getValue());
		System.out.println("Expected bit: 1 | Actual bit: " + test.getBit(2).getValue());
		System.out.println("Expected bit: 0 | Actual bit: " + test.getBit(3).getValue());
		System.out.println();
	}
	
	public static void testSetBit(longword test) {
		bit bit_zero = new bit(0);
		bit bit_one = new bit(1);
		test.setBit(0, bit_one);
		test.setBit(1, bit_one);
		test.setBit(2, bit_zero);
		test.setBit(3, bit_zero);
		
		System.out.println("bit setBit(int i, bit value) test: ");
		System.out.println("Expected bit: 1 | Actual bit: " + test.getBit(0).getValue());
		System.out.println("Expected bit: 1 | Actual bit: " + test.getBit(1).getValue());
		System.out.println("Expected bit: 0 | Actual bit: " + test.getBit(2).getValue());
		System.out.println("Expected bit: 0 | Actual bit: " + test.getBit(3).getValue());
		
		test.setBit(0, bit_zero);
		test.setBit(1, bit_zero);
		test.setBit(2, bit_one);
		test.setBit(3, bit_one);
		
		System.out.println("Expected bit: 0 | Actual bit: " + test.getBit(0).getValue());
		System.out.println("Expected bit: 0 | Actual bit: " + test.getBit(1).getValue());
		System.out.println("Expected bit: 1 | Actual bit: " + test.getBit(2).getValue());
		System.out.println("Expected bit: 1 | Actual bit: " + test.getBit(3).getValue());
		System.out.println();
	}
	
	public static void testSet(longword test) {
		System.out.println("set(int value) test:");
		
		test.set(0);
		System.out.println("Expected result: 00000000000000000000000000000000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(50);
		System.out.println("Expected result: 00000000000000000000000000110010");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(890);
		System.out.println("Expected result: 00000000000000000000001101111010");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-20);
		System.out.println("Expected result: 11111111111111111111111111101100");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-390);
		System.out.println("Expected result: 11111111111111111111111001111010");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
	}
	
	public static void testNot(longword test) {
		System.out.println("longword not() test:");
		longword negated = new longword(0);
		
		test.set(100);
		negated = test.not();
		System.out.println("Expected result: 11111111111111111111111110011011");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(negated.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(833);
		negated = test.not();
		System.out.println("Expected result: 11111111111111111111110010111110");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(negated.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-500);
		negated = test.not();
		System.out.println("Expected result: 00000000000000000000000111110011");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(negated.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(0);
		negated = test.not();
		System.out.println("Expected result: 11111111111111111111111111111111");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(negated.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
	}
	
	public static void testOr(longword test) {
		System.out.println("longword or(longword other) test:");
		longword or = new longword(300);
		
		test.set(100);
		or = or.or(test);
		System.out.println("Expected result: 00000000000000000000000101101100");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(or.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(423);
		or.set(9532);
		or = or.or(test);
		System.out.println("Expected result: 00000000000000000010010110111111");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(or.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-492);
		or.set(501);
		or = or.or(test);
		System.out.println("Expected result: 11111111111111111111111111110101");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(or.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-666);
		or.set(-682);
		or = or.or(test);
		System.out.println("Expected result: 11111111111111111111110101110110");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(or.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
	}

	public static void testXor(longword test) {
		System.out.println("longword xor(longword other) test:");
		longword xor = new longword(583);
		
		test.set(398);
		xor = xor.xor(test);
		System.out.println("Expected result: 00000000000000000000001111001001");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(xor.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(819);
		xor.set(712);
		xor = xor.xor(test);
		System.out.println("Expected result: 00000000000000000000000111111011");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(xor.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(492);
		xor.set(-117);
		xor = xor.xor(test);
		System.out.println("Expected result: 11111111111111111111111001100111");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(xor.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-520);
		xor.set(-142);
		xor = xor.xor(test);
		System.out.println("Expected result: 00000000000000000000001010001010");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(xor.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
	}

	public static void testAnd(longword test) {
		System.out.println("longword and(longword other) test:");
		longword and = new longword(748);
		
		test.set(395);
		and = and.and(test);
		System.out.println("Expected result: 00000000000000000000000010001000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(and.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(523);
		and.set(952);
		and = and.and(test);
		System.out.println("Expected result: 00000000000000000000001000001000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(and.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(537);
		and.set(-243);
		and = and.and(test);
		System.out.println("Expected result: 00000000000000000000001000001001");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(and.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-135);
		and.set(-682);
		and = and.and(test);
		System.out.println("Expected result: 11111111111111111111110101010000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(and.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
	}

	public static void testCopy(longword test) {
		System.out.println("copy(longword other) test:");
		longword copy = new longword(186);
		
		test.set(974);
		copy.copy(test);
		System.out.println("Expected result: 00000000000000000000001111001110");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(copy.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(547);
		copy.set(9632);
		copy.copy(test);
		System.out.println("Expected result: 00000000000000000000001000100011");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(copy.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(0);
		copy.set(582);
		copy.copy(test);
		System.out.println("Expected result: 00000000000000000000000000000000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(copy.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(987);
		copy.set(0);
		copy.copy(test);
		System.out.println("Expected result: 00000000000000000000001111011011");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(copy.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-235);
		copy.set(267);
		copy.copy(test);
		System.out.println("Expected result: 11111111111111111111111100010101");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(copy.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-7647);
		copy.set(-7328);
		copy.copy(test);
		System.out.println("Expected result: 11111111111111111110001000100001");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(copy.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
	}
	
	public static void testLeftShift(longword test) {
		System.out.println("longword leftShift(int amount) test:");
		
		test.set(587);
		test = test.leftShift(4);
		System.out.println("Expected result: 00000000000000000010010010110000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(800);
		test = test.leftShift(6);
		System.out.println("Expected result: 00000000000000001100100000000000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-487);
		test = test.leftShift(7);
		System.out.println("Expected result: 11111111111111110000110010000000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(16);
		test = test.leftShift(0);
		System.out.println("Expected result: 00000000000000000000000000010000");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
	}
	
	public static void testRightShift(longword test) {
		System.out.println("longword rightShift(int amount) test:");
		
		test.set(359);
		test = test.rightShift(3);
		System.out.println("Expected result: 00000000000000000000000000101100");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(600);
		test = test.rightShift(9);
		System.out.println("Expected result: 00000000000000000000000000000001");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
		
		test.set(-400);
		test = test.rightShift(4);
		System.out.println("Expected result: 11111111111111111111111111100111");
		System.out.print("Actual result:   ");
		for(int i = 31; i > -1; i--) {
			System.out.print(test.getBit(i).getValue());
		}
		System.out.println();
		System.out.println();
	}
	
	public static void testGetUnsigned(longword test) {
		System.out.println("long getUnsigned() test:");
		long result;
		
		test.set(0);
		result = test.getUnsigned();
		System.out.println("Expected result: 0");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		test.set(200);
		result = test.getUnsigned();
		System.out.println("Expected result: 200");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		test.set(420);
		result = test.getUnsigned();
		System.out.println("Expected result: 420");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		test.set(168);
		result = test.getUnsigned();
		System.out.println("Expected result: 168");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
	}
	
	public static void testToString(longword test) {
		System.out.println("String toString() test:");
		String result;
		
		test.set(0);
		result = test.toString();
		System.out.println("Expected result: 00000000000000000000000000000000");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		test.set(64);
		result = test.toString();
		System.out.println("Expected result: 00000000000000000000000001000000");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		test.set(375);
		result = test.toString();
		System.out.println("Expected result: 00000000000000000000000101110111");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		test.set(-208);
		result = test.toString();
		System.out.println("Expected result: 11111111111111111111111100110000");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
	}
	
	public static void testGetSigned(longword test) {
		System.out.println("int getSigned() test:");
		int result;
		
		test.set(0);
		System.out.println("Expected result: 0");
		System.out.print("Actual result:   ");
		result = test.getSigned();
		System.out.println(result);
		System.out.println();
		
		test.set(100);
		System.out.println("Expected result: 100");
		System.out.print("Actual result:   ");
		result = test.getSigned();
		System.out.println(result);
		System.out.println();
		
		test.set(52392);
		System.out.println("Expected result: 52392");
		System.out.print("Actual result:   ");
		result = test.getSigned();
		System.out.println(result);
		System.out.println();
		
		test.set(-1537);
		System.out.println("Expected result: -1537");
		System.out.print("Actual result:   ");
		result = test.getSigned();
		System.out.println(result);
		System.out.println();
		
		test.set(-195);
		System.out.println("Expected result: -195");
		System.out.print("Actual result:   ");
		result = test.getSigned();
		System.out.println(result);
		System.out.println();
	}
	
}
