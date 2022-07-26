package com.projectApi.demo.controller;

import com.projectApi.demo.model.Contacto;
import com.projectApi.demo.model.Sucursal;
import com.projectApi.demo.model.dto.ContactoDto;
import com.projectApi.demo.model.dto.ResponseContactoDto;
import com.projectApi.demo.model.dto.SucursalDto;
import com.projectApi.demo.service.ContactoService;
import com.projectApi.demo.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/contactos")
//http://localhost:9090/empresa/contactos

public class ContactoController {

    private final ContactoService contactoService;
    private final SucursalService sucursalService;

    @Autowired
    public ContactoController(ContactoService contactoService, SucursalService sucursalService) {
        this.contactoService = contactoService;
        this.sucursalService = sucursalService;
    }

    @PostMapping(value ="{idSucursal}")
    public ResponseEntity<ResponseContactoDto> addContacto(@PathVariable   final Integer idSucursal, @RequestBody final ContactoDto contactoDto){
        Contacto contacto = Contacto.from(contactoDto);
        contacto.setSucursalpertenece(sucursalService.getSucursal(idSucursal));

        contacto = contactoService.addContacto(contacto);

        sucursalService.addContactoToSucursal(idSucursal, contacto.getIdcontacto());

        return new ResponseEntity<>(ResponseContactoDto.from(contacto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseContactoDto>> getContactos(){
        List<Contacto> contactoList = contactoService.getContactos();
        List<ResponseContactoDto> contactoDtoList = contactoList.stream().map(ResponseContactoDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(contactoDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "{idContacto}")
    public ResponseEntity<ResponseContactoDto> getContacto(@PathVariable final Integer idContacto){
        Contacto contacto = contactoService.getContacto(idContacto);
        return new ResponseEntity<>(ResponseContactoDto.from(contacto), HttpStatus.OK);
    }

    @DeleteMapping(value = "{idContacto}")
    public ResponseEntity<ResponseContactoDto> deleteContacto(@PathVariable final Integer idContacto){
        Contacto contacto = contactoService.deleteContacto(idContacto);
        return new ResponseEntity<>(ResponseContactoDto.from(contacto), HttpStatus.OK);
    }

    @PutMapping(value = "{idContacto}")
    public ResponseEntity<ResponseContactoDto> updateContacto(@PathVariable final Integer idContacto, @RequestBody final ContactoDto contactoDto){
        Contacto updateContacto = contactoService.updateContacto(idContacto, Contacto.from(contactoDto));
        return new ResponseEntity<>(ResponseContactoDto.from(updateContacto), HttpStatus.OK);
    }

    @GetMapping(value="{usuario}/login/{contrasenia}")
    public ResponseEntity<ResponseContactoDto> login (@PathVariable final String usuario, @PathVariable final String contrasenia){
        Contacto contacto = contactoService.loginContacto(usuario, contrasenia);
        return new ResponseEntity<>(ResponseContactoDto.from(contacto), HttpStatus.OK);
    }

}
