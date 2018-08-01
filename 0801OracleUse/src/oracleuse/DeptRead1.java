package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeptRead1 {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// select 구문의 결과를 저장하기 위한 변수
		ResultSet rs = null;

		try {

			// 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터 베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// sql 실행 객체 생성
			pstmt = conn.prepareStatement("select deptno, dname, loc from dept");
			// select 하는 sql 실행
			rs = pstmt.executeQuery();
			// 데이터 전체 읽기
			while (rs.next()) {
				System.out.print(rs.getInt("deptno") + ":");
				System.out.print(rs.getString("dname") + ":");
				System.out.print(rs.getString("loc") + "\n");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
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
