package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MabDBBean {
	private static MabDBBean instance = new MabDBBean();
	public static MabDBBean getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws NamingException, SQLException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/bit");
		Connection con = ds.getConnection();
		return con;
	}
	
	public int checkMultiple(String id) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select id from mab_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//ID 있음
				result = -1;
			}
			else {
				//ID없음
				result = 0;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int checkMultipleLicence(String license) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "select license from mab_member where license=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, license);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//db에 면허번호 있음
				result = -1;
			}
			else {
				//db에 면허번호 없음
				result = 0;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int insertInfo(String id, String passwd, String name, String tel, String email, String license) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into mab_member (id, passwd, name, tel, email, license) values( ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, email);
			pstmt.setString(6, license);
			result = pstmt.executeUpdate();
			if(result == 0) {
				//수행 실패
				result = 0;
			}
			else {
				//수행 성공
				result = 1;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int checkLogin(String id, String passwd) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select id from mab_member where id=? and passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//아이디 비밀번호 일치
				result = 1;
			}
			else {
				//아이디 비밀번호 불일치 or 비 로그인
				result = -5;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public MabDataLoginBean getInfo(String id) {
		MabDataLoginBean dto = new MabDataLoginBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select id, passwd, name, tel, email, license from mab_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setLicense(rs.getString("license"));
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public int updateInfo(String id, String passwd, String tel, String email) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update mab_member set "
					+ "    passwd = ?, "
					+ "    tel = ?, "
					+ "    email = ? "
					+ "where id= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, passwd);
			pstmt.setString(2, tel);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			result = pstmt.executeUpdate();
			// 1 리턴시 성공
			if(result == 1) {
				result = 1;
			}
			else {
				result = 0;
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(String id, String passwd) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select id, passwd from mab_member where id=? and passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
				
				pstmt.close();
				sql = "delete from mab_member where id=? and passwd=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, passwd);
				result = pstmt.executeUpdate();
				if(result == 1) {
					result = 1;
				}
				else {
					result = 0;
				}
			}
			else {
				//비밀번호 틀림
				result = -4;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int insertArticle(String id, String subject, String Content) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into mab_post values (?, mab_post_seq.nextval,?, sysdate, 0, 1, 1, 1, ?, 0) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, subject);
			pstmt.setString(3, Content);
			System.out.println("insert id" + id);
			System.out.println(id);
			System.out.println("sql");
			System.out.println(sql);
			
			result = pstmt.executeUpdate();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<MabDataPostBean> getArticles() {
		ArrayList<MabDataPostBean> dtos = new ArrayList<MabDataPostBean>();
		MabDataPostBean dto = new MabDataPostBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			con = getConnection();
			String sql = "select * from mab_post";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setPostId(rs.getString("post_id"));
				dto.setPostNum(rs.getInt("post_num"));
				dto.setPostSubject(rs.getString("post_subject"));
				dto.setPostWriteDate(rs.getTimestamp("post_write_date"));
				dto.setPostReadCount(rs.getInt("post_readcount")	);
				dto.setPostRef(rs.getInt("post_ref"));
				dto.setPostRefStep(rs.getInt("post_ref_step"));
				dto.setPostRefLevel(rs.getInt("post_ref_level"));
				dto.setPostContent(rs.getString("post_content"));
				dto.setIp(rs.getString("ip"));
				System.out.println(dtos.add(dto));
				int i = 0;
				System.out.println("post postNum");
				System.out.println(dtos.get(i).getPostNum());
				i++;
			}
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	
	
}//class
