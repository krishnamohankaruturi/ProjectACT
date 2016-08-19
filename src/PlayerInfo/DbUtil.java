package PlayerInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DbUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        
    	//1.������������
    	Class.forName("com.mysql.jdbc.Driver");
        //2. ������ݿ�����
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.�������ݿ⣬ʵ����ɾ�Ĳ�
        Statement stmt = conn.createStatement();
        
        /*
         * �������
         * �������: Coffees
         * ����: COF_NAME VARCHAR(32), SUP_ID INTEGER, PRICE FLOAT, " +
        		   "SALES INTEGER, TOTAL INTEGER
         */
//        String createTableCoffees="CREATE TABLE COFFEES " +
//        		   "(COF_NAME VARCHAR(32), SUP_ID INTEGER, PRICE FLOAT, " +
//        		   "SALES INTEGER, TOTAL INTEGER)";
        
//        stmt.executeUpdate(createTableCoffees);
        
        //�� coffees����������
        stmt.executeUpdate("INSERT INTO COFFEES VALUES ('Colombian',101,7.99,0,0)");
        
        
        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM imooc_goddess");
        //��������ݣ�rs.next()����true
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" ���䣺"+rs.getInt("age"));

        }
    }
}