package uniandes.edu.co.SuperAndesNoSQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.SuperAndesNoSQL.repositorios.BodegaRepository;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

     @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarProveedor(@PathVariable("id") String id) {
        try {
            bodegaRepository.eliminarBodegaPorId(id);
            return new ResponseEntity<>("Bodega eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la Bodega: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
