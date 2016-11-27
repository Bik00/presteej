package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presteej.bean.UserDBBean;

public class UserLoginAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	    String id = request.getParameter("id");
	    String password = request.getParameter("password");
	    HttpSession session = request.getSession();
	    
	    String command = request.getParameter("command");
	    if(command != null && command.equals("logout")){
	    	session.removeAttribute("id");
	        session.invalidate();
	        return "main.jsp";
	    }
	    
	    UserDBBean manager = UserDBBean.getInstance();
	    int check=manager.userCheck(id, password);
	    
	    session.setAttribute("id", id);
	    session.setAttribute("check", new Integer(check));
	    return "loginPro.jsp";
	}
}