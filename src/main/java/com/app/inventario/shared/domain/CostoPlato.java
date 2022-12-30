package com.app.inventario.shared.domain;

import com.app.inventario.shared.application.Notification;
import com.app.inventario.shared.application.Result;

public class CostoPlato {
    private String costoPlato;

    private CostoPlato(String costoPlato) {
        this.costoPlato = costoPlato;
    }

    public static Result<CostoPlato, Notification> create(String costoPlato) {
        Notification notification = new Notification();
        if (costoPlato.equals("")) notification.addError("Costo del plato es requerido", null);
        if (notification.hasErrors()) return Result.failure(notification);
        return Result.success(new CostoPlato(costoPlato));
    }
}
