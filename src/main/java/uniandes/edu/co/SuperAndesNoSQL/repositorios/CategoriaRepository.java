package uniandes.edu.co.SuperAndesNoSQL.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.SuperAndesNoSQL.modelo.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {

    @Query("{ 'nombre': ?0 }")
    Categoria buscarPorNombre(String nombre);

    @Query("{ 'codigo': ?0 }")
    Categoria buscarPorCodigo(Integer codigo);

}
