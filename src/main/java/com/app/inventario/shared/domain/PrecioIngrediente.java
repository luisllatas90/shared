package com.app.inventario.shared.domain;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class PrecioIngrediente {
    private String precioIngrediente;

    private PrecioIngrediente(String precioIngrediente) {
        this.precioIngrediente = precioIngrediente;
    }

    public static Result<PrecioIngrediente, Notification> create(String precioIngrediente) {
        Notification notification = new Notification();
        if (precioIngrediente.equals("")) notification.addError("Precio del ingrediente es requerido", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new PrecioIngrediente(precioIngrediente));
    }
}
