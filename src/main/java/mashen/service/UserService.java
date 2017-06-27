package mashen.service;

import java.util.List;

import mahsen.model.User;

public interface UserService {
	public void add();
	public void selectList();
	public void delete(String name);
	public void update();
	public List<User> selectAll();
	public void addTwoUser(int i);
	public User find(String name);
}
