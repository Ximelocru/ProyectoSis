package uniandes.edu.co.SuperAndesNoSQL.controller;

import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import uniandes.edu.co.SuperAndesNoSQL.modelo.InfoExtraOrden;
import uniandes.edu.co.SuperAndesNoSQL.modelo.OrdenCompra;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.SucursalRepository;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SucursalRepository sucursalRepository;

    @PostMapping("/{sucursalId}/ordencompra")
    public ResponseEntity<String> agregarOrdenDeCompra(@PathVariable String sucursalId,@RequestBody Map<String, Object> requestBody) {

    OrdenCompra ordenCompra = objectMapper.convertValue(requestBody.get("ordenCompra"), OrdenCompra.class);

    List<InfoExtraOrden> infoExtraOrden = objectMapper.convertValue(
        requestBody.get("infoExtraOrden"),
        new com.fasterxml.jackson.core.type.TypeReference<List<InfoExtraOrden>>() {}); 
    try{       
        sucursalRepository.agregarOrdenDeCompra(sucursalId, ordenCompra, infoExtraOrden);
        return new ResponseEntity<>("Orden de Compra creada exitosamente", HttpStatus.CREATED);
        }catch (Exception e){

        return new ResponseEntity<>("Error al crear la Orden de Compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
