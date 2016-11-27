package presteej.bean;

public class FranchiseDBBean {
	private static FranchiseDBBean instance = new FranchiseDBBean();
	private FranchiseDBBean() { }
	
	public static FranchiseDBBean getInstance() {
		return instance;
	}
}