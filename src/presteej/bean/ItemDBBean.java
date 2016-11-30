package presteej.bean;

public class ItemDBBean {
	private static ItemDBBean instance = new ItemDBBean();
	private ItemDBBean() { }
	
	public static ItemDBBean getInstance() {
		return instance;
	}
}