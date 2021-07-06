
public class cpu_test3 {

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
		cpu_test1.runTests();
		System.out.println("CPU test 2");
		cpu_test2.runTests();
		System.out.println("CPU test 3");
		runTests();
	}

	public static void runTests() {
		test_1(new cpu());
		test_2(new cpu());
		test_3(new cpu());
	}
	
	private static void test_1(cpu cpu) {
		String[] test1 = {"call 6", "interrupt 0", "halt", "interrupt 1", "return"};
		String[] assembledCode = assembler.assemble(test1);
		cpu.preload(assembledCode);
		cpu.run();
		System.out.println();
	}
	
	private static void test_2(cpu cpu) {
		String[] test1 = {"move R0 5", "move R1 10", "push R0", "push R1", "interrupt 1", "pop R2", "pop R3", "interrupt 0", "interrupt 1", "halt"};
		String[] assembledCode = assembler.assemble(test1);
		cpu.preload(assembledCode);
		cpu.run();
		System.out.println();
	}
	
	private static void test_3(cpu cpu) {
		String[] test1 = {"move R1 3", "move R2 4", "push R1", "push R2", "call 16", "pop R4", "interrupt 0", "halt", "pop R15", "pop R1", "pop R2", "add R1 R2 R3", "push R3", "push R15", "return"};
		String[] assembledCode = assembler.assemble(test1);
		cpu.preload(assembledCode);
		cpu.run();
		System.out.println();
	}
}
