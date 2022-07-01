package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import DBPKG.DBConnect;

public class StudentDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public StudentDAO() {
		try {
			con = DBConnect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<StudentDTO> getStudent() {
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		String sql = "select * from student";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setId( rs.getString("id") );
				dto.setName( rs.getString("name") );
				dto.setKor( rs.getString("kor") );
				dto.setEng(rs.getString("eng") );
				dto.setMath( rs.getString("math") );
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public StudentDTO stInfo(String name) {
		String sql = "select * from student where name=?";
		StudentDTO dto = new StudentDTO();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setId( rs.getString("id"));
				dto.setName( rs.getString("name"));
				dto.setKor( rs.getString("kor"));
				dto.setEng( rs.getString("eng"));
				dto.setMath( rs.getString("math"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
