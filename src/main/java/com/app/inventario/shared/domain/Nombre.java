package com.app.inventario.shared.domain;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class Nombre {
    private String nombre;
    private static int MAX_LENGTH = 50;

    private Nombre(String nombre) {
        this.nombre = nombre;
    }

    public static Result<Nombre, Notification> create(String nombre) {
        Notification notification = new Notification();
        nombre = nombre.trim();
        if (nombre.equals("")) notification.addError("Nombre es requerido", null);
        if (nombre.length() > MAX_LENGTH) notification.addError("El tamaño máximo de usuario es " + MAX_LENGTH +" caracteres", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new Nombre(nombre));
    }
}
