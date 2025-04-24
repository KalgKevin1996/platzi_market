package com.platzi.market.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @Column(name = "id", nullable = false, length = 20)
    private String id;

    @Column(name = "nombre", length = 40)
    private String nombre;

    @Column(name = "apellidos", length = 100)
    private String apellidos;

    @Column(name = "celular")
    private Long celular;

    @Column(name = "direccion", length = 80)
    private String direccion;

    @Column(name = "correo_electronico", length = 70)
    private String correoElectronico;



}
