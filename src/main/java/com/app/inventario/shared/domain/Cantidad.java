package com.app.inventario.shared.domain;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class Cantidad {
    private String cantidad;

    private Cantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public static Result<Cantidad, Notification> create(String cantidad) {
        Notification notification = new Notification();
        if (cantidad.equals("")) notification.addError("Cantidad es requerido", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new Cantidad(cantidad));
    }
}
