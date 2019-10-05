package Demo.Dao;

import java.util.List;

import Demo.Bean.*;

public interface UserNameDao {

	public List<UserName> getListByUserName();

	public void Save(UserName name);

	public void update(UserName name);
	
	public boolean getlistById(UserName name);
	
	
}

