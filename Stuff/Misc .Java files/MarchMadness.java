import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MarchMadness {
	String[] teams = {  "virginia", "umbc", "creighton", "kansasst", "kentucky", "davidson", "arizona", "buffalo", "miami", "loyolachicago", "tennessee", "wrightstate", "nevada", "texas", "cincinnati",
						"georgiastate", "villanova", "radford", "virginiatech", "alabama", "westvirginia", "murraystate", "wichitastate", "marshall", "florida", "stbonaventure", "texastech", "sfa",
						"arkansas", "butler", "purdue", "csufullerton"
					 };		// used to compare input 
	
	public boolean isTeam( String team )
	{
		if( team == null )
		{
			// null check for when user "cancels" a team input, this will terminate the program
			System.exit(0);
		}
		
		team = team.replaceAll("[^a-zA-Z ]", "");			// replaces all punctuation 
		team = team.replaceAll("\\s+", "");
		
		for( int i = 0; i < teams.length; i++ )
		{
			if( team.equalsIgnoreCase(teams[i]) )
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main( String[] args )
	{
		MarchMadness mm = new MarchMadness();

		try {
			 // attempts to set the look and feel of the UI 
	        UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
	    } 
	    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	    	// if it fails oh well
	    	System.out.println("Error setting look and feel");
	    }
		 
		int returnValue = 0;					// used for loop control
		do {
			/*
			 * This loop block handles all of the inputs from the user
			 * 
			 * values are declared here to insure that they are reset at each turn
			 */
			
			String team1 = "",  team2 = "";			// name of the team
			double per1  = 0 ,  per2  = 0;			// percent win
			int    wins1 = 0 ,  wins2 = 0;			// counter for the team wins
			
			do {
				team1 = JOptionPane.showInputDialog(null, "Enter the name of team one");
				if( !mm.isTeam(team1) )
				{
					// not valid team 
					JOptionPane.showMessageDialog(null, "Team must be on the 2018 NCAA bracket");
				}
			} while( !mm.isTeam(team1) );
			
			do {
				team2 = JOptionPane.showInputDialog(null, "Enter the name of team two");
				if( !mm.isTeam(team1) )
				{
					// not valid team 
					JOptionPane.showMessageDialog(null, "Team must be on the 2018 NCAA bracket");
				}
			} while( !mm.isTeam(team2) );
			
			
			do {
				per1 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter team one's win percentage") );
				per2 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter team two's win percentage") );

				if( per1 > 100 || per1 < 0 )
				{
					// check for valid range
					do { 
						JOptionPane.showMessageDialog(null, "Invalid Input: The win percentage must be between 0 and 100");
						per1 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter team one's win percentage") );
					} while( per1 > 100 || per1 < 0 );
				} 
				if( per2 > 100 || per2 < 0 )
				{
					// check for valid range
					do { 
						JOptionPane.showMessageDialog(null, "Invalid Input: The win percentage must be between 0 and 100");
						per2 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter team one's win percentage") );
					} while( per2 > 100 || per2 < 0 );
				}
				
				if( (per1 + per2) != 100 )
				{
					// displays error message if percentage is not valid
					JOptionPane.showMessageDialog(null, "Invalid Input: The total win percentage must equal 100");
				}
			} while( (per1 + per2) != 100 );		// gets team percentages until they add to 100
			
			String[] buttons = { "5", "10", "15", "20" };    
			returnValue = JOptionPane.showOptionDialog(null, "Choose the number of simulations you want to run", "March Madness Simulator", 
														   JOptionPane.YES_NO_OPTION, 0, null, buttons, buttons[0]);
			
			for( int i = 0; i < Integer.parseInt(buttons[returnValue]); i++ )
			{
				int value =  (int) (100 * Math.random());		//	generates a random number
				
				System.out.println(value);
				
				if( value <= per1 )
				{
					// team 1 wins
					wins1++;
				} else if( value > per1 ) {
					// team 2 wins
					wins2++;
				}
			}
			JOptionPane.showMessageDialog(null, team1 + " Wins: " + wins1 + " & " + team2 + " Wins: " + wins2);
			
			returnValue = JOptionPane.showOptionDialog(null, "Choose the number of simulations you want to run", "March Madness Simulator", 
					   								   JOptionPane.YES_NO_OPTION, 0, null, new String[]{"Yes", "No"}, 0);
			
		} while( returnValue == 0 );		// Exits if the user wants otherwise everything is done again
		
		JOptionPane.showMessageDialog(null, "Thank you for simulating March Madness");
		
	}
}



















