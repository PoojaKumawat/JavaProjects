package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainAdd {

	public static void main(String[] args) {
		fetchCustomersWithAddress();

	}

	public static void fetchCustomersWithAddress() {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root", "root")) {

			String sql = "select * from customer c inner join address a on c.id = a.customer_id where c.id =?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("firstname"));
				System.out.println(rs.getString("lastname"));
				System.out.println(rs.getString("city"));

			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
