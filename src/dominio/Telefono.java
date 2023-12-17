package dominio;

public abstract class Telefono{
    private double peso;
    private double pantalla;
    private int bateria;
    private int camara;
    private int memoria;
    private double precio;
    private String marca;
    private String modelo;

    public Telefono(double peso, double pantalla, int bateria, int camara, int memoria, double precio, String marca, String modelo){
        this.peso = peso;
        this.pantalla = pantalla;
        this.bateria = bateria;
        this.camara = camara;
        this.memoria = memoria;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
    }
    public double getPeso(){
        return peso;
    }
    public double getPantalla(){
        return pantalla;
    }
    public int getBateria(){
        return bateria;
    }
    public int getCamara(){
        return camara;
    }
    public int getMemoria(){
        return memoria;
    }
    public double getPrecio(){
        return precio;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    public void setPantalla(double pantalla){
        this.pantalla = pantalla;
    }
    public void setBateria(int bateria){
        this.bateria = bateria;
    }
    public void setCamara(int camara){
        this.camara = camara;
    }
    public void setMemoria(int memoria){
        this.memoria = memoria;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }


    public String toCSV() {
        // Convierte el objeto Carta a una cadena en formato CSV
        return peso + "," + pantalla+ "," + bateria + "," + camara + "," + memoria + "," + precio + "," + marca + "," + modelo;
    }

    public static Telefono fromCSV(String csvLine) {
        String[] values = csvLine.split(",");
        String tipo = values[0];

        switch (tipo) {
            case "Apple":
                return new TelefonoApple(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Double.parseDouble(values[6]), values[7], values[8]);
            case "Huawei":
                return new TelefonoHuawei(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Double.parseDouble(values[6]), values[7], values[8]);
            case "Samsung":
                return new TelefonoSamsung(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Double.parseDouble(values[6]), values[7], values[8]);
            case "Xiaomi":
                return new TelefonoXiaomi(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Double.parseDouble(values[6]), values[7], values[8]);

            default:
                throw new IllegalArgumentException("Tipo de carta desconocido: " + tipo);
        }
    }

}