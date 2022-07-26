package com.projectApi.demo.model.dto;

import com.projectApi.demo.model.Notificacion;
import lombok.Data;

import java.util.Date;

@Data

public class ResponseNotificacionDto {

    private Integer idnotificacion;
    private Date fechanotificacion;
    private ResponseSucursalDto sucursalDto;

    public static ResponseNotificacionDto from(Notificacion notificacion){
        ResponseNotificacionDto notificacionDto = new ResponseNotificacionDto();
        notificacionDto.setIdnotificacion(notificacion.getIdnotificacion());
        notificacionDto.setFechanotificacion(notificacion.getFechanotificacion());
        notificacionDto.setSucursalDto(ResponseSucursalDto.from(notificacion.getSucursal()));
        //if (Objects.nonNull(notificacion.getSucursal())){

        //}

        return notificacionDto;
    }


}
