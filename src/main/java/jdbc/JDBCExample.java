package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {


	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/marsqlclass";
		String un="root";
		String pass="root";

		//Create connection
		Connection con=DriverManager.getConnection(url,un,pass);
		
		//Create statement
		Statement stm=con.createStatement();
		String s="select * from department ";
		//String s="insert into employee values(105,'shapan')";
       // stm.executeUpdate(s);
		//Execute Statement
		ResultSet rs=stm.executeQuery(s);
		//process the result
		while(rs.next()){
			int d_id=rs.getInt("DepartmentID");
			String dname=rs.getString("DepartmentName");
			System.out.println(d_id+"..........>"+dname);
			
		}


		//Close connection
		con.close();
		System.out.println("Program is completed");
	
	






	}

}
