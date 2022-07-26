package com.projectApi.demo.controller;

import com.projectApi.demo.model.Notificacion;
import com.projectApi.demo.model.Sucursal;
import com.projectApi.demo.model.dto.NotificacionDto;
import com.projectApi.demo.model.dto.ResponseNotificacionDto;
import com.projectApi.demo.service.NotificacionService;
import com.projectApi.demo.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/notificaciones")
//http://localhost:9090/empresa/notificaciones

public class NotificacionController {

    private final NotificacionService notificacionService;
    private final SucursalService sucursalService;

    @Autowired
    public NotificacionController(NotificacionService notificacionService, SucursalService sucursalService) {
        this.notificacionService = notificacionService;
        this.sucursalService = sucursalService;
    }

    @PostMapping(value = "{idSucursal}")
    public ResponseEntity<ResponseNotificacionDto> addNotificacion(@PathVariable final Integer idSucursal, @RequestBody final NotificacionDto notificacionDto){
        Notificacion notificacion = Notificacion.from(notificacionDto);
        notificacion.setSucursal(sucursalService.getSucursal(idSucursal));
        notificacion = notificacionService.addNotificacion(notificacion);

        sucursalService.addNotificacionToSucursal(idSucursal, notificacion.getIdnotificacion());
        return new ResponseEntity<>(ResponseNotificacionDto.from(notificacion), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseNotificacionDto>> getNotificaciones(){
        List<Notificacion> notificaciones = notificacionService.getNotificaciones();
        List<ResponseNotificacionDto> responseNotificacionDto = notificaciones.stream().map(ResponseNotificacionDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(responseNotificacionDto, HttpStatus.OK);
    }

    @GetMapping(value="{idNotificacion}")
    public ResponseEntity<ResponseNotificacionDto> getNotificacion(@PathVariable final Integer idNotificacion){
        Notificacion notificacion = notificacionService.getNotificacion(idNotificacion);
        return new ResponseEntity<>(ResponseNotificacionDto.from(notificacion), HttpStatus.OK);
    }

    @DeleteMapping(value = "{idNotificacion}")
    public ResponseEntity<ResponseNotificacionDto> deleteNotificacion(@PathVariable final Integer idNotificacion){
        Notificacion notificacion = notificacionService.deleteNotificacion(idNotificacion);
        return new ResponseEntity<>(ResponseNotificacionDto.from(notificacion), HttpStatus.OK);
    }

    @PutMapping(value = "{idNotificacion}")
    public ResponseEntity<ResponseNotificacionDto> updateNotificacion(@PathVariable final Integer idNotificacion, @RequestBody final NotificacionDto notificacionDto){
        Notificacion updateNotificacion = notificacionService.updateNotificacion(idNotificacion, Notificacion.from(notificacionDto));
        return new ResponseEntity<>(ResponseNotificacionDto.from(updateNotificacion), HttpStatus.OK);
    }

}
