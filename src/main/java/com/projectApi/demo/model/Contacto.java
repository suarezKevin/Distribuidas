package com.projectApi.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectApi.demo.model.dto.ContactoDto;
import com.projectApi.demo.model.dto.SucursalDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contacto")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Integer idcontacto;

    @Column(name = "cedula_contacto", nullable = false, unique = true)
    private String cedulacontacto;

    @Column(name = "nombre_contacto", nullable = false)
    private String nombrecontacto;

    @Column(name = "apellido_contacto", nullable = false)
    private String apellidocontacto;

    @Column(name = "direccion_contacto", nullable = false)
    private String direccioncontacto;

    @Column(name = "telefono_contacto", nullable = false)
    private String telefonocontacto;

    @Column(name = "usuario_contacto", nullable = false, unique = true)
    private String usuariocontacto;

    @Column(name = "contrasenia_contacto", nullable = false)
    private String contraseniacontacto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursalpertenece;


    public static Contacto from(ContactoDto contactoDto){
        Contacto contacto = new Contacto();
        contacto.setIdcontacto(contactoDto.getIdcontacto());
        contacto.setCedulacontacto(contactoDto.getCedulacontacto());
        contacto.setNombrecontacto(contactoDto.getNombrecontacto());
        contacto.setApellidocontacto(contactoDto.getApellidocontacto());
        contacto.setDireccioncontacto(contactoDto.getDireccioncontacto());
        contacto.setTelefonocontacto(contactoDto.getTelefonocontacto());
        contacto.setUsuariocontacto(contactoDto.getUsuariocontacto());
        contacto.setContraseniacontacto(contactoDto.getContraseniacontacto());

        if (Objects.nonNull(contactoDto.getSucursalperteneceDto())){
            contacto.setSucursalpertenece(Sucursal.from(contactoDto.getSucursalperteneceDto()));
        }

        return contacto;
    }

}
