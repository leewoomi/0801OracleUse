package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleMain {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			// 사용하는 데이터베이스 마다 로드하는 클래스 이름은 결정되어 있음.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 확인하기 위한 코드
			// 이 코드가 출력되지 않으면 드라이버 이름을 확이해보고
			// 드라이버 이름이 틀리지 않았다면 ojdbc6.jar가 Referenced Libraries에 포함되어 있는지 확인
			System.out.println("오라클 드라이버 로드 성공");

			// 데이터 베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			//이 메세지가 안나오면 데이터베이스 실행 여부 확인
			//데이터베이스 주소 제대로 입력되었는지 확인
			//계정확인
			System.out.println("데이터 베이스 연결 성공");
		} catch (Exception e) {
			System.out.println("e : " + e.getMessage());
		} finally {
			try {
				// 데이터베이스가 열려 있으면 데이터베이스를 닫기
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
			}
		}

	}

}
