package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presteej.bean.BidDBBean;
import presteej.bean.CartDataBean;

public class CartListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		CartDataBean[] cartList = null;
		int count = 0;
	    HttpSession session = request.getSession();
	    String name = (String) session.getAttribute("name");
	    System.out.println(name);
		
		BidDBBean bidProcess = BidDBBean.getInstance();
		count = bidProcess.getCartCount();
		
		if(count >0) {
			cartList = bidProcess.getCarts(count, name);
			request.setAttribute("cartList", cartList);
		}
		
		
		request.setAttribute("count", new Integer(count));
		request.setAttribute("name", name);
		return "/cartList.jsp";
	}
}
