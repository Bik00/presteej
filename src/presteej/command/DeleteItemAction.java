package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presteej.bean.ItemDBBean;

public class DeleteItemAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String itemId = request.getParameter("id");
		
		ItemDBBean process = ItemDBBean.getInstance();
		process.deleteItem(itemId);
		
		return "/adminMain.jsp";
	}

}
