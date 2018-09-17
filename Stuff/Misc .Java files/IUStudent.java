
public class IUStudent extends CollegeStudent {
	private double bookFees;
	private double transportationCost;
	private double financialAid;
	private double GPA;
	
	public IUStudent( String residency ) {
		super(residency);						// calls the super
		
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(10534.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(34846.00);
		else 
			throw new IllegalArgumentException("Student must be in state or out of state");
		
		// Setting class specific values
		this.bookFees = 1034.00;
		this.financialAid = 0;
	}
	public IUStudent( String residency, boolean livesOffCampus ) {
		super(residency, livesOffCampus);		// calls the super 
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(10534.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(34846.00);
		else 
			throw new IllegalArgumentException("Student must be in state or out of state");
		// dormCosts
		if( this.isLivingOffCampus() )
		{
			this.setTransportationCost(500);
			this.setDormCost(400.00);
		}
		else
		{
			this.setTransportationCost(100);
			this.setDormCost(800.0);
		}
		
		// Setting class specific values
		this.bookFees = 1034.00;
		this.financialAid = 0;
	}
	public IUStudent( String residency, boolean livesOffCampus, double GPA ) {
		super(residency, livesOffCampus);		// calls the super
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(10534.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(34846.00);
		else 
			throw new IllegalArgumentException("Student must be in state or out of state");
		// dormCosts
		if( this.isLivingOffCampus() )
		{
			this.setTransportationCost(500);
			this.setDormCost(400.00);
		}
		else
		{
			this.setTransportationCost(100);
			this.setDormCost(800.00);
		}
		// GPA
		if( GPA < 0 )
			throw new IllegalArgumentException("GPA needs to be above or equal to 0");
		else
			this.GPA = GPA;
		
		// Setting class specific values
		this.bookFees = 1034.00;
		this.financialAid = this.calculateAid(GPA);
	}
	public void setTransportationCost( double transportationCost ) 
	{
		this.transportationCost = transportationCost;
	}
	public void setBookFees( double bookFees )
	{
		this.bookFees = bookFees;
	}
	public void setFinancialAid( double financialAid ) 
	{
		this.financialAid = financialAid;
	}
	public double getBookFees()
	{
		return this.bookFees;
	}
	public double getFinancialAid()
	{
		return this.financialAid;
	}
	public double getTransportationCost()
	{
		return this.transportationCost;
	}
	public double calculateYearlyCost()
	{
		return (this.getTuition() + this.getBookFees() + this.getTransportationCost() + (this.getDormCost() * 12)) - this.getFinancialAid();
	}
	public String toString()
	{
		String f = String.format("The total expenses are %.2f\nHere is the breakdown:\nThe student is %s\nYearly Tuition: %.2f\nDorm Costs: %.2f\nBook Fees: %.2f\nTransportation Cost: %.2f\nFinancial Aid: %.2f", 
				this.calculateYearlyCost(), this.getResidency().toString(),this.getTuition(), (this.getDormCost() * 12), this.getBookFees(), this.getTransportationCost(), this.getFinancialAid() );

		return f;
	}
	
	
	// Custom methods 
	private double calculateAid( double GPA )
	{
		// 
		if( GPA >= 3.75 )
			return 4500;
		else if( GPA >= 3.50 )
			return 3500;
		else if( GPA >= 3.00)
			return 2750;
		else if( GPA >= 2.50 )
			return 2500;
		else 
			return 0;
	}
}




















