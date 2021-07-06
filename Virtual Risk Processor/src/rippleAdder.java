
public class rippleAdder {
	
	public static longword add(longword a, longword b) {
		longword result = new longword(0);
		bit tempResult = new bit(0);
		bit carry = new bit(0);
		
		for(int i = 0; i < 32; i++) {
			tempResult = a.getBit(i).xor(b.getBit(i)); // Adds the two bits together
			result.setBit(i, tempResult.xor(carry)); // Adds the result with the carry
			
			if(tempResult.getValue() == 1) { // If carry = 1 and both bits add up to 1, carry = 1
				if(carry.getValue() == 1) carry.set();
			} 
			else if(a.getBit(i).getValue() == 1) { // If both addition bits are 1, carry = 1
				if(b.getBit(i).getValue() == 1) carry.set();
				else carry.clear();
			}
			else carry.clear();
		}
		return result;
	}
	
	public static longword subtract(longword a, longword b) {
		longword result = new longword(0);
		
		// Reversing the sign of b
		for(int i = 31; i >= 0; i --) { // I negate the longword
			if(b.getBit(i).getValue() == 1) b.setBit(i, new bit(0));
			else b.setBit(i, new bit(1));
		}
		for(int i = 0; i < 32; i ++){ // Then I add 1 to the binary number
			if(b.getBit(i).getValue() == 1) b.setBit(i, new bit(0));
			else if(b.getBit(i).getValue() == 0) {
				b.setBit(i, new bit(1));
				break;
			}
		}
		// Now that the sign of b is changed, its addition would be equal to the desired subtraction
		result = add(a,b);
		return result;
	}
}
