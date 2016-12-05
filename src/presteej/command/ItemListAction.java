package presteej.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presteej.bean.ItemDBBean;
import presteej.bean.ItemDataBean;

public class ItemListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		
		
		ItemDataBean[] itemList = null;
		int count = 0;
		
		ItemDBBean ItemProcess = ItemDBBean.getInstance();
		count = ItemProcess.getItemCount();

		if(count >0) {
			itemList = ItemProcess.getItems(count);
			request.setAttribute("ItemList", itemList);
		}
		
		request.setAttribute("count", new Integer(count));
		return "/itemList.jsp";
	}
}
