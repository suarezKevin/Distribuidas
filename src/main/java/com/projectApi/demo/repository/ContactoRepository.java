package com.projectApi.demo.repository;

import com.projectApi.demo.model.Contacto;
import com.projectApi.demo.model.Sucursal;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    Contacto findByUsuariocontactoAndContraseniacontacto(String usuariocontacto, String contraseniacontacto);

    List<Contacto> findAllBySucursalpertenece(Sucursal sucursal);
}
