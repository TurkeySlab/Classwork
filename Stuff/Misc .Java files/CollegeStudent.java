
public class CollegeStudent {
	private double dormCost;
	private double tuition;
	private Residency residency;
	private boolean livesOffCampus;
	
	public CollegeStudent( String residency )
	{
		this.residency = getResidency( residency );
		this.livesOffCampus = false;
		
		// sets default value of dormCost
		this.setDormCost(800.00);
		
		// assigns defaults to the tuitions
		if( this.residency.equals(Residency.IN_STATE) )
			this.setTuition(23000.00);
		else if ( this.residency.equals(Residency.OUT_OF_STATE) ) 
			this.setTuition(42000.00);
		else if ( this.residency.equals(Residency.INTERNATIONAL) )
			this.setTuition(44500.00);
		else 
			throw new IllegalArgumentException("Student residency must be one of the three specified statuses.");
	}
	public CollegeStudent( String residency,  boolean livesOffCampus )
	{
		this.residency = getResidency( residency );
		this.livesOffCampus = livesOffCampus;
		
		// sets default value of dormCost
		if( this.livesOffCampus )
			this.setDormCost(500.0);
		else 
			this.setDormCost(800.00);
		
		// assigns defaults to the tuitions
		if( this.residency.equals(Residency.IN_STATE) )
			this.setTuition(23000.00);
		else if ( this.residency.equals(Residency.OUT_OF_STATE) ) 
			this.setTuition(42000.00);
		else if ( this.residency.equals(Residency.INTERNATIONAL) )
			this.setTuition(44500.00);
		else 
			throw new IllegalArgumentException("Student residency must be one of the three specified statuses.");
		
	}
	public void setTuition( double tuition )
	{
		this.tuition = tuition;
	}
	public void setDormCost( double dormCost )
	{
		this.dormCost = dormCost;
	}
	public double calculateYearlyCost()
	{
		// returns the total cost for the student based on defaults
		return this.getTuition() + (this.getDormCost() * 12);
	}
	public double getTuition()
	{
		return this.tuition;
	}
	public double getDormCost()
	{
		return this.dormCost;
	}
	public Residency getResidency()
	{
		return this.residency;
	}
	public boolean isLivingOffCampus()
	{
		return this.livesOffCampus;
	}
	public String toString()
	{
		String f = String.format("The total expenses are %.2f\nHere is the breakdown:\nThe student is %s\nYearly Tuition: %.2f\nDorm Costs: %.2f", 
									this.calculateYearlyCost(), this.getResidency().toString(), this.getTuition(), (this.getDormCost() * 12));
		
		return f;
	}
	
	// personal methods are below
	
	private Residency getResidency( String r )
	{
		/*
		 * This is an added method to not write it twice
		 * private as this should not be accessed elsewhere
		 * @Parm   : r = value as a string to be entered to properly return the Enum type Residency 
		 * @Return : the input as a Residency value
		 */
		// '_' are replaced with ' ' to convert to input syntax
		if( r.equalsIgnoreCase("in state") )
			return Residency.IN_STATE;
		
		else if( r.equalsIgnoreCase("out of state") )
			return Residency.OUT_OF_STATE;
		
		else if( r.equalsIgnoreCase("international"))
			return Residency.INTERNATIONAL;
		
		else											// user entered a non real answer, throwing exception
			throw new IllegalArgumentException("Student residency must be one of the three specified statuses");
	}
}




















