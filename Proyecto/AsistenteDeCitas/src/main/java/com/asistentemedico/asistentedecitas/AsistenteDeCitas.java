package com.asistentemedico.asistentedecitas;

import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AsistenteDeCitas {
    //Tenemos la entrada de nuestro programa en el frame principal 
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //Me adapta la interfaz para que se vea mejor dependiendo del sistema operativo
        // Crea y muestra la ventana principal
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        }); //cambiar su tamanio aparte de la                                            
    } //Configuracion
}
/**
 * En mi proyecto se podra visualizar que respetamos la linea guía, siendo por
 * que mantenemos de esa forma consiste en tener un codigo legible y ordenado
 */