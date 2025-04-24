package com.platzi.market.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="compras_productos")
@Data

public class ComprasProducto {

    @Id
    @Column(name = "id_compra", nullable = false)
    private Integer idCompra;

    @Id
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total", precision = 16, scale = 2)
    private BigDecimal total;

    @Column(name = "estado")
    private Boolean estado;
}
