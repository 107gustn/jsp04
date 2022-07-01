package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBPKG.DBConnect;

// DAO: DB에 관련된 코드들
public class MemberDAO {
	
	//인스턴스 변수
	Connection con; //Oracle과 연결되어 있는 코드
	PreparedStatement ps;
	ResultSet rs;
	
	//생성자
	public MemberDAO() { 
		try {
			con = DBConnect.getConnection(); //연결된 객체 저장
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> getNewSt() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); //웹 화면에 띄우기 위해 생성
		System.out.println("getNewSt연결 성공");
		String sql = "select * from newst";
		/*
		1. 드라이브 로드(오라클 기능을 사용할 수 있게 해줌)
		2. 오라클과 자바와 연결(Connection)
		3. 명령어 전송하는 객체 얻어오기(PreparedStatement)
		4. 결과값 받는 객체 생성(ResultSet)
			- select를 통해서 많은 정보를 얻어올 때 ResultSet사용
			- select를 제외한 나머지는 int로 받는다.
		 */
		//명령어 전송객체 얻어옴
		try {
			ps = con.prepareStatement(sql); //ps: 명령어를 전송할 수 있는 전송객체 //DB로 명령어를 보내줌
			/*
			select = executeQuery
			select제외한 나머지 = executeUpdate
			executeQuery
			   - 결과값을 ResultSet으로 가져온다.
			executeUpdate
			   - 결과값을 int형태로 가져온다.
			*/
			rs = ps.executeQuery(); //명령어 실행(연결되어 있는 DB로 쿼리문을 보냄) //rs: DB에서 가져온 정보를 받아줌
			while(rs.next()) { //DB에서 하나씩 값을 가져옴
				MemberDTO dto = new MemberDTO();
				dto.setId( rs.getString("id") );
				dto.setName( rs.getString("name") );
				dto.setAge( rs.getInt("age") );
				
				list.add(dto); //ArrayList에 순차적으로 사용자 정보 저장
				
				System.out.println("id : " + rs.getString("id"));
				System.out.println("name : " + rs.getString("name"));
				System.out.println("age : " + rs.getInt("age"));
				System.out.println("---------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberDTO getUser(String id) {
		System.out.println("id : " + id);
		String sql = "select * from newst where id=?"; //가변적인 값은 ?로 처리한다 //?: 나중에 값이 들어오면 처리한다
		MemberDTO dto = new MemberDTO();
		
		try {
			ps = con.prepareStatement(sql); //전송객체를 얻어옴
			// ?를 순서대로 채워줌 //"select * from newst where id=111"
			ps.setString(1, id); //1: 첫번쨰 물음표
			
			rs = ps.executeQuery(); //명령어 실행한뒤 결과값 저장
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	

}
