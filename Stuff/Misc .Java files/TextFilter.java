import java.util.Scanner;

/**
 * TODO: DESCRIBE YOUR PROJECT HERE
 *
 * @author Your Name, youremail@purdue.edu
 * @version MM/DD/YY
 */
public class TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print hello message
        System.out.println("Welcome to TextFilter!");

        // Value to keep track of if the user wants to keep filtering text
        boolean keepFiltering = false;

        do {
            // Print options for the user to select
            System.out.println("Please select one of the following filtering options: \n");
            System.out.println("1. Filter Word\n" +
                    		   "2. Find-And-Replace\n" +
                    		   "3. Censor Information");

            // Save their choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                // PART 1 - Censoring Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");
                passage = scanner.nextLine();

                String word;  // The word to be censored from the text phrase
                System.out.println("Please enter the word you would like to censor: ");
                word = scanner.nextLine();

                System.out.println("Uncensored: ");
                System.out.println(passage);
                
                if( passage.equals(word) )
                {
                	// if the censored word is the only thing in the passage
                	word = "";
                	for( int i = 0; i < passage.length(); i++)
                	{
                		word += 'X';
                	}
                	passage = word;
                	word = ""; 				// set to "" to skip next sections
                }
                if( passage.contains(word) )
                {
                	// checks if word exists
                	String cen = "";
                	for( int i = 0; i < word.length(); i++ )
                	{
                		// generates the censor 
                		cen += 'X';
                	}
                	for( int i = 0; i < passage.length(); i++ )
                	{
                		if( passage.indexOf(word, i) == i )
                		{
                			int end = passage.indexOf(word, i) + word.length(); 
                			try {
                				
                				//System.out.println(passage.charAt(i - 1) + ">   <" + passage.charAt(end));
                				
                				if( passage.charAt(i - 1) == ' ' && (passage.charAt(end) == ' ' || passage.charAt(end) == '.' || passage.charAt(end) == '!' ||
                													 passage.charAt(end) == '?' || passage.charAt(end) == ',' || passage.charAt(end) == ';')   )
                				{
                        			//System.out.println(passage.substring(i, i + word.length()) + ">   " + i);
                        			
                					passage = passage.substring(0 , i) + cen + passage.substring(end);
                        			
                				}
                			} catch ( Exception e ) {
                				if( i == 0 )
                				{
                					// the word is at the start need to check for ending char
                					if( passage.charAt(end) == ' ' || passage.charAt(end) == '.' || passage.charAt(end) == '!' ||
									    passage.charAt(end) == '?' || passage.charAt(end) == ',' || passage.charAt(end) == ';')
                					{
                						//System.out.println(passage.substring(i, i + word.length()) + ">   " + i);
                						passage = passage.substring(0 , i) + cen + passage.substring(end);

                					}
									
                				} else {
                					// word is at the end check for beginning 
                					if( passage.charAt(i - 1) == ' ' )
                					{
                						//System.out.println(passage.substring(i, i + word.length()) + ">   " + i);
                            			passage = passage.substring(0 , i) + cen + passage.substring(end);

                					}
                				}
                			}
                			
                		}
                	}
                } // else : phrase doesn't exist and code is skipped
                
                System.out.println("Censored: ");
                System.out.println(passage);


            } else if (choice == 2) {

                // PART 2 - Replacing Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");
                passage = scanner.nextLine();
                

                String replace;  // The word to be filtered from the text phrase
                System.out.println("Please enter the word you would like to replace: ");
                replace = scanner.nextLine();
                
                String insert;  // The word to be inserted in the text phrase
                System.out.println("Please enter word you would like to insert: ");
                insert = scanner.nextLine();


                System.out.println("Uncensored: ");
                System.out.println(passage);

                if( passage.equals(replace) )
                {
                	// if the censored word is the only thing in the passage
                	passage = insert;
                	replace = "";          	// set to "" to skip next sections
                }
                if( passage.contains(replace) )
                {
                	// checks if word exists
                	for( int i = 0; i < passage.length(); i++ )
                	{
                		if( passage.indexOf(replace, i) == i )
                		{
                			int end = passage.indexOf(replace, i) + replace.length(); 
                			try {
                				
                				//System.out.println(passage.charAt(i - 1) + ">   <" + passage.charAt(end));
                				
                				if( passage.charAt(i - 1) == ' ' && (passage.charAt(end) == ' ' || passage.charAt(end) == '.' || passage.charAt(end) == '!' ||
                													 passage.charAt(end) == '?' || passage.charAt(end) == ',' || passage.charAt(end) == ';')   )
                				{
                        			//System.out.println(passage.substring(i, i + replace.length()) + ">   " + i);
                        			passage = passage.substring(0 , i) + insert + passage.substring(end);
                        			
                				}
                			} catch ( Exception e ) {
                				if( i == 0 )
                				{
                					// the word is at the start need to check for ending char
                					if( passage.charAt(end) == ' ' || passage.charAt(end) == '.' || passage.charAt(end) == '!' ||
									    passage.charAt(end) == '?' || passage.charAt(end) == ',' || passage.charAt(end) == ';')
                					{
                						//System.out.println(passage.substring(i, i + replace.length()) + ">   " + i);
                						passage = passage.substring(0 , i) + insert + passage.substring(end);

                					}
									
                				} else {
                					// word is at the end check for beginning 
                					if( passage.charAt(i - 1) == ' ' )
                					{
                						//System.out.println(passage.substring(i, i + replace.length()) + ">   " + i);
                            			passage = passage.substring(0 , i) + insert + passage.substring(end);

                					}
                				}
                			}
                			
                		}
                	}
                } // else : phrase doesn't exist and code is skipped

                System.out.println("Censored: ");
                System.out.println(passage);



            } else if (choice == 3) {

                // PART 3 - Censoring Personal Information


                /*
                 * DO NOT ALTER THIS CODE! This formatting is imperative to the completion of this task.
                 *
                 * Keep asking for input until the user enters an empty line
                 * If they enter an empty line and the phrase is empty, keep waiting for input
                 */
                String passage = "";  // String for holding text to be filtered

                System.out.println("Please enter the phrase you would like to censor information from: ");

                while (true) {

                    // Obtain a line from the user
                    String temp = scanner.nextLine();

                    if (!passage.isEmpty() && temp.isEmpty()) {
                        break;
                    } else if (passage.isEmpty() && temp.isEmpty()) {
                        continue;
                    }


                    // Add the contents of temp into the phrase
                    passage += temp;


                    // Append a newline character to each line for parsing
                    // This will separate each line the user enters
                    // To understand how input is formatted in Part 3, please refer to the handout.
                    passage += '\n';
                }

                // Print the uncensored passage
                System.out.println("Uncensored: ");
                System.out.println(passage);

                String[] raw = passage.split("\n");				// raw data is put into list to be sifted through
                TextFilter t = new TextFilter(); 				// creates object to use custom "replaceAt" method 
                String val = null;
                passage = "";									// set to empty to be refilled later
                
                int x = 0;
                while( x < raw.length )
                {
                	/*
                	 * Sifts through each element and matches the type of information entered
                	 * to the required censoring. The is taken out of the array into a String 
                	 * 
                	 * code assumes data is entered correctly as stated in Project description 
                	 */
                	String type = raw[x].substring( 0, raw[x].indexOf(':') );			// type of data
                	val  = raw[x].substring( raw[x].indexOf(':') + 2 );			// value of data
                	
                	if( type.equalsIgnoreCase("name") )
                	{
                		// removes all but first & last letter of the series
                		for( int i = 1; i < val.length()-1; i++ )
                		{
                			if( val.charAt(i) == ' ' )
                			{
                				continue;
                			} else {
                				val = t.replaceAt(val, i, '*');
                			}
                		}
                	}
                	
                	if( type.equalsIgnoreCase("email") )
                	{
                		// removes all but first of address & domain and all of extension
                		for( int i = 1; i < val.lastIndexOf('.'); i++ )
                		{
                			if( val.charAt(i) == '@' )
                			{
                				i++;
                			} else {
                				val = t.replaceAt(val, i, '*');
                			}
                		}
                	}
                	
                	if( type.equalsIgnoreCase("phone") )
                	{
                		// removes all but last 4 digits in user entered syntax
                		for( int i = 0; i < val.length() - 4; i++ )
                		{
                			if( Character.isDigit(val.charAt(i)) )
                			{
                				// when the char is a digit ; allows for any type of separation of digit sets
                				val = t.replaceAt(val, i, '*');
                			}
                		}
                	}
                	x++; 
                	passage += type + ": " + val + "\n"; 
                }
                
                
                // Print the censored passage
                System.out.println("Censored: ");
                System.out.println(passage);

            } else {

                // They entered a number that was not 1, 2 or 3
                System.out.println("The option you chose was invalid!");

            }
            
            String go = "";
            System.out.println("Would you like to keep filtering? Yes/No");
            do {
            	go = scanner.nextLine();
            } while ( go.equals("") );
            if( go.equalsIgnoreCase("yes") )
            	keepFiltering = true;
            else
	            keepFiltering = false;

        } while (keepFiltering);

        System.out.println("Thank you for using TextFilter!");

    }
    
    public String replaceAt(String s, int index, char ch )
    {
    	s = s.substring(0, index) + ch + s.substring(index + 1);
    	return s;
    }

}



















