package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStmt {

	public static void main(String[] args) {
		printAllCustomersWithASpecificLastname("Doe");
	}

	public static void printAllCustomersWithASpecificLastname(String lastname) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root", "root")) {

			String sql = "select firstname, lastname  from students where lastname =?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lastname);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println(rs.getString("name"));
				System.out.println(rs.getString("firstname"));
				System.out.println(rs.getString("lastname"));
			
			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
