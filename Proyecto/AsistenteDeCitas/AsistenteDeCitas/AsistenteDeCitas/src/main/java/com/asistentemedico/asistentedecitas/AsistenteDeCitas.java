package com.asistentemedico.asistentedecitas;

import com.asistentemedico.asistentedecitas.igu.Principal.Principal;

public class AsistenteDeCitas {
    //Tenemos la entrada de nuestro programa en el frame principal 
    public static void main(String[] args) {
        Principal princ= new Principal();    //De esta forma new Principal princ
        princ.setResizable(false);    //variable y localicacion central
        princ.setVisible(true);            //visibilidad y que no se pueda
        princ.setLocationRelativeTo(null); //cambiar su tamanio aparte de la                                            
    }                                        //Configuracion
}
/**
 * En mi proyecto se podra visualizar que respetamos la linea guía, siendo por
 * que mantenemos de esa forma consiste en tener un codigo legible y ordenado
 */