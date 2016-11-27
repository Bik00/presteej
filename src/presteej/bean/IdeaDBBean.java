package presteej.bean;

public class IdeaDBBean {
	private static IdeaDBBean instance = new IdeaDBBean();
	private IdeaDBBean() { }
	
	public static IdeaDBBean getInstance() {
		return instance;
	}
}