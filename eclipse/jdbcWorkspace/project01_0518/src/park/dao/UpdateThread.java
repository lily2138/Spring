package park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import park.exception.InvalidTransactionException;

public class UpdateThread implements Runnable{

	@Override
	public void run() {
		EncoreLandDaoImpl dao = EncoreLandDaoImpl.getInstance();
		while(true) {
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conn = dao.getConnect();
			// �Ʒ� ������ ���� �ȵɽ� SET SQL_SAFE_UPDATES = 0 ���� ��ų��
			String query1 = "update uselist set status = -1 where status = 0";	//���� ž�� �ο��� ž�¿Ϸ� => -1 �� ����
			ps = conn.prepareStatement(query1);
			ps.executeUpdate();
			
			
			//ž�� ��� �ο��� ���� ������� �ⱸ�� ž�½�Ŵ
			String query3 = "SELECT maxperson FROM attraction WHERE attraction_no = ?";
			int maxP = 0;
			for(int attrNo =1000; attrNo<1010; attrNo++) {
				ps= conn.prepareStatement(query3);
				ps.setInt(1, attrNo);
				rs = ps.executeQuery();
				rs.next();
				maxP=rs.getInt(1);
				for(int j=0; j<maxP; j++) {
					String query2 = "SELECT MIN(uselist_no) FROM uselist WHERE attraction_no = ? AND status = 1";
					ps= conn.prepareStatement(query2);
					ps.setInt(1, attrNo);
					rs = ps.executeQuery();
					rs.next();
					int useListNo=rs.getInt(1);
					String query4 = "UPDATE uselist SET status = 0 WHERE uselist_no = ? AND attraction_no = ?";
					ps= conn.prepareStatement(query4);
					ps.setInt(1, useListNo);
					ps.setInt(2, attrNo);
					ps.executeUpdate();
					
				}
			}
			
			
			
			String query7 = "select count(customer_no) from customer";	//�� �ο� ���� �޾ƿ�
			ps = conn.prepareStatement(query7);
			rs = ps.executeQuery();
			rs.next();
			
			int custN = rs.getInt(1);
			
			dao.randUseAttraction(custN, custN);	//�� �� ��ŭ ���ο� ��û ������ �߰� -> �ټ��� + ž��.
			
			Thread.sleep(15000);	//10�ʰ� ��������.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
