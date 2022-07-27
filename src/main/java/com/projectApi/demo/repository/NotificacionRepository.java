package com.projectApi.demo.repository;

import com.projectApi.demo.model.Notificacion;
import com.projectApi.demo.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {

    List<Notificacion> findAllBySucursal(Sucursal sucursal);
}
