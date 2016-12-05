package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presteej.bean.BidDBBean;
import presteej.bean.BidDataBean;


public class HistoryAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		BidDataBean[] bidList = null;
		int count = 0;
		
		BidDBBean bidProcess = BidDBBean.getInstance();
		count = bidProcess.getBidCount();
		if(count >0) {
			bidList = bidProcess.getBids(count);
			request.setAttribute("bidList", bidList);
		}
		
		request.setAttribute("count", new Integer(count));
		return "/history.jsp";
		
		
	}
}