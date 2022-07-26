package com.projectApi.demo.model.exception;

import java.text.MessageFormat;

public class SucursalNotFoundException extends RuntimeException {

    public SucursalNotFoundException(final Integer id){
        super(MessageFormat.format("No se encontro la sucursal con el id: {0}", id));
    }
}
