package uniandes.edu.co.SuperAndesNoSQL.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Categoria;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
     @Autowired
    private CategoriaRepository categoriaRepository;

    // Crear una nueva categoría
    @PostMapping("/new")
    public ResponseEntity<String> crearCategoria(@RequestBody Categoria categoria) {
        try {
            if (categoriaRepository.buscarPorCodigo(categoria.getCodigo())!= null) {
                return new ResponseEntity<>("El ID de la categoría ya existe", HttpStatus.BAD_REQUEST);
            }
            categoriaRepository.save(categoria);
            return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoría: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/consulta/nombre")
    public ResponseEntity<Categoria> obtenerCategoriaPorNombre(@RequestParam String nombre) {
        try {
            Categoria categoria = categoriaRepository.buscarPorNombre(nombre);
            if (categoria != null) {
                return ResponseEntity.ok(categoria);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/consulta/codigo")
    public ResponseEntity<Categoria> obtenerProductoPorCodigoBarras(@RequestParam Integer codigo) {
        try {
            Categoria categoria= categoriaRepository.buscarPorCodigo(codigo);
            if (categoria != null) {
                return ResponseEntity.ok(categoria);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
