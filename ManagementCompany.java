import java.util.ArrayList;

public class ManagementCompany {
	public static final int MAX_PROPERTY = 5;
	private static final int MGMT_WIDTH = 10;
	private static final int MGMT_DEPTH = 10;
	
	private String name;
	private String taxID;
	private double mgmFee;
	
	private ArrayList<Property> properties;
	private Plot plot;
	private int numberOfProperties;
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0.0;
		this.properties = new ArrayList<>();
		this.plot = new Plot(1, 1, MGMT_WIDTH, MGMT_DEPTH);
		
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new ArrayList<>();
		this.plot = new Plot(1, 1, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new ArrayList<>();
		this.plot = new Plot(x, y, width, depth);
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public double getMgmFeePer() {
		return mgmFee;
	}
	public void setMgmFee(double mgmFee) {
		this.mgmFee = mgmFee;
	}
	
	public Plot getPlot() {
		return this.plot;
	}
	
	@SuppressWarnings("unused")
	public int addProperty(String name, String city, double rent, String owner) {
		Property prop = new Property(name, city, rent, owner, 1, 1, 1, 1);
		if (isPropertiesFull()) {
			return -1;
		}
		if (prop == null) {
			return -2;
		}
		
		if (plot.encompasses(prop.getPlot()) == false) {
			return -3;
		}
		
		for (int i = 0; i < properties.size(); i++) {
			if (properties.get(i).getPlot().overlaps(prop.getPlot()) == true) {
				return -4;
			}
		}
		
		
		properties.add(prop);
		return properties.indexOf(prop);
		
	}
	
	@SuppressWarnings("unused")
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property prop = new Property(name, city, rent, owner, x, y, width, depth);
		
		if (isPropertiesFull()) {
			return -1;
		}
		if (prop == null) {
			return -2;
		}
		
		if (plot.encompasses(prop.getPlot()) == false) {
			return -3;
		}
		
		if (plot.overlaps(prop.getPlot()) == true) {
			return -4;
		}
		
		properties.add(prop);
		return properties.indexOf(prop);
		
		
		
	}
	
	public int addProperty(Property prop) {
		
		if (isPropertiesFull()) {
			return -1;
		}
		if (prop == null) {
			return -2;
		}
		
		if (plot.encompasses(prop.getPlot()) == false) {
			return -3;
		}
		for (int i = 0; i < properties.size(); i++) {
			if (properties.get(i).getPlot().overlaps(prop.getPlot()) == true) {
				return -4;
			}
		}
		
		
		properties.add(prop);
		return properties.indexOf(prop);
	}
	
	public double getTotalRent() {
		double rentTotal = 0.0;
		for (int i = 0; i < properties.size(); i++) {
			rentTotal += properties.get(i).getRentAmount();
		}
		return rentTotal;
	}
	
	public Property getHighestRentProperty() {
		double highestRent = properties.get(0).getRentAmount();
		Property highestProp = properties.get(0);
		for (int i = 1; i < properties.size(); i++) {
			if (properties.get(i).getRentAmount() > highestRent) {
				highestRent = properties.get(i).getRentAmount();
				highestProp = properties.get(i);
			}
		}
		
		return highestProp;
	}
	
	public void removeLastProperty() {
		properties.remove(properties.size() - 1);
	}
	
	public boolean isPropertiesFull() {
		
		if (properties.size() == MAX_PROPERTY) {
			return true;
		}
		return false;
	}
	
	public int getPropertiesCount() {
		return properties.size();
	}
	
	public boolean isManagementFeeValid() {
		if (mgmFee >= 0 && mgmFee <= 100) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String s = "";
		s += ("List of the properties for " + name + ", taxID: " + taxID);
		for (int i = 0; i < properties.size(); i++) {
			s += ("\n" + properties.get(i).getPropertyName() + "," + properties.get(i).getCity() + "," + properties.get(i).getOwner() + "," + properties.get(i).getRentAmount());
		}
		s += ("\n");
		s += ("Total Management Fee: " + mgmFee);
		return s;
		
	}
	
	
	
	
	
}
