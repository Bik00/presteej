package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAction implements CommandAction{

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
           throws Throwable {
	    return "/userLoginForm.jsp";
    }
}