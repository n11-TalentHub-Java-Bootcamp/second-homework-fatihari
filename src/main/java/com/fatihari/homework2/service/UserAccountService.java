package com.fatihari.homework2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatihari.homework2.dao.ProductRepository;
import com.fatihari.homework2.dao.UserAccountRepository;
import com.fatihari.homework2.entity.Product;
import com.fatihari.homework2.entity.UserAccount;

@Service
public class UserAccountService implements IUserAccountService 
{
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	public UserAccountService(UserAccountRepository userAccountRepository) {
		this.userAccountRepository = userAccountRepository;
	}
	
	@Override
	public List<UserAccount> findAll() 
	{
		return this.userAccountRepository.findAll();
	}
	
	@Override
	public UserAccount findById(Long userId) {
		Optional<UserAccount> result = this.userAccountRepository.findById(userId);
		UserAccount userAccount = null;
		
		if(result.isPresent())
			userAccount = result.get();
		else
			throw new RuntimeException("Did not find user id - " + userId);
		return userAccount;
	}

	@Override
	public UserAccount findByUsername(String username) 
	{
		return this.userAccountRepository.findByUsername(username);
	}

	@Override
	public UserAccount findByPhone(String phone) {
		return this.userAccountRepository.findByPhone(phone);
	}
	
	@Override
	public UserAccount saveOrUpdate(UserAccount userAccount) 
	{
		return this.userAccountRepository.save(userAccount);
	}
	
	@Override
	public UserAccount findByUsernameAndPhone(String username, String phone) {
		return this.userAccountRepository.findByUsernameAndPhone(username, phone);
	}
	
	@Transactional
	@Override
	public void deleteByUsernameAndPhone(String username, String phone) 
	{
		this.userAccountRepository.deleteByUsernameAndPhone(username, phone);	
	}


	
}
