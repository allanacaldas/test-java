package br.com.blz.testjava.mapper;

import br.com.blz.testjava.data.dto.ProductDTO;
import br.com.blz.testjava.data.dto.ProductOutputDTO;
import br.com.blz.testjava.data.entities.Product;
import br.com.blz.testjava.data.request.ProductRequest;
import br.com.blz.testjava.data.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "inventory.quantity", source = "quantity")
    @Mapping(target = "inventory.warehouses", source = "product.inventory.warehouses")
    @Mapping(target = "isMarketable", source = "isMarketable")
    @Mapping(target = "sku", source = "sku")
    ProductOutputDTO toOutputDTO(Product product, Boolean isMarketable, Integer quantity, Long sku);

    ProductResponse toProductResponse(ProductOutputDTO outputDTO);

    @Mapping(target = "inventory.warehouses", source = "inventory.warehouses")
    ProductDTO toInputDTO(ProductRequest productRequest);

    @Mapping(target = "inventory.warehouses", source = "inventory.warehouses")
    Product toProduct(ProductDTO dto);



}
