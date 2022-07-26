package com.projectApi.demo.repository;

import com.projectApi.demo.model.Contacto;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    Contacto findByUsuariocontactoAndContraseniacontacto(String usuariocontacto, String contraseniacontacto);

}
