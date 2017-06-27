package mashen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import mahsen.model.User;

@Repository(value = "userDaoimp")
public class UserDaoimp implements UserDao {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate ht;
	public RowMapper<User> mapRow = new RowMapper<User>() {
		public User mapRow(ResultSet arg0, int arg1) throws SQLException {
			User user = new User();
			user.setName(arg0.getString("n"));
			user.setPw(arg0.getString("p"));
			return user;
		}
	};

	public void add(User user) {
		String sql = "insert into user(name,pw) value('" + user.getName() + "','" + user.getPw() + "')";
		jdbcTemplate.execute(sql);
		System.out.println("add()");
	}

	public List<User> selectList() {
		String sql = "select * from user";
		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}

	public void delete(String name) {
		String sql = "delete from user where name='" + name + "'";
		jdbcTemplate.execute(sql);
	}

	public void update(User user) {
		String sql = "update user set pw='" + user.getPw() + "'where name='" + user.getName() + "'";
		jdbcTemplate.execute(sql);
	}

	public List<User> selectAll() {
		String sql = "select name as n,pw as p from user";
		List<User> list = jdbcTemplate.query(sql, mapRow);
		return list;
	}

	public User find(String name){
		User u=ht.load(User.class, name);
		System.out.println(u.getPw());
		return u;
		
	}

}
