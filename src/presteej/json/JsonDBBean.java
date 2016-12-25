package presteej.json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import presteej.json.ItemDataBean;

public class JsonDBBean {
	private static JsonDBBean instance = new JsonDBBean();
	private JsonDBBean() { }
	
	public static JsonDBBean getInstance() {
		return instance;
	}
	
	//커넥션 풀에서 커넥션 객체를 얻어내는 메소드
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/bnj");
		return ds.getConnection();
	}
	
	public ArrayList<ItemDataBean> itemSelect(){
	    ArrayList<ItemDataBean> itemData = new ArrayList<ItemDataBean>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs= null;
	    try {
	        conn = getConnection();
	    	pstmt=conn.prepareStatement("select * from item where now() >= DATE_FORMAT(itemStartDate, '%Y-%m-%d') and now() <= DATE_FORMAT(itemEndDate, '%Y-%m-%d')");
	        rs= pstmt.executeQuery();
	        while(rs.next()){
	        	
				ItemDataBean item = new ItemDataBean();
				item.setItemId(rs.getInt("itemId"));
				item.setItemName(rs.getString("itemName"));
				item.setItemPrice(rs.getInt("itemPrice"));
				item.setItemImgUrl(rs.getString("itemImgUrl"));
				item.setItemRegNo(rs.getString("itemRegNo"));
				item.setItemStartDate(rs.getString("itemStartDate"));
				item.setItemEndDate(rs.getString("itemEndDate"));
				item.setItemDetail(rs.getString("itemDetail"));
	        	itemData.add(item);

	        }
	    } catch(Exception ex) {
	            ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return itemData;
	}
	
	public ArrayList<ItemDataBean> scheduleSelect(){
	    ArrayList<ItemDataBean> result = new ArrayList<ItemDataBean>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs= null;
	    try {
	        conn = getConnection();
	    	pstmt=conn.prepareStatement("select * from item where now() >= DATE_FORMAT(itemStartDate, '%Y-%m-%d') and now() <= DATE_FORMAT(itemEndDate, '%Y-%m-%d')");
	        rs= pstmt.executeQuery();
	        while(rs.next()){
	        	
				ItemDataBean schedule = new ItemDataBean();
				schedule.setItemName(rs.getString("itemName"));
				schedule.setItemStartDate(rs.getString("itemStartDate"));
				schedule.setItemEndDate(rs.getString("itemEndDate"));
	        	result.add(schedule);

	        }
	    } catch(Exception ex) {
	            ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return result;
	}
	
}