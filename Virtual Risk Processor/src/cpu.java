import java.lang.String;

public class cpu {
	bit halted = new bit(1);
	private memory RAM = new memory();
	longword PC = new longword(0);
	static longword current_instruction = new longword(0);
	longword [] registers = new longword [16];
	static longword op1 = new longword(0);
	static longword op2 = new longword(0);
	static bit [] opcode = new bit[4];
	static longword destination = new longword(0);
	static longword result = new longword(0);
	static bit[] moveInstruction = new bit[4];
	static boolean opcodeIsMove = false;
	static bit[] jumpInstruction = new bit[4];
	static boolean opcodeIsJump = false;
	static bit[] compareInstruction = new bit[4];
	static boolean opcodeIsCompare = false;
	static bit[] compareResult = new bit[2];
	static bit[] branchInstruction = new bit[4];
	static boolean opcodeIsBranch = false;
	static bit[] branchCondition = new bit[2];
	static boolean branch = false;
	static bit[] stackInstruction = new bit[4];
	static boolean opcodeIsStack = false;
	static boolean instructionIsReturn = false;
	static boolean instructionIsCall = false;
	static boolean instructionIsPush = false;
	static boolean instructionIsPop = false;
	static boolean opcodeIsInterrupt = false;
	longword SP = new longword(0);
	
	void run() {
		SP.set(1020);
		while(halted.getValue() == 1) {
			fetch();
			decode();
			execute();
			store();
		}
	}
	
	public void fetch() {
		current_instruction = memory.read(PC);
		longword two = new longword(2);
		PC = rippleAdder.add(PC, two);
	}
	
