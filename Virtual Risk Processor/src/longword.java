
public class longword implements ILongword {
	private bit [] longword = new bit [32];
	
	public longword(int value) { 
		this.set(value);
	}

	@Override
	public bit getBit(int i) {
		if(i >= 0) { //So users can't request non-existent bits.
			if(i <= 31) {
				return this.longword[i];
			}
			System.out.println("Please input a integer less than 31.");
			return null;
		}
		else {
			System.out.println("Please input a integer greater than 0.");
			return null;
		}
	}

	@Override
	public void setBit(int i, bit value) { 
		if(i >= 0) { //So users can't set non-existent bits.
			if(i <= 31) {
				this.longword[i] = value;
			}
			else System.out.println("Please input an integer less than 31.");
		}
		else {
			System.out.println("Please input an integer greater than 0.");
		}
	}

	@Override
	public longword and(longword other) {
		longword and = new longword(0);
		for(int i = 31; i >= 0; i --) {
			if(this.getBit(i).getValue() == 1) {
				if(other.getBit(i).getValue() == 1) and.setBit(i, new bit(1));
				else and.setBit(i, new bit(0));
			}
			else and.setBit(i, new bit(0));
		}
		return and;
	}

	@Override
	public longword or(longword other) {
		longword or = new longword(0);
		for(int i = 31; i >= 0; i --) {
			if(this.getBit(i).getValue() == 1) or.setBit(i, new bit(1));
			else if(other.getBit(i).getValue() == 1) or.setBit(i, new bit(1));
			else or.setBit(i, new bit(0));
		}
		return or;
	}

	@Override
	public longword xor(longword other) {
		longword xor = new longword(0);
		for(int i = 31; i >= 0; i --) {
			if(this.getBit(i).getValue() == 1) {
				if(other.getBit(i).getValue() == 1) xor.setBit(i, new bit(0));
				else xor.setBit(i, new bit(1));
			}
			if(this.getBit(i).getValue() == 0){
				if(other.getBit(i).getValue() == 0) xor.setBit(i, new bit(0));
				else xor.setBit(i, new bit(1));
			}
		}
		return xor;
	}

	@Override
	public longword not() {
		longword negated = new longword(0);
		for(int i = 31; i >= 0; i --) {
			if(this.getBit(i).getValue() == 1) negated.setBit(i, new bit(0));
			else negated.setBit(i, new bit(1));
		}
		return negated;
	}

	@Override
	public longword rightShift(int amount) {
		longword rightShift = new longword(0);
		
		if(amount == 0) return this;
		if(amount < 0) {
			System.out.println("Error: Please input a number greater than 0.");
			return null;
		}
		for(int i = 31; i >= 0; i--) {
			if(i >= 31 - amount) rightShift.setBit(i, this.getBit(31));
			else rightShift.setBit(i, this.getBit(i+amount));
		}
		
		return rightShift;
	}

	@Override
	public longword leftShift(int amount) {
		longword leftShift = new longword(0);
		
		if(amount == 0) return this;
		if(amount < 0) {
			System.out.println("Error: Please input a number greater than 0.");
			return null;
		}
		for(int i = 0; i <= 31; i++) {
			if(i < amount) leftShift.setBit(i, new bit(0));
			else leftShift.setBit(i, this.getBit(i-amount));
		}
		
		return leftShift;
	}

	public String toString() {
		String longword = new String();
		for(int i = 31; i >= 0; i--) longword += this.getBit(i).getValue();
		return longword;
	}
	
	@Override
	public long getUnsigned() {
		int count = 0; long sum = 0;
		for(int i = 0; i <= 31; i++) {
			count = (int) Math.pow(2, i);
			if(this.getBit(i).getValue() == 1) sum = sum + count;
		}
		return sum;
	}

	@Override
	public int getSigned() {
		longword copy = new longword(0);
		copy.copy(this);
		
		if(this.getBit(31).getValue() == 0) { //If the value isn't negative, use the unsigned method
			return (int) copy.getUnsigned();
		}
		
		for(int i = 31; i >= 0; i--) { //Negating the longword
			if(copy.getBit(i).getValue() == 1) copy.setBit(i, new bit(0));
			else copy.setBit(i, new bit(1));
		}
		for(int i = 0; i < 32; i++) { //Adding 1 to the negated longword
			if(copy.getBit(i).getValue() == 1) copy.setBit(i, new bit(0));
			else if(copy.getBit(i).getValue() == 0) {
				copy.setBit(i, new bit(1));
				break;
			}
		}
		return (int) - copy.getUnsigned();
	}

	@Override
	public void copy(longword other) {
		for(int i = 31; i >= 0; i --) {
			if(other.getBit(i).getValue() == 1) this.setBit(i, new bit(1));
			else this.setBit(i, new bit(0));
		}
	}

	@Override
	public void set(int value) {
		if(value == 0) {
			for(int i = 0; i < 32; i++) this.setBit(i, new bit(0));
		}
		else if(value < Math.pow(2, 31)-1 && value > 0) { //If the value is greater than 0 and less than 2^31
			for(int i = 31; i >= 0; i--) {
				if(Math.pow(2, i) > value) this.setBit(i, new bit(0));
				else {
					this.setBit(i, new bit(1));
					value = (int) (value - Math.pow(2, i));
				}
			}
		}
		else if(value > -(Math.pow(2, 31)) - 1 && value < 0) { //If the value is less than 0 & greater than -(2^31)
			int absValue = Math.abs(value);
			
			for(int i = 31; i >= 0; i--) { //Get the longword as the absolute value of the value
				if(Math.pow(2, i) > absValue) this.setBit(i, new bit(0));
				else {
					this.setBit(i, new bit(1));
					absValue = (int) (absValue - Math.pow(2, i));
				}
			}
			for(int i = 31; i >= 0; i --) { //Negate the longword
				if(this.getBit(i).getValue() == 1) this.setBit(i, new bit(0));
				else this.setBit(i, new bit(1));
			}
			for(int i = 0; i < 32; i ++){ //Finally, I add 1 to the binary number
				if(this.getBit(i).getValue() == 1) this.setBit(i, new bit(0));
				else {
					this.setBit(i, new bit(1));
					break;
				}
			}
		}
		else System.out.println("Please input a number within the appropriate range");
	}
}
