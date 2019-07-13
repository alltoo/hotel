package save;

public class Hotel {
	private String name;
	private String number;
	private String level;
	private String quantity;
	
	
	
	public Hotel(String name, String number, String level, String quantity) {
		super();
		this.name = name;
		this.number = number;
		this.level = level;
		this.quantity = quantity;
	}
	public Hotel() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		//String save=name/t+number/t+level/t+quantity/n;
		return "hotel [name="+ name + ", number=" + number + ", level=" + level + ", quantity=" + quantity + "]";
	}
	public String toSaveString() {
		//String save=name/t+number/t+level/t+quantity/n;
		return  name + "\t" + number + "\t" + level + "\t" + quantity + "\n";
	}

}
