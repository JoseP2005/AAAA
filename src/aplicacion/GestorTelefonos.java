package aplicacion;

import dominio.Telefono;
import java.util.ArrayList;
import java.util.List;


public class GestorTelefonos {
    private List<Telefono> telefonos;


    public GestorTelefonos() {
        this.telefonos = new ArrayList<>();
    }


    public void agregarTelefono(Telefono telefono) {
        telefonos.add(telefono);
    }


    public void eliminarTelefono(Telefono telefono) {
        telefonos.remove(telefono);
    }


    public void modificarTelefono(int indice, Telefono telefono ) {
        if (indice >= 0 && indice < telefonos.size()) {
            telefonos.set(indice, telefono);
        }
    }


    public List<Telefono> obtenerTelefonos() {
        return new ArrayList<>(telefonos);
    }
}

