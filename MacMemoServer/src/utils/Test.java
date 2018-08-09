package utils;
import java.sql.*; 
public class Test {
	


	    public static void main(String argv[]) {

	        try {

	            Class.forName("com.mysql.cj.jdbc.Driver");

	            System.out.println("jdbc 드라이버 로딩 성공");

	        } catch (ClassNotFoundException e) {

	            System.out.println(e.getMessage());

	        }

	              

	        try {

	            String url = "jdbc:mysql://localhost:3306/kikiplus";

	            Connection con = 

	            DriverManager.getConnection(url,"kikiplus","tkfkdgo4596!");

	            System.out.println("mysql 접속 성공");

	            Statement stmt = con.createStatement();

	            ResultSet rs = stmt.executeQuery("select user from user where user = 'kikiplus'");

	            System.out.println("Got result:");

	                 

	            while(rs.next()) {

	                String no= rs.getString(1);

	                String tblname  = rs.getString(1);

	                System.out.println(" no = " + no);

	                System.out.println(" tblname= "+ tblname);

	            }

	                 

	            stmt.close();

	            con.close();

	        } catch(java.lang.Exception ex) {

	            ex.printStackTrace();

	        }

	    }

}
