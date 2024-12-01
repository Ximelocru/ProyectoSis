package uniandes.edu.co.SuperAndesNoSQL.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.ToString;

@ToString
@Document(collection="bodegas")
public class Bodega {

    @Id
    private Integer id;
    private String nombre;
    private Integer tamaniom2;
    private InfoExtraBodega InfoExtraBodega;

    public Bodega()
    {;}

    public Bodega(Integer id, String nombre, Integer tamaniom2,
            InfoExtraBodega infoExtraBodega) {
        this.id = id;
        this.nombre = nombre;
        this.tamaniom2 = tamaniom2;
        InfoExtraBodega = infoExtraBodega;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public InfoExtraBodega getInfoExtraBodega() {
        return InfoExtraBodega;
    }
    public void setInfoExtraBodega(InfoExtraBodega infoExtraBodega) {
        InfoExtraBodega = infoExtraBodega;
    }

}
