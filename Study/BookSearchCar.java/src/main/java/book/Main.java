package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//프로그램 작성
		// 1. 입력을 받아요
		// 책 제목에 대한 keyword를 받는다.
		System.out.print("키워드를 입력하세요 =>");
		
		//도스창으로부터 입력을 받기위해 Scanner 객체 생성
		//Scanner 객체로 도스창으로부터 입력을 하나씩 받는다. 
		Scanner s = new Scanner(System.in);
		String keyword = s.nextLine();
		
		
		// 2. 로직 처리를 해요
		// 데이터베이스 처리를 해요!!
		try{
			//2-1. 드라이버 로딩
			//자바프로그램이 MySQL에 접근하기 위해서 필요한 라이브러리를 불러들인다.
			//pom.xml 에 MySQL에 대한 dependency를 입력해서 라이브러리를 다운로드 받는다.
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loading Success");
			
			
			//2-2 실제 데이터베이스에 접속
			//어떤 데이터베이스에 접속할 건지, 아이디와 패스워드가 필요
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "root";
			String pw = "cps431";
			Connection con = DriverManager.getConnection(url,id,pw);
			System.out.println("Database loading Success");
			
			//2-3.SQL문을 실행하기 위한 Statement를 생성한다.
			String sql ="select btitle from book where bisbn='89-7914-063-0'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//2-4 Statement 실행!!
			//수행한 쿼리문의 결과를 가져옴
			//rs 는 테이블 라인을 가리키는 포인터. 한칸씩 내려가면서 라인을 가리킴
			ResultSet rs = pstmt.executeQuery();
			
			//2-5 결과처리
			rs.next();
			//btitle 컬럼명의 문자열을 가져와라.(열 선택)
			String title = rs.getString("btitle"); 
			
			System.out.println(title);
			
		}catch(Exception e){
			//만약 오류가 생기면 오류 출력
			System.out.println(e);
		}
		
		// 3. 출력해요
	}

}
