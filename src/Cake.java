// Kelsee Carmichael T00632621

public class Cake extends Product {
	
	private boolean isGlutenFree;
	private int sugarContent;

	public Cake(double cogs, String name, boolean isGlutenFree, int sugarContent)
	{
		super(cogs, name);
		this.isGlutenFree = isGlutenFree;
		this.sugarContent = sugarContent;
	}
	
	public String getType()
	{
		return "Cake";
	}
	
	public String glutenFreeCheck()
	{
		if (isGlutenFree == true)
			return "This " + name + " cake is gluten free!";
		else
			return "This " + name  + " cake is not gluten free."; 
	}
	
	public String getSugarContent()
	{
		return "This " + name + " cake has " + sugarContent + " grams of sugar.";
	}
	

}
