package com.thiruacademy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thiruacademy.entity.UserInfo;
import com.thiruacademy.repository.UserInfoRepository;
import com.thiruacademy.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	boolean flag;
	@Override
	public String addUser(UserInfo userInfo) {
		
		List<UserInfo> userList = repository.findAll();
		
		if(null != userList) {
			for(UserInfo user : userList) {
				if(user.getUname().equals(userInfo.getUname()))
					flag = true;
				else
					flag = false;
			}
		}
		
		if(flag) {
			return "User already exists";
		} else {
			userInfo.setPwd(passwordEncoder.encode(userInfo.getPwd()));
			repository.save(userInfo);
			return "User saved";
		}
	}
}
