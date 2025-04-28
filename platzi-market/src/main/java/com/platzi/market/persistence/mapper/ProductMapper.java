package com.platzi.market.persistence.mapper;


import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);


    @Mappings({
            @Mapping(source = "productId", target = "idProducto"),
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "categoryId", target = "idCategoria"),
            @Mapping(source = "price", target = "precioVenta"),
            @Mapping(source = "stock", target = "cantidadStock"),
            @Mapping(source = "active", target = "estado"),
            @Mapping(source = "category", target = "categoria"),
            @Mapping(target = "codigoBarras", ignore = true) // No mandas código de barras, así que lo ignoras
    })
    Producto toProducto(Product product);


}
