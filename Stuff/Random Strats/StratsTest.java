import java.io.FileNotFoundException;

public class StratsTest{
	public static void main(String [] args) throws FileNotFoundException
	{
		Strats test = new Strats();
	    test.addAttack("ADDED 1 TO ATTACK");

	 //  test.addDefend("STRAT 1 DEFENCE");
	    
	    System.out.println(test.Attack());
	    System.out.println(test.Attack());
	    System.out.println(test.Attack());
	    
	    test.SAVE();
	}
}
