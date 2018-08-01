package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OracleDataBinding_Delete {

	public static void main(String[] args) {
		// ������ ���̽� ���� ����
		Connection conn = null;
		// SQL ���� ����
		PreparedStatement pstmt = null;

		// Ű����� ���� �Է� ���� �� �ִ� ��ü ����
		Scanner sc = new Scanner(System.in);

		System.out.print("�μ� ��ȣ (����) : ");
		int deptno = sc.nextInt();

		System.out.println("deptno : " + deptno);
		sc.close();

		try {
			// ����̹� Ŭ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// ������ ���̽� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
			//autocommit ����
			conn.setAutoCommit(false);
			
			String sql = "delete from dept " + "where deptno=?";
			
			// pstmt ���� - �ٸ� �����͸� ���ε��� �� �ִ� PreparedStatement ����
			pstmt = conn.prepareStatement(sql);
			// ������ ���ε�
			pstmt.setInt(1, deptno);
			
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("���� ����");
				//�۾��� �����ϸ� commit�� ȣ��
				conn.commit();
			}else {
				System.out.println("���ǿ� �´� �����Ͱ� �����ϴ�.");
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				//������ ������ ���
				System.out.println(e1.getMessage());
				//���� �߻� ���� ������
				e1.printStackTrace();
			}
			//������ ������ ���
			System.out.println(e.getMessage());
			//���� �߻� ���� ������
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
				//������ ������ ���
				System.out.println(e.getMessage());
				//���� �߻� ���� ������
				e.printStackTrace();
				
			}
		}
	}
}
