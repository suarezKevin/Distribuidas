package com.projectApi.demo.model.dto;

import com.projectApi.demo.model.Notificacion;
import com.projectApi.demo.model.Sucursal;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.Objects;

@Data

public class NotificacionDto {

    private Integer idnotificacion;
    private Date fechanotificacion;
    private SucursalDto sucursalDto;

    public static NotificacionDto from(Notificacion notificacion){
        NotificacionDto notificacionDto = new NotificacionDto();
        notificacionDto.setIdnotificacion(notificacion.getIdnotificacion());
        notificacionDto.setFechanotificacion(notificacion.getFechanotificacion());
        notificacionDto.setSucursalDto(SucursalDto.from(notificacion.getSucursal()));
        //if (Objects.nonNull(notificacion.getSucursal())){

        //}

        return notificacionDto;
    }

}
