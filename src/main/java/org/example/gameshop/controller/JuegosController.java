package org.example.gameshop.controller;

import org.example.gameshop.entity.Juegos;
import org.example.gameshop.repository.JuegosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")

public class JuegosController {

    final JuegosRepository juegosRepository;
    public JuegosController(JuegosRepository juegosRepository) {
        this.juegosRepository = juegosRepository;
    }

    //Listar juegos
    @GetMapping("/list")
    public List<Juegos> listarJuegos(){
        return juegosRepository.findAll();
    }


    //Crear o actualizar producto
    @PostMapping("/save")
    public ResponseEntity<?> savejuegos(@RequestBody Juegos juegos) {
        try {
            // Verificar si el juego tiene un ID para determinar si es una inserción o actualización
            if (juegos.getId() == null) {
                // Es un juego nuevo
                Juegos nuevoJuego = juegosRepository.save(juegos);
                return new ResponseEntity<>(nuevoJuego, HttpStatus.OK);
            } else {
                // El id existe, entonces se debe actualizar el juego
                Juegos juegoExistente = juegosRepository.findById(juegos.getId())
                        .orElseThrow(() -> new RuntimeException("juego no encontrado"));

                juegoExistente.setNombre(juegos.getNombre());
                juegoExistente.setDescripcion(juegos.getDescripcion());
                juegoExistente.setPrecio(juegos.getPrecio());
                juegoExistente.setImagen(juegos.getImagen());

                juegoExistente.setGenero(juegos.getGenero());
                juegoExistente.setPlataforma(juegos.getPlataforma());
                juegoExistente.setEditora(juegos.getEditora());
                juegoExistente.setDistribuidoras(juegos.getDistribuidoras());

                Juegos updatedjuegos = juegosRepository.save(juegoExistente);
                return new ResponseEntity<>(updatedjuegos, HttpStatus.OK);
            }
        } catch (Exception e) {
            return handleValidationException();
        }
    }
    private ResponseEntity<Map<String, String>> handleValidationException() {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Parametros incorrectos");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }



}
