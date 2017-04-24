package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 勉強クラス。
 * 
 * @author Masa
 */
public class Study {

	/**
	 * メイン処理。
	 * 
	 * @param args 引数
	 */
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STD", "STD");
			
			PreparedStatement ps = con.prepareStatement("insert into TBL_ITEM values(seq1.nextval, ?, ?)");
			
			ps.setString(1	, "イカゲソ焼き");
			ps.setInt(2, 300);
			int upCnt = ps.executeUpdate();
			
			System.out.println("upCnt=" + upCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