	public static void decode() {
		longword copy = new longword(0);
		//Move opcode initialized
		int counter = 0;
		while(counter < 4) {
			moveInstruction[counter] = new bit(0);
			counter++;
		}
		moveInstruction[3].set();
		
		//Jump opcode initialized
		counter = 0;
		while(counter < 4) {
			jumpInstruction[counter] = new bit(0);
			counter++;
		}
		jumpInstruction[3].set();
		jumpInstruction[2].set();
		
		//Compare opcode initialized
		counter = 0;
		while(counter < 4) {
			compareInstruction[counter] = new bit(0);
			counter++;
		}
		compareInstruction[1].set();
		
		//Branch opcode initialized
		counter = 0;
		while(counter < 4) {
			branchInstruction[counter] = new bit(0);
			counter++;
		}
		branchInstruction[1].set();
		branchInstruction[3].set();
		
		//Stack opcode initialized
		counter = 0;
		while(counter < 4) {
			stackInstruction[counter] = new bit(0);
			counter++;
		}
		stackInstruction[1].set();
		stackInstruction[2].set();
		
		//Get opcode from instruction
		copy = current_instruction.rightShift(28); //right shifting to get the first 4 bits that are the opcode
		for(int i = 0; i < 4; i++) {
			opcode[3-i] = copy.getBit(i);
		}
		
		//Testing if the opcode matches jump, compare, branch, move, and stack instructions
		int y = 0;
		int z = 0;
		opcodeIsMove = false;
		for(bit b: opcode) {
			if(b.getValue() == moveInstruction[z].getValue()) {
				y++;
			}
			z++;
		}
		if(y == 4) {
			opcodeIsMove = true;
		}
		
		y = 0;
		z = 0;
		opcodeIsJump = false;
		for(bit b: opcode) {
			if(b.getValue() == jumpInstruction[z].getValue()) {
				y++;
			}
			z++;
		}
		if(y == 4) {
			opcodeIsJump = true;
		}
		
		y = 0;
		z = 0;
		opcodeIsCompare = false;
		for(bit b: opcode) {
			if(b.getValue() == compareInstruction[z].getValue()) {
				y++;
			}
			z++;
		}
		if(y == 4) {
			opcodeIsCompare = true;
		}
		
		y = 0;
		z = 0;
		opcodeIsBranch = false;
		for(bit b: opcode) {
			if(b.getValue() == branchInstruction[z].getValue()) {
				y++;
			}
			z++;
		}
		if(y == 4) {
			opcodeIsBranch = true;
		}
		
		y = 0;
		z = 0;
		opcodeIsStack = false;
		for(bit b: opcode) {
			if(b.getValue() == stackInstruction[z].getValue()) {
				y++;
			}
			z++;
		}
		if(y == 4) {
			opcodeIsStack = true;
		}
		
		//After confirming what the opcode is we decode the instruction
		if(opcodeIsMove == true) {
			destination = current_instruction.rightShift(24); //right shifting and masking bits to get second byte (destination register).
			for(int i = 3; i > -1; i--) {
				copy.setBit(i, destination.getBit(i));
			}
			destination = destination.and(copy);
			
			result = current_instruction.rightShift(16);
			for(int i = 7; i > -1; i--) { //gets the last two bytes (Value to be moved into destination register).
				copy.setBit(i, result.getBit(i));
			}
			result = result.and(copy);
		}
		else if(opcodeIsJump == true) {
			result = current_instruction.rightShift(16);
			for(int i = 11; i > -1; i--) { //gets the last three bytes (Value to be moved into destination register).
				copy.setBit(i, result.getBit(i));
			}
			result = result.and(copy);
		}
		else if(opcodeIsCompare == true) {
			op1 = current_instruction.rightShift(20); //right shifting and masking bits to get third byte (first register)
			for(int i = 3; i > -1; i--) {
				copy.setBit(i, op1.getBit(i));
			}
			op1 = op1.and(copy);
			
			op2 = current_instruction.rightShift(16);
			for(int i = 3; i > -1; i--) { //gets the last byte (second register).
				copy.setBit(i, op2.getBit(i));
			}
			op2 = op2.and(copy);
		}
		else if(opcodeIsBranch) {
			op1 = current_instruction.rightShift(24); //getting the first two bits of the second byte
			int h = 2;
			for(int i = 1; i > -1; i--) {
				branchCondition[i] = new bit(0);
				branchCondition[i].set(op1.getBit(h).getValue());
				h++;
			}
			
			op2 = current_instruction.rightShift(16); //Gets the remaining bits of the instruction
			for(int i = 9; i > -1; i--) { 
				copy.setBit(i, op2.getBit(i));
			}
			op2 = op2.and(copy);
			if(op2.getBit(9).getValue() == 1) {
				int i = 31;
				bit one = new bit(1);
				one.set();
				while(i > 9) {
					op2.setBit(i, one);
					i--;
				}
			}
		}
		else if(opcodeIsStack) {
			//Now it must be determined which stack instruction it is by checking the next two bits after the opcode
			bit[] nextTwoBits = new bit[2];
			nextTwoBits[0] = current_instruction.getBit(26);
			nextTwoBits[1] = current_instruction.getBit(27);
			instructionIsPop = false;
			instructionIsPush = false;
			instructionIsCall = false;
			instructionIsReturn = false;
			
			if(nextTwoBits[1].getValue() == 1) {
				if(nextTwoBits[0].getValue() == 1) { //If the instruction is return
					instructionIsReturn = true;
				}
				else { //If the instruction is call
					instructionIsCall = true;
					
					op1 = current_instruction.rightShift(16); //Gets the remaining 10 bits of the instruction (i.e., the address)
					for(int i = 9; i > -1; i--) { 
						copy.setBit(i, op1.getBit(i));
					}
					op1 = op1.and(copy);
				}
			}
			else {
				if(nextTwoBits[0].getValue() == 1) { //If the instruction is pop
					instructionIsPop = true;
					
					op1 = current_instruction.rightShift(16);
					for(int i = 3; i > -1; i--) { //gets the last byte (the register).
						copy.setBit(i, op1.getBit(i));
					}
					op1 = op1.and(copy);
				}
				else { //If the instruction is push
					instructionIsPush = true;
					
					op1 = current_instruction.rightShift(16);
					for(int i = 3; i > -1; i--) { //gets the last byte (the register).
						copy.setBit(i, op1.getBit(i));
					}
					op1 = op1.and(copy);
				}
			}
			
		}
		else {
			op1 = current_instruction.rightShift(24); //right shifting and masking bits to get second byte (source register).
			copy.set(0);
			for(int i = 3; i > -1; i--) {
				copy.setBit(i, op1.getBit(i));
			}
			op1 = op1.and(copy);
			
			op2 = current_instruction.rightShift(20); //right shifting and masking bits to get third byte (source register).
			for(int i = 3; i > -1; i--) {
				copy.setBit(i, op2.getBit(i));
			}
			op2 = op2.and(copy);
			
			destination = current_instruction.rightShift(16);
			for(int i = 3; i > -1; i--) { //gets the last byte (destination register).
				copy.setBit(i, destination.getBit(i));
			}
			destination = destination.and(copy);
		}
		
	}
	
