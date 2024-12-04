package uniandes.edu.co.SuperAndesNoSQL.controller;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Producto;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.ProductoRepository;



@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Crear un nuevo producto
    @PostMapping("/new")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        try {
            if (productoRepository.buscarPorCodBarras(producto.getId())!= null) {
                return new ResponseEntity<>("El ID del producto ya existe", HttpStatus.BAD_REQUEST);
            }
            if (productoRepository.buscarPorCodBarras(producto.getCodBarras()) != null) {
                return new ResponseEntity<>("El código de barras del producto ya existe", HttpStatus.BAD_REQUEST);
            }
            productoRepository.save(producto);
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  

    @GetMapping("/codbarras/{codigoBarras}")
    public ResponseEntity<Producto> obtenerProductoPorCodigoBarras(@PathVariable Integer codigoBarras) {
        try {
            Producto producto = productoRepository.buscarPorCodBarras(codigoBarras);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Collection<Producto>> obtenerProductoPorNombre(@PathVariable String nombre) {
        try {
            List<Producto> producto = productoRepository.buscarPorNombre(nombre);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/{codBarras}/edit/save")
    public ResponseEntity<String> actualizarProducto(@PathVariable("codBarras") Integer codBarras, @RequestBody Producto producto) {
        try {
            productoRepository.actualizarProducto(
                producto.getCodBarras(),
                producto.getNombre(),
                producto.getPrecioUnitarioVenta(),
                producto.getPresentacion(),
                producto.getCantidadPresentacio(),
                producto.getUnidadMedia(),
                producto.getFechaExpiracion(),
                producto.getid_expecificacionesEmpacado(),
                producto.getId_categoria()
            );
            return new ResponseEntity<>("Bar actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el bar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}