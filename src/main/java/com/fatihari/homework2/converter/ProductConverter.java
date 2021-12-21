package com.fatihari.homework2.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatihari.homework2.dto.ProductDTO;
import com.fatihari.homework2.entity.Product;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter 
{
	public ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);
	
	@Mapping(source="category_id", target = "category.id") // source => ProductDTO, target=> Product
	Product convertFromProductDtoToProduct(ProductDTO productDto);

}
