package presteej.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presteej.bean.UserDBBean;

public class UserConfirmIdAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		


		request.setCharacterEncoding("utf-8");


				//id는 사용자가 회원가입을 하기 위해서 입력한 아이디
				String id= request.getParameter("id");

				//DB 처리빈인 UserDBBean 클래스의 객체를 얻어낸다.
				UserDBBean manager = UserDBBean.getInstance();

				//사용자가 입력한 id값을 가지고 UserDBBean 클래스의 confirmID()메소드 호출
				//중복 아이디 체크 confirmId() 메소드의 실행 결과로 check에는 1 또는 -1값이 리턴됨

				int check = manager.confirmId(id);

				request.setAttribute("check", new Integer(check));

		return "confirmId.jsp";
	}

}
