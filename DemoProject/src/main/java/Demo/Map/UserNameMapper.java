package Demo.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Demo.Bean.UserName;
public class UserNameMapper implements RowMapper<UserName> {

	@Override
	public UserName mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserName userName=new UserName();
		userName.setUSER_ID(arg0.getInt("USER_ID"));
		userName.setUSER_PASSWORD(arg0.getString("USER_PASSWORD"));
		userName.setUSER_NAME(arg0.getString("USER_NAME"));
		userName.setUSER_COMPANY(arg0.getString("USER_COMPANY"));
		userName.setUSER_FISTNAME(arg0.getString("USER_FISTNAME"));
		userName.setUSER_LASTNAME(arg0.getString("USER_LASTNAME"));
		return userName;
	}
	

}
