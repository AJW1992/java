package utilities;

public class BaseConversion {
	public static String intToHex(int n) {
		String hexNum = "0x";
		if (n < 0) {
			n *= -1;
			hexNum = "-" + hexNum;
		}
		
		if (n >= 16) {
			hexNum = intToHex(n/16, hexNum);
		}
		
		switch (n % 16) {
			case 10: return hexNum + "A";
			case 11: return hexNum + "B";
			case 12: return hexNum + "C";
			case 13: return hexNum + "D";
			case 14: return hexNum + "E";
			case 15: return hexNum + "F";
			default: return hexNum + Integer.toString(n%16);
		}
	}
	
	public static int binToDecimal(String binString) {
		boolean flag = false;
		if (binString.startsWith("-")) {
			binString = binString.substring(1);
			flag = true;
		}
		if (binString.startsWith("0b")) {
			binString = binString.substring(2);
		}

		int binaryNum = 0;
		for (int i = 0, j = binString.length() - 1; i < binString.length(); i++, j--) {
			if (binString.charAt(i) == '1') {
				binaryNum += Math.pow(2, j);
			}
		}
		
		return flag ? binaryNum*-1 : binaryNum;
	}
	
	private static String intToHex(int n, String hexNum) {
		if (n >= 16) {
			hexNum = intToHex(n/16, hexNum);
		}
		
		switch (n % 16) {
			case 10: return hexNum + "A";
			case 11: return hexNum + "B";
			case 12: return hexNum + "C";
			case 13: return hexNum + "D";
			case 14: return hexNum + "E";
			case 15: return hexNum + "F";
			default: return hexNum + Integer.toString(n%16);
		}
	}
	
	public static int hexToDecimal(String hexString) {
		boolean flag = false;
		if (hexString.startsWith("-")) {
			hexString = hexString.substring(1);
			flag = true;
		}
		if (hexString.startsWith("0x")) {
			hexString = hexString.substring(2);
		}
		
		Integer decimalNum = Integer.decode("0x"+hexString);
		
		return flag ? Wrapper.Nums.unwrap(decimalNum*-1) : Wrapper.Nums.unwrap(decimalNum);
	}
	
	public static String intToBinary(int n) {
		String bin = "0b";
		if (n < 0) {
			n *= -1;
			bin = "-" + bin;
		}
		if (n >= 2) {
			bin = intToBinary(n/2, bin);
			return bin + Integer.toString(n%2);
		} else {
			return bin + Integer.toString(n);
		}
	}
	
	private static String intToBinary(int n, String bin) {
		if (n >= 2) {
			bin = intToBinary(n/2, bin);
			return bin + Integer.toString(n%2);
		} else {
			return bin + Integer.toString(n);
		}
	}
}
