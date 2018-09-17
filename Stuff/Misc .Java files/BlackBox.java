import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author  maxwell williams
 * @version 02/22/2018
 * 
 * This code simulates the black box game 
 */
public class BlackBox {
    public static char box[][]; // The matrix for the game.
    public static int size;       // to store the number of rows and columns.
    public static int numball;
    public static int numlink;
    public static boolean end;
    public static int score;
    public static int high_score = 10;
    public static int guess[][] = new int[3][2];		// each game gets 3 guesses that are saved as a point
    public static int guessCt = 0;						// used to move the index of the user's guesses
    /**
     * The default constructor which places default values to the class variables
     */
    public BlackBox()
    {
        this.box = new char[0][0];
        this.size = 0;
        this.numball = 0;
        this.numlink = 0;
        this.end = false;
        this.score = 0;
    }
    /**
     * The parameterized constructor which places values to the class variables
     */
    public BlackBox(int size, int numball, int numlink, boolean end, int score)
    {
        this.box = new char[size][size];
        this.size = size;
        this.numball = numball;
        this.numlink = numlink;
        this.end = end;
        this.score = score;
    }
    /**
     * The main function takes input for the difficulty level and call the functions initialize(int) and
     * playgame()
     */
    public static void main(String[] args) {
    	BlackBox b = new BlackBox();		// done for vocarium 
    	b.check(1, 2);
    	
    	Scanner s = new Scanner(System.in);
    	String input = "";
    	boolean played = false, con = false;
    	do {
    		System.out.println("Welcome to the Blackbox Game! Please choose the difficulity level:\n"
					 + "easy/ medium/ hard. or quit to end the game ");
    		input = s.nextLine();
    		// checks the input from the user and alters the required values relative to the input
    		// size is set to be +2 of board size to handle borders
    		if( input.equalsIgnoreCase("easy") )
    		{
    			size = 7;
    			initialize();		// size has been created; now creating the board
    	    	printbox();			// initial board is printed
    	    	playgame();			// game is started
    	    	played = true;
    		} else if( input.equalsIgnoreCase("medium") ){
    			size = 9;
    			initialize();		// size has been created; now creating the board
    	    	printbox();			// initial board is printed
    	    	playgame();			// game is started
    	    	played = true;
    		} else if( input.equalsIgnoreCase("hard") ) {
    			size = 10;
    			initialize();		// size has been created; now creating the board
    	    	printbox();			// initial board is printed
    	    	playgame();			// game is started
    	    	played = true;
    		} else if( input.equalsIgnoreCase("quit") ) {
    			// leaves
    			System.out.println("Goodbye!");
    			return;
    		} else {
    			// there was not a valid input
    			// input is reset and the question is asked again
    			System.out.println("Please choose the difficulity level:\n" + 
    					"easy/ medium/ hard. or quit to end the game");
    			input = "";
    		}
    		if( played )
    		{
    			// checks if you want to play another game
    			do {
    				System.out.println("Would you like to play again? ( yes/ no )\n");
    				String answ = s.nextLine();
    				if( answ.toLowerCase().charAt(0) == 'y' )
    				{
    					System.out.println("Alright new game!\n\n");
    					con = true;
    					break;
    				} else if ( answ.toLowerCase().charAt(0) == 'n' ) {
    					System.out.println("Play again soon!");
    					break;
    				}
    			} while( true );
    		}
    	} while ( con );
    }
    /**
     * The initialize function
     */
    public static void check(int i, int j ) {
    	//done for vocarium
    }
    public static void initialize() {
    	box = new char[size][size];					// generates the matrix
    	
    	for( int i = 0; i < size; i++ )
    	{
    		for( int j = 0; j < size; j++ )
    		{
    			if( i == 0 || i == size - 1)		// handles top and bottom
    				box[i][j] = '#';
    			if( j == 0 || j == size - 1)		// handles left and right columns
    				box[i][j] = '#';
    			if( (i == 0 && j == 0) || ( i == 0 && j == size -1 ) || ( i == size -1 && j == 0 ) || (i == size -1&& j == size -1) )	// handles corners
    				box[i][j] = 'X';
    		}
    	}
    	for( int i = 0; i < 3; i++ )
    	{
    		// generates 3 random ball locations in [i][j] point form
    		boolean validPlace = false;
    		Random r = new Random();
    		do
    		{
    			// generates a new point in the matrix
    			int x = r.nextInt(size - 2) + 1, y = r.nextInt(size - 2) + 1;
    			if( box[x][y] == 'o' )
    			{
    				// there is already a ball at the location 
    				validPlace = false;
    			} else {
    				// adds a ball to the location and changes loop parameter 
    				box[x][y] = 'o';
    				validPlace = true;
    			}
    			// will continue to generate new [i][j] values until a new ball is placed
    		} while ( !validPlace );
    	}
    }
    /**
     * The printbox function prints out the matrix in a particular format as given in the handout.
     */
    public static void printbox() {
        //Todo:print the box in the correct order
        // for  5*5 example
        /*1  2  3  4  5  6  7
         ======================
        1|X |# |# |# |# |# |X |
        2|# |  |  |  |  |  |# |
        3|# |  |  |  |  |  |# |
        4|# |  |  |  |  |  |# |
        5|# |  |  |  |  |  |# |
        6|# |  |  |  |  |  |# |
        7|X |# |# |# |# |# |X |
         ======================*/
        //place the guesses as they come and print the balls when the player enter submit..
    	if( size == 10)					// done to line up bottom row for hard mode
    		System.out.print("  |");
    	else
    		System.out.print(" |");
    	for( int i = 1; i < size + 1; i++ )
    	{
    		System.out.print(i + "  ");
    	} 
    	String f = String.format("\n   %" + (( size * 3 )) + "s", "").replace(" ", "=");	// adjusts for variable game box sizes ( 3.75 )
    	System.out.println( f );
    	
    	for(int i = 1; i < size + 1; i++)		
    	{	
    		if( i < 10 )					// done to line up bottom row for hard mode
    			System.out.print(i + " |");
    		else 
    			System.out.print(i + "|");
    		
    		for( int j = 0; j < size; j++ )
    		{
    			// prints the "cells"
    			if( box[i - 1][j] == 'o' )
    			{
    				System.out.print("  |");
    			} else {
    				System.out.print(box[i - 1][j] + " |");
    			} 
    			//System.out.print(box[i - 1][j] + " |");
    		}
    		
    		if( i == size )				// used to determine bottom line to not have the bottom border "hanging"
    			System.out.print("");
    		else
    			System.out.println();
    	}
    	System.out.print(f);
    	System.out.println("\n");
    	
    }
    public static void submitGame()
    {
    	boolean right = true;
    	for( int x = 0; x < 3; x++)
    	{
    		// compares guesses
    		int i = guess[x][0], j = guess[x][1];
    		if( box[i - 1][j - 1] != 'o' )
    		{
    			right = false;
    		}
    	}
    	if( right )
    	{
    		// user had a winning game
    		System.out.println("\n\nYou Won! :D");
    		if( score <= high_score )
    		{
    			System.out.println("You beat the highscore!");
    			high_score = score;
    		}
    		else 
    			System.out.println("So close to breaking the record!\n\tYou scored: " + score);
    		System.out.println("Highscore: " + high_score);
    	} else {
    		// user is the worst player in the world and lost the game
    		System.out.println("\n\nYou Lost! :/");
    		System.out.println("Maybe next time guess the balls correctly.");
    	}
    }
    /**
     * The playgame function opens the first cell and is the main controller for the game. It calls various function when needed.
     */
    public static void playgame() {
    	/*
    	 * 						   -------------------------------------------------------
    	 * 						<<  DOES NOT USE CHECK METHOD THIS WORKS ON A TICK SYSTEM  >>
    	 * 						   -------------------------------------------------------
    	 * 
    	 * This game operates on a step-by-step beam system. The user input port fires the "beam" which move in a linear motion
    	 * perpendicular to the entry port. At the current beam location ( so if the beam was fired from [0][5] the current
    	 * location would be at [0][6] because the beam is moving right from the entry point. ) the 3 checks reflection, hit, 
    	 * deflection are checked in order by the project description and the beam will be moved 1 unit relative to direction
    	 * of the beam and if any ball interaction occurred. Because the game operates on a 'tick' system the beam is able to
    	 * interact with multiple ball objects making the game simulation operate like a real game would.
    	  
    	 * playgame() operation and logic
    	 * 1 ) Input is received from the user for next move. The input will either quit, submit a guess, or fire a beam
    	 * 		a) game is exited
    	 * 		b) user is prompted for a guess to submit
    	 * 		c) a new beam is fired from the port
    	 * 2 ) If a new beam is fired
    	 * 		1) starting coordinates are defined, the beam coordinates are defined, all other variables reset
    	 * 		2) from the starting port the beam checks if there is a reflection or hit directly next to the port
    	 * 		3) if the beam was not returned the beam is moved forward 1 space perpendicular to the port
    	 * 		4) Beam is checked for reflections, hits, or deflections
    	 * 			a) reflection : the beam is "killed" and a 'R' is returned to the firing port
    	 * 			b) hit        : the beam is "killed" and a 'H' is returned to the firing port
    	 * 			c) deflection : the beam is moved 1 unit relative to the deflection and the beam is marked as not a
    	 * 							straight beam through its return values
    	 * 		5) beam is moved the unit defined by the deflection check
    	 * 		6) steps 3 - 6 are repeated until the beam exits the box
    	 * 		7) exit notation is placed on the firing port
    	 */
    	int i, j;						// the beams current location
    	int iStart, jStart;				// the firing port
    	int[] val = new int[3];			// used to both move the beam relative to the balls and detect straight rays
    	int d;							// the direction of movement for methods
    	boolean inBounds = true, str8 = true, game = true;	// handles beam movement loop; used to determine if the beam moved straight; master game control
    	int beamExits = 1;				// used for updating the margin values for user returns
    	String input = "";
    	
    	Scanner s = new Scanner( System.in );
    	do {
    		/* 
    		 * the master game control
    		 * gets inputs, tests values and prints the end result 
    		 */
    		System.out.println("Choose the new coordinate (row, column) to play the next step or say submit/ quit");
    		input = s.nextLine();
    		input = input.replaceAll("\\s+", "");			// remove all white space
    		Pattern pattern = Pattern.compile("\\d,\\d");	// pattern to match a coordinate
    		Matcher matcher = pattern.matcher(input);		// object to check with the pattern
    		
    		if( input.equalsIgnoreCase("quit") )
    		{
    			// user request to leave the game ( really weird doubt this will be used because the game is the best like 10/10 by IGN game )
    			System.out.println("\tThanks for playing!\n");
    			return;
    		} else if( input.equalsIgnoreCase("submit") ) {
    			String in = "";
    			do {
    				if( guessCt == 3 )
    				{
        				/*
        				 * used to allow for the user to change old submissions 
        				 * this code is reached when the user enters 3 guesses but then exits the submission screen
        				 * 
        				 */
    					System.out.println("You have entered 3 guesses would you like to submit them?\n"
    									 + "Say 'submit' to submit"
    									 + "\nSay 'change' to change a guess");
    					System.out.println("\t1)  " + guess[0][0] + ", " + guess[0][1] +
    							   		   "\n\t2)  " + guess[1][0] + ", " + guess[1][1] + 
    							   		   "\n\t3)  " + guess[2][0] + ", " + guess[2][1] + "\n");
    					in = s.nextLine();
    					if ( in.equalsIgnoreCase("change") ) 
    					{
    						do {
    	    					try {
    	    						System.out.println("Enter the guess you want to change:");
    	    						in = s.nextLine();
    	    						int index = Integer.parseInt( in.substring(0, 1) );
    	    						index--;		// removes 1 because 0 is start
    	    						
    	    						if( index < 3 )
    	    						{
    	    							System.out.println("Enter a coordinate to replace " + guess[index][0] + ", " + guess[index][1] + " : ");
    	    							String temp = s.nextLine();
    	    							guess[index] = coordinates(temp);
    	    						} else { 
    	    							System.out.println("\tPlease enter a valid input\n");
    	    						}
    	    					} catch ( Exception e ) {
    	    						continue;
    	    					}
    	    					//runs until a second enter is pressed
    						} while( !in.replaceAll("\\s+", "").equals("") );
    						System.out.println("\tReturning to game... \n");
        				} 
    					if ( in.equalsIgnoreCase("submit") )
    					{
    						submitGame();
    						//s.close();
    						return;		// game is over returning to paly another
    					}
    				} else {
    					/*
    					 * User typed 'submit' 
    					 * user is now allowed to view old submissions
    					 * change old submissions
    					 * add new submissions
    					 * and submit final inputs
    					 */
	    				System.out.println("\t1) Enter a corrdinate pair to place a guess 'x, y'\n"
								 + "\t2) Say 'view' to see previous guesses\n"
								 + "\t3) Say 'change' to change a guess\n"
								 + "\t\t( press enter a second time to return to firing )");
	    				
	    				in = s.nextLine();
	    				matcher = pattern.matcher(in);		// used to check if input is a coordinate
	    				if( in.equalsIgnoreCase("view") )
	    				{
	    					System.out.println("\t\t1)  " + guess[0][0] + ", " + guess[0][1] +
	    									   "\n\t\t2)  " + guess[1][0] + ", " + guess[1][1] + 
	    									   "\n\t\t3)  " + guess[2][0] + ", " + guess[2][1] + "\n");
	    				} else if ( in.equalsIgnoreCase("change") ) {
    						do {
    	    					try {
    	    						System.out.println("Enter the guess you want to change:");
    	    						in = s.nextLine();
    	    						int index = Integer.parseInt( in.substring(0, 1) );
    	    						index--;		// removes 1 because 0 is start
    	    						
    	    						if( index < 3 )
    	    						{
    	    							System.out.println("Enter a coordinate to replace " + guess[index][0] + ", " + guess[index][1] + " : ");
    	    							String temp = s.nextLine();
    	    							guess[index] = coordinates(temp);
    	    						} else { 
    	    							System.out.println("\tPlease enter a valid input\n");
    	    						}
    	    					} catch ( Exception e ) {
    	    						continue;
    	    					}
    	    					//runs until a second enter is pressed
    						} while( !in.replaceAll("\\s+", "").equals("") );
    						System.out.println("\tReturning to game... \n");
        				} else if( matcher.find() ) {
	    					guess[guessCt] = coordinates(in);		// saves the returned point
	    					guessCt++;
	    					if( guessCt == 3 )
	    					{
	    						System.out.println("You have entered 3 guesses would you like to submit them?\n"
	    										 + "Say 'submit' to submit"
	    										 + "\nSay 'change' to change a guess");
	    						System.out.println("\t1)  " + guess[0][0] + ", " + guess[0][1] +
										   		   "\n\t2)  " + guess[1][0] + ", " + guess[1][1] + 
										   		   "\n\t3)  " + guess[2][0] + ", " + guess[2][1] + "\n");
	    						in = s.nextLine();
	    						if ( in.toLowerCase().contains("change") ) {
	        						do {
	        	    					try {
	        	    						System.out.println("Enter the guess you want to change:");
	        	    						in = s.nextLine();
	        	    						int index = Integer.parseInt( in.substring(0, 1) );
	        	    						index--;		// removes 1 because 0 is start
	        	    						
	        	    						if( index < 3 )
	        	    						{
	        	    							System.out.println("Enter a coordinate to replace " + guess[index][0] + ", " + guess[index][1] + " : ");
	        	    							String temp = s.nextLine();
	        	    							guess[index] = coordinates(temp);
	        	    						} else { 
	        	    							System.out.println("\tPlease enter a valid input\n");
	        	    						}
	        	    					} catch ( Exception e ) {
	        	    						continue;
	        	    					}
	        	    					//runs until a second enter is pressed
	        						} while( !in.replaceAll("\\s+", "").equals("") );
	        						System.out.println("\tReturning to game... \n");
	            				} 
	        					if ( in.equalsIgnoreCase("submit") )
	        					{
	        						submitGame();
	        						//s.close();
	        						return;				// game is over returning to prompt for another game
	        					}
	    					}
	    				} else {
	    					System.out.println("\tPlease enter a valid input\n");
	    				}
    				}
    				
    				
    			} while ( !in.replaceAll("\\s+", "").equals(""));
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * * * * * *
 * * * * * * The user entered a coordinate and will run the beam and return the outputs
 * * * * * *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    		} else if ( matcher.find() ) {		// user entered x,y input 
    			int[] temp;
    			score++;						// user entered a guess increasing score
    			temp = coordinates(input);		// gets the coordinates
    			
    			iStart = temp[0] - 1;				// saves starting values for user returns 
    			jStart = temp[1] - 1;				//  ...
    			
    			i = iStart;							// assigns beam location variables to move beam
    			j = jStart;							//  ...
    			
    			inBounds = true;					// boolean values and directions are reset
    			str8 = true;						//   ...
    			d = getDirection(i, j);	 			//  ... 		TODO : set d relative to input
    			
		    	while( inBounds )
		    	{	
		    		/*
		    		 * this loop handles beam movement and will run while the (i, j) beam location 
		    		 * is within the grid. the loop will also exit in the even that the beam leaves the 
		    		 * board due to a reflection at the detection of a reflection
		    		 */
		    		if( reflectionCheck(i, j, d) )		// a reflection has been detected the starting coordinates will be updated
		    		{
		    			//System.out.println("Reflection @ : " + i + ", " + j );
		    			box[iStart][jStart] = 'R';		// updates the margin 
		    			inBounds = false;				// beam 'exited' getting new input for next beam
		    		}
		    		
		    		if( hitcheck(i, j, d) )				// placed above because stacked balls will return a deflection when it should be a hit
		    		{
		    			//System.out.println("Hit @ : " + i + ", " + j);
		    			box[iStart][jStart] = 'H';		// updates the margin 
		    			inBounds = false;				// beam 'exited' getting new input for next beam
		    		}
		    		
		    		val = deflectionCheck(i, j, d);		// gets data from deflection and uses values to alter beam location (i, j)
		    		i += val[0];						// moves i relative to
		    		j += val[1];						// moves j relative to 
		    		d  = val[3];						// changes direction relative to
		    		if( val[2] == 1 )
		    			str8 = false;					// there was a deflection beam is no longer straight
		    		
		    		if( i == 0 || i == size - 1 || j == 0 || j == size - 1 )
		    		{
		    			if( str8 )
		    			{
		    				// the beam path was not altered
		    				box[iStart][jStart] = Character.forDigit(beamExits, 10);
		    				box[i][j] 			= Character.forDigit(beamExits, 10);
		    				beamExits++;
		    			} else {
		    				// the beam path was altered
		    				box[iStart][jStart] = Character.forDigit(beamExits, 10);
		    				box[i][j] 			= Character.forDigit(beamExits, 10);
		    				beamExits++;
		    			}
		    			inBounds = false;
		    		}
		    		/* 
		    		 * Uncomment to see the laser
		    		 * box[i][j] = '*';					// used to "track" laser
		    		 * printbox();
		    		 * 
		    		 */
		    	}
		    	printbox();							// updates playing field
    		}
    	} while( game );
    	s.close();
    }
    /**
     * The hitcheck function takes in the row and column in the matrix, checks for Hit (H)
     *
     */
    public static boolean hitcheck(int i,int j, int d) 
    {
    	/* 
    	 * @return : if the next point the laser will hit is a ball then a hit char 'H' is placed at the entry point
    	 */
    	try {
	    	if( d == 2 )		// coming from left
	    		if( box[i][j-1] == 'o' ) 			
	    			return true;
			if( d == 4 )		// coming from right
				if ( box[i][j+1] == 'o' ) 		
					return true;
			if( d == 1 )		// coming from bottom
				if( box[i-1][j] == 'o' ) 			
					return true;
			if( d == 3 )		// coming from top
				if( box[i+1][j] == 'o' )			// down right	
					return true;
    	} catch( ArrayIndexOutOfBoundsException e ) {
    		return false;
    	}
    	return false;
    }
    /**
     * The check function takes in the row and column in the matrix, checks for Reflection (R)
     */
    public static boolean reflectionCheck(int i,int j, int d)
    {
    	/* @ return : will return true if
    	  				1) a ball is 45 from the entry point causing a reflection
    	  				2) there is "ball-space-ball" combination 
    	 * @return  : if this returns true the loop is exited and a reflection char 'R' is placed at the entry point
    	 */
    	if( i == 0 ) {					// top row 
    		if( box[i+1][j+1] == 'o' || box[i+1][j-1] == 'o' )
    		{
    			return true;
    		}
    	} else if ( i == size - 1 ) { 	// bottom row
    		if( box[i-1][j-1] == 'o' || box[i-1][j+1] == 'o' ) 
    		{
    			return true;
    		}
    	} else if ( j == 0 ) {			// left col	 
    		if( box[i+1][j+1] == 'o' || box[i-1][j+1] == 'o' )
    		{
    			return true;
    		}
    	} else if ( j == size - 1) {	// right col
    		if( box[i+1][j-1] == 'o' || box[i+1][j-1] == 'o' ) 
    		{
    			return true;
    		}
    	}
    	/*
    	 *  if the "laser" has passed the entry point and is inside the box
    	 */
    	if( i != 0 && i != size - 1 )
    	{
	    	if( d == 2 && j < size - 1 )		// coming from left
	    		if( box[i-1][j+1] == 'o' && box[i+1][j+1] == 'o' ) 			
	    			return true;
			if( d == 4 )		// coming from right
				if ( box[i-1][j-1] == 'o' && box[i+1][j-1] == 'o') 		
					return true;
    	} 
    	if( j != 0 && j != size - 1 )
    	{
			if( d == 1 )		// coming from bottom
				if( box[i-1][j+1] == 'o' && box[i-1][j-1] == 'o' ) 			
					return true;
			if( d == 3 )		// coming from top
				if( box[i+1][j+1] == 'o' && box[i+1][j-1] == 'o')		
					return true;
    	}
    	return false;
    }
    /**
     * The check function takes in the row and column in the matrix, checks for Divergence(#num)
     */
    public static int[]  deflectionCheck(int i, int j, int d)
    {
    	/* 
    	   @parm d : the direction the "laser" is moving towards ( N,S,E,W ) = ( 1,2,3,4 )
    	   @Note   : This is the only method that will move the point ( i, j ) relative to the firing direction
    	   @return : the direction to move the "laser" from point ( i, j ) 
    	 		    	[0] > moves i  
    	 		    	[1] > moves j  
    	 		    	[2] > if there was a deflection	 
    	 		    	[3] updates direction  :  1=N 2=E 3=S 4=W
    	 		    	
    			   		if [2] == 1 then straightRay boolean will be false
    	   @return : the loop will exit and place a deflection char 'current-delfection-num' if straightRay is false and ( i, j ) reaches the end
    	*/
		if( d == 2 )		// coming from left
		{
			if( box[i-1][j+1] == 'o' ) 			// up right
				return new int[] {1, 0, 1, 3};
			else if( box[i+1][j+1] == 'o' )		// down right	
				return new int[] {-1, 0, 1, 1};
			
			return new int[] {0, 1, 0, 2};			// moves space 1 right
		} 
		if( d == 4 )		// coming from right
		{
			if ( box[i-1][j-1] == 'o' ) 		// up left
				return new int[] {1, 0, 1, 3};
			else if( box[i+1][j-1] == 'o' )		// down left	
				return new int[] {-1, 0, 1, 1};
			
			return new int[] {0, -1, 0, 4};		// moves space 1 left
		}
		if( d == 1 )		// coming from bottom
		{
			if( box[i-1][j+1] == 'o' ) 			// up right
				return new int[] {0, -1, 1, 4};
			else if ( box[i-1][j-1] == 'o' ) 	// up left
				return new int[] {0, 1, 1, 2};
			
			return new int[] {-1, 0, 0, 1};		// moves space up 1
		}
		if( d == 3 )		// coming from top
		{
			if( box[i+1][j+1] == 'o' )			// down right	
				return new int[] {0, -1, 1, 4};
			else if( box[i+1][j-1] == 'o' )		// down left	
				return new int[] {0, 1, 1, 2};
			
			return new int[] {1, 0, 0, 3};			// moves space down 1
		}
		// ( will not be reached )
		return new int[] {};
    }
    public static char getDirection( int i, int j )
    {
    	// calculates the direction of the beam from the firing port
    	// done to clean up play game 
    	if( i == 0 ) {
    		return 3;
    	} else if ( i == size - 1 ) {
    		return 1;
    	} else if ( j == 0 ) {
    		return 2;
    	} else if ( j == size - 1 ) {
    		return 4;
    	}
    	return '?';
    }
    public static int[] coordinates(String in)
    {
    	/*
    	 * Returns the coordinate pair based on input and removes all white space 
    	 * [0] = i
    	 * [1] = j
    	 */
    	in = in.replaceAll("\\s+", "");
    	return new int[] {Integer.parseInt(in.substring(0, in.indexOf(','))), Integer.parseInt(in.substring(in.indexOf(',') + 1))};
    }
}














