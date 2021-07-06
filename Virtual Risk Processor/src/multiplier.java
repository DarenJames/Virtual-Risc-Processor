
public class multiplier {
	public static longword multiply(longword a, longword b) {
		longword partial_product_1 = new longword(0);
		longword partial_product_2 = new longword(0);
		for(int i = 0; i<32; i++) {
			if(b.getBit(i).getValue() == 1) {
				partial_product_2 = a;
				partial_product_2 = partial_product_2.leftShift(i);
				partial_product_1 = rippleAdder.add(partial_product_1, partial_product_2);
			}
		}
		return partial_product_1;
	}
}
