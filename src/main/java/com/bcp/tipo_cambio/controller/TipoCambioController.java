package com.bcp.tipo_cambio.controller;

import com.bcp.tipo_cambio.Entity.EntityTipoCambio;
import com.bcp.tipo_cambio.model.TipoCambioInput;
import com.bcp.tipo_cambio.model.TipoCambioOuput;
import com.bcp.tipo_cambio.services.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/currency_exchange/currency_exchange_transaction/sd32269")
public class TipoCambioController {

    @Autowired
    TipoCambioService service;

    @GetMapping("/fx_transaction_pricing")
    public List<EntityTipoCambio> obtenerListaTipoCambio(){
        return service.getListaTipoCambio();
    }

    @GetMapping("/fx_transaction_pricing/{id}")
    public EntityTipoCambio obtenerTipoCambio(@PathVariable("id") Long id){
        EntityTipoCambio entidad = service.getTipoCambio(id);
        return entidad;
    }

    @PostMapping("/currency_exchange/update")
    public ResponseEntity<EntityTipoCambio> updateTipoCambio(@Valid @RequestBody EntityTipoCambio entity) {
        EntityTipoCambio updated = service.updateTipoCambio(entity);
        return new ResponseEntity<EntityTipoCambio>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/currency_exchange_sd_operations")
    public TipoCambioOuput calcularTipoCambio(@Valid @RequestBody TipoCambioInput request){
        System.out.println("Request calculo tipo cambio: " + request.getMonto());
        return service.calcularTipoCambio(request);
    }
}
