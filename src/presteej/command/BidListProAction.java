package presteej.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import presteej.json.ItemDataBean;
import presteej.json.JsonDBBean;

public class BidListProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		JsonDBBean dbbean = JsonDBBean.getInstance();
		ArrayList<ItemDataBean>  result = dbbean.itemSelect();

		// 최종 완성될 JSONObject 선언(전체)
		JSONObject jsonObject = new JSONObject();
		// result의 JSON정보를 담을 Array 선언
		JSONArray resultArray = new JSONArray();

		for (int i = 0; i < result.size(); i++) {
			// DBBean의 하나 정보가 들어갈 JSONObject 선언
			JSONObject bidInfo = new JSONObject();
			bidInfo.put("itemId", result.get(i).getItemId());
			bidInfo.put("itemName", result.get(i).getItemName());
			bidInfo.put("itemPrice", result.get(i).getItemPrice());
			bidInfo.put("itemImgUrl", result.get(i).getItemImgUrl());
			bidInfo.put("itemRegNo", result.get(i).getItemRegNo());
			bidInfo.put("itemStartDate", result.get(i).getItemStartDate());
			bidInfo.put("itemEndDate", result.get(i).getItemEndDate());
			bidInfo.put("itemDetail", result.get(i).getItemDetail());
			resultArray.add(bidInfo);

		}
		jsonObject.put("length", result.size());
		if (result.size() > 0) {
			jsonObject.put("item", resultArray);
		}

		String itemData = jsonObject.toJSONString();
		session.setAttribute("itemData", itemData);
		return "bidListPro.jsp";
	}

}
