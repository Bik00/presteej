package presteej.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ItemDBBean {
	private static ItemDBBean instance = new ItemDBBean();
	private ItemDBBean() { }
	
	public static ItemDBBean getInstance() {
		return instance;
	}
	
	//커넥션 풀에서 커넥션 객체를 얻어내는 메소드
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/bnj");
		return ds.getConnection();
	}
	
	public int addNewItem(ItemDataBean item){
    	Connection conn = null;
        PreparedStatement pstmt = null;
        Timestamp createdDate = null;
        String sql = null;
        int result = 0;
        try{
        	conn = getConnection();
        	createdDate = new Timestamp(System.currentTimeMillis());
        	sql = "insert into bnj.item(itemName, itemPrice, itemImgUrl, itemRegNo, itemStartDate,";
        	sql +="itemEndDate, itemDetail, remain) values (?,?,?,?,?,?,?,?)";
        	pstmt = conn.prepareStatement(sql);
        	
        	pstmt.setString(1, item.getItemName());
        	pstmt.setInt(2, item.getItemPrice());
        	pstmt.setString(3, item.getItemImgUrl());
        	pstmt.setString(4, item.getItemRegNo());
        	pstmt.setString(5, item.getItemStartDate());
        	pstmt.setString(6, item.getItemEndDate());
        	pstmt.setString(7, item.getItemDetail());
        	pstmt.setInt(8, item.getRemain());
        	
        	result = pstmt.executeUpdate();
        	result = 1;
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    	return result;
    }
}