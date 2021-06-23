import java.time.LocalDate;

public abstract class Product {

	private String name;
	private String brand;
	private double pricePerProduct;
	private double quantity;
	
	//Constructor
	public Product(String n, String b, double p, double q) 
	{
		name = n;
		brand = b;
		pricePerProduct = p;
		quantity = q;
	}
	
	//Abstract methods.
	abstract String Print();
	abstract LocalDate getDate();
	
	
	public String getName()
	{
		return this.name;
	}
	
	public String getBrand()
	{
		return this.brand;
	}
	
	public double getPrice()
	{
		return this.pricePerProduct;
	}
	
	public double getQuantity()
	{
		return this.quantity;
	}
	
	public void setDiscountedPrice(double p)
	{
		this.pricePerProduct = p;
	}
	
}
