package com.projectApi.demo.service;

import com.projectApi.demo.model.Contacto;
import com.projectApi.demo.model.Sucursal;
import com.projectApi.demo.model.exception.ContactoNotFoundException;
import com.projectApi.demo.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional

public class ContactoService {

    private final ContactoRepository contactoRepository;

    @Autowired
    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public Contacto addContacto(Contacto contacto){
        return contactoRepository.save(contacto);
    }

    public List<Contacto> getContactos(){
        return StreamSupport.stream(contactoRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Contacto getContacto(Integer idContacto){
        return contactoRepository.findById(idContacto).orElseThrow(() ->
                new ContactoNotFoundException(idContacto));
    }

    public Contacto deleteContacto(Integer idContacto){
        Contacto contacto = getContacto(idContacto);
        contactoRepository.delete(contacto);
        return contacto;
    }

    public Contacto updateContacto(Integer idContacto, Contacto contacto){
        Contacto contactoToEdit = getContacto(idContacto);
        contactoToEdit.setNombrecontacto(contacto.getNombrecontacto());
        contactoToEdit.setApellidocontacto(contacto.getApellidocontacto());
        contactoToEdit.setDireccioncontacto(contacto.getDireccioncontacto());
        contactoToEdit.setTelefonocontacto(contacto.getTelefonocontacto());
        contactoToEdit.setUsuariocontacto(contacto.getUsuariocontacto());
        contactoToEdit.setContraseniacontacto(contacto.getContraseniacontacto());
        contactoToEdit.setSucursalpertenece(contacto.getSucursalpertenece());
        return contactoToEdit;
    }

    //login
    public Contacto loginContacto(String usuario, String contrasenia){
        Contacto contacto = contactoRepository.findByUsuariocontactoAndContraseniacontacto(usuario, contrasenia);
        return contacto;
    }

    //Obtener todos los contactos por sucursal (enviamos la entidad)
    public List<Contacto> getAllContactosBySucursal(Sucursal sucursal){
        return contactoRepository.findAllBySucursalpertenece(sucursal);
    }

}
