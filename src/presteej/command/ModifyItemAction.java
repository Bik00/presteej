package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presteej.bean.ItemDBBean;
import presteej.bean.ItemDataBean;

public class ModifyItemAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		ItemDataBean[] itemList = null;
		int count = 0;
	    HttpSession session = request.getSession();
	    String id = request.getParameter("id");
	    System.out.println(id);
	    
	    ItemDBBean itemProcess = ItemDBBean.getInstance();
		count = itemProcess.getItemCount(id);

		if(count >0) {
			itemList = itemProcess.getItem(count, id);
			request.setAttribute("itemList", itemList);
		}
		
		return "/modifyItemForm.jsp";
	}

}