
public class assembler_test {

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
		ALU_test.runTests();
		System.out.println("Memory tests");
		System.out.println("CPU test 1");
		cpu_test1.runTests();
		System.out.println("Assembler tests");
		runTests();

	}
	
	public static void runTests() {
		test_1();
		test_2();
		test_3();
	}

	public static void test_1() {
		System.out.println();
		System.out.println("Test 1:");
		String[] instructions = new String[13];
		String[] results = new String[13];
		instructions[0] = "and R1 R2 R3";
		instructions[1] = "or R4 R5 R6";
		instructions[2] = "xor R7 R8 R9";
		instructions[3] = "not R10 R11 R12";
		instructions[4] = "leftShift R13 R14 R15";
		instructions[5] = "rightShift R0 R1 R2";
		instructions[6] = "add R3 R4 R5";
		instructions[7] = "subtract R6 R7 R8";
		instructions[8] = "halt";
		instructions[9] = "move R1 5";
		instructions[10] = "interrupt 0";
		instructions[11] = "interrupt 1";
		instructions[12] = "multiply R9 R10 R11";
		results = assembler.assemble(instructions);
		
		for(int i = 0; i < results.length; i++) {
			System.out.println(instructions[i]);
			System.out.println(results[i]);
			System.out.println();
		}
	}
	
	public static void test_2() {
		System.out.println();
		System.out.println("Test 2:");
		String[] instructions = new String[13];
		String[] results = new String[13];
		instructions[0] = "and R4 R6 R1";
		instructions[1] = "or R2 R3 R7";
		instructions[2] = "xor R5 R9 R10";
		instructions[3] = "not R11 R3 R0";
		instructions[4] = "leftShift R1 R13 R4";
		instructions[5] = "rightShift R12 R15 R5";
		instructions[6] = "add R15 R2 R8";
		instructions[7] = "subtract R1 R6 R9";
		instructions[8] = "halt";
		instructions[9] = "move R11 30";
		instructions[10] = "interrupt 0";
		instructions[11] = "interrupt 1";
		instructions[12] = "multiply R1 R2 R3";
		results = assembler.assemble(instructions);
		
		for(int i = 0; i < results.length; i++) {
			System.out.println(instructions[i]);
			System.out.println(results[i]);
			System.out.println();
		}
	}
	
	public static void test_3() {
		System.out.println();
		System.out.println("Test 3:");
		String[] instructions = new String[13];
		String[] results = new String[13];
		instructions[0] = "and R15 R14 R13";
		instructions[1] = "or R12 R11 R10";
		instructions[2] = "xor R7 R8 R9";
		instructions[3] = "not R6 R5 R4";
		instructions[4] = "leftShift R3 R2 R1";
		instructions[5] = "rightShift R0 R15 R14";
		instructions[6] = "add R13 R12 R11";
		instructions[7] = "subtract R10 R9 R8";
		instructions[8] = "halt";
		instructions[9] = "move R7 100";
		instructions[10] = "interrupt 0";
		instructions[11] = "interrupt 1";
		instructions[12] = "multiply R6 R5 R4";
		results = assembler.assemble(instructions);
		
		for(int i = 0; i < results.length; i++) {
			System.out.println(instructions[i]);
			System.out.println(results[i]);
			System.out.println();
		}
	}
}
