package nykkis;

public class Product {
	
	private String name;
	private int product_id;
	private String service_type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", product_id=" + product_id + ", service_type=" + service_type + "]";
	}
	
	

}
