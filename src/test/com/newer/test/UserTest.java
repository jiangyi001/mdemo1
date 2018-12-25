package com.newer.test;

import com.newer.test.pojo.User;
import com.newer.test.dao.UserDao;
import com.newer.test.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    @Test
    public void test1(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
      UserDao userDao=sqlSession.getMapper(UserDao.class);

        User user=new User();
        user.setUsername("wangqing");
        user.setPassword("111111");
        user.setState(1);
        user.setMobile("13900008888");

        User user1 =new User();
        user1.setUsername("jiangyi");
        user1.setPassword("111111");
        user1.setState(1);
        user1.setMobile("15616014967");

        userDao.addUser(user1);
            sqlSession.commit();
            SqlSessionUtil.closeSqlSession(sqlSession);

    }

}
