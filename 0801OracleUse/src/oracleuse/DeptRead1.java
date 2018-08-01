package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeptRead1 {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// select ������ ����� �����ϱ� ���� ����
		ResultSet rs = null;

		try {

			// ����̹� Ŭ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ������ ���̽� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// sql ���� ��ü ����
			pstmt = conn.prepareStatement("select deptno, dname, loc from dept");
			// select �ϴ� sql ����
			rs = pstmt.executeQuery();
			// ������ ��ü �б�
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
