
public class rippleAdder_test {

	public static void main(String[] args) {
		System.out.println("Bit tests");
		bit_test.runTests();
		System.out.println("Longword tests");
		longword_test.runTest();
		System.out.println("Ripple Adder tests");
		runTests();
	}
	
	public static void runTests() {
		testAdd(new longword(0), new longword(0));
		testSubtract(new longword(0), new longword(0));
	}
	
	public static void testAdd(longword a, longword b){
		System.out.println("longword add(longword a, longword b) test: ");
		longword c = new longword(0);
		longword expectedResult = new longword(0);
		String result;
		
		a.set(2000000000); 
		b.set(2000000000);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: 11101110011010110010100000000000");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(1500);
		b.set(5000);
		expectedResult.set(6500);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(30);
		b.set(50);
		expectedResult.set(80);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(170);
		b.set(255);
		expectedResult.set(425);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(-3895);
		b.set(7849);
		expectedResult.set(3954);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(8746);
		b.set(-4976);
		expectedResult.set(3770);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(-867);
		b.set(-255);
		expectedResult.set(-1122);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(-954);
		b.set(-743);
		expectedResult.set(-1697);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(-954);
		b.set(954);
		expectedResult.set(0);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(79548);
		b.set(57537);
		expectedResult.set(137085);
		c = rippleAdder.add(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
	}
	
	public static void testSubtract(longword a, longword b) {
		System.out.println("longword subtract(longword a, longword b) test: ");
		longword c = new longword(0);
		String result;
		longword expectedResult = new longword(0);
		
		a.set(10);
		b.set(10);
		expectedResult.set(0);
		c = rippleAdder.subtract(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(536);
		b.set(825);
		expectedResult.set(-289);
		c = rippleAdder.subtract(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(955);
		b.set(735);
		expectedResult.set(220);
		c = rippleAdder.subtract(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(8764);
		b.set(-8754);
		expectedResult.set(17518);
		c = rippleAdder.subtract(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(-986496);
		b.set(854);
		expectedResult.set(-987350);
		c = rippleAdder.subtract(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(-9647);
		b.set(-9753);
		expectedResult.set(106);
		c = rippleAdder.subtract(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(-2000000000);
		b.set(2000000000);
		c = rippleAdder.subtract(a,b);
		result = c.toString();
		System.out.println("Expected result: 00010001100101001101100000000000");
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
		
		a.set(530284);
		b.set(352985);
		expectedResult.set(177299);
		c = rippleAdder.subtract(a,b);
		result = c.toString();
		System.out.println("Expected result: " + expectedResult.toString());
		System.out.print("Actual result:   ");
		System.out.println(result);
		System.out.println();
	}

}
