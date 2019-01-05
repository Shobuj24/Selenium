package org.zia.training.java.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbInsertDataFile {

public static void main(String[] args) throws ClassNotFoundException, SQLException {

    PreparedStatement ps = null;
    Connection conn = null;
    ResultSet rs = null;
    BufferedReader br = null;

    try
    {
        br = new BufferedReader(new FileReader("DataFile.txt"));
        String username = "zia";
        String pwd = "zia123";
        String connurl = "jdbc:oracle:thin:@localhost:1521:xe";
        
        Class.forName("oracle.jdbc.driver.OracleDriver"); // For Oracle DB

			conn = DriverManager.getConnection(connurl, username, pwd);

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String tmp[] = line.split(",");
				String firstname = tmp[0];
				String middlename = tmp[1];
				String lastname = tmp[2];
				String address1 = tmp[3];
				String address2 = tmp[4];
				String city = tmp[5];
				String state = tmp[6];
				String zip5 = tmp[7];
				String zip4 = tmp[8];
				String phone = tmp[9];
				String email = tmp[10];

				System.out.println(firstname + "\t" + middlename + "\t" + lastname);
				String sql = "INSERT INTO users (firstname, middlename, lastname, address1, address2, city, state, zip5, zip4, phone, email) values ('"
						+ firstname + "','" + middlename + "','" + lastname + "','" + address1 + "','" + address2
						+ "','" + city + "','" + state + "','" + zip5 + "','" + zip4 + "','" + phone + "','" + email
						+ "')";

				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} //finally {
//			try {
//				br.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			conn.close();
//			ps.close();
//		}
	}
}
