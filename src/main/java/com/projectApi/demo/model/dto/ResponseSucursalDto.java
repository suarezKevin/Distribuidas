package com.projectApi.demo.model.dto;

import com.projectApi.demo.model.Sucursal;
import lombok.Data;

@Data

public class ResponseSucursalDto {

    private Integer idsucursal;
    private String nombresucursal;
    private String provinciasucursal;
    private String ciudadsucursal;
    private String direccionsucursal;
    private String telefonosucursal;
    private String latitudsucursal;
    private String longitudsucursal;

    public static ResponseSucursalDto from(Sucursal sucursal){
        ResponseSucursalDto sucursalDto = new ResponseSucursalDto();
        sucursalDto.setIdsucursal(sucursal.getIdsucursal());
        sucursalDto.setNombresucursal(sucursal.getNombresucursal());
        sucursalDto.setProvinciasucursal(sucursal.getProvinciasucursal());
        sucursalDto.setCiudadsucursal(sucursal.getCiudadsucursal());
        sucursalDto.setDireccionsucursal(sucursal.getDireccionsucursal());
        sucursalDto.setTelefonosucursal(sucursal.getTelefonosucursal());
        sucursalDto.setLatitudsucursal(sucursal.getLatitudsucursal());
        sucursalDto.setLongitudsucursal(sucursal.getLongitudsucursal());
        return sucursalDto;
    }

}
