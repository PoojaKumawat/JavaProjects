package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainScroll {

	public static void main(String[] args) {
		getAllWithScrollType();
	}

	public static void getAllWithScrollType() {

		try (

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root", "root")) {
			String sql = "select * from customer";
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			System.out.println(rs.getString("firstname"));
			System.out.println(rs.getString("lastname"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getInt("id"));
			System.out.println();
			/*
			rs.first();
			System.out.println(rs.getString("firstname"));
			System.out.println(rs.getString("lastname"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getInt("id"));
			*/
			rs.next();
			System.out.println(rs.getString("firstname"));
			System.out.println(rs.getString("lastname"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getInt("id"));
			System.out.println();
			
			//from bottom 1st row
			rs.absolute(-1);
			System.out.println(rs.getString("firstname"));
			System.out.println(rs.getString("lastname"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getInt("id"));

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
