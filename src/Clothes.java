import java.time.LocalDate;

public class Clothes extends Product{
	private String size;
	private String color;
	
	public Clothes(String n, String b, double p, double q, String s, String c)
	{
		super(n,b,p,q);
		size = s;
		color = c;
	}
	
	public String Print()
	{
		double total = this.getQuantity() * this.getPrice();
		total = Math.round(total * 100.0)/100.0;
		
		String printText = this.getName() + " - " + this.getBrand() + ", " + this.size + ", " + this.color + "\n"
			+ this.getQuantity() + " x " + "$" + this.getPrice() + " = " + "$" +total + "\n";
		
		return printText;
	}
	
	public LocalDate getDate()
	{
		return null;
	}
}
