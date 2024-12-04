package uniandes.edu.co.SuperAndesNoSQL.repositorios;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Producto;

@Repository
public class ProductoRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public ProductoRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Producto> buscarPorCaracteristicas(Integer precioMin, Integer precioMax, Date fechaVencimiento, Integer categoriaId) {
        Query query = new Query();

        if (precioMin != null || precioMax != null) {
            Criteria precioCriteria = Criteria.where("precioUnitarioVenta");
            if (precioMin != null) {
                precioCriteria.gte(precioMin);
            }
            if (precioMax != null) {
                precioCriteria.lte(precioMax);
            }
            query.addCriteria(precioCriteria);
        }

        if (fechaVencimiento != null) {
            query.addCriteria(Criteria.where("fechaExpiracion").gte(fechaVencimiento));
        }

        if (categoriaId != null) {
            query.addCriteria(Criteria.where("id_categoria").is(categoriaId));
        }

        return mongoTemplate.find(query, Producto.class);
    }
}
