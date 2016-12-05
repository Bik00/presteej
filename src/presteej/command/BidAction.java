package presteej.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presteej.bean.BidDBBean;
import presteej.bean.BidDataBean;

public class BidAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		BidDataBean bid = new BidDataBean();
		
		bid.setItemId(Integer.parseInt(request.getParameter("itemId")));
		bid.setUserName(request.getParameter("name"));
		bid.setBidPrice(Integer.parseInt(request.getParameter("bidText")));
		bid.setDb(new Timestamp(System.currentTimeMillis()));

		BidDBBean dbPro = BidDBBean.getInstance();
		dbPro.insertBid(bid);
		return "registerBid.jsp";
	}

}
