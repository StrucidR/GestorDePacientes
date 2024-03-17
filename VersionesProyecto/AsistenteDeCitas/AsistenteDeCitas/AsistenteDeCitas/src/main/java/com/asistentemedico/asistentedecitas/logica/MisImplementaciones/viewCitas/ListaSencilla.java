package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas;

import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Sencilla.Proceso;

public interface ListaSencilla <T>{
    public void agregar(T elemento);
    public void buscar(Proceso<T> proceso);
    public void limpiar();
}
