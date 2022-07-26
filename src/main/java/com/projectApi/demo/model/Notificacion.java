package com.projectApi.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectApi.demo.model.dto.NotificacionDto;
import com.projectApi.demo.model.dto.ResponseSucursalDto;
import com.projectApi.demo.model.dto.SucursalDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "notificacion")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idnotificacion;

    @Column(name = "fecha_noti", nullable = false)
    private Date fechanotificacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursal;

    public static Notificacion from(NotificacionDto notificacionDto){
        Notificacion notificacion = new Notificacion();
        notificacion.setIdnotificacion(notificacionDto.getIdnotificacion());
        notificacion.setFechanotificacion(notificacionDto.getFechanotificacion());
        if (Objects.nonNull(notificacionDto.getSucursalDto())){
            notificacion.setSucursal(Sucursal.from(notificacionDto.getSucursalDto()));
        }
        return notificacion;
    }

    @PrePersist
    public void prePersist(){
        fechanotificacion = new Date();
    }

}
