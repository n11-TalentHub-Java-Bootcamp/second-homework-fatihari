package com.fatihari.homework2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatihari.homework2.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>
{
	UserAccount findByUsername(String username);
	UserAccount findByPhone(String phone);
	UserAccount findByUsernameAndPhone(String username, String phone);
	void deleteByUsernameAndPhone(String username, String phone);
}
