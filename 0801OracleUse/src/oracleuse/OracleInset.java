package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class OracleInset {

	public static void main(String[] args) {
		// ������ ���̽� ���� ����
		Connection conn = null;
		// SQL ���� ����
		PreparedStatement pstmt = null;
		try {
			// ����̹� Ŭ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ������ ���̽� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// SQL ���� ��ü�� ����
			// insert, delete, update�� ����� ����.
			// ����
			pstmt = conn.prepareStatement("insert into dept(deptno,dname,loc) " + "values(70,'��','�λ�')");

			// ����
			//pstmt = conn.prepareStatement("update dept set loc='��⵵' " + "where deptno=70");

			// ����
			 //pstmt = conn.prepareStatement("delete from dept where loc='�λ�' or dname='��'");
			// SQL�� ���� - select�� ������ ���� ����
			// r�� ����Ǵ� ���� ����޴� ���� ����
			int r = pstmt.executeUpdate();
			// �������� ���
			if (r > 0) {
				 System.out.println("���� ����");
				//System.out.println("���� ����");
				// System.out.println("���� ����");
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
