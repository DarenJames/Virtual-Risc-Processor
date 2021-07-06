
public class cpu_test1 {

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
		memory_test.runTests();
		System.out.println("CPU test 1");
		runTests();
	}

	public static void runTests() {
		test_1(new cpu());
		test_2(new cpu());
		test_3(new cpu());
		test_4(new cpu());
		test_5(new cpu());
	}

	private static void test_1(cpu cpu) {
		//Create program
		String[] instructions = new String[6];
		instructions[0] = "0001 0000 0000 0101"; // Move R0 5
		instructions[1] = "0001 0001 0001 0011"; // Move R1 19
		instructions[2] = "1110 0000 0001 0010"; // Add R0 R1 R2
		instructions[3] = "0010 0000 0000 0000"; // Interrupt 0
		instructions[4] = "0010 0000 0000 0001"; // Interrupt 1
		instructions[5] = "0000 0000 0000 0000"; // Halt
		//Call preload and run
		cpu.preload(instructions);
		cpu.run();
	}
	
	private static void test_2(cpu cpu) {
		//Create program
		String[] instructions = new String[7];
		instructions[0] = "0001 0000 0000 1010"; // Move R0 10
		instructions[1] = "0001 0001 0001 0100"; // Move R1 20
		instructions[2] = "1111 0001 0000 0010"; // Sub R1 R0 R2
		instructions[3] = "0001 0011 0000 0010"; // Move R3 2
		instructions[4] = "0010 0000 0000 0000"; // Interrupt 0
		instructions[5] = "0010 0000 0000 0001"; // Interrupt 1
		instructions[6] = "0000 0000 0000 0000"; // Halt
		//Call preload and run
		cpu.preload(instructions);
		cpu.run();		
	}
	
	private static void test_3(cpu cpu) {
		// TODO Auto-generated method stub
		
	}
	
	private static void test_4(cpu cpu) {
		// TODO Auto-generated method stub
		
	}
	
	private static void test_5(cpu cpu) {
		// TODO Auto-generated method stub
	}
	
}
