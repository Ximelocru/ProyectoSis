package uniandes.edu.co.SuperAndesNoSQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.SuperAndesNoSQL.modelo.Proveedor;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.ProveedoresRepository;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> crearBar(@RequestBody Proveedor proveedor) {
        try {
            proveedoresRepository.save(proveedor);
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {;
            return new ResponseEntity<>("Error al crear el proveedor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{nit}/delete")
    public ResponseEntity<String> eliminarProveedor(@PathVariable("nit") int nit) {
        try {
            proveedoresRepository.eliminarProveedorPorNit(nit);
            return new ResponseEntity<>("Proveedor eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el proveedor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
