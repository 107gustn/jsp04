package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBPKG.DBConnect;

public class MembershipDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public MembershipDAO() { 
		try {
			con = DBConnect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MembershipDTO getMembers(String id) {
		String sql = "select * from members where id = ?";
		MembershipDTO dto = new MembershipDTO();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
		
		
	}
	
}
