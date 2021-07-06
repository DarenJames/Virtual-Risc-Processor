
public class memory {
	
	private static bit [] memory = new bit[8192];
	
	public memory() {
		for(int i = 0; i<8192; i++) memory[i] = new bit(0);
	}
	
	public static longword read(longword address) {
		longword data = new longword(0);
		int index = (int) address.getUnsigned();
		index = index * 8;
		
		if(index > memory.length - 1) { //Checks if the range is within memory
			System.out.println("Please input an address within the range of 0-1023");
			return null;
		}
		if(index < 0) {
			System.out.println("Please input an address within the range of 0-1023");
			return null;
		}
		
		for(int i = 31; i > -1; i--) { //Copies the data at the address given to a longword to be returned
			data.setBit(i, memory[index]);
			index++;
		}
		return data;
	}
	
	public static void write(longword address, longword value) {
		int index = (int) address.getUnsigned();
		index = index * 8;
		
		if(index > memory.length - 1) System.out.println("Please input an address within the range of 0-1023");
		else if(index < 0) System.out.println("Please input an address within the range of 0-1023");
		else { //fills 32 bit memory starting at the address given with the value 
			for(int i = 31; i > -1; i--) {
				memory[index] = value.getBit(i);
				index++;
			}
		}
		
		
	}
}
