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
			String sql ="select btitle,bauthor from book where btitle like ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//sql문에 내가 원하는 문자열을 넣는 작업
			//첫번째 물음표에 , keyword를 넣는다.
			//% 와일드문자는 0개이상의 문자를 의미한다. 즉 keyword를 포함하고 있는 문자열을 ?에 넣는다.
			pstmt.setString(1,"%"+ keyword + "%"); 
			
			
			//2-4 Statement 실행!!
			//수행한 쿼리문의 결과를 가져옴
			//rs 는 테이블 라인을 가리키는 포인터. 한칸씩 내려가면서 라인을 가리킴
			ResultSet rs = pstmt.executeQuery();
			
			//2-5 결과처리
			//반복 해서 rs.next() 를 수행하고
			//btitle 컬럼명의 열의 문자열을 가져와라.
			while(rs.next())
			{
				System.out.println("책 제목:" + rs.getString("btitle"));
			}
		
			//2-6 사용한 리소스 정리
			rs.close();
			pstmt.close();
			con.close();
			
			
		}catch(Exception e){
			//만약 오류가 생기면 오류 출력
			System.out.println(e);
		}
		
		// 3. 출력해요
	}

}
