package com.projectApi.demo.model.dto;

import com.projectApi.demo.model.Notificacion;
import com.projectApi.demo.model.Sucursal;
import lombok.Data;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data

public class SucursalDto {

    private Integer idsucursal;
    private String nombresucursal;
    private String provinciasucursal;
    private String ciudadsucursal;
    private String direccionsucursal;
    private String telefonosucursal;
    private String latitudsucursal;
    private String longitudsucursal;
    private List<NotificacionDto> notificacionListDto = new ArrayList<>();
    private List<ContactoDto> contactosListDto = new ArrayList<>();

    public static SucursalDto from(Sucursal sucursal){
        SucursalDto sucursalDto = new SucursalDto();
        sucursalDto.setIdsucursal(sucursal.getIdsucursal());
        sucursalDto.setNombresucursal(sucursal.getNombresucursal());
        sucursalDto.setProvinciasucursal(sucursal.getProvinciasucursal());
        sucursalDto.setCiudadsucursal(sucursal.getCiudadsucursal());
        sucursalDto.setDireccionsucursal(sucursal.getDireccionsucursal());
        sucursalDto.setTelefonosucursal(sucursal.getTelefonosucursal());
        sucursalDto.setLatitudsucursal(sucursal.getLatitudsucursal());
        sucursalDto.setLongitudsucursal(sucursal.getLongitudsucursal());
        //if (Objects.nonNull(sucursal.getNotificaciones())){
      //      sucursalDto.setNotificacionListDto(sucursal.getNotificaciones().stream().map(NotificacionDto::from).collect(Collectors.toList()));

      //  }
      ///  if (Objects.nonNull(sucursal.getNotificaciones())){
    //             sucursalDto.setContactosListDto(sucursal.getContactosList().stream().map(ContactoDto::from).collect(Collectors.toList()));
     //   }

        return sucursalDto;
    }

}
