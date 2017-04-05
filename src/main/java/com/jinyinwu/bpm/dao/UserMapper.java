package com.jinyinwu.bpm.dao;

import com.jinyinwu.bpm.model.User;

public interface UserMapper {

    void save(User user);
    /**
     * 根据主键查找用户
     * @param userId
     * @return
     */
    User findById(Integer userId);
}
