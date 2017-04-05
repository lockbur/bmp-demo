package com.jinyinwu.bpm.service.impl;

import com.jinyinwu.bpm.dao.UserMapper;
import com.jinyinwu.bpm.model.User;
import com.jinyinwu.bpm.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 *
 * Created by wangkun23 on 2017/3/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Value("${user.salt}")
    private String passwordSalt;
    /**
     * 保存新用户
     * @param user
     * @param role
     */
    public void saveNewUser(User user, String[] role) {
        //产生微信端使用的userid
        user.setUserid(String.valueOf(DateTime.now().getMillis()));
        user.setPassword(DigestUtils.md5Hex(user.getPassword()+passwordSalt));
        user.setCreatetime(DateTime.now().toString("yyyy-MM-dd HH:mm"));
        user.setState(User.USER_STATE_OK);
        userMapper.save(user);
    }
}
