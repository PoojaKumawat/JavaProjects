package jdbc;

public class Address {

	private Integer id;
	private String city;
	private String state;
	private String country;
	private String zip;

	public Address(Integer id, String city, String state, String country, String zip) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public Address() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
