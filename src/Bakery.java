// Kelsee Carmichael T00632621

import java.util.*;

public class Bakery {

 public static void main(String[] args) 
 {
  Shelf shelf = new Shelf();
  
  Scanner scan = new Scanner(System.in);
  
  int selection = 0;
  String again = "Y";
  
 //User input loop
 do
 {
   System.out.print("Please enter the number of the item you would like to add \n" + 
               "1-Bread \t 2-Flatbread \t 3-Cake");
   try
   {
   selection = scan.nextInt();

   if (selection > 0 && selection < 4)
   System.out.println("Enter the cost of goods sold and the name of this item.");
   double cogs = scan.nextDouble();
   String name = scan.nextLine();

   if (selection == 1)
   {
	int i = 0;
    Bread breadi = new Bread(cogs, name);
    shelf.addItem(breadi);
    i++;
   }
    
   else if (selection == 2)
   {
	int j = 0;
    System.out.println("Enter the diameter of this item.");
    FlatBread flatj = new FlatBread(cogs, name, scan.nextInt());
    shelf.addItem(flatj);
    j++;
	
   }
   
   else if (selection == 3)
   {
	int k = 0;
    System.out.println("Enter the sugar content in grams.");
    int sugar = scan.nextInt();
    System.out.println("Is this cake gluten free? (Y/N)");
    String gf = scan.next();
    boolean glutenFree = false;
    if (gf.equalsIgnoreCase("y"))
     glutenFree = true;
    Cake cakek = new Cake(cogs, name, glutenFree, sugar);
    shelf.addItem(cakek);
    k++;
	}
   }
   
   catch (InputMismatchException e)
   {
	   System.out.println("Exception occured: " + e);
   }
   
   scan.nextLine();
   System.out.println("----------------------------------------------");
   System.out.println("Would you like to enter another item? (Y/N)");
   again = scan.next();

  }

  while (again.equalsIgnoreCase("y"));
   
    System.out.println("Printing the stack items & checking the amount stored in totalProductCount");
    System.out.println(Product.getTotalProduct());
    System.out.println(shelf.printStack());
    System.out.println();
    
    //Manually creating a gluten free cake & adding it to the shelf
    Cake myCake = new Cake(4.65, "Chocolate", true, 400);
    shelf.addItem(myCake);
    
    //Manually adding a flat bread & adding it to the shelf
    FlatBread myFlat = new FlatBread(.78, "Garlic", 50);
    shelf.addItem(myFlat);
       
    System.out.println("Selling top 3 items on the stack, printing the stack & checking totalProductCount");
    System.out.println(((Product) shelf.sellItem()).sold());
    System.out.println(((Product) shelf.sellItem()).sold());
    System.out.println(((Product) shelf.sellItem()).sold());
    System.out.println(shelf.printStack());
    System.out.println(Product.getTotalProduct());
    System.out.println();
    
    System.out.println("Testing isSold() method & if an already sold item decreases the totalProductCount");
    System.out.println(myFlat.isSold());
    System.out.println(myCake.sold());
    System.out.println(Product.getTotalProduct());
    System.out.println();
    
  /* 
   * Testing my custom feature. I chose to create a profit tracker. 
   *  I have the user input the cost of goods sold(cogs) to bake each product then my getCost() 
   *  method--which is implemented as soon as a new object is created-- calculates a selling price 
   *  based on a 30% profit margin and stores it as the cost property in my parent class Product. 
   *  getProfit() is a static method used to track the total profit made.
   *  When an item is still available and my sold() method is implemented, the cogs is subtracted from
   *  the cost and added to the static property profit in the Product class.
   */
    System.out.println(Product.getProfit());
    System.out.println();
    
    System.out.println("Testing get dateOfBake() & dateOfExpiry()");
    System.out.println(myCake.getDateOfBake());
    System.out.println(myCake.getDateOfExpiry());
    System.out.println();
    
    System.out.println("Testing setName() and getName() method");
    myCake.setName("Angel Food");
    System.out.println(myCake.getName());
    System.out.println();
    
    System.out.println("Testing getDiameter()");
    System.out.println(myFlat.getDiameter());
    System.out.println();
    
    System.out.println("Testing glutenFreeCheck()");
    System.out.println(myCake.glutenFreeCheck());
    System.out.println();
    
    System.out.println("Testing getSugarContent()");
    System.out.println(myCake.getSugarContent());
 
  }
}