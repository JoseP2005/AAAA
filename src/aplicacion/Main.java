package aplicacion;

import presentacion.InterfazUsuario;
import dominio.*;

import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        GestorTelefonos gestorTelefonos = new GestorTelefonos();

        ManejadorCSV manejadorCSV = new ManejadorCSV();

        // Ruta del archivo CSV donde se almacenan las cartas
        String rutaArchivo = "../cartas.csv";
        try {
            // Cargar cartas existentes desde el archivo CSV
            List<Telefono> telefonosCargadas = manejadorCSV.cargarCartasDesdeCSV(rutaArchivo);
            for (Telefono telefono : telefonosCargadas) {
                gestorTelefonos.agregarTelefono(telefono);
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar las cartas desde el archivo CSV.");
        }

        // Creación y visualización de la interfaz de usuario
        InterfazUsuario interfazUsuario = new InterfazUsuario(gestorTelefonos);
        interfazUsuario.mostrarMenu();

        try {
            // Guardar las cartas en el archivo CSV
            manejadorCSV.guardarCartasCSV(gestorTelefonos.obtenerTelefonos(), rutaArchivo);
        } catch (IOException e) {
            System.out.println("No se pudo guardar las cartas en el archivo CSV.");
        }
    }
}
