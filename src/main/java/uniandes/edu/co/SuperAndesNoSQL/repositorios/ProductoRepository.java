package uniandes.edu.co.SuperAndesNoSQL.repositorios;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Categoria;
import uniandes.edu.co.SuperAndesNoSQL.modelo.EspecificacionesEmpacado;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Producto;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {

    // Consulta personalizada: Buscar producto por código de barras
    @Query("{ 'codBarras': ?0 }")
    Producto buscarPorCodBarras(Integer codBarras);

    // Consulta personalizada: Buscar productos por categoría
    @Query("{ 'nombre': ?0 }")
    List<Producto> buscarPorNombre(String nombre);

    //Actualizacion
    @Query("{codBarras:?0 }")
    @Update("{ $set: {nombre:?1, precioUnitarioVenta:?2, presentacion:?3, cantidadPresentacio: ?4, unidadMedia:?5, fechaExpiracion:?6, id_expecificacionesEmpacado:?7, id_categoria:?8 }}")
    void actualizarProducto(Integer codBarras, String nombre, Integer precioUnitarioVenta, String presentacion, Integer cantidadPresentacio, Integer unidadMedia, Date fechaExpiracion, EspecificacionesEmpacado id_expecificacionesEmpacado, Categoria id_categoria);

}