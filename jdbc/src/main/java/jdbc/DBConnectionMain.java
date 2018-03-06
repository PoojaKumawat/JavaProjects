package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Statement ,PreparedStatement(parameterized sql ,pre compiled statements), CallableStatement(Stored Procedure)

public class DBConnectionMain {

	public static void main(String[] args) {

		try 
			(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root", "root"))
			{
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root", "root");
			String sql ="select * from customers";
			//String sql ="select name,age from customers";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("age"));
				System.out.println(rs.getString("address"));
				
				// accessing database through column indexes(starts from 1)
				System.out.println(rs.getString(5));
			}
			rs.close();
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
