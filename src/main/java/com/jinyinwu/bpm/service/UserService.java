package com.jinyinwu.bpm.service;

import com.jinyinwu.bpm.model.User;

public interface UserService {

    public void saveNewUser(User user, String[] role);
}
