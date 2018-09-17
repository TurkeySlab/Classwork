import java.math.BigDecimal;
import java.util.Scanner;

public class SqrtEstimator {
	public static void main(String args[])
	{
		boolean number = false;					// assumes the number is correct : used for loop control 
		boolean run    = true;					// used for loop control : changes when user enters "quit"
		
		int   val = 0, per = 0;					// value to find square root of : precision to return
		double up = 0, low = 0, p = 0;			// upper and lower boundaries of val : the current point
		String pt;							    // the final value to be "trimed" to the user precision
				
		String input   = "";	    			// used to stores user's most recent input
		Scanner s = new Scanner(System.in);		// its a Scanner 
		
		while( run )
		{
			do 
			{
				try
				{
					System.out.println("Enter a positive number to find the square root of: [type quit to exit]");
					input = s.nextLine();
					val   = Integer.parseInt(input);
					
					if( val < 0 )
					{
						// checks if number is greater than zero & breaks to restart if isn't
						System.out.println("Enter a positive number");
						number = false;
						break;
					}
					
					// initializes per and checks again for messed up inputs
					System.out.println("Enter the precision of the estimator (number of digits after the decimal point):");
					input = s.nextLine();
					per   = Integer.parseInt(input);
					
					// both numbers entered are proven valid and loop will exit
					number = true;
				} catch ( Exception e ) {
					// if this is accessed then user has entered a letter or symbol
					if( input.equals("quit"))
					{
						//if user inputs either of the exit commands
						run = false;
						break;
					} 
					// only be reached when random characters are entered
					System.out.println("Error: Please enter a non zero number");
				}
				
			}while ( !number );		// loop runs while the most recent inputs are invalid
						
			s.close();		// closes the Scanner
			
			// if there are no errors then we proceeded
			
			up = val;		// assigns the upper bound
			p = (up + low) / 2.0;	// p assigned to the middle value of the upper and lower bound
			System.out.println(low+"   "+p+"   "+up+"   :   "+val+"   "+ per);
			while( number )
			{
				// tries to find the square root
				p = (up + low) / 2.0;	// p assigned to the middle value of the upper and lower bound at the start of the loop
										// 	up and low are changed in relation to the condition p^2 results in 
				
				System.out.println(p + " =  " + p * p + "    : " + val );
				if( Math.abs(p*p - val) <= .0000000001 )
				{
					pt = p + "";		//initializes to be trimmed
					System.out.println("----- " + pt + "   " + per);
					try {
						// trims off extra values
						pt = pt.substring(0, pt.indexOf('.')  + per + 1);
					} catch ( Exception e) {
						// if the value of the square root has less decimals than requested : '0' is appended
						for( int i = 0; i < per - 1; i++)
						{
							pt += "0";
						}
					}
					
					System.out.println("---- : " + pt);
					
					System.out.printf("Square root of %d: %s\n\n", val, pt);
					break;
				}
				if( p*p > val )
				{
					// when p^2 is greater than val
					up = p;
				}
				if( p*p < val )
				{
					// when p^2 is less than val
					low = p;
				}
				
			}
			number = false;
			p = 0;
			up = 0;
			pt = "";
			low = 0;
		}
		
		System.out.println("Quiting...");
		System.out.println("Goodbye!");
		
	}
}









