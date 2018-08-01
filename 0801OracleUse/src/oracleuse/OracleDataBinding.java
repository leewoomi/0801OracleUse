package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OracleDataBinding {

	public static void main(String[] args) {
		// ������ ���̽� ���� ����
		Connection conn = null;
		// SQL ���� ����
		PreparedStatement pstmt = null;

		// Ű����� ���� �Է� ���� �� �ִ� ��ü ����
		Scanner sc = new Scanner(System.in);

		System.out.print("�μ� ��ȣ (deptno) : ");
		int deptno = sc.nextInt();

		System.out.print("�μ� �̸� (dname) : ");
		// ������ �����ִ� Enter�� �����ϱ� ���� �ڵ�
		sc.nextLine();
		String dname = sc.nextLine();

		System.out.println("���� (loc) : ");
		String loc = sc.nextLine();

		sc.close();

		try {
			// ����̹� Ŭ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ������ ���̽� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			String sql = "insert into dept(deptno,dname,loc) " + "values(?,?,?)";
			
			// pstmt ���� - �ٸ� �����͸� ���ε��� �� �ִ� PreparedStatement ����
			pstmt = conn.prepareStatement(sql);
			//������ ���ε�
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("���� ����");
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
