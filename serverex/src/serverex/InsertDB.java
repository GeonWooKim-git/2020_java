package serverex;

import java.sql.*;
import java.util.Scanner;

public class InsertDB {
	Connection con;
	String id = "root";
	String pass = "비밀번호";
	public InsertDB(String id, String passwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/재고관리";
			con = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(String na, String ph, String em, String co) {
		String sql = "insert into 재고관리(name, ph1, ph2, email1, email2, ch1, ch2, fax, std)" + " values ( ?, ?, ?, ?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, na);
			st.setString(2, ph);
			st.setString(3, em);
			st.setString(4, co);
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			con.close();
		} catch (Exception e) {
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("전화번호:");
		String phone = sc.nextLine();
		System.out.print("이메일:");
		String email = sc.nextLine();
		System.out.print("회사:");
		String company = sc.nextLine();
		InsertDB id = new InsertDB("root", "mysql5");
		id.insert(name, phone, email, company);
		id.close();
	}
}