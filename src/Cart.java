import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Cart {

	private List<Product> cart;
	
	public Cart()
	{
		cart = new ArrayList<Product>();
	}
	
	public void addProduct(Product pr)
	{
		cart.add(pr);
	}
	
	public ListIterator<Product> listIterator()
	{
		ListIterator<Product> iter = cart.listIterator();
		return iter;
	}
	
	//Calculating the Subtotal of the price(could have been done in the 'Cashier' class too)
	public double calculateSubtotal()
	{   
		double subtotal = 0;
		ListIterator<Product> iter = cart.listIterator();
		
		while(iter.hasNext())
		{
			Product current = iter.next();
			subtotal += current.getPrice() * current.getQuantity();
		}
		
		//Rounding the double value to two decimal places.
		subtotal = Math.round(subtotal * 100.0) / 100.0;
		return subtotal;
	}
}
