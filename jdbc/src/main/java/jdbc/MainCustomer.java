package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainCustomer {

	public static void main(String[] args) {
		CallSp();

	}

	public static void CallSp() {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/febdb", "root", "root")) {

			String sql = "call fetch_Stud_lName(?);";

			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "Doe");
			ResultSet rs = cstmt.executeQuery();

			List<Customer> customers = new ArrayList<Customer>();

			while (rs.next()) {
				Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				customers.add(c);
			}

			cstmt.close();
			conn.close();
			/*
			 * Consumer<Customer> c =new Consumer<Customer>(){
			 * 
			 * @Override public void accept(Customer t){ System.out.pirntln(c)} 
			 * }
			 * };
			 * Consumer<Customer> c1 =(t) ->System.out.pirntln(c);
			 * costumers.forEach((c)->System.out.pirntln(c));
			 */
			for (Customer customer : customers) {
				System.out.println(customer);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
