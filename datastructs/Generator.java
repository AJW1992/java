package datastructs;

import java.util.Random;
/*
 * The 'digits' variable should fall in the range [1, 9]
 * 
 */
public class Generator {
	Random random = new Random();
	int digits = 1;
	
	public Generator(int digits) {
		setDigits(digits);
	}
	
	public int getDigits() {
		return this.digits;
	}
	
	public void setDigits(int digits) {
		for (int i = digits; i > 0; i--) {
			this.digits *= 10;
		}
	}
	
	public int generate() {
		return (int) (random.nextDouble() * this.digits);
	}
	
	public void generateArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = this.generate();
		}
	}
	
	public int generateAny() {
		if (random.nextBoolean()) {
			return (this.generate() * -1);
		}
		
		return this.generate();
	}
	
	public void generateAnyArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = this.generateAny();
		}
	}
}
