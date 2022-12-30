package com.app.inventario.shared.domain;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class CodIngrediente {
    private String codIngrediente;

    private CodIngrediente(String codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public static Result<CodIngrediente, Notification> create(String codIngrediente) {
        Notification notification = new Notification();
        if (codIngrediente.equals("")) notification.addError("Código de ingrediente es requerido", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new CodIngrediente(codIngrediente));
    }
}
