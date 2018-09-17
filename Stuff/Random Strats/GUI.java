

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI extends JFrame implements ActionListener{
		
	JTextField Attack;
	JTextField Defend;
	JButton addAttack, addDefend, getAttack, getDefend;
	String storedAttack, storedDefend;
	
	static ArrayList <String> stratsAttack = new ArrayList<String>();
	static ArrayList <String> stratsDefend = new ArrayList<String>();
	
	static int DefendInitial = 0;
	static int AttackInitial = 0;
	
	@SuppressWarnings("resource")
	public GUI()
	{		
		Attack = new JTextField("Add Attack Strat");
		Defend = new JTextField("Add Defend Strat");
		
		addAttack = new JButton("Add Attack");
		addDefend = new JButton("Add Defend");
		getAttack = new JButton("Attacking Strat");
		getDefend = new JButton("Defending Strat");
		
		Dimension size = Attack.getPreferredSize();
		setLayout(null);
			
		Attack.setBounds(   120, 250, 435, size.height);
		addAttack.setBounds( 10, 250,  100, size.height);
			addAttack.addActionListener(this);
		getAttack.setBounds(200,  10,  200, 100);
			getAttack.addActionListener(this);
		
		Defend.setBounds(   120, 300, 435, size.height);
		addDefend.setBounds(10, 300,  100, size.height);
			addDefend.addActionListener(this);
		getDefend.setBounds(200, 120, 200, 100);
			getDefend.addActionListener(this);
		
		add(Attack);
		add(addAttack);
		add(getAttack);
	
		add(Defend);
		add(addDefend);
		add(getDefend);
		
		getContentPane().setBackground(Color.BLACK);		
		setSize(600, 400);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Random Strageties");
		
		Scanner file = null;
		try {
			file = new Scanner(new FileReader("file.txt"));
		} catch (FileNotFoundException e) {
			new File("file.txt");
			e.printStackTrace();
		}
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

	}
	
	public void actionPerformed(ActionEvent e)
	{
		int x = 0;
		int y = 0;

		
		if(e.getSource() == addAttack)				//ADD ATTACK
		{
			String temp	= Attack.getText();
				System.out.println(temp);
			stratsAttack.add(temp);
			temp = null;
		}
			
		if(e.getSource() == addDefend)  			//ADD DEFEND
		{										
			String temp = Defend.getText();
				System.out.println(temp);
			stratsDefend.add(temp);
			temp = null;
			
		}
		
		if(e.getSource() == getAttack)				//GET ATTACK
		{
			int num = (int)(Math.random()*100);
			if(stratsAttack.size() == 0)
			{
				JOptionPane.showMessageDialog(null, "You need to add strategies to use", "This rounds Attcking Stragety", 0, null);
			}
			else{
				while(num > stratsAttack.size() -1)
				{
					num = (int)(Math.random()*100);
				}
				JOptionPane.showMessageDialog(null, stratsAttack.get(num), "This rounds Attcking Stragety", 0, null);	//second null is for icon if want to add later
			}
		}
		
		if(e.getSource() == getDefend)				//GET DEFEND
		{
			int num = (int)(Math.random()*100);
			if(stratsDefend.size() == 0)
			{
				JOptionPane.showMessageDialog(null, "You need to add strategies to use", "This rounds Attcking Stragety", 0, null);
			}
			else
			{
				while(num > stratsDefend.size() -1)
				{
					num = (int)(Math.random()*100);
				}
				JOptionPane.showMessageDialog(null, stratsDefend.get(num), "This rounds Defending Stragety", 0, null);	
			}
		}

		if(e.getSource() == addDefend || e.getSource() == addAttack)	//PRINTS ALL ADDED STRATS TO THE SAVE FILE
		{																		//NOT 100% CERTIN ON LOGIC HERE
			PrintWriter writer = null;
			try {										//CHECKS FOR FILE TO SAVE TO IF THERE INITILIZES WRITER TO FILE
				writer = new PrintWriter("file.txt");
			} catch (FileNotFoundException e1) {		//IF NOT THERE CREATES NEW FILE /**needs testing to check if writer will still work after new file creation**\ SHOULD WORK BUT WILL NEED ARRAY IDENTIFIESRS REPRINTED
				new File("file.txt");
				e1.printStackTrace();
			}
			
			writer.print("stratsAttack:");								//PRINTS ATTACK SAVE
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
			if(DefendInitial == stratsDefend.size())					//PRINTS DEFEND SAVE
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
			
			System.out.println("D : " + stratsDefend);
			System.out.println("A : " + stratsAttack);
		}
	}
	
	public static void main(String[] args)
	{
		GUI w = new GUI();
		w.setVisible(true);
	}
}
