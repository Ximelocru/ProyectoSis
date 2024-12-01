package uniandes.edu.co.SuperAndesNoSQL.modelo;

import lombok.ToString;

@ToString
public class EspecificacionesEmpacado {
    private Integer volumen;
    private Integer pesoGR;

    public EspecificacionesEmpacado()
    {;}

    public EspecificacionesEmpacado( Integer volumen,Integer peso) {
        this.volumen = volumen;
        this.pesoGR = peso;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public Integer getPeso() {
        return pesoGR;
    }

    public void setPeso(Integer peso) {
        this.pesoGR = peso;
    }
}
