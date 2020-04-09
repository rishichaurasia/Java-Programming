package BitManipulation;

public class PascalTriangle {
	
/*						Sum
 *  1					 1	= 2^0
 *  1 1					 2	= 2^1
 *  1 2 1				 4	= 2^2
 *  1 3 3 1				 8	= 2^3
 *  1 4 6 4 1			16	= 2^4
 *  1 5 10 10 5 1		32	= 2^5
 *  						= 2^0 + 2^1 + 2^2 + 2^3 + 2^4 + 2^5 = 2^6 - 1   ( Geometric series )
 */

	public static void main(String[] args) {
		System.out.println(pascalSum(6));
	}
	
	public static int pascalSum(int n) {
		return (1 << n) - 1;
	}

}
