package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUpdate {

	public static void main(String[] args) {

		// createStudents();
		 printAllStudentsWithASpecificLastnameWithStmt("Doe");
	}
	/*
	 * public static void createStudents() {
	 * 
	 * try (Connection conn =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root",
	 * "root")) {
	 * 
	 * String sql = "INSERT INTO STUDENTS (FIRSTNAME,LASTNAME,EMAIL) VALUES(?,?,?)";
	 * PreparedStatement pstmt = conn.prepareStatement(sql); pstmt.setString(1,
	 * "HARRY"); pstmt.setString(2, "PORTER"); pstmt.setString(3, "HP@GMAIL.COM");
	 * 
	 * int rowCount = pstmt.executeUpdate(); System.out.println(rowCount);
	 * 
	 * pstmt.close(); conn.close();
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); }
	 */

	public static void printAllStudentsWithASpecificLastnameWithStmt(String lastname) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root", "root")) {

			String sql = "select firstname, lastname  from students where lastname ='" + lastname + " ' ";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("firstname"));
				System.out.println(rs.getString("lastname"));

			}

			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
