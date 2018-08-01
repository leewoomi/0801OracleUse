package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataSaveMap {

	public static void main(String[] args) {
		// �����ͺ��̽����� ������ �б⸦ ���� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// �о�� ������ ������ ���� �ڷᱸ��
		ArrayList<Map<String, Object>> list = new ArrayList<>();

		try {
			// ����̹� Ŭ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ������ ���̽� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// sql ���� ��ü ����
			pstmt = conn.prepareStatement("select deptno, dname, loc from dept");
			// sql ����
			rs = pstmt.executeQuery();
			// ������ �б�
			// �� ������ �б�
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("deptno", rs.getInt("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
				
				//���� �ϳ��� ���� ����Ʈ�� ����
				list.add(map);
			}
		
			System.out.printf("%10s","�μ���ȣ");
			System.out.printf("%20s","�μ� �̸�");
			System.out.printf("%30s","�μ� ��ġ");
			System.out.println();
			for(Map map : list) {
				System.out.printf("%10s",map.get("deptno"));
				System.out.printf("%20s",map.get("dname"));
				System.out.printf("%30s",map.get("loc"));
				System.out.println();
			}
			
		} catch (Exception e) {
			// ���� ������ ���
			System.out.println(e.getMessage());
			// ���� ������ ����
			e.printStackTrace();
		} finally {
			// ����� ���� ��� �ݱ�
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
