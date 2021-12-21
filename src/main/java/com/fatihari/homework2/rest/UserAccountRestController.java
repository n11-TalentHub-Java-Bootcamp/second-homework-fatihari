package com.fatihari.homework2.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatihari.homework2.entity.UserAccount;
import com.fatihari.homework2.exception.NotFoundException;
import com.fatihari.homework2.service.IUserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountRestController {
	
	@Autowired
	private IUserAccountService iUserAccountService;
		
	//	quick and dirty: inject user service (use constructor injection)
	@Autowired
	public UserAccountRestController(IUserAccountService iUserAccountService)
	{
		this.iUserAccountService = iUserAccountService;
	}
	
	//  pojo to json
	//	expose "api/users/" and return list of users 
	
	@GetMapping("/")
	public List<UserAccount> findAll()
	{
		return iUserAccountService.findAll();
	}
	
	//	add mapping for GET api/users/username/{username}
	@GetMapping("/username/{username}") //username parameter
	public UserAccount getByUsername(@PathVariable String username) 
	{
		UserAccount userAccount = iUserAccountService.findByUsername(username);
		
		if(userAccount == null)
			throw new NotFoundException("username is not found - " + username);
		return userAccount;
	}
	
	//	add mapping for GET api/users/phone/{phone}
	@GetMapping("/phone/{phone}") //phone parameter
	public UserAccount getByPhone(@PathVariable String phone) 
	{
		UserAccount userAccount = iUserAccountService.findByPhone(phone);
		if(userAccount == null)
			throw new NotFoundException("phone is not found - " + phone);
		return userAccount;
	}
	
	//	add mapping for POST "api/users" - add new user
	@PostMapping("/")
	public UserAccount save(@RequestBody UserAccount userAccount) 
	{		
		//	also just in case they pass id in JSON ... set id to 0
		//	this is to force a save of new item, instead of update.
		userAccount.setId(0L);
		iUserAccountService.saveOrUpdate(userAccount);
		return userAccount;
	}

	//	add mapping for DELETE api/users/{username/{phone} - delete user
	@DeleteMapping(path = {"/{username}/{phone}"})
	public String delete(@PathVariable("username") String username, @PathVariable("phone") String phone) 
	{
		UserAccount userAccount = iUserAccountService.findByUsernameAndPhone(username, phone);
		if(userAccount == null) //throw exception if null
		{
			throw new NotFoundException("Username " + username +  " and phone number " + phone + " do not match. ");
		}
		iUserAccountService.deleteByUsernameAndPhone(username, phone);
		
		return "User with username '" + username + "' and phone number '" + phone + "' has been deleted.";
	}

	//	add mapping for PUT api/users/{username/{phone} - update the user
	@PutMapping("/")
	public UserAccount updateProduct(@RequestBody UserAccount userAccount) 
	{		
		//	also just in case they pass id in JSON ... set id to 0
		//	this is to force a save of new item, instead of update.
		iUserAccountService.saveOrUpdate(userAccount);
		return userAccount;
	}

}
