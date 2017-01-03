package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.BankDTO;

public class BankDAO {

	public BankDTO UpdateDeposit(BankDTO dto) {
		try{
			//1. 드라이버 로딩
			//자바프로그램이 MySQL에 접근하기 위해서 필요한 라이브러리를 불러들인다.
			//pom.xml 에 MySQL에 대한 dependency를 입력해서 라이브러리를 다운로드 받는다.
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 실제 데이터베이스에 접속
			//어떤 데이터베이스에 접속할 건지, 아이디와 패스워드가 필요
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "root";
			String pw = "cps431";
			Connection con = DriverManager.getConnection(url,id,pw);	
			
			//3. SQL문을 실행하기 위한 Statement를 생성한다.
			String sql ="update account set balance = balance + ? where username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//sql문에 내가 원하는 문자열을 넣는 작업.
			pstmt.setInt(1, dto.getBalance()); 
			pstmt.setString(2, dto.getUsername()); 
			
			
			//4. Statement 실행!!
			//update 쿼리문 수행
			pstmt.executeUpdate();
			
			//5. 결과처리
			//update한 결과를 가져옴
			sql = "select username,balance from account where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername()); 
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			dto = new BankDTO();
			dto.setUsername(rs.getString("username"));
			dto.setBalance(rs.getInt("balance"));

			//6. 사용한 리소스 정리
			rs.close();
			pstmt.close();
			con.close();
			
			
		}catch(Exception e){
			//만약 오류가 생기면 오류 출력
			System.out.println(e);
		}
		
		
		return dto;
	}

	public BankDTO UpdateWithdrawal(BankDTO dto) {
		try{
			//1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 실제 데이터베이스에 접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "root";
			String pw = "cps431";
			Connection con = DriverManager.getConnection(url,id,pw);	
			
			//3. SQL문을 실행하기 위한 Statement를 생성한다.
			String sql ="update account set balance = balance - ? where username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBalance()); 
			pstmt.setString(2, dto.getUsername()); 
			
			
			//4. Statement 실행!!
			pstmt.executeUpdate();
			
			//5. 결과처리
			sql = "select username,balance from account where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername()); 
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			dto = new BankDTO();
			dto.setUsername(rs.getString("username"));
			dto.setBalance(rs.getInt("balance"));

			//6. 사용한 리소스 정리
			rs.close();
			pstmt.close();
			con.close();
			
			
		}catch(Exception e){
			//만약 오류가 생기면 오류 출력
			System.out.println(e);
		}
		
		
		return dto;
	}

	public ArrayList<BankDTO> UpdateTransfer(ArrayList<BankDTO> list) {
	
		try{
			//1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 실제 데이터베이스에 접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "root";
			String pw = "cps431";
			Connection con = DriverManager.getConnection(url,id,pw);	
			
			//3. SQL문을 실행하기 위한 Statement를 생성한다.
			//4. Statement 실행!!
			String sql ="update account set balance = balance - ? where username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, list.get(0).getBalance()); 
			pstmt.setString(2, list.get(0).getUsername()); 
			pstmt.executeUpdate();
			
			
			sql ="update account set balance = balance + ? where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, list.get(1).getBalance()); 
			pstmt.setString(2, list.get(1).getUsername()); 
			pstmt.executeUpdate();
			
			
			
			//5. 결과처리
			sql = "select username,balance from account where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, list.get(0).getUsername());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			BankDTO dto = new BankDTO();
			dto.setUsername(rs.getString("username"));
			dto.setBalance(rs.getInt("balance"));

			
			
			sql = "select username,balance from account where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, list.get(1).getUsername());
			rs = pstmt.executeQuery();
			rs.next();
			BankDTO dto2 = new BankDTO();
			dto2.setUsername(rs.getString("username"));
			dto2.setBalance(rs.getInt("balance"));

			list.clear();
			list.add(dto);
			list.add(dto2);
			
			//6. 사용한 리소스 정리
			rs.close();
			pstmt.close();
			con.close();
			
			
		}catch(Exception e){
			//만약 오류가 생기면 오류 출력
			System.out.println(e);
		}
		
		
		return list;
	}

		
}

