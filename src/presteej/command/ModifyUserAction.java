package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presteej.bean.UserDBBean;
import presteej.bean.UserDataBean;

public class ModifyUserAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		UserDataBean[] userList = null;
		int count = 0;
	    HttpSession session = request.getSession();
	    String id = request.getParameter("id");
	    
	    UserDBBean userProcess = UserDBBean.getInstance();
		count = userProcess.getUserCount(id);

		if(count >0) {
			userList = userProcess.getUser(count, id);
			request.setAttribute("userList", userList);
		}
		return "/modifyUserForm.jsp";
	}

}
