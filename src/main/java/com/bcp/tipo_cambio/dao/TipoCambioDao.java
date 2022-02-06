package com.bcp.tipo_cambio.dao;

import com.bcp.tipo_cambio.Entity.EntityTipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioDao extends JpaRepository<EntityTipoCambio, Long> {

        public EntityTipoCambio findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
