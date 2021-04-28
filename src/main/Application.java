import java.util.List;
import java.util.Map;

public class Application {

	// instance variables
	private String name, userAdded, dateAdded, description, organization, link, category;
	private double price, rating;
	private boolean isVerified;
	private Map<String, List<String>> platformNversion;
	
	public Application(String name, String userAdded, String dateAdded, String description, 
			String organization, String link, String category, double price, double rating, 
			boolean isVerified, Map<String, List<String>> platformNversion) {
		setName(name);
		setUserAdded(userAdded);
		setDateAdded(dateAdded);
		setDescription(description);
		setOrganization(organization);
		setLink(link);
		setCategory(category);
		setPrice(price);
		setRating(rating);
		setVerified(isVerified);
		setPlatformNversion(platformNversion);
	}
	public Application() {
		this.name = null;
		this.userAdded = null;
		this.dateAdded = null;
		this.description = null;
		this.organization = null;
		this.link = null;
		this.category = null;
		this.price = 0;
		this.rating = 0;
		this.isVerified = false;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserAdded() {
		return userAdded;
	}
	
	public void setUserAdded(String userAdded) {
		this.userAdded = userAdded;
	}
	
	public String getDateAdded() {
		return dateAdded;
	}
	
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOrganization() {
		return organization;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
		this.price = price;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		if (rating < 0) throw new IllegalArgumentException("Rating cannot be negative");
		this.rating = rating;
	}
	
	public boolean isVerified() {
		return isVerified;
	}
	
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	public Map<String, List<String>> getPlatformNversion() {
		return platformNversion;
	}
	
	public void setPlatformNversion(Map<String, List<String>> platformNversion) {
		this.platformNversion = platformNversion;
	}
	
}
