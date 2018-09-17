import java.util.ArrayList; 
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Strats {
	static ArrayList <String> stratsAttack = new ArrayList<String>();
	static ArrayList <String> stratsDefend = new ArrayList<String>();
	
	static int DefendInitial = 0;
	static int AttackInitial = 0;
	
	public Strats() throws FileNotFoundException
	{						//http://www.tutorialspoint.com/java/util/scanner_findinline_pattern.htm
		Scanner file = new Scanner(new FileReader("file.txt"));
	//CREATES stratsAttack
			file.findInLine("stratsAttack:");
			String StringStratsAttack = "";
			while(file.hasNextLine() == true && file.hasNext("stratsDefend:") == false)
			{
				StringStratsAttack += file.nextLine() + ",";
			//	System.out.println(StringStratsAttack);
			}
			if(StringStratsAttack.length() >= 2)
				StringStratsAttack = StringStratsAttack.substring(1 , StringStratsAttack.length()-1);
			//System.out.println(StringStratsAttack);
			String [] tempA = StringStratsAttack.split(",");
			for(int x = 0; x < tempA.length; x++)
			{
				stratsAttack.add(tempA[x]);
			}
			//System.out.println(stratsAttack);
			
	//CREATES stratsDefend
			
			file.findInLine("stratsDefend:");
			String StringStratsDefend = "";
			while(file.hasNextLine() == true && file.hasNext("stratsDefend:") == false)
			{
				StringStratsDefend += file.nextLine() + ",";
			//	System.out.println(StringStratsDefend);
			}
			if(StringStratsDefend.length() >= 2)
				StringStratsDefend = StringStratsDefend.substring(1 , StringStratsDefend.length()-1);
			String [] tempD = StringStratsDefend.split(",");
			for(int x = 0; x < tempD.length; x++)
			{
				stratsDefend.add(tempD[x]);
			}
			
	//print statement & assigns initial for SAVE();

			System.out.println("ATTACK ----- " + stratsAttack);
			System.out.println("DEFEND ----- " + stratsDefend);

			AttackInitial = stratsAttack.size();
			DefendInitial = stratsDefend.size();
		
			file.close();
	}
	
	public String Attack()					//calls random Attack
	{
		int num = (int)(Math.random()*100);
		while(num > stratsAttack.size() -1)
		{
			num = (int)(Math.random()*100);
		}
		return stratsAttack.get(num);
	}
	public String Defend()					//calls random Defense
	{
		int num = (int)(Math.random()*100);
		while(num > stratsDefend.size() -1)
		{
			num = (int)(Math.random()*100);
		}
		return stratsDefend.get(num);
	}
	public void addAttack(String str)		//Adds to stratsAttack (from GUI actionListener)
	{
		stratsAttack.add(str);
	}

	//add defend
	
	public void SAVE() throws FileNotFoundException	//SAVES ALL ELEMENTS IN THE ARRAYLISTS TO BE READ AT NEXT OPENING
	{
		int x = 0;
		int y = 0;
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter("file.txt");
		} catch (FileNotFoundException e1) {
			new File("file.txt");
			e1.printStackTrace();
		}
		writer.print("stratsAttack:");
		writer.println();
		if(AttackInitial == stratsAttack.size())
		{
			while(x <= stratsAttack.size() -1)
			{
				writer.print(stratsAttack.get(x));
				writer.println();
				x++;
			}
		}
		else if(AttackInitial < stratsAttack.size())
		{
			while(x <= stratsAttack.size() -1)
			{
				writer.print(stratsAttack.get(x));
				writer.println();
				x++;
			}
		}
		
		//----------------------------------------------------------------------------------
		
		writer.print("stratsDefend:" + "\n");
		if(DefendInitial == stratsDefend.size())
		{
			while(y <= stratsDefend.size() -1)
			{
				writer.print(stratsDefend.get(y));
				writer.println();
				y++;
			}
		}
		else if(DefendInitial < stratsDefend.size())
		{
			while(y <= stratsDefend.size() -1)
			{
				writer.print(stratsDefend.get(y));
				writer.println();
				y++;
			}
		}	
		writer.flush();
		writer.close();
	}
}