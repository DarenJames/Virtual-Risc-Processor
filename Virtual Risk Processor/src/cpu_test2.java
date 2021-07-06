
public class cpu_test2 {

	public static void main(String[] args) {
		/*System.out.println("Bit tests");
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
		cpu_test1.runTests();*/
		System.out.println("CPU test 2");
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
		String[] test1 = {"jump 4", "move R1 5", "interrupt 0", "halt"};
		String[] assembledCode = assembler.assemble(test1);
		cpu.preload(assembledCode);
		cpu.run();
		System.out.println();
	}
	
	private static void test_2(cpu cpu) {
		String[] test2 = {"move R0 5", "move R1 5", "move R2 100", "add R0 R1 R0", "compare R0 R2", "branchifnotequal -8", "interrupt 0", "halt"};
		String[] assembledCode = assembler.assemble(test2);
		cpu.preload(assembledCode);
		cpu.run();
		System.out.println();
	}
	
	private static void test_3(cpu cpu) {
		String[] test3 = {"move R0 2", "move R1 100", "multiply R0 R0 R0", "compare R1 R0", "branchifgreaterthan -8", "interrupt 0", "halt"};
		String[] assembledCode = assembler.assemble(test3);
		cpu.preload(assembledCode);
		cpu.run();
		System.out.println();
	}
	
	private static void test_4(cpu cpu) {
		String[] test4 = {};
		String[] assembledCode = assembler.assemble(test4);
		cpu.preload(assembledCode);
		cpu.run();
		System.out.println();
	}
	
	private static void test_5(cpu cpu) {
		String[] test5 = {};
		String[] assembledCode = assembler.assemble(test5);
		cpu.preload(assembledCode);
		cpu.run();
		System.out.println();
	}
	
}
