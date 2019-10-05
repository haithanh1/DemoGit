package Demo.Dao.Impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Demo.Bean.UserName;
import Demo.Dao.UserNameDao;
import Demo.Map.UserNameMapper;

@Repository
@Transactional
public class UserNameDaoImpl extends JdbcDaoSupport implements UserNameDao {

	@Autowired
	public UserNameDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public List<UserName> getListByUserName() {
		String sql = "Select * from USER_NAME";

		List<UserName> lstuserNames = (List<UserName>) this
				.getJdbcTemplate()
				.query(sql, new BeanPropertyRowMapper<UserName>(UserName.class));
		return lstuserNames;
	}

	@Override
	public void Save(UserName name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserName name) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getlistById(UserName name) {
		boolean temp = false;
		String sql = "SELECT *  FROM USER_NAME WHERE [USER_NAME]  =? AND USER_PASSWORD=?";
		try {

			 this.getJdbcTemplate()
					.queryForObject(
							sql,
							new Object[] { name.getUSER_NAME(),
									name.getUSER_PASSWORD()},
							new UserNameMapper());
			temp = true;
		} catch (Exception e) {
			temp = false;
		}
		return temp;
	}

}
