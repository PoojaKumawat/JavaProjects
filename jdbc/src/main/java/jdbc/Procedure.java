package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Procedure {

	public static void main(String[] args) {
		CallSp();

	}

	public static void CallSp() {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root", "root")) {

			String sql = "call fetch_Stud_lName(?);";

			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "Doe");
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("name"));
				System.out.println(rs.getString("firstname"));
				System.out.println(rs.getString("lastname"));

			}

			cstmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
