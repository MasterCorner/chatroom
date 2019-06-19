package cn.edu.swu.service;

import cn.edu.swu.vo.User;
import cn.edu.swu.dao.UserDao;
import cn.edu.swu.dao.UserDao;
import cn.edu.swu.dao.UserDaoImple;
import cn.edu.swu.vo.User;
import java.sql.SQLException;

public class UserService {

	public boolean register(String name, String password){

		System.out.println(name+" "+password);
	    boolean register=false;
	    UserDaoImple userDaoImple = new UserDaoImple();
	    boolean checkUser = userDaoImple.checkUser(name); //返回的否的话 就说明可以注册
	    if (checkUser) {
	    	System.out.println("3");
	        register = UserDaoImple.register(name, password);//如果没有就去注册
	    }

	    //然后把返回值返回给servlet
	    return register;
	}
	
	public User login(User user) {
		UserDao dao = new UserDaoImple();
		return dao.login(user);
	}
	
	
}
