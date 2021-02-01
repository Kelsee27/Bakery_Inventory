// Kelsee Carmichael T00632621

public class FlatBread extends Bread {

	private int diameter;
	
	public FlatBread(double cogs, String name, int diameter)
	{
		super(cogs, name);
		this.diameter = diameter;
	}
	
	public String getType()
	{
		return "Flat Bread";
	}
	
	public String getDiameter()
	{
		return "This " + name + " " + getType() + "'s diameter is: " + diameter;
	}
	
}
