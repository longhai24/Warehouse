package cpm.accp.ping.dao;
import java.sql.*;
import java.util.ArrayList;
public class BaseDao {
	private static final String Driver = "com.mysql.jdbc.Driver";
	protected static String URL = "jdbc:mysql://127.0.0.1:3306/aicces";
	private static final String USER = "root";
	private static final String PASSWORD = "lq926494";
	private Connection con = null;
	private PreparedStatement p = null;
	//��������
	public Connection getConnection(){
		try {
			Class.forName(Driver);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//��ɾ��Update
	public int exceuteUpdate(String sql,Object ... por){
		this.getConnection();
		try {
			p = con.prepareStatement(sql);
			for (int i = 0; i < por.length; i++) {
				p.setObject(i+1,por[i]);
			}
			return p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.closeAll(null);
		}
		return 0;
	}
	//�ر�����
	public void closeAll(ResultSet rs){
			try {
				if (con != null) {
					con.close();
				}

				if(p!=null){
					p.close();
				}
				if (rs!= null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		
		
	}
	//��
	public ResultSet query(String sql , Object ... por){
		this.getConnection();
		ResultSet rs = null;
		try {
			p = con.prepareStatement(sql);
			for (int i = 0; i < por.length; i++) {
				p.setObject(i+1,por[i]);
			}
			rs = p.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
