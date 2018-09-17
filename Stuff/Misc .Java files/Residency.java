
public enum Residency {
	IN_STATE, OUT_OF_STATE, INTERNATIONAL;
	
	public String toString()
	{
		switch( this )
		{
			case IN_STATE:
				return "In State";
			case OUT_OF_STATE:
				return "Out Of State";
			case INTERNATIONAL:
				return "International";
		}
		return null;
	}
}
