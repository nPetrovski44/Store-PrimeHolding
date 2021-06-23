import java.time.LocalDate;

public class Appliances extends Product{
	
	private LocalDate prodDate;
	private String model;
	private int weight;
	
	//Constructor
	public Appliances(String n, String b, double p, double q, LocalDate pd, String m, int w)
	{
		super(n,b,p,q);
		prodDate = pd;
		model = m;
		weight = w;
	}
	
	public LocalDate getDate()
	{
		return prodDate;
	}
	
	public String Print()
	{
		double total = this.getQuantity() * this.getPrice();
		total = Math.round(total * 100.0)/100.0;
		
		String printText = this.getName() + " - " + this.getBrand()  + ", " + this.model + "\n"
				+ this.getQuantity() + " x " + "$" +this.getPrice() + " = " + "$" + total + "\n";
		
		return printText;
	}

}
