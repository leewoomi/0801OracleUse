package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleMain {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			// ����ϴ� �����ͺ��̽� ���� �ε��ϴ� Ŭ���� �̸��� �����Ǿ� ����.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Ȯ���ϱ� ���� �ڵ�
			// �� �ڵ尡 ��µ��� ������ ����̹� �̸��� Ȯ���غ���
			// ����̹� �̸��� Ʋ���� �ʾҴٸ� ojdbc6.jar�� Referenced Libraries�� ���ԵǾ� �ִ��� Ȯ��
			System.out.println("����Ŭ ����̹� �ε� ����");

			// ������ ���̽� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			//�� �޼����� �ȳ����� �����ͺ��̽� ���� ���� Ȯ��
			//�����ͺ��̽� �ּ� ����� �ԷµǾ����� Ȯ��
			//����Ȯ��
			System.out.println("������ ���̽� ���� ����");
		} catch (Exception e) {
			System.out.println("e : " + e.getMessage());
		} finally {
			try {
				// �����ͺ��̽��� ���� ������ �����ͺ��̽��� �ݱ�
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
			}
		}

	}

}
