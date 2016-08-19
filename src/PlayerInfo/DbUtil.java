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
        
    	//1.加载驱动程序
    	Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        
        /*
         * 创建表格
         * 表格名称: Coffees
         * 列名: COF_NAME VARCHAR(32), SUP_ID INTEGER, PRICE FLOAT, " +
        		   "SALES INTEGER, TOTAL INTEGER
         */
//        String createTableCoffees="CREATE TABLE COFFEES " +
//        		   "(COF_NAME VARCHAR(32), SUP_ID INTEGER, PRICE FLOAT, " +
//        		   "SALES INTEGER, TOTAL INTEGER)";
        
//        stmt.executeUpdate(createTableCoffees);
        
        //对 coffees表填入数据
        stmt.executeUpdate("INSERT INTO COFFEES VALUES ('Colombian',101,7.99,0,0)");
        
        
        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM imooc_goddess");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" 年龄："+rs.getInt("age"));

        }
    }
}