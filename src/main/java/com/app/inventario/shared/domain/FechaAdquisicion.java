package com.app.inventario.shared.domain;

import java.util.Date;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class FechaAdquisicion {
    private String fechaAdquisicion;

    private FechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public static Result<FechaAdquisicion, Notification> create(String fechaAdquisicion) {
        Notification notification = new Notification();
        if (fechaAdquisicion.equals("")) notification.addError("Fecha de adquisición requerida", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new FechaAdquisicion(fechaAdquisicion));
    }
}
