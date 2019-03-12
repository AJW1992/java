package utilities;

public class Wrapper {
	public static Boolean wrap(boolean flag) {
		return new Boolean(flag);
	}
	
	public static boolean unwrap(Boolean flag) {
		return (boolean) flag;
	}
	
	public static Byte wrap(byte bits) {
		return new Byte(bits);
	}
	
	public static byte unwrap(Byte bits) {
		return (byte) bits;
	}
	
	public static Character wrap(char ch) {
		return new Character(ch);
	}
	
	public static char unwrap(Character ch) {
		return (char) ch;
	}
	
	public static Boolean[] wrap(boolean[] flags) {
		Boolean[] wrapped = new Boolean[flags.length];
		for (int i = 0; i < flags.length; i++) {
			wrapped[i] = wrap(flags[i]);
		}
		
		return wrapped;
	}
	
	public static boolean[] unwrap(Boolean[] flags) {
		boolean[] unwrapped = new boolean[flags.length];
		for (int i = 0; i < flags.length; i++) {
			unwrapped[i] = unwrap(flags[i]);
		}
		
		return unwrapped;
	}
	
	public static Byte[] wrap(byte[] bytes) {
		Byte[] wrapped = new Byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			wrapped[i] = wrap(bytes[i]);
		}
		
		return wrapped;
	}
	
	public static byte[] unwrap(Byte[] bytes) {
		byte[] unwrapped = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			unwrapped[i] = unwrap(bytes[i]);
		}
		
		return unwrapped;
	}
	
	public static Character[] wrap(char[] chs) {
		Character[] wrapped = new Character[chs.length];
		for (int i = 0; i < chs.length; i++) {
			wrapped[i] = wrap(chs[i]);
		}
		
		return wrapped;
	}
	
	public static char[] unwrap(Character[] chs) {
		char[] unwrapped = new char[chs.length];
		for (int i = 0; i < chs.length; i++) {
			unwrapped[i] = unwrap(chs[i]);
		}
		
		return unwrapped;
	}
	
	public static class Nums {
		public static Short wrap(short num) {
			return new Short(num);
		}
	
		public static short unwrap(Short num) {
			return (short) num;
		}
		
		public static Integer wrap(int num) {
			return new Integer(num);
		}
	
		public static int unwrap(Integer num) {
			return (int) num;
		}
	
		public static Float wrap(float num) {
			return new Float(num);
		}
	
		public static float unwrap(Float num) {
			return (float) num;
		}
		
		public static Long wrap(long num) {
			return new Long(num);
		}
	
		public static long unwrap(Long num) {
			return (long) num;
		}
	
		public static Double wrap(double num) {
			return new Double(num);
		}
	
		public static double unwrap(Double num) {
			return (double) num;
		}
		
		public static Short[] wrap(short[] nums) {
			Short[] wrapped = new Short[nums.length];
			for (int i = 0; i < nums.length; i++) {
				wrapped[i] = wrap(nums[i]);
			}
			
			return wrapped;
		}
		
		public static short[] unwrap(Short[] nums) {
			short[] unwrapped = new short[nums.length];
			for (int i = 0; i < nums.length; i++) {
				unwrapped[i] = unwrap(nums[i]);
			}
			
			return unwrapped;
		}
		
		public static Integer[] wrap(int[] nums) {
			Integer[] wrapped = new Integer[nums.length];
			for (int i = 0; i < nums.length; i++) {
				wrapped[i] = wrap(nums[i]);
			}
			
			return wrapped;
		}
		
		public static int[] unwrap(Integer[] nums) {
			int[] unwrapped = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				unwrapped[i] = unwrap(nums[i]);
			}
			
			return unwrapped;
		}
		
		public static Float[] wrap(float[] nums) {
			Float[] wrapped = new Float[nums.length];
			for (int i = 0; i < nums.length; i++) {
				wrapped[i] = wrap(nums[i]);
			}
			
			return wrapped;
		}
		
		public static float[] unwrap(Float[] nums) {
			float[] unwrapped = new float[nums.length];
			for (int i = 0; i < nums.length; i++) {
				unwrapped[i] = unwrap(nums[i]);
			}
			
			return unwrapped;
		}
		
		public static Long[] wrap(long[] nums) {
			Long[] wrapped = new Long[nums.length];
			for (int i = 0; i < nums.length; i++) {
				wrapped[i] = wrap(nums[i]);
			}
			
			return wrapped;
		}
		
		public static long[] unwrap(Long[] nums) {
			long[] unwrapped = new long[nums.length];
			for (int i = 0; i < nums.length; i++) {
				unwrapped[i] = unwrap(nums[i]);
			}
			
			return unwrapped;
		}
		
		public static Double[] wrap(double[] nums) {
			Double[] wrapped = new Double[nums.length];
			for (int i = 0; i < nums.length; i++) {
				wrapped[i] = wrap(nums[i]);
			}
			
			return wrapped;
		}
		
		public static double[] unwrap(Double[] nums) {
			double[] unwrapped = new double[nums.length];
			for (int i = 0; i < nums.length; i++) {
				unwrapped[i] = unwrap(nums[i]);
			}
			
			return unwrapped;
		}
	}
}
