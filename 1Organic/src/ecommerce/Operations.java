package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Operations {
	
	void register(User u) {
	
	 Connection con = DB.getConnection();
		try {
			
			PreparedStatement pre_stmt = con.prepareStatement("insert into  user(name,email,phone,username,street,city,state,pincode,password) values (?,?,?,?,?,?,?,?,?)");
			pre_stmt.setString(1, u.name);
			pre_stmt.setString(2, u.email);
			pre_stmt.setInt(3, u.phone);
			pre_stmt.setString(4,u.username);
			pre_stmt.setString(5, u.street);
			pre_stmt.setString(6, u.city);
		    pre_stmt.setString(7, u.state);
			pre_stmt.setInt(8, u.pincode);
			pre_stmt.setString(9, u.password);
			pre_stmt.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	int verify(String username,String password){
		int userID=0;
		Connection con = DB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select userID from user where username = ? and password = ?");
			 ps.setString(1, username);
			 ps.setString(2,password);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 if(rs.first())
			 {
			 userID = rs.getInt("userID");
			 }
			 else
			userID = 0;
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userID;
	}

}