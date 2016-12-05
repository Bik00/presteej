package presteej.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presteej.bean.UserDBBean;
import presteej.bean.UserDataBean;

public class UserListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		UserDataBean[] userList = null;
		int count = 0;
		
		UserDBBean userProcess = UserDBBean.getInstance();
		count = userProcess.getUserCount();

		if(count >0) {
			userList = userProcess.getUsers(count);
			request.setAttribute("userList", userList);
		}
		  
		request.setAttribute("count", new Integer(count));
		return "/userList.jsp";
	}
}
