package com.projectApi.demo.model.dto;

import com.projectApi.demo.model.Contacto;
import lombok.Data;

@Data

public class ResponseContactoDto {

    private Integer idcontacto;
    private String cedulacontacto;
    private String nombrecontacto;
    private String apellidocontacto;
    private String direccioncontacto;
    private String telefonocontacto;
    private String usuariocontacto;
    private String contraseniacontacto;
    private ResponseSucursalDto sucursalperteneceDto;

    public static ResponseContactoDto from(Contacto contacto) {
        ResponseContactoDto contactoDto = new ResponseContactoDto();
        contactoDto.setIdcontacto(contacto.getIdcontacto());
        contactoDto.setCedulacontacto(contacto.getCedulacontacto());
        contactoDto.setNombrecontacto(contacto.getNombrecontacto());
        contactoDto.setApellidocontacto(contacto.getApellidocontacto());
        contactoDto.setDireccioncontacto(contacto.getDireccioncontacto());
        contactoDto.setTelefonocontacto(contacto.getTelefonocontacto());
        contactoDto.setUsuariocontacto(contacto.getUsuariocontacto());
        contactoDto.setContraseniacontacto(contacto.getContraseniacontacto());
        contactoDto.setSucursalperteneceDto(ResponseSucursalDto.from(contacto.getSucursalpertenece()));
        return contactoDto;
    }
}
