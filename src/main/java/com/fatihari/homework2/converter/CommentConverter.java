package com.fatihari.homework2.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.fatihari.homework2.dto.ProductCommentDTO;
import com.fatihari.homework2.entity.ProductComment;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentConverter 
{
	public CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);
	
	@Mapping(source="user_account_id", target = "userAccount.id") // source => ProductCommentDTO, target=> ProductComment
	@Mapping(source="product_id", target = "product.id") // source => ProductCommentDTO, target=> ProductComment
	ProductComment convertFromCommentDtoToComment(ProductCommentDTO productCommentDTO);
	

}
