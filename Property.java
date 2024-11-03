
public class Property {
	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
		this.propertyName = "";
		this.city = ""; 
		this.rentAmount = 0.0;
		this.owner = "";
		this.plot = new Plot(0, 0, 1, 1);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city; 
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(0, 0, 1, 1);
		
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city; 
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	
	public Property(Property prop) {
		this(prop.propertyName, prop.city, prop.rentAmount, prop.owner, prop.plot.getX(), prop.plot.getY(), prop.plot.getWidth(), prop.plot.getDepth());
	}
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = new Plot(plot);
	}
	
	public String toString() {
		String s = "";
		s += (propertyName + "," + city + "," + owner + "," + rentAmount);
		return s;
	}
	
	
	
}
