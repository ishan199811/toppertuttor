package com.toppertutors.service;

import com.toppertutors.entity.User;

public interface UserService {

	  void save(User user);

	    User findByEmail(String email);

}
