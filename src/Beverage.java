import java.time.LocalDate;

public class Beverage extends Product{
	private LocalDate expDate;
	
	//Constructor
	public Beverage(String n, String b, double p, double q, LocalDate ed)
	{
		super(n,b,p,q);
		expDate = ed;
	}
	
	public LocalDate getDate()
	{
		return this.expDate;
	}
	
	public String Print()
	{
		double total = this.getQuantity() * this.getPrice();
		total = Math.round(total * 100.0)/100.0;
		
		String printText = this.getName() + " - " + this.getBrand()  + "\n"
				+ this.getQuantity() + " x " + "$" + this.getPrice() + " = " + "$" +total + "\n";
		
		return printText;
	}
}
