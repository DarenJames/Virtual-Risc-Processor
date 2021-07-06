
public class bit implements IBit{

	private int bit_value;
	
	bit(int value){
		if(value == 1 || value == 0) bit_value = value;
		else System.out.println("The bit value must be 0 or 1");
	}
	
	@Override
	public void set(int value) { //sets bit_value to value as long as value is 1 or 0
		if(value == 1) bit_value = value;
		else if(value == 0) bit_value = value;
		else
			System.out.println("Error: You must input a 1 or 0.");
	}

	@Override
	public void toggle() { //reverses the bit_value
		if(bit_value == 1) bit_value = 0;
		else if(bit_value == 0) bit_value = 1;
	}

	@Override
	public void set() {
		bit_value = 1;
	}

	@Override
	public void clear() {
		bit_value = 0;
	}

	@Override
	public int getValue() {
		return bit_value;
	}

	@Override
	public bit and(bit other) { //Performs logical and on two bits and returns a bit with the result
		bit b = new bit(0);
		
		if(bit_value == 0) return b;
		else if(other.bit_value == 0) return b;
		
		b.bit_value = 1;
		return b;
	}

	@Override
	public bit or(bit other) { //Performs logical or on two bits and returns a bit with the result
		bit b = new bit(1);
		if(bit_value == 1) return b;
		else if(other.bit_value == 1) return b;
		
		b.bit_value = 0;
		return b;
	}

	@Override
	public bit xor(bit other) { //Performs logical xor on two bits and returns a bit with the result
		bit b = new bit(0);
		if(bit_value == other.bit_value) return b;
		b.bit_value = 1;
		return b;
	}

	@Override
	public bit not() { //Performs logical not on a bit and returns a bit with the result
		bit b = new bit(0);
		if(bit_value == 1) return b;
		b.bit_value = 1;
		return b;
	}
	
	@Override
    public String toString() { //returns the bit_value as a string
		String value;
		if(bit_value == 1) {
			value = "1";
			return value;
		}
		value = "0";
		return value;
		
	}
}
