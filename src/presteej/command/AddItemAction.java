package presteej.command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import presteej.bean.ItemDBBean;
import presteej.bean.ItemDataBean;


public class AddItemAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	    request.setCharacterEncoding("utf-8");//한글 인코딩

	    String filename ="";
	    String realFolder = "";//웹 어플리케이션상의 절대 경로 저장
	    String saveFolder = "/upload"; //파일 업로드 폴더 지정
	    String encType = "utf-8"; //인코딩타입
	    int maxSize = 5*1024*1024;  //최대 업로될 파일크기 5Mb

	    MultipartRequest imageUp = null;

	    //웹 어플리케이션상의 절대 경로를 구함
	    ServletContext context = request.getSession().getServletContext();
	    realFolder = context.getRealPath(saveFolder); 
	    try{
	        //파일 업로드를 수행하는 MultipartRequest 객체 생성 
	        imageUp = new MultipartRequest(request,realFolder,maxSize, encType,new DefaultFileRenamePolicy());
	        //<input type="file">인 모든 파라미터를 얻어냄
	        Enumeration<?> files = imageUp.getFileNames();
	        //파일 정보가 있다면
	        while(files.hasMoreElements()){
	            //input 태그의 속성이 file인 태그의 name 속성값 :파라미터이름
	            String name = (String)files.nextElement();
	            //서버에 저장된 파일 이름
	            filename = imageUp.getFilesystemName(name);
	        }
	    }catch(Exception e){
	         e.printStackTrace();
	    }
	    ItemDataBean bread = new ItemDataBean();
	    bread.setBreadName(imageUp.getParameter("breadName"));
	    bread.setImageUrl(filename); // 서버 저장 이름으로 설정해야 함.
	    bread.setIngredient(imageUp.getParameter("ingredient"));
	    bread.setCreatedCount(Integer.parseInt(imageUp.getParameter("createdCount")));
	    bread.setRemains(Integer.parseInt(imageUp.getParameter("createdCount")));
	    bread.setPrice(Integer.parseInt(imageUp.getParameter("price")));

	    BreadDBBean db = BreadDBBean.getInstance();
	    int result = db.addNewBread(bread);

	    if(result ==0)
		request.setAttribute("result","Succeed");
	    else
		request.setAttribute("result", "Error!!");
	return "/adminIndex.jsp";
	}

	}

}
