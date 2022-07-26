package com.projectApi.demo.model.exception;

import java.text.MessageFormat;

public class ContactoNotFoundException extends RuntimeException{

    public ContactoNotFoundException(final Integer idContacto) {
        super(MessageFormat.format("No se encontro el contacto con el id: {0}", idContacto));
    }
}
