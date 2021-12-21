package com.fatihari.homework2.service;

import java.util.List;
import java.util.Optional;

import com.fatihari.homework2.entity.UserAccount;

public interface IUserAccountService 
{
	public List<UserAccount> findAll();
	public UserAccount findById(Long id);
	public UserAccount findByUsername(String username);
	public UserAccount findByPhone(String phone);
	public UserAccount saveOrUpdate(UserAccount userAccount);
	public UserAccount findByUsernameAndPhone(String username, String phone);
	public void deleteByUsernameAndPhone(String username, String phone);
}
