// Kelsee Carmichael T00632621

import java.text.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Product 
{
	protected LocalDate dateOfBake;
	protected LocalDate dateOfExpiry;
	protected double cogs = 0; //Cost of goods sold, user inputs in constructor
	protected double cost = 0; //Selling price, calculated from cogs with a 30% margin
	protected String name;
	protected boolean sold = false;
	protected static double profit = 0; //Total profit made, cost - cogs of each item
	protected static int totalProductCount = 0;
	
public Product(double cogs, String name)
{	
	this.cogs = cogs;
	this.name = name;

	getCost();
	
	LocalDate dateOfBake = LocalDate.now();
	this.dateOfBake = dateOfBake;
	
	LocalDate dateOfExpiry = LocalDate.now().plusDays(4);
	this.dateOfExpiry = dateOfExpiry;
	
	totalProductCount ++;
}

public abstract String getType();

public String getDateOfBake()
{
	return name + " " + getType() + " date of bake: " + dateOfBake;
}

public String getDateOfExpiry()
{
	return name + " " + getType() + " date of expiry: " + dateOfExpiry;
}

public String getCost()
{
	NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
	this.cost = cogs / .30; //Calculates the item price point using a 30% margin
	return fmt1.format(cost);
}

public static String getProfit()
{
	NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
	return fmt1.format(profit) + " in profit made.";
}

public static String getTotalProduct()
{
	return "There are " + totalProductCount + " product(s) in stock.";
}

public void setName(String name)
{
	this.name = name;
}

public String getName()
{
	return name;
}

public String isSold()
{
	if (sold == true)
		return toString() + " has been sold already.";
	else
		return toString() + " is still available.";
}

public String sold()
{
	if (sold == true)
		return "Sorry, can not sell " + name + " " + getType() + 
				". This item has been sold.";
	else
	{
	profit += cost - cogs; //Calculates the profit made from an individual item and adds it to the overall profit
	totalProductCount--;
	sold = true;
	return "Selling " + name + " " + getType() + " for " + getCost() + "!";
	}

}

public String toString()
{
	return name + " " + getType();
}

}
