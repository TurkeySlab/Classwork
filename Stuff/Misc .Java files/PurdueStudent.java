
public class PurdueStudent extends CollegeStudent {
	private double bookFees;
	private double financialAid;
	private double GPA;
	private String major;
	
	public PurdueStudent( String residency ) {
		super( residency );						// calls the super
		
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(9992.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(28794.00);
		else if( this.getResidency().equals( Residency.INTERNATIONAL) )
			this.setTuition(30954.00);
		
		// Setting class specific values
		this.bookFees = 1034.00;
		this.financialAid = 0;
	}
	public PurdueStudent( String residency, boolean livesOffCampus ) {
		super( residency, livesOffCampus );		// calls the super 
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(9992.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(28794.00);
		else if( this.getResidency().equals( Residency.INTERNATIONAL) )
			this.setTuition(30954.00);

		// Setting class specific values
		this.bookFees = 100;		// Default
		this.financialAid = 0;
	}
	public PurdueStudent( String residency, boolean livesOffCampus, double GPA ) {
		super( residency, livesOffCampus );		// calls the super
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(9992.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(28794.00);
		else if( this.getResidency().equals( Residency.INTERNATIONAL) )
			this.setTuition(30954.00);
		// GPA
		if( GPA < 2.0 )
			throw new IllegalArgumentException("GPA needs to be above or equal to 0");
		else
			this.GPA = GPA;
		
		// Setting class specific values
		this.bookFees = 100;		// Default
		this.financialAid = this.calculateAid(GPA);
	}
	public PurdueStudent( String residency, String major, boolean livesOffCampus, double GPA ) {
		super( residency, livesOffCampus );		// calls the super
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(9992.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(28794.00);
		else if( this.getResidency().equals( Residency.INTERNATIONAL) )
			this.setTuition(30954.00);
		// GPA
		if( GPA < 2.0 )
			throw new IllegalArgumentException("GPA needs to be above or equal to 0");
		else
			this.GPA = GPA;
		
		// Setting class specific values
		this.major = major;
		this.bookFees = calculateBook( this.major );
		this.financialAid = this.calculateAid(GPA);
	}
	public void setBookFees( double bookFees )
	{
		this.bookFees = bookFees;
	}
	public double getBookFees()
	{
		return this.bookFees;
	}
	public void setFinancialAid( double aid)
	{
		this.financialAid = aid;
	}
	public double getFinancialAid()
	{
		return this.financialAid;
	}
	public String getMajor()
	{
		return this.major;
	}
	public double calculateYearlyCost()
	{
		return (this.getBookFees() + this.getTuition() + (this.getDormCost() * 12)) - this.getFinancialAid();
	}
	public String toString()
	{
		String f = String.format("The total expenses are %.2f\nHere is the breakdown:\nThe student is %s\nYearly Tuition: %.2f\nDorm Costs: %.2f\nBook Fees: %.2f\nFinancial Aid: %.2f", 
				this.calculateYearlyCost(), this.getResidency().toString(), this.getTuition(), (this.getDormCost() * 12), this.getBookFees(), this.getFinancialAid() );

		return f;
	}
	// Custom methods 
	private double calculateBook( String major )
	{
		if( major.equalsIgnoreCase("computer science"))
		{
			return 200.0;
		}
		else if( major.equalsIgnoreCase("engineering"))
		{
			return 500.0;
		}
		else if( major.equalsIgnoreCase("liberal arts"))
		{
			return 750.0;
		}
		return 100;		// default is 100
	}
	private double calculateAid( double GPA )
	{
		// 
		if( GPA >= 3.75 )
			return 5000;
		else if( GPA >= 3.50 )
			return 4500;
		else if( GPA >= 3.00)
			return 3000;
		else if( GPA >= 2.50 )
			return 2500;
		else 
			return 0;
	}
}
