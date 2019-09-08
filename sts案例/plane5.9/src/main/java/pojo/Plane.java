package pojo;

public class Plane {
	private Integer id;
	private String flight_number;
	private String destination;
	private String flight_date;
	
	@Override
	public String toString() {
		return "Plane [id=" + id + ", flight_number=" + flight_number + ", destination=" + destination
				+ ", flight_date=" + flight_date + "]";
	}
	public Plane() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlight_date() {
		return flight_date;
	}
	public void setFlight_date(String flight_date) {
		this.flight_date = flight_date;
	}
}
