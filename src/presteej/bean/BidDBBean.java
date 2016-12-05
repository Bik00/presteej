package presteej.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BidDBBean {
	private static BidDBBean instance = new BidDBBean();
	private BidDBBean() { }
	
	public static BidDBBean getInstance() {
		return instance;
	}
	
	//커넥션 풀에서 커넥션 객체를 얻어내는 메소드
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/bnj");
		return ds.getConnection();
	}
	
	//커넥션 풀에서 커넥션 객체를 얻어내는 메소드
	public void insertBid(BidDataBean bid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement("insert into bid values(?,?,?,now())");
			pstmt.setInt(1,bid.getItemId());
			pstmt.setString(2,bid.getUserName());
			pstmt.setInt(3,bid.getBidPrice());
			
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

	public int getBidCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select count(*) from bid");
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
	
	public BidDataBean[] getBids(int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BidDataBean[] bidList = null;
		int i = 0;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select item.itemName, bid.userName, bid.bidPrice, bid.db from item, bid where item.itemId = bid.itemId;");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bidList = new BidDataBean[count];
				do {
					BidDataBean bid = new BidDataBean();
					bid.setItemName(rs.getString("item.itemName"));
					bid.setUserName(rs.getString("bid.userName"));
					bid.setBidPrice(rs.getInt("bid.bidPrice"));
					bid.setDb(rs.getTimestamp("bid.db"));

					bidList[i]=bid;
					
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
		return bidList;
	}
	
	public int getCartCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("SELECT count(DISTINCT itemId) as 'count' FROM bid;");
			rs = pstmt.executeQuery();
			if(rs.next())
			x = rs.getInt("count");
			
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
	
	public CartDataBean[] getCarts(int count, String name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartDataBean[] cartList = null;
		int i = 0;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select item.itemName, bid.userName, max(bid.bidPrice) as 'resultPrice' from item, bid where item.itemId = bid.itemId and now() >= DATE_FORMAT(item.itemEndDate, '%Y-%m-%d') and bid.userName=? and bid.bidPrice In (SELECT MAX(bid.bidPrice) FROM bid GROUP BY bid.itemId) GROUP BY item.itemName");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cartList = new CartDataBean[count];
				do {
					CartDataBean cart = new CartDataBean();
					cart.setItemName(rs.getString("item.itemName"));
					cart.setUserName(rs.getString("bid.userName"));
					cart.setResultPrice(rs.getInt("resultPrice"));

					cartList[i]=cart;
					
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
		return cartList;
	}
	
}
