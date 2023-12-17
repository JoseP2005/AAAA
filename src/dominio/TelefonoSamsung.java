package dominio;

import java.io.Serializable;


public class TelefonoSamsung extends Telefono implements Serializable {


    public TelefonoSamsung(double peso, double pantalla, int bateria, int camara, int memoria, double precio, String marca, String modelo) {
        super(peso, pantalla, bateria, camara, memoria, precio, marca, modelo);
    }


    @Override
    public String toCSV() {
        return "Samsung," + super.toCSV();
    }


    @Override
    public String toString() {
        return "Samsung{" +
                "=" + getPeso() +
                ", peso=" + getPantalla() +
                ", pantalla=" + getBateria() +
                ", Bateria=" + getCamara() +
                ", defensa=" + getMemoria() +
                ", regate=" + getPrecio() +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                '}';
    }


    public static Telefono fromCSV(String csvLine) {
        String[] values = csvLine.split(",");
        return new TelefonoApple(
                Double.parseDouble(values[1]),
                Double.parseDouble(values[2]),
                Integer.parseInt(values[3]),
                Integer.parseInt(values[4]),
                Integer.parseInt(values[5]),
                Double.parseDouble(values[6]),
                values[7],
                values[8]
        );
    }
}
