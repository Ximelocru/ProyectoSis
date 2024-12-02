package uniandes.edu.co.SuperAndesNoSQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Producto;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.CategoriaRepository;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.ProductoRepository;



@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Crear un nuevo producto
    @PostMapping("/new")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        try {
            if (productoRepository.existsById(producto.getId())) {
                return new ResponseEntity<>("El ID del producto ya existe", HttpStatus.BAD_REQUEST);
            }
            if (productoRepository.buscarPorCodigoBarras(producto.getCodBarras()) != null) {
                return new ResponseEntity<>("El código de barras del producto ya existe", HttpStatus.BAD_REQUEST);
            }
            productoRepository.save(producto);
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}