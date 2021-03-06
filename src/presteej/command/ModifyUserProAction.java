package presteej.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presteej.bean.UserDBBean;
import presteej.bean.UserDataBean;

public class ModifyUserProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		UserDataBean member = new UserDataBean();
		
		member.setUserId(request.getParameter("id"));
		member.setUserName(request.getParameter("name"));
		member.setBirthyy(request.getParameter("birthyy"));
		member.setBirthmm(request.getParameter("birthmm"));
		member.setBirthdd(request.getParameter("birthdd"));
		member.setMail1(request.getParameter("mail1"));
		member.setMail2(request.getParameter("mail2"));
		member.setUserCellNo(request.getParameter("phone"));
		
		System.out.println(member.getUserId());
		
		UserDBBean dbPro = UserDBBean.getInstance();
		dbPro.modifyMember(member);
		return "modifyPro.jsp";
	}

}
