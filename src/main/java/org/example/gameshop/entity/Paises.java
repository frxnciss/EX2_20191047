package org.example.gameshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paises")
@Getter
@Setter
public class Paises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpais")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "iso")
    private String iso;

}
