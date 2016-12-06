package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presteej.bean.ItemDBBean;
import presteej.bean.ItemDataBean;

public class ModifyItemProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		ItemDataBean item = new ItemDataBean();
		
		item.setItemId(Integer.parseInt(request.getParameter("id")));
		item.setItemName(request.getParameter("name"));
		item.setItemPrice(Integer.parseInt(request.getParameter("price")));
		item.setItemStartDate(request.getParameter("startdate"));
		item.setItemEndDate(request.getParameter("enddate"));
		item.setItemDetail(request.getParameter("detail"));
		
		ItemDBBean dbPro = ItemDBBean.getInstance();
		dbPro.modifyItem(item);
		return "modifyPro.jsp";
	}

}
