import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * The main class 'Cashier'. I have decided not to the different classes
 * in separate builds as to make the final file a single one.
 * 
 * @author Nikolay Petrovski
 *
 */

//Main class
public class Cashier {

	//Initializing the 'Cart' object.
	private Cart myCart = new Cart();
	
	//A variable to store all the discounts.
	private double totalDiscount = 0;
	
	//Constructor
	public Cashier()
	{		
		/*
		 * I have manually added the examples as no input was required.
		 * Examples for adding new Products more easily:
		 * 
		 * new Food("name", "brand", price, quantity, expDate);
		 * new Beverage("name", "brand", price, quantity, expDate);
		 * new Clothes("name", "brand", price, quantity, "size", "color");
		 * new Appliances("name", "brand", price, quantity,  productionDate, "model", weight);
		 * 
		 */
		
		
		LocalDate dateOfPurchase = LocalDate.parse("2021-06-14");
		LocalTime timeOfPurchase = LocalTime.parse("12:34:56");
	
		
		LocalDate foodDate = LocalDate.parse("2021-06-14");
		Food food1 = new Food("Apples", "BrandA", 1.5, 2.45, foodDate);
		
		LocalDate beverageDate = LocalDate.parse("2022-02-02");
		Beverage beverage1 = new Beverage("Milk", "BrandM", 0.99, 3, beverageDate);

		Clothes clothes1 = new Clothes("T-shirt", "BrandT", 15.99, 2, "M", "violet");
		
		LocalDate appliancesDate = LocalDate.parse("2021-03-03");
		Appliances appliances1 = new Appliances("Laptop", "BrandL", 2345, 1,  appliancesDate, "ModelL", 1125);
		
		//Adding all elements to the ArrayList in 'Cart'.
		myCart.addProduct(food1);
		myCart.addProduct(beverage1);
		myCart.addProduct(clothes1);
		myCart.addProduct(appliances1);
		
		printReceipt(myCart, dateOfPurchase, timeOfPurchase);
	}

	//Main method to run the program.
	public static void main(String args[])
	{
		Cashier cashier = new Cashier();
	}
	
	//Printing method using an Iterator.
	public void printReceipt(Cart cart, LocalDate date, LocalTime time)
	{
		//The final message to be printed.
		String printText = "Date: " + date + " " + time + "\n\n---Products---\n\n";
		ListIterator<Product> iter = cart.listIterator();
		while(iter.hasNext())
		{
			Product current = iter.next();
			printText = printText + current.Print();
			
			//Doing some check-ins to compute discounts if applicable.
			if(current instanceof Food || current instanceof Beverage)
			{ 
				//Using a variable 'daysUntilExp' to compute the difference between the two dates in days.
				long daysUntilExp = date.until(current.getDate(), ChronoUnit.DAYS);
				
				if(daysUntilExp == 0)
				{
					printText = printText + "#discount 50% -$" + calculateDiscount(current.getPrice() * current.getQuantity(), 50) + "\n\n";
				}

				else if(daysUntilExp <= 5 && daysUntilExp > 0)
				{
					printText = printText + "#discount 10% -$" + calculateDiscount(current.getPrice() * current.getQuantity(), 10) + "\n\n";
				}
				else
				{
					printText += "\n";
				}
			}
			
			if(current instanceof Clothes)
			{
				if(date.getDayOfWeek().getValue() < 6)
				{
					printText = printText + "#discount 10% -$" + calculateDiscount(current.getPrice() * current.getQuantity(), 10) + "\n\n";
				}
				else
				{
					printText += "\n";
				}
			}
			
			if(current instanceof Appliances)
			{
				if(date.getDayOfWeek().getValue() > 5 && current.getPrice() > 999)
				{
					printText = printText + "#discount 5% -$" + calculateDiscount(current.getPrice() * current.getQuantity(), 5) + "\n\n";
				}
			}
		}
		printText = printText + "----------------------------------------------\n\nSUBTOTAL: $" + cart.calculateSubtotal()
		+ "\nDISCOUNT: -$" + totalDiscount + "\n\nTOTAL: $" + (cart.calculateSubtotal() -totalDiscount);
		

		System.out.println(printText);
	}
	
	//A method to calculate the discount whenever there is one and add it to the total.
	public double calculateDiscount(double price, int discount)
	{	
		double result = price / 100 * (double)discount;
		result = Math.round(result * 100.0) / 100.0;
		totalDiscount += result;
		return result;
	}
}
