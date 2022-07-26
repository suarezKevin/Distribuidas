package com.projectApi.demo.model.exception;

import java.text.MessageFormat;

public class NotificacionNotFoundException extends RuntimeException {

    public NotificacionNotFoundException(final Integer id) {
        super(MessageFormat.format("No se encontro la notificación con el id: {0}", id));
    }
}
