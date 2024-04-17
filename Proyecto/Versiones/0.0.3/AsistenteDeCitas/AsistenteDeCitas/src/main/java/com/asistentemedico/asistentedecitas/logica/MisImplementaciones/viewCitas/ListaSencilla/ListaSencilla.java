package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaSencilla;

import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaSencilla.Sencilla.Proceso;

public interface ListaSencilla <T>{
    public void agregar(T elemento);
    public void buscar(Proceso<T> proceso);
    public void limpiar();
}
