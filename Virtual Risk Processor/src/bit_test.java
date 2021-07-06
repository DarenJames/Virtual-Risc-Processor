
public class bit_test {

	public static void main(String[] args) {
		runTests();
	}
	
	public static void runTests() {
		testSet(new bit(0));
		testToggle(new bit(0));
		testClear(new bit(0));
		testGetValue(new bit(0));
		testAnd(new bit(0));
		testOr(new bit(0));
		testXor(new bit(0));
		testNot(new bit(0));
		testToString(new bit(0));
	}
	
	public static void testSet(bit b) {
		System.out.println("void set() test:");
		b.set();
		System.out.println("Expected value: 1 | Actual value: " + b.getValue());
		b.set();
		System.out.println("Expected value: 1 | Actual value: " + b.getValue());
		System.out.println();
		
		System.out.println("void set(int value) test: ");
		bit c = new bit(0);
		System.out.println("Expected value: 0 | Actual value: " + c.getValue());
		c.set(1);
		System.out.println("Expected value: 1 | Actual value: " + c.getValue());
		System.out.print("Expected result: error | ");
		c.set(5);
		System.out.println();
	}
	
	public static void testToggle(bit b) {
		System.out.println("void toggle() test:");
		b.toggle();
		System.out.println("Expected value: 1 | Actual value: " + b.getValue());
		b.toggle();
		System.out.println("Expected value: 0 | Actual value: " + b.getValue());
		System.out.println();
	}
	
	public static void testClear(bit b) {
		System.out.println("void clear() test:");
		b.set(1);
		b.clear();
		System.out.println("Expected value: 0 | Actual value: " + b.getValue());
		b.clear();
		System.out.println("Expected value: 0 | Actual value: " + b.getValue());
		System.out.println();
	}
	
	public static void testGetValue(bit b) {
		System.out.println("int getValue() test:");
		b.set();
		System.out.println("Expected value: 1 | Actual value: " + b.getValue());
		b.clear();
		System.out.println("Expected value: 0 | Actual value: " + b.getValue());
		System.out.println();
	}
	
	public static void testAnd(bit b) {
		System.out.println("bit and(bit other) test:");
		bit other = new bit(0);
		System.out.println("Expected value: 0 | Actual value: " + b.and(other));
		other.set();
		System.out.println("Expected value: 0 | Actual value: " + b.and(other));
		b.set();
		System.out.println("Expected value: 1 | Actual value: " + b.and(other));
		other.clear();
		System.out.println("Expected value: 0 | Actual value: " + b.and(other));
		System.out.println();
	}
	
	public static void testOr(bit b) {
		System.out.println("bit or(bit other) test:");
		bit other = new bit(0);
		System.out.println("Expected value: 0 | Actual value: " + b.or(other));
		b.set();
		System.out.println("Expected value: 1 | Actual value: " + b.or(other));
		other.set();
		System.out.println("Expected value: 1 | Actual value: " + b.or(other));
		b.clear();
		System.out.println("Expected value: 1 | Actual value: " + b.or(other));
		System.out.println();
	}
	
	public static void testXor(bit b) {
		System.out.println("bit xor(bit other) test:");
		bit other = new bit(0);
		System.out.println("Expected value: 0 | Actual value: " + b.xor(other));
		b.set();
		System.out.println("Expected value: 1 | Actual value: " + b.xor(other));
		other.set();
		System.out.println("Expected value: 0 | Actual value: " + b.xor(other));
		b.clear();
		System.out.println("Expected value: 1 | Actual value: " + b.xor(other));
		System.out.println();
	}
	
	public static void testNot(bit b) {
		System.out.println("bit not() test:");
		System.out.println("Expected value: 1 | Actual value: " + b.not());
		b.set();
		System.out.println("Expected value: 0 | Actual value: " + b.not());
		System.out.println();
	}
	
	public static void testToString(bit b) {
		System.out.println("String toString() test:");
		System.out.println("Expected string: 0 | Actual string: " + b.toString());
		b.set();
		System.out.println("Expected string: 1 | Actual string: " + b.toString());
		System.out.println();
	}
}
