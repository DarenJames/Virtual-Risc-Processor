
public class assembler {

	public static String[] assemble(String[] instructions) {
		String[] machineLanguage = new String [instructions.length];
		int counter = 0;
		int i = 0;
		for(String instruction : instructions) { //every instruction will be checked for its opcode and registers/numbers to be converted into bits in a string
			String[] parsedInstruction = instruction.split(" ");
			
			switch(parsedInstruction[0]) {
			
			case "and":
				machineLanguage[counter] = "1000";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "or":
				machineLanguage[counter] = "1001";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "xor":
				machineLanguage[counter] = "1010";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "not":
				machineLanguage[counter] = "1011";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "leftShift":
				machineLanguage[counter] = "1100";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "rightShift":
				machineLanguage[counter] = "1101";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "add":
				machineLanguage[counter] = "1110";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "subtract":
				machineLanguage[counter] = "1111";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "halt":
				machineLanguage[counter] = "0000 0000 0000 0000";
				break;
				
			case "move": //need to fix
				machineLanguage[counter] = "0001";
				machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[1]);
				machineLanguage[counter] = machineLanguage[counter] + " " + getNumber(parsedInstruction[2]);
				break;
				
			case "interrupt":
				machineLanguage[counter] = "0010 0000 0000";
				machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[1]);
				break;
				
			case "multiply":
				machineLanguage[counter] = "0111";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "compare":
				machineLanguage[counter] = "0100 0000";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "jump":
				machineLanguage[counter] = "0011";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + " " + getTwelveBits(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "branchifequal":
				machineLanguage[counter] = "0101 01";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + getBranchValue(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "branchifnotequal":
				machineLanguage[counter] = "0101 00";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + getBranchValue(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "branchifgreaterthan":
				machineLanguage[counter] = "0101 10";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + getBranchValue(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "branchifgreaterthanorequal":
				machineLanguage[counter] = "0101 11";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + getBranchValue(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "pop":
				machineLanguage[counter] = "0110 0100 0000";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "push":
				machineLanguage[counter] = "0110 0000 0000";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + getRegister(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "call":
				machineLanguage[counter] = "0110 10";
				i = 1;
				while(i < parsedInstruction.length) {
					machineLanguage[counter] = machineLanguage[counter] + getBranchValue(parsedInstruction[i]);
					i++;
				}
				break;
				
			case "return":
				machineLanguage[counter] = "0110 1100 0000 0000";
				break;
				
			default:
				System.out.println("Error. This instruction is not supported: " + instruction);
			}
			counter++;
		}
		return machineLanguage;
	}
	
	private static String getRegister(String string) { //this method converts registers or numbers into 4 bits in a string
		String registerNum= string.replaceAll("[^0-9]", "");
		int num = Integer.parseInt(registerNum);
		longword register = new longword(num);
		registerNum = register.toString();
		registerNum = registerNum.substring(28, 32);
		
		return registerNum;
	}
	
	private static String getNumber(String string) { //this method converts registers or numbers into 8 bits in a string
		String registerNum= string.replaceAll("[^0-9]", "");
		int num = Integer.parseInt(registerNum);
		longword register = new longword(num);
		registerNum = register.toString();
		registerNum = registerNum.substring(24,28) + " " + registerNum.substring(28,32);
		
		return registerNum;
	}
	
	private static String getTwelveBits(String string) { //this method converts registers or numbers into 12 bits in a string
		String registerNum= string.replaceAll("[^0-9]", "");
		int num = Integer.parseInt(registerNum);
		longword register = new longword(num);
		registerNum = register.toString();
		registerNum = registerNum.substring(20,24) + " " + registerNum.substring(24,28) + " " + registerNum.substring(28,32);
		
		return registerNum;
	}
	
	private static String getBranchValue(String string) { //this method converts registers or numbers into 10 bits in a string for branch
		int num = Integer.parseInt(string);
		longword register = new longword(num);
		string = register.toString();
		string = string.substring(22,24) + " " + string.substring(24,28) + " " + string.substring(28,32);
		
		return string;
	}
}
