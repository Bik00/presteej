package presteej.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import presteej.json.ItemDataBean;
import presteej.json.JsonDBBean;

public class CalendarAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		JsonDBBean dbbean = JsonDBBean.getInstance();
		ArrayList<ItemDataBean>  result = dbbean.scheduleSelect();

		// result의 JSON정보를 담을 Array 선언
		JSONArray resultArray = new JSONArray();

		for (int i = 0; i < result.size(); i++) {
			// DBBean의 하나 정보가 들어갈 JSONObject 선언
			JSONObject scheInfo = new JSONObject();
			scheInfo.put("title", result.get(i).getItemName());
			scheInfo.put("start", result.get(i).getItemStartDate());
			scheInfo.put("end", result.get(i).getItemEndDate());
			resultArray.add(scheInfo);

		}
		String itemData = resultArray.toJSONString();
		session.setAttribute("itemData", itemData);
		return "schedulePro.jsp";
	}
}