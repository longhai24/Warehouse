package com.accp.Goods.dao;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;


	public abstract class BaseDao {

			String DRIVER = "com.mysql.jdbc.Driver";
			String URL = "jdbc:mysql://localhost:3306/goods";
			String USER = "root";
			String PWD = "123456";
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pst = null;
			
			public Connection Open()
			{
				try {
					Class.forName(DRIVER);
				 conn=	DriverManager.getConnection(URL, USER, PWD);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return conn;
			}
			
			public int Update(String sql ,Object ...objects )
			{
				//PreparedStatement pst = null;
				this.Open();
				try {
					pst=conn.prepareStatement(sql);
					if (objects !=null) {
						for (int i = 0; i < objects.length; i++) {
							pst.setObject(i+1, objects[i]);
						}
					}
					int sum = pst.executeUpdate();
					return sum;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				finally
				{
					this.Close(pst,conn);
				}
				return 0;
			}

			public void Close(PreparedStatement rs,Connection conn)
			{
				
				if (conn!=null) {
					try {
						conn.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				if (pst!=null) {
					try {
						pst.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				if (rs!=null) {
					try {
						rs.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}

			public ResultSet Select(String sql,Object ...objects)
			{
				this.Open();
				//PreparedStatement pst = null;
				try {
					pst= conn.prepareStatement(sql);
					if (objects !=null) {
						for (int i = 0; i < objects.length; i++) {
							pst.setObject(i+1, objects[i]);
						}
					}
					rs = pst.executeQuery();
					return rs;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return rs;
			}
	}


