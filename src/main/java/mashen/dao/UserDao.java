package mashen.dao;

import java.util.List;

import mahsen.model.User;

public interface UserDao {
	public void add(User user);
	public List<User> selectList();
	public void delete(String name);
	public void update(User user);
	public List<User> selectAll();
	public User find(String name);
}
