package cn.edu.swu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.edu.swu.utils.JDBCUtils;
import cn.edu.swu.vo.User;
/*
知识点：如何使用c3p0连接池去对数据库进行增删改查
    1. 先创建ComboPooledDataSource 拿到连接池中的数据源
    2. 需要创建一个相对应的QueryRunner用的时候用这个对象在
       去调用你需要的查询方式(如果是插入需要返回值就是影响的行数)

一、如何在dao层取到数据库中的信息和用户的信息进行比对，看数据库中是否有
    1. 需要用到c3p0连接池的有关配置需要配合QueryRunner对象使用
*
*
* */
public class UserDaoImple implements UserDao {

    public boolean checkUser(String name){

        try {
            ComboPooledDataSource dataSource= new ComboPooledDataSource();
            QueryRunner queryRunner= new QueryRunner(dataSource);
            String sql= "select username from user where username=?";
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class),name);
//如果在数据库中没有查询到用户的信息就说明可以注册，否则 就不能注册提示已注册
            if (user==null){//说明没有查询到该用户
                System.out.println("1");
            	return true;
            }
            else {
            	System.out.println("2");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean register(String name, String password) {

        try {
            ComboPooledDataSource dataSource= new ComboPooledDataSource();
            QueryRunner queryRunner = new QueryRunner(dataSource);
            String sql = "insert into user values(null,?,?,'user')";
            //插入数据库的时候返回值是影响的行数
            int row = queryRunner.update(sql, name, password);
            if (row>0){ //如果返回影响的行数大于0说插入数据库成功
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
	
	public User login(User user) {
		// 创建QueryRunner对象。
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		// 编写sql
		String sql = "select * from user where username = ? and password = ?";
		User existUser;
		try {
			existUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("用户登录失败！");
		}
		return existUser;
	}

}
