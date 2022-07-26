package com.projectApi.demo.model.exception;

import java.text.MessageFormat;

public class NotificacionIsAlreadyAssignedException extends RuntimeException {

    public NotificacionIsAlreadyAssignedException(final Integer idNotificacion, final Integer idSucursal){
        super(MessageFormat.format("Notificacion: {0} is already assigned to sucursal: {1}", idNotificacion, idSucursal));
    }
}
