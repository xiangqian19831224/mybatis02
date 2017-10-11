package cn.java.entity;

public class Computer {
	private Long id;
	private String brand;
	private String computer_name;
	private Float memory_size;
	private Float hard_size;
	private String cpu_type;
	private String system;
	private Float price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getComputer_name() {
		return computer_name;
	}
	public void setComputer_name(String computer_name) {
		this.computer_name = computer_name;
	}
	public Float getMemory_size() {
		return memory_size;
	}
	public void setMemory_size(Float memory_size) {
		this.memory_size = memory_size;
	}
	public Float getHard_size() {
		return hard_size;
	}
	public void setHard_size(Float hard_size) {
		this.hard_size = hard_size;
	}
	public String getCpu_type() {
		return cpu_type;
	}
	public void setCpu_type(String cpu_type) {
		this.cpu_type = cpu_type;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", brand=" + brand + ", computer_name=" + computer_name + ", memory_size="
				+ memory_size + ", hard_size=" + hard_size + ", cpu_type=" + cpu_type + ", system=" + system
				+ ", price=" + price + "]";
	}
}
