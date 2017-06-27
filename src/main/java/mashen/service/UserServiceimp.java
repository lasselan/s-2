package mashen.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mahsen.model.User;
import mashen.dao.UserDaoimp;
@Transactional(rollbackFor=java.lang.Exception.class)
@Service(value = "userServiceimp")
public class UserServiceimp implements UserService {
	@Resource(name = "userDaoimp")
	private UserDaoimp dao;
	private User user = new User();

	public void add() {
		user.setName("la");
		user.setPw("123321");
		dao.add(user);
	}

	public void selectList() {
		dao.selectList();		
	}

	public void delete(String name) {
		dao.delete(name);
	}

	public void update() {
//		user.setName("lan");
//		user.setPw("000");
//		dao.update(user);
	}

	public List<User> selectAll() {
		return dao.selectAll();		
	}
	public void addTwoUser(int i){
		User user = new User();
		user.setName("xing");
		user.setPw("admin2");
		dao.add(user);
		if(i == 1){
			throw new RuntimeException();
		}
		User user2 = new User();
		user2.setName("ll");
		user2.setPw("11");
		dao.add(user2);
	}
	public User find(String name){
		return dao.find(name);
		
	}
}
