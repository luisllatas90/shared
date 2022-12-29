package com.app.inventario.shared.domain;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class Clave {
    private String clave;
    private static int MAX_LENGTH = 25;

    private Clave(String clave) {
        this.clave = clave;
    }

    public static Result<Clave, Notification> create(String clave) {
        Notification notification = new Notification();
        clave = clave.trim();
        if (clave.equals("")) notification.addError("Clave es requerida", null);
        if (clave.length() > MAX_LENGTH) notification.addError("El tamaño máximo de clave es " + MAX_LENGTH +" caracteres", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new Clave(clave));
    }
   
}
