package com.app.inventario.shared.domain;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class NombrePlato {
    private String nombrePlato;
    private static int MAX_LENGTH = 100;

    private NombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public static Result<NombrePlato, Notification> create(String nombrePlato) {
        Notification notification = new Notification();
        nombrePlato = nombrePlato.trim();
        if (nombrePlato.equals("")) notification.addError("Nombre de plato es requerido", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new NombrePlato(nombrePlato));
    }
}
