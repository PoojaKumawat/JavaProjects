package jdbc;

public class Order {

	private String orderId;
	private String orderDesc;
	private Customer customer;
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order(String orderId, String orderDesc) {
		super();
		this.orderId = orderId;
		this.orderDesc = orderDesc;
	}

	public Order() {
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDesc=" + orderDesc + "]";
	}

}
