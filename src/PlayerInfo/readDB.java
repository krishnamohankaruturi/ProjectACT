package PlayerInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class readDB {

	 private static final String URL = "jdbc:mysql://localhost:3306/test";
	    private static final String USER = "root";
	    private static final String PASSWORD = "";
	    private static PlayerBase a,b;
	    private static Statement stmt;
	public static void main(String[] args) throws Exception {
		//1.������������
    	Class.forName("com.mysql.jdbc.Driver");
        //2. ������ݿ�����
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.�������ݿ⣬ʵ����ɾ�Ĳ�
        stmt = conn.createStatement();
        
        
        ResultSet rs = stmt.executeQuery("SELECT ID,NAME,HP,MP,DMG,DEF FROM playerbase");
        while(rs.next()){
        if(rs.getInt("ID") == 101){
        		a = new PlayerBase(rs.getString("NAME"),rs.getFloat("HP"),rs.getFloat("MP"),rs.getFloat("DMG"),rs.getFloat("DEF"));
                a.showPlayerInfo(a);
        }
        rs.next();
        if(rs.getInt("ID") == 102){
    		b = new PlayerBase(rs.getString("NAME"),rs.getFloat("HP"),rs.getFloat("MP"),rs.getFloat("DMG"),rs.getFloat("DEF"));
    		b.showPlayerInfo(b);
        }
       }
		a.attack(a,b);
		System.out.println("     Time up    ");
		sync(stmt,a,b);
		conn.close();

	}

	public static void sync(Statement stmt,PlayerBase a,PlayerBase b) throws Exception{
		stmt.executeUpdate("update playerbase set HP= '"+a.getBaseHp()+"',MP= '"+a.getBaseMP()+"',DMG = '"+a.getBaseDmg()+"',DEF= '"+a.getBaseDef()+"' WHERE ID='101'");
		stmt.executeUpdate("update playerbase set HP= '"+b.getBaseHp()+"',MP= '"+b.getBaseMP()+"',DMG = '"+b.getBaseDmg()+"',DEF= '"+b.getBaseDef()+"' WHERE ID='102'");
	}
}
