package presteej.bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDBBean {
	private static UserDBBean instance = new UserDBBean();
	private UserDBBean() { }
	public Date birthday;
	
	public static UserDBBean getInstance() {
		return instance;
	}
	
	//커넥션 풀에서 커넥션 객체를 얻어내는 메소드
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/bnj");
		return ds.getConnection();
	}
	
    public Date stringToDate(UserDataBean member)
    {
        String year = member.getBirthyy();
        String month = member.getBirthmm();
        String day = member.getBirthdd();
        
        Date birthday = Date.valueOf(year+"-"+month+"-"+day);
        
        return birthday;
        
    } // end stringToDate()
	
	//회원 가입 처리(registerPro.jsp)에서 사용하는 새 레코드 추가 메소드
	public void insertMember(UserDataBean member){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1,member.getUserId());
			pstmt.setString(2,member.getUserPassword());
			pstmt.setString(3,member.getUserName());
            pstmt.setDate(4, stringToDate(member));
			pstmt.setString(5, member.getUserCellNo());
            pstmt.setString(6, member.getMail1()+"@"+member.getMail2());
            pstmt.setInt(7, 0);
            pstmt.setTimestamp(8, member.getUserCreatedDate());
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
	
	public int userCheck(String id, String passwd){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			String orgPass = passwd;
			
			pstmt=conn.prepareStatement("select userPassword from user where userId = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){// 해당아이디가 있으면 수행
				String dbpasswd = rs.getString("userPassword");
				if(orgPass.equals(dbpasswd)){
					x = 1; //인증성공
				}else{
					x = 0; //비밀번호 틀림
				}
			}else{//해당 아이디가 없으면 수행
				x = -1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	//아이디 중복 확인(confirmId.jsp)에서 아이디의 중복여부를 확인하는 메소드
	public int confirmId(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from user where userId= ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x=-1; //같은 아이디 있음
			else
				x=1; //같은 아이디 없음
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
//	//회원 정보 수정 폼(modifyForm.jsp)을 위한 기존 가입 정보를 가져오는 메소드
//	public LogonDataBean getMember(String id, String passwd){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		LogonDataBean member = null;
//		
//		
//			try {
//				conn = getConnection();
//				String orgPass=passwd;
//				
//				pstmt = conn.prepareStatement("select * from member where id = ?");
//				pstmt.setString(1, id);
//				rs = pstmt.executeQuery();
//				
//				if(rs.next()){//해당 아이디에 대한 레코드가 존재
//					String dbpasswd = rs.getString("psswd");
//					//사용자가 입력한 비밀번호와 테이브르이 비밀번호가 같으면 수행
//					if(dbpasswd.equals(orgPass)){
//						member = new LogonDataBean();
//						member.setId(rs.getString("id"));
//						member.setName(rs.getString("name"));
//						member.setReg_date(rs.getTimestamp("reg_date"));
//						member.setAddress(rs.getString("adress"));
//						member.setTel(rs.getString("tel"));
//					}
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally{
//				if(rs != null)
//					try {
//						rs.close();
//					} catch (SQLException e) {}
//				if(pstmt != null)
//					try {
//						pstmt.close();
//					} catch (SQLException e) {}
//				if(conn != null)
//					try {
//						conn.close();
//					} catch (SQLException e) {}
//			}
//			return member; //데이터 저장빈 객체 member 리턴
//
//		}
//	//회원 정보 수정 처리(modifyPro.jsp)에서 회원 정보 수정을 처리하는 메소드
//	public int updataMember(LogonDataBean member){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int x = -1;
//		
//		try {
//			conn = getConnection();
//			
//			String orgPass= member.getPasswd();
//			
//			pstmt = conn.prepareStatement("select passwd from member where id = ?");
//			pstmt.setString(1, member.getId());
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()){
//				String dbpasswd = rs.getString("passwd");
//				if(dbpasswd==orgPass){
//					/*pstmt = conn.prepareStatement("update member set name = ?, address =?, tel = ?" +
//							"where id =?");*/
//					pstmt.setString(1, member.getName());
//					pstmt.setString(2, member.getAddress());
//					pstmt.setString(3, member.getTel());
//					pstmt.setString(4, member.getId());
//					pstmt.executeQuery();
//					x=1; //회원 정보 수정 처리 성공
//				}else{
//					x=0; //회원 정보 수정 처리 실패
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(rs != null)
//				try {
//					rs.close();
//				} catch (SQLException e) {}
//			if(pstmt != null)
//				try {
//					pstmt.close();
//				} catch (SQLException e) {}
//			if(conn != null)
//				try {
//					conn.close();
//				} catch (SQLException e) {}
//		}
//		return x;
//	}
//	//회원 탈퇴 처리(deletePro.jsp)에서 회원 정보를 삭제하는 메소드
//	public int deleteMember(String id, String passwd){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int x = -1;
//		
//		try {
//			conn = getConnection();
//			
//			String orgPass = passwd;
//			
//			pstmt = conn.prepareStatement("select passwd from member where id = ?");
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()){
//				String dbpasswd = rs.getString("passwd");
//				if(dbpasswd==orgPass){
//					/*pstmt = conn.prepareStatement("delete from member where id=?");
//*/					pstmt.setString(1, id);
//					pstmt.executeQuery();
//					x=1; //회원 탈퇴 성공
//				}else{
//					x=0; // 회원 탈퇴 처리 실패
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(rs != null)
//				try {
//					rs.close();
//				} catch (SQLException e) {}
//			if(pstmt != null)
//				try {
//					pstmt.close();
//				} catch (SQLException e) {}
//			if(conn != null)
//				try {
//					conn.close();
//				} catch (SQLException e) {}
//		}
//		return x;
//	}
/*	public ArrayList<LogonDataBean> shID(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LogonDataBean> result = new ArrayList();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()){
				LogonDataBean data = new LogonDataBean();
				data.setId(rs.getString("id"));
				result.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}*/
	
}