	public void execute() {
		bit[] haltInstruction = new bit[4]; 
		int counter = 0;
		while(counter < 4) {
			haltInstruction[counter] = new bit(0);
			counter++;
		}
		
		bit[] interrupt = new bit[4];
		counter = 0;
		while(counter < 4) {
			interrupt[counter] = new bit(0);
			counter++;
		}
		interrupt[2].set();
		
		int y = 0;
		int z = 0;
		opcodeIsInterrupt = false;
		for(bit b: opcode) {
			if(b.getValue() == interrupt[z].getValue()) {
				y++;
			}
			z++;
		}
		if(y == 4) {
			opcodeIsInterrupt = true;
			}
		
		y = 0;
		z = 0;
		boolean opcodeIsHalt = false;
		for(bit b: opcode) {
			if(b.getValue() == haltInstruction[z].getValue()) {
				y++;
			}
			z++;
		}
		if(y == 4) {
			opcodeIsHalt = true;
		}
		
		if(opcodeIsHalt == true) { //if the opcode is a halt instruction (gonna have to make this boolean most likely
			halted.clear();
		}
		else if(opcodeIsInterrupt == true) { //if the opcode is an interrupt instruction
			longword printMemory = new longword(0);
			printMemory.set(1);			
			if(destination.getUnsigned() == printMemory.getUnsigned()) { //if the interrupt request memory be read, the memory is read
				counter = 0;
				longword address = new longword(0);
				System.out.println("Memory");
				while(counter < 1024) {
					address.set(counter);
					System.out.println(RAM.read(address));
					counter += 4;
				}
			}
			else { //if the interrupt request isn't for memory, it must be for registers. Therefore the registers are printed.
				counter = 0;
				System.out.println("Registers: ");
				while (counter < 16) {
					System.out.println("Register " + counter + ": " + registers[counter]);
					counter++;
				}
			}
		}
		else if(opcodeIsJump == true) {
			//do nothing
		}
		else if(opcodeIsCompare == true) {
			result = rippleAdder.subtract(registers[(int) op1.getUnsigned()], registers[(int) op2.getUnsigned()]);
		}
		else if(opcodeIsBranch == true) {
			if(compareResult[0] == null) {
				System.out.println("Error: You must give a compare instruction before branching");
			}
			else { //Checks if status bits correspond with branch condition bits
				branch = false;
				bit zero = new bit(0);
				bit one = new bit(1);
				one.set();
				
				if(compareResult[1].getValue() == one.getValue()) {
					if(compareResult[1].getValue() == branchCondition[1].getValue()) {
						branch = true;
					}
				}
				else if(compareResult[0].getValue() == one.getValue()) {
					if(compareResult[0].getValue() == branchCondition[0].getValue()) {
						branch = true; 
					}
				}
				else {
					if(compareResult[0].getValue() == branchCondition[0].getValue()) {
						if(compareResult[1].getValue() == branchCondition[1].getValue()) {
							branch = true;
						}
					}
				}
			}
		}
		else if(opcodeIsStack) { //If the opcode is a stack instruction...
			if(instructionIsReturn) {
				longword four = new longword(0);
				four.set(4);
				SP = rippleAdder.add(SP, four);
				longword address = new longword(0); //Reading the address from memory and setting PC equal to it
				address = memory.read(SP);
				PC.copy(address); 
				
				longword zero = new longword(0); //Erasing the address stored there
				zero.set(0);
				memory.write(SP, zero);
			}
			else if(instructionIsCall) {
				longword nextInstruction = new longword(0); //getting the next instruction
				longword four = new longword(0);
				
				memory.write(SP, PC); //Writing the address for the next instruction into the Stack
				four.set(4); //Subtracting the SP by 4
				SP = rippleAdder.subtract(SP, four);
				
				PC.copy(op1); //Setting PC to the address stored in the call instruction
			}
			else if(instructionIsPush) {
				longword value = registers[op1.getSigned()];
				memory.write(SP, value);
				longword four = new longword(0);
				four.set(4);
				SP = rippleAdder.subtract(SP, four);
			}
			else if(instructionIsPop) {
				longword zero = new longword(0);
				zero.set(0);
				longword four = new longword(0);
				four.set(4);
				
				SP = rippleAdder.add(SP, four);
				registers[op1.getSigned()] = memory.read(SP); //Storing what will be popped into a register
				memory.write(SP, zero); // Popping what's in the stack
			}
		}
		else if(opcodeIsMove == false){ //if the opcode is a normal instruction
			bit[] clone = opcode.clone();
			for(int i = 0; i<opcode.length; i++) {
				opcode[i] = clone[3-i];
			}
			result = ALU.doOP(opcode, registers[op1.getSigned()], registers[op2.getSigned()]);
		}
	}
	
