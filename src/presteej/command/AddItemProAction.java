package presteej.command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import presteej.bean.ItemDBBean;
import presteej.bean.ItemDataBean;


public class AddItemProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");// 한글 인코딩

		String filename = "";
		String realFolder = "";// 웹 어플리케이션상의 절대 경로 저장
		String saveFolder = "/upload"; // 파일 업로드 폴더 지정
		String encType = "utf-8"; // 인코딩타입
		int maxSize = 5*1024*1024; // 최대 업로될 파일크기 1Mb

		MultipartRequest imageUp = null;

		// 웹 어플리케이션상의 절대 경로를 구함
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);

		try {
			// 파일 업로드를 수행하는 MultipartRequest 객체 생성
			imageUp = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			// <input type="file">인 모든 파라미터를 얻어냄
			Enumeration<?> files = imageUp.getFileNames();
			// 파일 정보가 있다면
			while (files.hasMoreElements()) {
				// input 태그의 속성이 file인 태그의 name 속성값 :파라미터이름
				String name = (String) files.nextElement();
				// 서버에 저장된 파일 이름
				filename = imageUp.getFilesystemName(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	    ItemDataBean Item = new ItemDataBean();
	    
	    String franBox1 = imageUp.getParameter("franBox01");
	    String franBox2 = imageUp.getParameter("franBox02");
	    String franBox3 = imageUp.getParameter("franBox03");
	    String ideaBox1 = imageUp.getParameter("ideaBox01");
	    String ideaBox2 = imageUp.getParameter("ideaBox02");
	    String ideaBox3 = imageUp.getParameter("ideaBox03");
	    String regDate = franBox1+"-"+franBox2+"-"+franBox3+ideaBox1+"-"+ideaBox2+"-"+ideaBox3;
	    int remain = 1;
	    Item.setItemName(imageUp.getParameter("name"));
	    Item.setItemPrice(Integer.parseInt(imageUp.getParameter("price")));
	    Item.setItemImgUrl(filename);
	    Item.setItemRegNo(regDate);
	    Item.setItemStartDate(imageUp.getParameter("startdate"));
	    Item.setItemEndDate(imageUp.getParameter("enddate"));
	    Item.setItemDetail(imageUp.getParameter("detail"));
	    Item.setRemain(remain);
	    
	    
	    ItemDBBean db = ItemDBBean.getInstance();
	    int result = db.addNewItem(Item);
	    if(result ==1)
		request.setAttribute("result","Succeed");
	    else
		request.setAttribute("result", "Error!!");
		return "/adminMain.jsp";
	}
}