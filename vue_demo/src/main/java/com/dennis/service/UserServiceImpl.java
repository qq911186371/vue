package com.dennis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.dennis.dao.UserDao;
import com.dennis.domain.PeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李恒
 * @date 2019-08-23 01:08
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<PeUser> findAll(Wrapper wrapper) {
        List users = userDao.selectList(wrapper);
        return users;
    }
}