	public void store() {
		if(opcodeIsJump == true) { //If the opcode is jump, change the pc to the result
			if(result.getSigned() < 0) {
				System.out.println("Error: You cannot jump to a negative address");
			}
			else {
				PC = result;
			}
		}
		else if(opcodeIsCompare == true) { //If the opcode is compare, set the compareResult bits
			if(result.getSigned() == 0) { //If op1 = op2, the bits are 0 1
				compareResult[1] = new bit(0);
				compareResult[1].set();
				compareResult[0] = new bit(0);
			}
			else if(result.getSigned() > 0) { //If op1 > op2, the bits are 1 0
				compareResult[0] = new bit(0);
				compareResult[0].set();
				compareResult[1] = new bit(0);
			}
			else { //If op1 != op2, the bits are 0 0
				compareResult[0] = new bit(0);
				compareResult[1] = new bit(0);
			}
		}
		else if(branch == true) { //Add op2 to the PC
			PC = rippleAdder.add(op2, PC);
			branch = false;
		}
		else if(opcodeIsStack) {
			
		}
		else if(opcodeIsInterrupt) {
			
		}
		else if(opcodeIsBranch == false){ //Otherwise, change the designated register to the result
			registers[destination.getSigned()] = result;
		}
	}
	
	public void preload(String[] program) {
		longword instructions = new longword(0);
		int address_counter = 0;
		longword address_longword = new longword(0);
		int a = 0;
		int b = 0;
		bit one = new bit(1);
		one.set();
		bit zero = new bit(0);
		
		for(int i = 0; i < program.length; i+=2) {
			char[] instruction = program[i].toCharArray();
			while(a < instruction.length) {
				if(instruction[a] == '1') {
					instructions.setBit(31-b, one);
					b++;
				}
				else if(instruction[a] == '0') {
					instructions.setBit(31-b, zero);
					b++;
				}
				a++;
			}
			a = 0;
			
			if(i+1 == program.length) {
				while(b < program[program.length-1].length()) {
					instructions.setBit(31-b, zero);
					b++;
				}
			}
			else {
				instruction = program[i+1].toCharArray();
				while(a < instruction.length) {
					if(instruction[a] == '1') {
						instructions.setBit(31-b, one);
						b++;
					}
					else if(instruction[a] == '0'){
						instructions.setBit(31-b, zero);
						b++;
					}
					a++;
				}
			}
			b = 0;
			a = 0;
			address_longword.set(address_counter);
			memory.write(address_longword, instructions);
			address_counter += 4;
		}
		
	}
}
