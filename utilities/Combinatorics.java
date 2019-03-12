package utilities;
/*  
 *  integer variable 'flag' specifies operation mode
 *  'flag' == 0: exponent mode, i.e. permutation with repetition
 *  'flag' == 1: combination with replacement
 *  'flag' == 2: permutation without repetition
 *  'flag' can be set to any integer other than 0, 1 or 2 for combination without replacement (standard 'n' choose 'm')
 *  
 *  factorial() and fibonacci() are tail-optimized
 *  
 */
public class Combinatorics {
	
	public static double nChooseM(double n, double m, int flag) {
		if (m > n) {
			return 0;
		} else if (m == n) {
			return 1;
		} else {
			if (flag == 0) {
				return Math.pow(n, m);
			} else if (flag == 1) {
				return factorial(n+m-1)/(factorial(n-1)*factorial(m));
			} else if (flag == 2) {
				return factorial(n)/factorial(n-m);
			} else {
				return factorial(n)/(factorial(m)*(factorial(n-m)));
			}
		}
	}
	
	public static double factorial(double n) {
		if (n <= 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			return factorial(n, 1);
		}
	}
	
	private static double factorial(double n, int base) {
		if (n == 1) {
			return base;
		}
		
		base *= n;
		return factorial(n-1, base);
	}
	
	public static int fibonacci(int n) {
		if (n < 0) {
			System.out.println("#ERROR#\nfibonacci() does not except negative values");
			return -1;
		}
		
		return fibonacci(n, 0, 1);
	}
	
	private static int fibonacci(int n, int x, int y) {
		if (n == 0) {
			return x;
		} else if (n == 1) {
			return y;
		} else {
			return fibonacci(n-1, y, x+y);
		}
	}
}
