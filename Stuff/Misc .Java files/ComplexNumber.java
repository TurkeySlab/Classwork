public class ComplexNumber implements Comparable<ComplexNumber>{
	private double realPart;
	private double imaginaryPart;
	// a +/- bi
	// +/- is determined by value of b
	public ComplexNumber()
	{
		this.realPart = 0;
		this.imaginaryPart = 0;
	}
	public ComplexNumber(double realPart, double imaginaryPart)
	{
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	public ComplexNumber(ComplexNumber number) throws IllegalArgumentException
	{
		if( number == null )
		{
			throw new IllegalArgumentException();
		}
		this.realPart = number.realPart;
		this.imaginaryPart = number.imaginaryPart;
	}
	public synchronized double getRealPart()
	{
		return this.realPart;
	}
	public synchronized double getImaginaryPart()
	{
		return this.imaginaryPart;
	}
	public synchronized void setRealPart(double realPart)
	{
		this.realPart = realPart;
	}
	public synchronized void setImaginaryPart(double imaginaryPart)
	{
		this.imaginaryPart = imaginaryPart;
	}
	public synchronized ComplexNumber conjugate()
	{
		/*
		 * +/- is determined by the value of the imaginaryPart
		 * by multilying by -1 the sign will be reversed : binary
		 */
		double rp = this.realPart;
		double ip = this.imaginaryPart * (-1);
		
		return new ComplexNumber( rp, ip );
	}
	public synchronized ComplexNumber reciprocal()
	{
		// (a / (a^2 + b^2)) - (b / (a^2 + b^2))i
		// (a / (a^2 + b^2)) - (b / (a^2 + b^2))i
		double rp = ( this.realPart / (Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2)) );
		double ip = -( this.imaginaryPart / (Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2)) );
		
		return new ComplexNumber( rp, ip );
	}
	public synchronized ComplexNumber add(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
	
		//(a + c) + (B + d)i
		double rp = this.realPart + aComplexNumber.getRealPart();
		double ip = this.imaginaryPart + aComplexNumber.getImaginaryPart();
		
		return new ComplexNumber( rp, ip );
	}
	public synchronized ComplexNumber subtract(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
		//(a + c) + (B + d)i
		double rp = this.realPart - aComplexNumber.getRealPart();
		double ip = this.imaginaryPart - aComplexNumber.getImaginaryPart();
				
		return new ComplexNumber( rp, ip );
	}
	public synchronized ComplexNumber multiply(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
	
		// a + bi	c + Di
		// (ac - bD) + (bc + aD)i
		double rp = this.realPart * aComplexNumber.getRealPart() - this.imaginaryPart * aComplexNumber.getImaginaryPart();
		double ip = this.imaginaryPart * aComplexNumber.getRealPart() + this.realPart * aComplexNumber.getImaginaryPart();
				
		return new ComplexNumber( rp, ip );
	}
	public synchronized ComplexNumber divide(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
		// ((ac + bD) / (c^2 + D^2)) + ((bc - aD) / (c^2 + D^2))i.
		// ((ac + bd) / (c^2 + d^2)) + ((bc - ad) / (c^2 + d^2))i
		// a + bi / c + di
		double rp = (this.realPart * aComplexNumber.getRealPart() + this.imaginaryPart * aComplexNumber.getImaginaryPart()) /
					(Math.pow( aComplexNumber.getRealPart(), 2) + Math.pow( aComplexNumber.getImaginaryPart(), 2) );
		
		double ip = (this.imaginaryPart * aComplexNumber.getRealPart() - this.realPart * aComplexNumber.getImaginaryPart())  /
					(Math.pow( aComplexNumber.getRealPart(), 2) + Math.pow( aComplexNumber.getImaginaryPart(), 2) );
				
		return new ComplexNumber( rp, ip );
	}
	public synchronized int compareTo(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
		
		if( this.realPart > aComplexNumber.getRealPart() )
			return 1;
		else if ( this.realPart < aComplexNumber.getRealPart() )
			return -1;
		else
		{
			// they are equal
			if( this.imaginaryPart > aComplexNumber.getImaginaryPart() )
				return 1;
			else if ( this.imaginaryPart < aComplexNumber.getImaginaryPart() )
				return -1;
			else 
				return 0;
		}
	}
	public synchronized boolean equals( Object anObject)
	{
		if( anObject instanceof ComplexNumber )
		{
			ComplexNumber cn = (ComplexNumber)anObject;
			if( this.realPart == cn.getRealPart() )
			{
				if( this.imaginaryPart == cn.getImaginaryPart() )
				{
					return true;
				}
				return false;
			}
		}
		return false;
	}
	public synchronized String toString()
	{
		// -12.279500[ - ]0.573315i
		// -12.279500[-]0.573315i
		
		String equa = null;
		if( this.imaginaryPart > 0 )
		{
			// value is being added
			equa = String.format("%.6f + %.6fi", this.realPart, this.imaginaryPart);			
		} else if ( this.imaginaryPart < 0 )  {
			// value is being subtracted 
			equa = String.format("%.6f - %.6fi", this.realPart, ( -1 * this.imaginaryPart));			
		} else if ( this.imaginaryPart == 0 ) {
			// value does not exist
			equa = String.format("%.6f", this.realPart);	
		}
		return equa;
	}
}



















