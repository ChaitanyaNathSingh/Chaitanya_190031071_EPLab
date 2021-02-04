package Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedIbackDAO {

	public int feedback_insert(FeedbackBean fb) throws ClassNotFoundException, SQLException{
	
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("insert into feedback values(?,?,?,?,?)");  
		ps.setString(1,fb.getQ1());
		ps.setString(2,fb.getQ2());
		ps.setString(3,fb.getQ3());
		ps.setString(4,fb.getQ4());
		ps.setString(5,fb.getQ5());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
}
