package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminMainAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user=(String)session.getAttribute("id");

		if(user != null)
		    return "/adminMain.jsp";
		else
		    return "/adminLoginForm.jsp";	    
	}
}
