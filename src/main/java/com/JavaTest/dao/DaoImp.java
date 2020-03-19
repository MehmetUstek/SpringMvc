package com.JavaTest.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.JavaTest.model.User;


public class DaoImp implements UserDao {

	private List<User> list;


	private JdbcTemplate jdbcTemp;

	public DaoImp(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> empList() {
		List<User> list = jdbcTemp.query("SELECT * FROM EMP_DETAILS", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User emp = new User();

				emp.setId(rs.getInt("id"));
				emp.setBody(rs.getString("body"));
				emp.setPostId(rs.getInt("postId"));
				return emp;
			}

		});
		User user= new User();
		user.setId(2);
		user.setBody("asdha");
		user.setPostId(2);
		list.add(user);
		
		return list;
	}

}
