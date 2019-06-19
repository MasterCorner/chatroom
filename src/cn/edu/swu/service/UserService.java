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
	    boolean checkUser = userDaoImple.checkUser(name); //���صķ�Ļ� ��˵������ע��
	    if (checkUser) {
	    	System.out.println("3");
	        register = UserDaoImple.register(name, password);//���û�о�ȥע��
	    }

	    //Ȼ��ѷ���ֵ���ظ�servlet
	    return register;
	}
	
	public User login(User user) {
		UserDao dao = new UserDaoImple();
		return dao.login(user);
	}
	
	
}
