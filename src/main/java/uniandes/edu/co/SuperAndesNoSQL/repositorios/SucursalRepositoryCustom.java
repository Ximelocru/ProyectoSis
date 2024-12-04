package uniandes.edu.co.SuperAndesNoSQL.repositorios;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class SucursalRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public SucursalRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Map<String, Object>> obtenerReporteBodegasPorSucursal(String sucursalId) {
        // Construir el pipeline de agregación usando Document
        List<Document> pipeline = Arrays.asList(
            // Match para filtrar la sucursal por ID
            new Document("$match", new Document("_id", sucursalId)),
            
            // Lookup para unir las bodegas asociadas
            new Document("$lookup", new Document("from", "bodegas")
                .append("localField", "Bodega")
                .append("foreignField", "_id")
                .append("as", "bodegas")),
            
            // Unwind para desglosar las bodegas
            new Document("$unwind", "$bodegas"),
            
            // Unwind para desglosar los productos en infoExtraBodega
            new Document("$unwind", "$bodegas.infoExtraBodega"),
            
            // Group para calcular métricas por bodega y producto
            new Document("$group", new Document("_id", new Document("bodegaId", "$bodegas._id")
                .append("productoId", "$bodegas.infoExtraBodega.idProducto"))
                .append("nombreProducto", new Document("$first", "$bodegas.infoExtraBodega.idProducto"))
                .append("cantidadActual", new Document("$sum", "$bodegas.infoExtraBodega.cantidad"))
                .append("costoPromedio", new Document("$avg", "$bodegas.infoExtraBodega.costoUnitarioCompra"))
                .append("cantidadMinima", new Document("$first", "$bodegas.infoExtraBodega.detalleCostoBodega.cantidadExistencias"))),
            
            // Project para estructurar la salida
            new Document("$project", new Document("bodegaId", "$_id.bodegaId")
                .append("producto", "$_id.productoId")
                .append("cantidadActual", "$cantidadActual")
                .append("costoPromedio", "$costoPromedio")
                .append("cantidadMinima", "$cantidadMinima")
                .append("_id", 0))
        );

        // Ejecutar la consulta usando MongoTemplate
        List<Map<String, Object>> resultado = (List<Map<String, Object>>) (List<?>) mongoTemplate.getDb().getCollection("sucursales")
            .aggregate(pipeline, Map.class)
            .into(new java.util.ArrayList<>());

        return resultado;
    }
}


