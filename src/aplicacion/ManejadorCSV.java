package aplicacion;

import dominio.Telefono;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ManejadorCSV {


    public void guardarCartasCSV(List<Telefono> telefonos, String rutaArchivo) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(rutaArchivo))) {
            for (Telefono telefono : telefonos) {
                pw.println(telefono.toCSV());
            }
        }
    }


    public List<Telefono> cargarCartasDesdeCSV(String rutaArchivo) throws IOException {
        List<Telefono> telefonos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                Telefono telefono = Telefono.fromCSV(line);
                telefonos.add(telefono);
            }
        }
        return telefonos;
    }
}
