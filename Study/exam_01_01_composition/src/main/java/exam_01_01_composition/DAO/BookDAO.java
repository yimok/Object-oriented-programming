package exam_01_01_composition.DAO;

import exam_01_01_composition.DTO.BookDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BookDAO implements DAO {

	
	
	public ArrayList<BookDTO> select(String keyword) {

		//제네릭을 이용해 BookDTO형 ArrayList만듬
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();

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
			String sql ="select btitle,bauthor from book where btitle like ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//sql문에 내가 원하는 문자열을 넣는 작업
			//첫번째 물음표에 , keyword를 넣는다.
			//% 와일드문자는 0개이상의 문자를 의미한다. 즉 keyword를 포함하고 있는 문자열을 ?에 넣는다.
			pstmt.setString(1,"%"+ keyword + "%"); 
			
			
			//4. Statement 실행!!
			//수행한 쿼리문의 결과를 가져옴
			//rs 는 테이블 라인을 가리키는 포인터. 한칸씩 내려가면서 라인을 가리킴
			ResultSet rs = pstmt.executeQuery();
			
			//5. 결과처리
			//여기서 얻은 데이터를 어떻게 해서든 Controller 까지 전달하여 출력
			//DTO가 책 1권에 대한 데이터를 담을 수 있으니까.. DTO를 여러개 만들어서 결과로 나온 여러권의 책을 담아서 
			//Controller에게 전달한다!!
			while(rs.next())
			{
				//한 책에대한 정보가 담긴 rs를 dto에 때려박음
				BookDTO dto = new BookDTO();
				dto.setBtitle(rs.getString("btitle"));
				//dto.setBisbn(rs.getString("bisbn"));
				//dto.setBprice( rs.getInt("bprice")  );
				dto.setBauthor(rs.getString("bauthor"));
				
				//한권의 책정보 dto를 리스트에 넣음
				list.add(dto);
				
			}
		
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