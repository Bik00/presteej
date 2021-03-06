package presteej.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
	
	public int getItemCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select count(*) from item");
			rs = pstmt.executeQuery();
			if(rs.next())
			x = rs.getInt("count(*)");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		return x;
	}
	
	public int getBidCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select count(*) from item where now() >= DATE_FORMAT(itemStartDate, '%Y-%m-%d') and now() <= DATE_FORMAT(itemEndDate, '%Y-%m-%d')");
			rs = pstmt.executeQuery();
			if(rs.next())
			x = rs.getInt("count(*)");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		return x;
	}
	
	public ItemDataBean[] getBids(int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemDataBean itemList[] = null;
		int i = 0;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select * from item where now() >= DATE_FORMAT(itemStartDate, '%Y-%m-%d') and now() <= DATE_FORMAT(itemEndDate, '%Y-%m-%d')");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				itemList = new ItemDataBean[count];
				do {
					ItemDataBean item = new ItemDataBean();
					item.setItemId(rs.getInt("itemId"));
					item.setItemName(rs.getString("itemName"));
					item.setItemPrice(rs.getInt("itemPrice"));
					item.setItemImgUrl(rs.getString("itemImgUrl"));
					item.setItemRegNo(rs.getString("itemRegNo"));
					item.setItemStartDate(rs.getString("itemStartDate"));
					item.setItemEndDate(rs.getString("itemEndDate"));
					item.setRemain(rs.getInt("remain"));
					
					itemList[i]=item;
					
					i++;
				} while(rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		return itemList;
	}
	
	public ItemDataBean[] getItems(int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemDataBean itemList[] = null;
		int i = 0;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select * from item");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				itemList = new ItemDataBean[count];
				do {
					ItemDataBean item = new ItemDataBean();
					item.setItemId(rs.getInt("itemId"));
					item.setItemName(rs.getString("itemName"));
					item.setItemPrice(rs.getInt("itemPrice"));
					item.setItemImgUrl(rs.getString("itemImgUrl"));
					item.setItemRegNo(rs.getString("itemRegNo"));
					item.setItemStartDate(rs.getString("itemStartDate"));
					item.setItemEndDate(rs.getString("itemEndDate"));
					item.setRemain(rs.getInt("remain"));
					
					itemList[i]=item;
					
					i++;
				} while(rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		return itemList;
	}
	
	public void deleteItem(String itemName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from item where itemId=?");
			pstmt.setString(1, itemName);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		
	}
	
	public int getItemCount(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select count(*) from item where itemId=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			x = rs.getInt("count(*)");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		return x;
	}
	
	
	
	public ItemDataBean[] getItem(int count, String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemDataBean[] itemList = null;
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		int i = 0;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select * from item where itemId=?");
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				itemList = new ItemDataBean[count];
				do {
					ItemDataBean item = new ItemDataBean();
					item.setItemId(rs.getInt("itemId"));
					item.setItemName(rs.getString("itemName"));
					item.setItemPrice(rs.getInt("itemPrice"));
					item.setItemImgUrl(rs.getString("itemImgUrl"));
					item.setItemRegNo(rs.getString("itemRegNo"));
					item.setItemStartDate(rs.getString("itemStartDate"));	
					item.setItemEndDate(rs.getString("itemEndDate"));	
					item.setItemDetail(rs.getString("itemDetail"));						
					itemList[i]=item;
					i++;
				} while(rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		return itemList;
	}
	
	public void modifyItem(ItemDataBean item) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement("update item set itemName=?, itemPrice=?, itemStartDate=?, itemEndDate=?, itemDetail=? where itemId=?");
			pstmt.setString(1, item.getItemName());
            pstmt.setInt(2, item.getItemPrice());
			pstmt.setString(3, item.getItemStartDate());
            pstmt.setString(4, item.getItemEndDate());
            pstmt.setString(5, item.getItemDetail());
            pstmt.setInt(6, item.getItemId());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
	}
}