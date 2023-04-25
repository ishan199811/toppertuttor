package com.toppertutors.service;

public interface SecurityService {
	

    void autoLogin(String username, String password);

	boolean isAuthenticated();

	
}
