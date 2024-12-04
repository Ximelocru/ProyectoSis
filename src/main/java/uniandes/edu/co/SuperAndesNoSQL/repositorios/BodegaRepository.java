package uniandes.edu.co.SuperAndesNoSQL.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Bodega;

@Repository
public interface BodegaRepository extends MongoRepository<Bodega, String>{

    @Query(value = "{_id: ?0}", delete = true)
    void eliminarBodegaPorId(String id);

    @Query("{ '_id': ?0 }")
    Bodega buscarPorId(String id);

}
