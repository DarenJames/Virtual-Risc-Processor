
public class ALU {
	public static longword doOP(bit[] operation, longword a, longword b) {
		if(operation[3].getValue() == 1) {
			if(operation[2].getValue() == 1) {
				if(operation[1].getValue() == 1) {
					if(operation[0].getValue() == 1) return rippleAdder.subtract(a, b);//if operation == 1111, subtract
					else return rippleAdder.add(a, b); //if operation == 1110, add
				}
				else if(operation[0].getValue() == 0) return a.leftShift(getShiftValue(b)); //if operation == 1100, left shift
				else return a.rightShift(getShiftValue(b)); //if operation == 1101, right shift
			}
			else if(operation[1].getValue() == 1){ // 101?
				if(operation[0].getValue() == 1) return a.not(); //if operation == 1011, perform not
				else return a.xor(b); //if operation == 1010, perform xor
			}
			else if(operation[0].getValue() == 1) return a.or(b); //if operation == 1001, perform or
			else return a.and(b); //if operation == 1000, perform and
		}
		else return multiplier.multiply(a, b); // if operation == 0???, multiply
	}
	
	public static int getShiftValue(longword b) { //turns longword b into an int
		int count = 0; int sum = 0;
		for(int i = 0; i < 5; i++) {
			count = (int) Math.pow(2, i);
			if(b.getBit(i).getValue() == 1) sum = sum + count;
		}
		if(b.getBit(31).getValue() == 1) {
			sum = 0-sum;
			return sum;
		}
		return sum;
	}

}
