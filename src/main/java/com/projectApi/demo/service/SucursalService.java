package com.projectApi.demo.service;

import com.projectApi.demo.model.Contacto;
import com.projectApi.demo.model.Notificacion;
import com.projectApi.demo.model.Sucursal;
import com.projectApi.demo.model.exception.NotificacionIsAlreadyAssignedException;
import com.projectApi.demo.model.exception.SucursalNotFoundException;
import com.projectApi.demo.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class SucursalService {

    private final SucursalRepository sucursalRepository;
    private final NotificacionService notificacionService;
    private final ContactoService contactoService;

    @Autowired
    public SucursalService(SucursalRepository sucursalRepository, NotificacionService notificacionService, ContactoService contactoService) {
        this.sucursalRepository = sucursalRepository;
        this.notificacionService = notificacionService;
        this.contactoService = contactoService;
    }

    public Sucursal addSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    public List<Sucursal> getSucursales(){
        return sucursalRepository.findAll();
    }

    public Sucursal getSucursal(Integer id){
        return sucursalRepository.findById(id).orElseThrow(() ->
                new SucursalNotFoundException(id));
    }

    public Sucursal deleteSucursal(Integer idSucursal){
        Sucursal sucursal = getSucursal(idSucursal);
        sucursalRepository.delete(sucursal);
        return  sucursal;
    }

    public Sucursal updateSucursal(Integer idSucursal, Sucursal sucursal){
        Sucursal sucursalToEdit = getSucursal(idSucursal);
        sucursalToEdit.setNombresucursal(sucursal.getNombresucursal());
        sucursalToEdit.setProvinciasucursal(sucursal.getProvinciasucursal());
        sucursalToEdit.setCiudadsucursal(sucursal.getCiudadsucursal());
        sucursalToEdit.setDireccionsucursal(sucursal.getDireccionsucursal());
        sucursalToEdit.setTelefonosucursal(sucursal.getTelefonosucursal());
        sucursalToEdit.setLatitudsucursal(sucursal.getLatitudsucursal());
        sucursalToEdit.setLongitudsucursal(sucursal.getLongitudsucursal());
        //sucursalToEdit.setContactosucursal(sucursal.getContactosucursal());
        return sucursalToEdit;
    }

    public Sucursal addNotificacionToSucursal(Integer idSucursal, Integer idNotificacion){
        Sucursal sucursal = getSucursal(idSucursal);
        Notificacion notificacion = notificacionService.getNotificacion(idNotificacion);

        sucursal.addNotificacion(notificacion);
        return sucursal;
    }

    public Sucursal removeNotificacionFromSucursal(Integer idSucursal, Integer idNotificacion){
        Sucursal sucursal = getSucursal(idSucursal);
        Notificacion notificacion = notificacionService.getNotificacion(idNotificacion);
        sucursal.removeNotificacion(notificacion);
        return sucursal;
    }

    public Sucursal addContactoToSucursal(Integer idSucursal, Integer idContacto){
        Sucursal sucursal = getSucursal(idSucursal);
        Contacto contacto = contactoService.getContacto(idContacto);

        sucursal.addContacto(contacto);
        return sucursal;
    }

    public Sucursal removeContactoFromSucursal(Integer idSucursal, Integer idContacto){
        Sucursal sucursal = getSucursal(idSucursal);
        Contacto contacto = contactoService.getContacto(idContacto);
        sucursal.removeContacto(contacto);
        return sucursal;
    }

}
