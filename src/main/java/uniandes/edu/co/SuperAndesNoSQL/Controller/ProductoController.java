package uniandes.edu.co.SuperAndesNoSQL.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Producto;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.ProductoRepository;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.ProductoRepositoryCustom;



@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoRepositoryCustom productoRepositoryCustom;
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
            e.printStackTrace();
            return new ResponseEntity<>("Error al crear el producto: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  

    @GetMapping("/consulta/codBarras")
    public ResponseEntity<Producto> obtenerProductoPorCodigoBarras(@RequestParam Integer codBarras) {
        try {
            Producto producto = productoRepository.buscarPorCodBarras(codBarras);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/consulta/nombre")
    public ResponseEntity<Collection<Producto>> obtenerProductoPorNombre(@RequestParam String nombre) {
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
    @GetMapping("/filtrar")
    public ResponseEntity<List<Producto>> filtrarProductos(
            @RequestParam(required = false) Integer precioMin,
            @RequestParam(required = false) Integer precioMax,
            @RequestParam(required = false) String fechaVencimiento,
            @RequestParam(required = false) Integer categoriaId) {
        try {
            Date fecha = null;
            if (fechaVencimiento != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                fecha = formatter.parse(fechaVencimiento);
            }

            List<Producto> productos = productoRepositoryCustom.buscarPorCaracteristicas(
                    precioMin,
                    precioMax,
                    fecha,
                    categoriaId
            );

            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}