package utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateInput {
	public static int fetchInt(Scanner input) throws Exception {
		int num;
		
		try {
			num = input.nextInt();
		} catch (InputMismatchException ex) {
			throw new Exception();
		}
		
		return num;
	}
	
	public static double fetchDouble(Scanner input) throws Exception {
		double num;
		
		try {
			num = input.nextDouble();
		} catch (InputMismatchException ex) {
			throw new Exception();
		}

		return num;
	}
	
	public static char fetchChar(Scanner input) throws Exception {
		String string = input.nextLine();
		
		if (string.toCharArray().length != 1) {
			throw new Exception();	
		} else {
			return string.charAt(0);
		}
	}
	
	public static String fetchString(Scanner input) {
		return input.nextLine();
	}
}
