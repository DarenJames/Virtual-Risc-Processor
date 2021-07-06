
public class ALU_test {

	public static void main(String[] args) {
		System.out.println("Bit tests");
		bit_test.runTests();
		System.out.println("Longword tests");
		longword_test.runTest();
		System.out.println("Ripple Adder tests");
		rippleAdder_test.runTests();
		System.out.println("Multiplier test");
		multiplier_test.runTests();
		System.out.println("ALU tests");
		runTests();

	}
	public static void runTests() {
		testAnd(new longword(0), new longword(0));
		testOr(new longword(0), new longword(0));
		testXor(new longword(0), new longword(0));
		testNot(new longword(0), new longword(0));
		testLeftShift(new longword(0), new longword(0));
		testRightShift(new longword(0), new longword(0));
		testAdd(new longword(0), new longword(0));
		testSubtract(new longword(0), new longword(0));
		testMultiply(new longword(0), new longword(0));
	}
	
	public static void testAnd(longword a, longword b) {
		System.out.println("longword and(longword other) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit0 = new bit(0);
		bit operationbit1 = new bit(1);
		operation[0] = operationbit0;
		operation[1] = operationbit0;
		operation[2] = operationbit0;
		operation[3] = operationbit1;
		
		a.set(849);
		b.set(764);
		expectedResult.set(592);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-634);
		b.set(964);
		expectedResult.set(388);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(762);
		b.set(-875);
		expectedResult.set(144);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-485);
		b.set(-835);
		expectedResult.set(-999);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(784);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(-749);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
	
	public static void testOr(longword a, longword b) {
		System.out.println("longword or(longword other) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit0 = new bit(0);
		bit operationbit1 = new bit(1);
		operation[0] = operationbit1;
		operation[1] = operationbit0;
		operation[2] = operationbit0;
		operation[3] = operationbit1;
		
		a.set(437);
		b.set(643);
		expectedResult.set(951);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-749);
		b.set(963);
		expectedResult.set(-45);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(174);
		b.set(-583);
		expectedResult.set(-577);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-684);
		b.set(-804);
		expectedResult.set(-548);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(-764);
		expectedResult.set(-764);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(874);
		b.set(0);
		expectedResult.set(874);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
	
