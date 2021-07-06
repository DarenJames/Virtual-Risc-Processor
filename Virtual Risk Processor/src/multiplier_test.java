
public class multiplier_test {

	public static void main(String[] args) {
		System.out.println("Bit tests");
		bit_test.runTests();
		System.out.println("Longword tests");
		longword_test.runTest();
		System.out.println("Ripple Adder tests");
		rippleAdder_test.runTests();
		System.out.println("Multiplier test");
		runTests();
	}
	
	public static void runTests() {
		testMultiplier(new longword(0), new longword(0));
	}
	
	public static void testMultiplier(longword a, longword b) {
		System.out.println("longword multiply(longword a, longword b) test: ");
		longword result = new longword(0);
		longword expectedResult = new longword(0);
		
		a.set(10); 
		b.set(10);
		expectedResult.set(100);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(359); 
		b.set(6420);
		expectedResult.set(2304780);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(378); 
		b.set(59);
		expectedResult.set(22302);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(633); 
		b.set(723);
		expectedResult.set(457659);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(43); 
		b.set(0);
		expectedResult.set(0);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(0); 
		b.set(436);
		expectedResult.set(0);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(0); 
		b.set(0);
		expectedResult.set(0);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(-325); 
		b.set(363);
		expectedResult.set(-117975);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(637); 
		b.set(-252);
		expectedResult.set(-160524);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(-754); 
		b.set(-486);
		expectedResult.set(366444);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(2000000000); 
		b.set(2000000000);
		expectedResult.set(-1651507200);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
		
		a.set(-2000000000); 
		b.set(-2000000000);
		expectedResult.set(-1651507200);
		result = multiplier.multiply(a,b);
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   " + result.toString());
		System.out.println();
		System.out.println();
	}

}
