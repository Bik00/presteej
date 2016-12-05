package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presteej.bean.BidDBBean;
import presteej.bean.ItemDBBean;
import presteej.bean.ItemDataBean;

public class BidListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		ItemDataBean[] itemList = null;
		int count = 0;
	    HttpSession session = request.getSession();
		
	    ItemDBBean ItemProcess = ItemDBBean.getInstance();
		count = ItemProcess.getItemCount();

		if(count >0) {
			itemList = ItemProcess.getItems(count);
			request.setAttribute("bidList", itemList);
		}
		request.setAttribute("name", session.getAttribute("name"));
		System.out.println(session.getAttribute("name"));
		request.setAttribute("count", new Integer(count));
		return "/bidList.jsp";
	}
}
