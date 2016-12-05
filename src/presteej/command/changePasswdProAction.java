package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presteej.bean.UserDBBean;

public class changePasswdProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	    String password = request.getParameter("passwd");
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("id");
	    
	    UserDBBean manager = UserDBBean.getInstance();
	    int check=manager.changePasswd(id, password);
	    session.setAttribute("check", new Integer(check));
	    return "changePro.jsp";
	}

}
