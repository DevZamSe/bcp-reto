package com.bcp.tipo_cambio.services;

import com.bcp.tipo_cambio.Entity.EntityTipoCambio;
import com.bcp.tipo_cambio.dao.TipoCambioDao;
import com.bcp.tipo_cambio.model.TipoCambioInput;
import com.bcp.tipo_cambio.model.TipoCambioOuput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    private TipoCambioDao dao;

    @Override
    public EntityTipoCambio getTipoCambio(Long id) {

        Optional<EntityTipoCambio> resultado = dao.findById(id);
        return resultado.get();
    }

    @Override
    public TipoCambioOuput calcularTipoCambio(TipoCambioInput request) {

        EntityTipoCambio resultado = dao.findByMonedaOrigenAndMonedaDestino(request.getMonedaOrigen(), request.getMonedaDestino());

        TipoCambioOuput response = new TipoCambioOuput();
        double montoTipocambioReactivo = 0.0;

        // Paso 2: Aplicando Java 8 - filter - Stream
        double tipoCambio = 0.0;
        List<EntityTipoCambio> lst = (List<EntityTipoCambio>) dao.findAll();
        tipoCambio = obtenerTipoCambio(lst, request.getMonedaOrigen(), request.getMonedaDestino());

        montoTipocambioReactivo = request.getMonto()*tipoCambio;

        response.setTipoCambio(resultado.getTipoCambio());
        response.setMonedaDestino(resultado.getMonedaDestino());
        response.setMonedaOrigen(resultado.getMonedaOrigen());
        response.setMontoOriginal(request.getMonto());
        response.setMontoTipoCambio(montoTipocambioReactivo);

        return response;
    }

    @Override
    public List<EntityTipoCambio> getListaTipoCambio() {
        return (List<EntityTipoCambio>)dao.findAll();
    }

    @Override
    public EntityTipoCambio updateTipoCambio(EntityTipoCambio entity) {

        EntityTipoCambio tipoCambio = dao.findByMonedaOrigenAndMonedaDestino(entity.getMonedaOrigen(),entity.getMonedaDestino());

        System.out.println("tipoCambio: " + tipoCambio);

        EntityTipoCambio newEntity = tipoCambio;
        newEntity.setMonedaDestino(entity.getMonedaDestino());
        newEntity.setMonedaOrigen(entity.getMonedaOrigen());
        newEntity.setTipoCambio(entity.getTipoCambio());

        newEntity = dao.save(newEntity);

        return newEntity;
    }

    // Aplicando Java 8 - Filter - Stream
    public double obtenerTipoCambio(List<EntityTipoCambio> lst, String monedaOrigen, String monedaDestino) {
        double tipoCambio;

        System.out.println("Ingresando paso 2 ..... ");
        tipoCambio = lst.stream()
                .filter(x -> x.getMonedaOrigen().equalsIgnoreCase(monedaOrigen) && x.getMonedaDestino().equalsIgnoreCase(monedaDestino))
                .findFirst()
                .map(EntityTipoCambio::getTipoCambio)
                .orElse(0.0);

        return tipoCambio;
    }
}
