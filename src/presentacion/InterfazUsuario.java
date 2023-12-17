package presentacion;

import aplicacion.GestorTelefonos;
import dominio.*;
import java.util.List;
import java.util.Scanner;

public class InterfazUsuario {
    private GestorTelefonos gestorTelefonos;
    private Scanner scanner;

    public InterfazUsuario(GestorTelefonos gestorTelefonos) {
        this.gestorTelefonos = gestorTelefonos;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Telefono");
            System.out.println("2. Eliminar Telefono");
            System.out.println("3. Modificar Telefono");
            System.out.println("4. Mostrar Telefonos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarTelefono();
                    break;
                case 2:
                    eliminarTelefono();
                    break;
                case 3:
                    modificarTelefono();
                    break;
                case 4:
                    mostrarTelefonos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void agregarTelefono() {
        System.out.println("Agregar nuevo telefono:");
        System.out.print("Tipo de Telefono (Apple, Huawei, Samsung, Xiaomi: ");
        String tipo = scanner.next();

        System.out.print("Peso: ");
        double peso = scanner.nextDouble();

        System.out.print("Pantalla: ");
        double pantalla = scanner.nextDouble();

        System.out.print("Bateria: ");
        int bateria = scanner.nextInt();

        System.out.print("Camara: ");
        int camara = scanner.nextInt();

        System.out.print("Memoria: ");
        int memoria = scanner.nextInt();

        System.out.print("Precio: ");
        int precio = scanner.nextInt();

        System.out.print("Marca: ");
        String marca = scanner.next();

        System.out.print("Modelo: ");
        String modelo = scanner.next();

        Telefono telefono = null;
        switch (tipo.toLowerCase()) {
            case "apple":
                telefono = new TelefonoApple(peso, pantalla, bateria, camara, memoria, precio, marca, modelo);
                break;
            case "huawei":
                telefono = new TelefonoHuawei(peso, pantalla, bateria, camara, memoria, precio, marca, modelo);
                break;
            case "samsung":
                telefono = new TelefonoSamsung(peso, pantalla, bateria, camara, memoria, precio, marca, modelo);
                break;
            case "xiaomi":
                telefono = new TelefonoXiaomi(peso, pantalla, bateria, camara, memoria, precio, marca, modelo);
                break;
            default:
                System.out.println("Tipo de telefono.");
                return;
        }

        gestorTelefonos.agregarTelefono(telefono);
        System.out.println("Telefono agregado exitosamente.");
    }

    private void eliminarTelefono() {
        System.out.println("Eliminar carta:");
        List<Telefono> cartas = gestorTelefonos.obtenerTelefonos();
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println((i + 1) + ". " + cartas.get(i));
        }

        System.out.print("Seleccione el número de la carta a eliminar: ");
        int indice = scanner.nextInt() - 1;

        if (indice >= 0 && indice < cartas.size()) {
            gestorTelefonos.eliminarTelefono(cartas.get(indice));
            System.out.println("Telefono eliminado exitosamente.");
        } else {
            System.out.println("Indice de carta inválido.");
        }
    }
    private void modificarTelefono() {
        System.out.println("Modificar carta:");
        List<Telefono> telefonos = gestorTelefonos.obtenerTelefonos();
        for (int i = 0; i < telefonos.size(); i++) {
            System.out.println((i + 1) + ". " + telefonos.get(i));
        }

        System.out.print("Seleccione el número de la carta a modificar: ");
        int indice = scanner.nextInt() - 1;

        if (indice >= 0 && indice < telefonos.size()) {
            Telefono telefono = telefonos.get(indice);

            System.out.print("Nuevo Peso (actual " + telefono.getPeso() + "): ");
            telefono.setPeso(scanner.nextDouble());

            System.out.print("Nueva Pantalla (actual " + telefono.getPantalla() + "): ");
            telefono.setPantalla(scanner.nextDouble());

            System.out.print("Nueva Bateria (actual " + telefono.getBateria() + "): ");
            telefono.setBateria(scanner.nextInt());

            System.out.print("Nueva Camara (actual " + telefono.getCamara() + "): ");
            telefono.setCamara(scanner.nextInt());

            System.out.print("Nueva Memoria (actual " + telefono.getMemoria() + "): ");
            telefono.setMemoria(scanner.nextInt());

            System.out.print("Nuevo Precio (actual " + telefono.getPrecio() + "): ");
            telefono.setPrecio(scanner.nextInt());

            System.out.print("Nueva Marca (actual " + telefono.getMarca() + "): ");
            telefono.setMarca(scanner.next());

            System.out.print("Nuevo Modelo (actual " + telefono.getModelo() + "): ");
            telefono.setModelo(scanner.next());

            gestorTelefonos.modificarTelefono(indice,telefono);
            System.out.println("Carta modificada exitosamente.");
        } else {
            System.out.println("Indice de carta inválido.");
        }
    }
    /**
     * Método privado para mostrar las cartas.
     */
    private void mostrarTelefonos() {
        List<Telefono> telefonos = gestorTelefonos.obtenerTelefonos();
        if (telefonos.isEmpty()) {
            System.out.println("No hay cartas disponibles.");
        } else {
            for (int i = 0; i < telefonos.size(); i++) {
                System.out.println((i + 1) + ". " + telefonos.get(i));
            }
        }
    }
}