package com.platzi.market.persistence.mapper;


import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public abstract class PurchaseMapper {

    public abstract Purchase toPurchase(Compra compra);
    public abstract List<Purchase> toPurchases(List<Compra> compras);

    public Compra toCompra(Purchase purchase) {
        Compra compra = internalToCompra(purchase);

        // ⚠️ Aquí va la lógica: evitar setear ID si es 0
        if (purchase.getPurchaseId() != null && purchase.getPurchaseId() != 0) {
            compra.setIdCompra(purchase.getPurchaseId());
        } else {
            compra.setIdCompra(null);
        }

        return compra;
    }

    @InheritInverseConfiguration(name = "toPurchase")
    @Mapping(target = "cliente", ignore = true)
    protected abstract Compra internalToCompra(Purchase purchase);
}

