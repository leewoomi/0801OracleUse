package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class OracleInset {

	public static void main(String[] args) {
		// 데이터 베이스 연결 변수
		Connection conn = null;
		// SQL 실행 변수
		PreparedStatement pstmt = null;
		try {
			// 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터 베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// SQL 실행 객체를 생성
			// insert, delete, update는 방법이 같다.
			// 삽입
			pstmt = conn.prepareStatement("insert into dept(deptno,dname,loc) " + "values(70,'비서','부산')");

			// 변경
			//pstmt = conn.prepareStatement("update dept set loc='경기도' " + "where deptno=70");

			// 삭제
			 //pstmt = conn.prepareStatement("delete from dept where loc='부산' or dname='비서'");
			// SQL을 실행 - select를 제외한 구문 실행
			// r에 저장되는 값은 영향받는 행의 개수
			int r = pstmt.executeUpdate();
			// 성공여부 출력
			if (r > 0) {
				 System.out.println("삽입 성공");
				//System.out.println("변경 성공");
				// System.out.println("삭제 성공");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
			
			}
		}
	}
}
