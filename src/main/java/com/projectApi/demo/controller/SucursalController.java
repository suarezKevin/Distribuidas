package com.projectApi.demo.controller;

import com.projectApi.demo.model.Sucursal;
import com.projectApi.demo.model.dto.SucursalDto;
import com.projectApi.demo.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sucursales")
//http://localhost:9090/empresa/sucursales


public class SucursalController {

    private final SucursalService sucursalService;
    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }


    @PostMapping
    public ResponseEntity<SucursalDto> addSucursal(@RequestBody final SucursalDto sucursalDto){
        Sucursal sucursal = sucursalService.addSucursal(Sucursal.from(sucursalDto));
        return new ResponseEntity<>(SucursalDto.from(sucursal), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SucursalDto>> getSucursales(){
        List<Sucursal> sucursales = sucursalService.getSucursales();
        List<SucursalDto> sucursalesDto = sucursales.stream().map(SucursalDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(sucursalesDto, HttpStatus.OK);
    }

    @GetMapping(value = "{idSucursal}")
    public ResponseEntity<SucursalDto> getSucursal(@PathVariable final Integer idSucursal){
        Sucursal sucursal = sucursalService.getSucursal(idSucursal);
        return new ResponseEntity<>(SucursalDto.from(sucursal), HttpStatus.OK);
    }

    @DeleteMapping(value = "{idSucursal}")
    public ResponseEntity<SucursalDto> deleteSucursal(@PathVariable final Integer idSucursal){
        Sucursal sucursal = sucursalService.deleteSucursal(idSucursal);
        return new ResponseEntity<>(SucursalDto.from(sucursal), HttpStatus.OK);
    }

    @PutMapping(value = "{idSucursal}")
    public ResponseEntity<SucursalDto> updateSucursal(@PathVariable final Integer idSucursal, @RequestBody final SucursalDto sucursalDto){
        Sucursal sucursal = sucursalService.updateSucursal(idSucursal, Sucursal.from(sucursalDto));
        return new ResponseEntity<>(SucursalDto.from(sucursal), HttpStatus.OK);
    }

    @PostMapping(value = "{idSucursal}/notificaciones/{idNotificacion}/add")
    public ResponseEntity<SucursalDto> addNotificacionToSucursal(@PathVariable final Integer idSucursal, @PathVariable final Integer idNotificacion){
        Sucursal sucursal = sucursalService.addNotificacionToSucursal(idSucursal, idNotificacion);
        return new ResponseEntity<>(SucursalDto.from(sucursal), HttpStatus.OK);
    }

    @DeleteMapping(value = "{idSucursal}/notificaciones/{idNotificacion}/remove")
    public ResponseEntity<SucursalDto> removeNotificacionFromSucursal(@PathVariable final Integer idSucursal, @PathVariable final Integer idNotificacion){
        Sucursal sucursal = sucursalService.removeNotificacionFromSucursal(idSucursal, idNotificacion);
        return new ResponseEntity<>(SucursalDto.from(sucursal), HttpStatus.OK);
    }

    @PostMapping(value = "{idSucursal}/contactos/{idContacto}/add")
    public ResponseEntity<SucursalDto> addContactoToSucursal(@PathVariable final Integer idSucursal, @PathVariable final Integer idContacto){
        Sucursal sucursal = sucursalService.addContactoToSucursal(idSucursal, idContacto);
        return new ResponseEntity<>(SucursalDto.from(sucursal), HttpStatus.OK);
    }

    @DeleteMapping(value = "{idSucursal}/contactos/{idContacto}/remove")
    public ResponseEntity<SucursalDto> removeContactoFromSucursal(@PathVariable final Integer idSucursal, @PathVariable final Integer idContacto){
        Sucursal sucursal = sucursalService.removeContactoFromSucursal(idSucursal, idContacto);
        return new ResponseEntity<>(SucursalDto.from(sucursal), HttpStatus.OK);
    }


}
