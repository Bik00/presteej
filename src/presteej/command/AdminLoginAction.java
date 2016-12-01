package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presteej.bean.UserDBBean;

public class AdminLoginAction implements CommandAction {

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
	    int check=manager.adminCheck(id, password);
	    int check2=manager.whoAreYou(id);
	    session.setAttribute("id", id);
	    session.setAttribute("check", new Integer(check));
	    session.setAttribute("check2",new Integer(check2));
	    return "loginPro.jsp";
	}
}