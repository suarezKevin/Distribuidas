package com.projectApi.demo.model.dto;

import com.projectApi.demo.model.Contacto;
import com.projectApi.demo.model.Sucursal;
import lombok.Data;

import javax.persistence.Column;
import java.util.Objects;

@Data

public class ContactoDto {

    private Integer idcontacto;
    private String cedulacontacto;
    private String nombrecontacto;
    private String apellidocontacto;
    private String direccioncontacto;
    private String telefonocontacto;
    private String usuariocontacto;
    private String contraseniacontacto;
    private SucursalDto sucursalperteneceDto;

    public static ContactoDto from(Contacto contacto){
        ContactoDto contactoDto = new ContactoDto();
        contactoDto.setIdcontacto(contacto.getIdcontacto());
        contactoDto.setCedulacontacto(contacto.getCedulacontacto());
        contactoDto.setNombrecontacto(contacto.getNombrecontacto());
        contactoDto.setApellidocontacto(contacto.getApellidocontacto());
        contactoDto.setDireccioncontacto(contacto.getDireccioncontacto());
        contactoDto.setTelefonocontacto(contacto.getTelefonocontacto());
        contactoDto.setUsuariocontacto(contacto.getUsuariocontacto());
        contactoDto.setContraseniacontacto(contacto.getContraseniacontacto());
        contactoDto.setSucursalperteneceDto(SucursalDto.from(contacto.getSucursalpertenece()));
        return contactoDto;
    }

}
