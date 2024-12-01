package uniandes.edu.co.SuperAndesNoSQL.repositorios;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.SuperAndesNoSQL.modelo.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {

    // Consulta personalizada: Buscar producto por código de barras
    @Query("{ 'codBarras': ?0 }")
    Producto buscarPorCodigoBarras(Integer codBarras);

    // Consulta personalizada: Buscar productos por categoría
    @Query("{ 'nombre': ?0 }")
    List<Producto> buscarPorNombre(String nombre);
    
}