import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbConnector {
	
	static ResultSet connection() {
		ResultSet rs=null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123456789");
			Statement st = conn.createStatement();
			rs = (ResultSet) st.executeQuery("select * from tablestu");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

}
