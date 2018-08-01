package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OracleDataBinding_Delete {

	public static void main(String[] args) {
		// 데이터 베이스 연결 변수
		Connection conn = null;
		// SQL 실행 변수
		PreparedStatement pstmt = null;

		// 키보드로 부터 입력 받을 수 있는 객체 생성
		Scanner sc = new Scanner(System.in);

		System.out.print("부서 번호 (정수) : ");
		int deptno = sc.nextInt();

		System.out.println("deptno : " + deptno);
		sc.close();

		try {
			// 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 데이터 베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
			//autocommit 해제
			conn.setAutoCommit(false);
			
			String sql = "delete from dept " + "where deptno=?";
			
			// pstmt 생성 - 다른 데이터를 바인딩할 수 있는 PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			// 데이터 바인딩
			pstmt.setInt(1, deptno);
			
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삭제 성공");
				//작업에 성공하면 commit을 호출
				conn.commit();
			}else {
				System.out.println("조건에 맞는 데이터가 없습니다.");
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				//예외의 내용을 출력
				System.out.println(e1.getMessage());
				//예외 발생 지점 역추적
				e1.printStackTrace();
			}
			//예외의 내용을 출력
			System.out.println(e.getMessage());
			//예외 발생 지점 역추적
			e.printStackTrace();
			
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				//예외의 내용을 출력
				System.out.println(e.getMessage());
				//예외 발생 지점 역추적
				e.printStackTrace();
				
			}
		}
	}
}
