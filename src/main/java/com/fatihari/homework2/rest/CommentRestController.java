package com.fatihari.homework2.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatihari.homework2.converter.CommentConverter;
import com.fatihari.homework2.dto.ProductCommentDTO;
import com.fatihari.homework2.entity.Product;
import com.fatihari.homework2.entity.ProductComment;
import com.fatihari.homework2.entity.UserAccount;
import com.fatihari.homework2.exception.NotFoundException;
import com.fatihari.homework2.service.ICommentService;
import com.fatihari.homework2.service.IProductService;
import com.fatihari.homework2.service.IUserAccountService;


@RestController
@RequestMapping("/api/comments")
public class CommentRestController {
	
	@Autowired
	private ICommentService iCommentService;
	@Autowired
	private IUserAccountService iUserAccountService;
	@Autowired
	private IProductService iProductService;
	
	@Autowired
	public CommentRestController(ICommentService iCommentService, 
			IUserAccountService iUserAccountService, IProductService iProductService) 
	{
		this.iCommentService = iCommentService;
		this.iUserAccountService = iUserAccountService;
		this.iProductService = iProductService;
	}
	
	//  pojo to json
	//	expose "api/comments/users/{userId}" and return list of comments 
	@GetMapping("/users/{userId}") //userId parameter
	public List<ProductComment> getAllByUserAccountId(@PathVariable Long userId) 
	{
		List<ProductComment> comments = this.iCommentService.findAllByUserAccountId(userId);
		UserAccount userAccount = this.iUserAccountService.findById(userId);
		if(comments.isEmpty())
			throw new NotFoundException("UserId: " + userId +" - User \'" + userAccount.getUsername() + "\' hasn't written any comments yet.");
		return comments;
	}
	
	//	add mapping for GET api/comments/products/{productsId}
	@GetMapping("/products/{productId}") //productId parameter
	public List<ProductComment> getAllByProductId(@PathVariable Long productId) 
	{
		List<ProductComment> comments = this.iCommentService.findAllByProductId(productId);
		
		Product product = this.iProductService.findById(productId);
		
		if(comments.isEmpty())
			throw new NotFoundException("Product Id: " + productId + " - There are no comments written for the product \'" +
					product.getName() + "\'.");
		
		return comments;
	}
	
	//	add mapping for POST "api/comments/" - add new comment
	@PostMapping("/")
	public ProductComment save(@RequestBody ProductCommentDTO productCommentDTO) 
	{	
		ProductComment comment = CommentConverter.INSTANCE.convertFromCommentDtoToComment(productCommentDTO);
		//	also just in case they pass id in JSON ... set id to 0
		//	this is to force a save of new item, instead of update.
		comment.setId(0L);
		iCommentService.save(comment);
		return comment;
	}
	
	//	add mapping for DELETE api/comments/{commentId} - delete comment
	@DeleteMapping("/{commentId}")
	public String delete(@PathVariable Long commentId) 
	{
		ProductComment comment = iCommentService.findById(commentId);
		
		//throw exception if null
		if(comment == null)
		{
			throw new NotFoundException("Comment id is not found - " + commentId);
		}
		iCommentService.deleteById(commentId);
		return "Delete comment id - " + commentId; 
	}
	
	
	


}
