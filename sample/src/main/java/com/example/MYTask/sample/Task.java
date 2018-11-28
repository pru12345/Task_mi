package com.example.MYTask;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;


	public class Test {
		public static void main(String[] args) throws SQLException {
			int count =100000;
			Connection conn = null;
	        Statement stmt = null;

		String JDBC_DRIVER = "org.h2.Driver"; // org.h2.Driver
		String DB_URL = "jdbc:h2:~/mytest";

		// Database credentials
		final String USER = "table";
		final String PASS = "";
		double highest = 0d;
		String sql = "";

		try{
			Class.forName("org.h2.Driver");
		
			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected database successfully...");
		
			// STEP 4: Execute a query
			System.out.println("Creating table in given database...");
			stmt=conn.createStatement();
		
			sql = "CREATE TABLE StandardDistribution3 " + "(id INTEGER not NULL, " + " value VARCHAR(255) "
					+ ")";
		
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
			for(int i = 1;i<count;++i){
				double t = (-1 * i * i) / 2;
				highest = Math.exp(t) / Math.sqrt(2 * Math.PI);
				System.out.println("highest..."+highest);
				sql = "INSERT INTO StandardDistribution3 " + "VALUES ("+ i +",'"+ highest +"')";
	            stmt.executeUpdate(sql);
	            System.out.println("Inserted records into the table..."+sql);
			}
			ResultSet rs = stmt.executeQuery("select * from StandardDistribution3");
	        double  IDS_vales =0;
	        int NUM_increments=0;
	        while (rs.next()) {
	        	
	            int id = rs.getInt(1);
					if (NUM_increments < 1001) {
						IDS_vales += Double.parseDouble(rs.getString(2)); // Assuming there is a column called name.
						IDS_vales++;
					} else {
						NUM_increments = 0;
						System.out.println("IDS_vales :" + 0.001 * IDS_vales);
						NUM_increments++;
						IDS_vales = Double.parseDouble(rs.getString(2));
					}
	        }
	        
			}catch(Exception e){
				
			}finally{
				if(conn != null){
					conn.close();
				}
				if(stmt != null){
					conn.close();
				}
			}
		}
		
	}


