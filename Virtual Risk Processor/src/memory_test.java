
public class memory_test {

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
		ALU_test.runTests();*/
		System.out.println("Memory tests");
		runTests();

	}
	
	public static void runTests() {
		testRead(new longword(0));
		testWrite(new longword(0), new longword(0));
	}

	public static void testRead(longword address) {
		System.out.println("longword read(longword address) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		longword value = new longword(0);
		
		address.set(0);
		value.set(500);
		expectedResult = value;
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		address.set(32);
		value.set(-1000);
		expectedResult = value;
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		address.set(64);
		value.set(7875);
		expectedResult = value;
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		address.set(-865);
		value.set(457);
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: null");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		address.set(555555);
		value.set(457);
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: null");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
	
	public static void testWrite(longword address, longword value) {
		System.out.println("write(longword address, longword value) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		
		address.set(0);
		value.set(64);
		expectedResult = value;
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		address.set(32);
		value.set(2668);
		expectedResult = value;
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		address.set(500);
		value.set(784);
		expectedResult = value;
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: " + expectedResult);
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		address.set(-1);
		value.set(784);
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: null");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
		
		address.set(5000);
		value.set(784);
		memory.write(address, value);
		result = memory.read(address);
		System.out.println("Expected result: null");
		System.out.print("Actual result:   " + result);
		System.out.println();
		System.out.println();
	}
}
