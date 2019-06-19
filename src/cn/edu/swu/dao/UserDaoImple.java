package cn.edu.swu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.edu.swu.utils.JDBCUtils;
import cn.edu.swu.vo.User;
/*
֪ʶ�㣺���ʹ��c3p0���ӳ�ȥ�����ݿ������ɾ�Ĳ�
    1. �ȴ���ComboPooledDataSource �õ����ӳ��е�����Դ
    2. ��Ҫ����һ�����Ӧ��QueryRunner�õ�ʱ�������������
       ȥ��������Ҫ�Ĳ�ѯ��ʽ(����ǲ�����Ҫ����ֵ����Ӱ�������)

һ�������dao��ȡ�����ݿ��е���Ϣ���û�����Ϣ���бȶԣ������ݿ����Ƿ���
    1. ��Ҫ�õ�c3p0���ӳص��й�������Ҫ���QueryRunner����ʹ��
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
//��������ݿ���û�в�ѯ���û�����Ϣ��˵������ע�ᣬ���� �Ͳ���ע����ʾ��ע��
            if (user==null){//˵��û�в�ѯ�����û�
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
            //�������ݿ��ʱ�򷵻�ֵ��Ӱ�������
            int row = queryRunner.update(sql, name, password);
            if (row>0){ //�������Ӱ�����������0˵�������ݿ�ɹ�
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
		// ����QueryRunner����
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		// ��дsql
		String sql = "select * from user where username = ? and password = ?";
		User existUser;
		try {
			existUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�û���¼ʧ�ܣ�");
		}
		return existUser;
	}

}
