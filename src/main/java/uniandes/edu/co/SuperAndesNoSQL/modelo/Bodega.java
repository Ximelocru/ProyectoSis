package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.List;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document(collection="bodegas")
public class Bodega {

    @Id
    private String id;
    private String nombre;
    private Integer tamaniom2;
    private List<InfoExtraBodega> infoExtraBodega;

    public Bodega()
    {;}

    public Bodega(String id, String nombre, Integer tamaniom2,
            List<InfoExtraBodega> infoExtraBodega) {
        this.id = id;
        this.nombre = nombre;
        this.tamaniom2 = tamaniom2;
        this.infoExtraBodega = infoExtraBodega;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getTamaniom2() {
        return tamaniom2;
    }
    public void setTamaniom2(Integer tamaniom2) {
        this.tamaniom2 = tamaniom2;
    }
    public List<InfoExtraBodega> getInfoExtraBodega() {
        return infoExtraBodega;
    }
    public void setInfoExtraBodega(List<InfoExtraBodega> infoExtraBodega) {
        this.infoExtraBodega = infoExtraBodega;
    }

}
