package uniandes.edu.co.SuperAndesNoSQL.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import uniandes.edu.co.SuperAndesNoSQL.modelo.Categoria;
import uniandes.edu.co.SuperAndesNoSQL.modelo.InfoExtraOrden;
import uniandes.edu.co.SuperAndesNoSQL.modelo.OrdenCompra;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Sucursal;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.SucursalRepository;
import uniandes.edu.co.SuperAndesNoSQL.repositorios.SucursalRepositoryCustom;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private SucursalRepositoryCustom sucursalRepositoryCustom;

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

    @GetMapping("/{ordencompraId}")
    public ResponseEntity<?> obtenerOrdenDeCompra(@PathVariable Integer ordencompraId) {

        try{
        Sucursal sucursal = sucursalRepository.findByOrdenCompraId(ordencompraId);

        OrdenCompra ordenCompra = sucursal.getOrdenCompra().stream()
                .filter(oc -> oc.getId().equals(ordencompraId))
                .findFirst()
                .orElse(null);
        
        // Crear una copia de la orden de compra sin recepcionProductos
        Map<String, Object> ordenCompraSinRecepcion = new HashMap<>();
        ordenCompraSinRecepcion.put("id", ordenCompra.getId());
        ordenCompraSinRecepcion.put("fechaCreacion", ordenCompra.getFechaCreacion());
        ordenCompraSinRecepcion.put("estado", ordenCompra.getEstado());
        ordenCompraSinRecepcion.put("fechaEntrega", ordenCompra.getFechaEntrega());
        ordenCompraSinRecepcion.put("productos", ordenCompra.getProducto());

        Map<String, Object> response = new HashMap<>();
        response.put("Detalle", sucursal.getInfoExtraOrden());
        response.put("Encabezado", ordenCompraSinRecepcion);
        response.put("sucursal", sucursal.getId());
        response.put("proveedor", sucursal.getProveedor());

        return ResponseEntity.ok(response);
        }catch(Exception e){

            return new ResponseEntity<>("Error al buscar la Orden de Compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bodegas/{sucursalId}")
    public ResponseEntity<List<Map<String, Object>>> obtenerReporteBodegas(@PathVariable String sucursalId) {
        try {
            List<Map<String, Object>> reporte = sucursalRepositoryCustom.obtenerReporteBodegasPorSucursal(sucursalId);
            return ResponseEntity.ok(reporte);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @PostMapping("/new")
    public ResponseEntity<String> crearSucursal(@RequestBody Sucursal sucursal) {
        try {
            if (sucursalRepository.buscarPorId(sucursal.getId())!= null) {
                return new ResponseEntity<>("El ID de la sucursal ya existe", HttpStatus.BAD_REQUEST);
            }
            sucursalRepository.save(sucursal);
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoría: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
