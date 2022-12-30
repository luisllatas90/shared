package com.app.inventario.shared.domain;

import java.util.Date;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class FechaVencimiento {
    private String fechaVencimiento;

    private FechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public static Result<FechaVencimiento, Notification> create(String fechaVencimiento) {
        Notification notification = new Notification();
        if (fechaVencimiento.equals("")) notification.addError("Fecha de vencimiento requerida", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new FechaVencimiento(fechaVencimiento));
    }
}
