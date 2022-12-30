package com.app.inventario.shared.domain;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class NombreIngrediente {
    private String nombreIngrediente;
    private static int MAX_LENGTH = 100;

    private NombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public static Result<NombreIngrediente, Notification> create(String nombreIngrediente) {
        Notification notification = new Notification();
        nombreIngrediente = nombreIngrediente.trim();
        if (nombreIngrediente.equals("")) notification.addError("Nombre de ingrediente es requerido", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new NombreIngrediente(nombreIngrediente));
    }
}
