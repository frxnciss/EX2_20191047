package org.example.gameshop.repository;

import org.example.gameshop.entity.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegosRepository extends JpaRepository<Juegos, Integer> {
    @Override
    <SaveJuegos extends Juegos> SaveJuegos save(SaveJuegos juegos);
}
