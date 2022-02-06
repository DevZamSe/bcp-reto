package com.bcp.tipo_cambio.services;

import com.bcp.tipo_cambio.Entity.EntityTipoCambio;
import com.bcp.tipo_cambio.model.TipoCambioInput;
import com.bcp.tipo_cambio.model.TipoCambioOuput;

import java.util.List;

public interface TipoCambioService {

    public EntityTipoCambio getTipoCambio(Long id);

    public TipoCambioOuput calcularTipoCambio(TipoCambioInput request);

    public List<EntityTipoCambio> getListaTipoCambio();

    public EntityTipoCambio updateTipoCambio(EntityTipoCambio entity);

}
