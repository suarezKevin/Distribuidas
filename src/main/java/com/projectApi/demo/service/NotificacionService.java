package com.projectApi.demo.service;

import com.projectApi.demo.model.Notificacion;
import com.projectApi.demo.model.exception.NotificacionNotFoundException;
import com.projectApi.demo.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;
    @Autowired
    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public Notificacion addNotificacion(Notificacion notificacion){
        return notificacionRepository.save(notificacion);
    }

    public List<Notificacion> getNotificaciones(){
        return StreamSupport.stream(notificacionRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Notificacion getNotificacion(Integer idNotificacion){
        return notificacionRepository.findById(idNotificacion).orElseThrow(() ->
                new NotificacionNotFoundException(idNotificacion));
    }

    public Notificacion deleteNotificacion(Integer idNotificacion){
        Notificacion notificacion = getNotificacion(idNotificacion);
        notificacionRepository.delete(notificacion);
        return notificacion;
    }

    public Notificacion updateNotificacion(Integer idNotificacion, Notificacion notificacion){
        Notificacion notificacionToEdit = getNotificacion(idNotificacion);

        return notificacionToEdit;
    }
}
