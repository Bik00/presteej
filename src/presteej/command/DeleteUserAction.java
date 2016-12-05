package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presteej.bean.UserDBBean;

public class DeleteUserAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String userId = request.getParameter("id");
		
		UserDBBean process = UserDBBean.getInstance();
		process.deleteUser(userId);
		
		return "deletePro.jsp";
	}

}
