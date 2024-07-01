package org.example.gameshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "distribuidoras")
@Getter
@Setter
public class Distribuidoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddistribuidora")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fundacion")
    private Integer fundacion;

    @Column(name = "web")
    private String web;

    @ManyToOne
    @JoinColumn(name = "idsede")
    private Paises paises;
}