	public static void testXor(longword a, longword b) {
		System.out.println("longword xor(longword other) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit0 = new bit(0);
		bit operationbit1 = new bit(1);
		operation[0] = operationbit0;
		operation[1] = operationbit1;
		operation[2] = operationbit0;
		operation[3] = operationbit1;
		
		a.set(753);
		b.set(273);
		expectedResult.set(992);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(6534);
		b.set(-8466);
		expectedResult.set(-14488);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-35027);
		b.set(5327);
		expectedResult.set(-39966);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-5732);
		b.set(-3572);
		expectedResult.set(7056);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-5733);
		b.set(0);
		expectedResult.set(-5733);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(5320);
		expectedResult.set(5320);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
	
	public static void testNot(longword a, longword b) {
		System.out.println("longword not() test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit0 = new bit(0);
		bit operationbit1 = new bit(1);
		operation[0] = operationbit1;
		operation[1] = operationbit1;
		operation[2] = operationbit0;
		operation[3] = operationbit1;
		
		a.set(3057);
		b.set(2572073);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: 11111111111111111111010000001110");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-643);
		b.set(3432);
		expectedResult.set(642);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(3432);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: 11111111111111111111111111111111");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
	
	public static void testLeftShift(longword a, longword b) {
		System.out.println("longword leftShift(int amount) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit0 = new bit(0);
		bit operationbit1 = new bit(1);
		operation[0] = operationbit0;
		operation[1] = operationbit0;
		operation[2] = operationbit1;
		operation[3] = operationbit1;
		
		a.set(37520);
		b.set(0);
		expectedResult.set(37520);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(42695);
		b.set(3);
		expectedResult.set(341560);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(373);
		b.set(5);
		expectedResult.set(11936);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(455);
		b.set(343);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: 11100011100000000000000000000000");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(342);
		b.set(31);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: 00000000000000000000000000000000");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(3752);
		b.set(-3);
		System.out.println("Expected result: " + "Error: Please input a number greater than 0.");
		result = ALU.doOP(operation, a, b);
		System.out.println();
		System.out.println();
		
		a.set(3245);
		b.set(-523);
		System.out.println("Expected result: " + "Error: Please input a number greater than 0.");
		result = ALU.doOP(operation, a, b);
		System.out.println();
		System.out.println();
	}
	
	public static void testRightShift(longword a, longword b) {
		System.out.println("longword rightShift(int amount) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit0 = new bit(0);
		bit operationbit1 = new bit(1);
		operation[0] = operationbit1;
		operation[1] = operationbit0;
		operation[2] = operationbit1;
		operation[3] = operationbit1;
		
		a.set(5426);
		b.set(0);
		expectedResult.set(5426);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(65356);
		b.set(3);
		expectedResult.set(8169);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(373);
		b.set(6);
		expectedResult.set(5);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(5435);
		b.set(526);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(2000000000);
		b.set(31);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: 00000000000000000000000000000000");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(3752);
		b.set(-3);
		System.out.println("Expected result: " + "Error: Please input a number greater than 0.");
		result = ALU.doOP(operation, a, b);
		System.out.println();
		System.out.println();
		
		a.set(3245);
		b.set(-523);
		System.out.println("Expected result: " + "Error: Please input a number greater than 0.");
		result = ALU.doOP(operation, a, b);
		System.out.println();
		System.out.println();
	}
	
	public static void testAdd(longword a, longword b) {
		System.out.println("longword add(longword a, longword b) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit0 = new bit(0);
		bit operationbit1 = new bit(1);
		operation[0] = operationbit0;
		operation[1] = operationbit1;
		operation[2] = operationbit1;
		operation[3] = operationbit1;
		
		a.set(434);
		b.set(5474);
		expectedResult.set(5908);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-536);
		b.set(853);
		expectedResult.set(317);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(772);
		b.set(-352);
		expectedResult.set(420);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-643);
		b.set(-634);
		expectedResult.set(-1277);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-543);
		b.set(0);
		expectedResult.set(-543);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(523);
		expectedResult.set(523);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
	
	public static void testSubtract(longword a, longword b) {
		System.out.println("longword subtract(longword a, longword b) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit1 = new bit(1);
		operation[0] = operationbit1;
		operation[1] = operationbit1;
		operation[2] = operationbit1;
		operation[3] = operationbit1;
		
		a.set(537);
		b.set(547);
		expectedResult.set(-10);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(6536);
		b.set(5363);
		expectedResult.set(1173);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-3525);
		b.set(5256);
		expectedResult.set(-8781);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(6346);
		b.set(-525);
		expectedResult.set(6871);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-253);
		b.set(-754);
		expectedResult.set(501);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-253);
		b.set(0);
		expectedResult.set(-253);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(746);
		expectedResult.set(-746);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
	
	public static void testMultiply(longword a, longword b) {
		System.out.println("longword multiply(longword a, longword b) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		bit[] operation = new bit [4];
		bit operationbit0 = new bit(0);
		bit operationbit1 = new bit(1);
		operation[0] = operationbit1;
		operation[1] = operationbit1;
		operation[2] = operationbit1;
		operation[3] = operationbit0;
		
		a.set(10);
		b.set(10);
		expectedResult.set(100);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(234);
		b.set(532);
		expectedResult.set(124488);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(234);
		b.set(-253);
		expectedResult.set(-59202);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-345);
		b.set(754);
		expectedResult.set(-260130);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-385);
		b.set(-843);
		expectedResult.set(324555);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(352);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(-352);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(253);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(-567);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		a.set(0);
		b.set(0);
		expectedResult.set(0);
		result = ALU.doOP(operation, a, b);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
}
