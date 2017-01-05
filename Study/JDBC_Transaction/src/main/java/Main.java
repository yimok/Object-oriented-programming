import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) {
			
		//Transaction을 적용하지 않은 예제
		//총 6단계를 거쳐서 데이터베이스 처리를 합니다.

		try{
			//1. Driver Loading( MySQL에 접속하기 위한 class를 로딩)
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loading Success");			
			//2. 실제 데이터베이스에 접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "root";
			String pw = "cps431";
			Connection con = DriverManager.getConnection(url, id, pw);
			
			
			//해당 connection에 transaction을 설정
			con.setAutoCommit(false); //★여기서부터 transaction 시작 이라고 알림.
			
			
			
			//3. 실행할 SQL을 작성(PreparedStatement 생성)
			String sql = "update account set balance = balance + 1000 where username='홍길동'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//4. PreparedStatement를 실행
			//update 이므로 executeUpdate();
			//★반환된 정수값은 SQL문에 의해서 영향을 받은 record의 수
			//만약 select면 result set이 리턴됨.
			int result1 = pstmt.executeUpdate();
			//Transaction이 설정되어 있기 때문에 바로 데이터베이스에 적용되지 않는다.
			
	
			
			sql = "update account set balance = balance - 1000";
			pstmt = con.prepareStatement(sql);
			int result2 = pstmt.executeUpdate();
			if(result1==1 && result2 ==1)
			{
				System.out.println("정상처리 되었습니다.!");
				//Transaction이 정상 수행되면 commit
				//commit이 되어야 데이터베이스에 처리결과를 넣는다.
				con.commit();
			}
			else
			{
				System.out.println("이상이 있습니다.");
				//Transaction이 제대로 수행이 안되면 rollback
				con.rollback();
			}
			
			
			
			
			//6.사용한 리소스 해제
			pstmt.close();
			con.close();
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}

}