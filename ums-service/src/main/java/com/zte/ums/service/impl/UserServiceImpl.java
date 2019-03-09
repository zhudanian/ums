package com.zte.ums.service.impl;

import com.zte.ums.dao.UserDao;
import com.zte.ums.entity.User;
import com.zte.ums.entity.vo.UserVO;
import com.zte.ums.service.UserService;
import com.zte.ums.utils.MyBatisUtil;

/**
 * Author:hellboy
 * Date:2018-10-29 15:22
 * Description:<描述>
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Override
    public void regist(UserVO userVO) {
        //获取UserDao对应的代理类
        userDao  = MyBatisUtil.getSession().getMapper(UserDao.class);
        User user = new User();
        user.setUsername(userVO.getUsername());
        user.setPassword(userVO.getPassword());
        user.setAge(userVO.getAge());

        try {
            userDao.insertUser(user);
            MyBatisUtil.getSession().commit();
        } catch (Exception e) {
            MyBatisUtil.getSession().rollback();
            throw new RuntimeException("注册失败");
        }
        finally {
            MyBatisUtil.closeSession();
        }


    }
}
