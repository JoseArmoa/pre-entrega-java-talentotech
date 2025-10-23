package CrudPoo;

import java.util.ArrayList;

// ============================================================================
// Main (orquestador limpio)
// ============================================================================
public class Main {
    public static void main(String[] args) {
        final ArrayList<Cliente> clientes = new ArrayList<>();
        final ArrayList<Reparacion> reparaciones = new ArrayList<>();

        ArrayList<String> contactos = new ArrayList<>();
        contactos.add("Telefono: 1130678745");
        contactos.add("Email: mario@mail.com");
        clientes.add(new ClienteFinal("Mario", contactos));

        contactos = new ArrayList<>();
        contactos.add("Telefono: 1160779755");
        contactos.add("Domicilio: calle falsa 123");
        clientes.add(new ClienteGremio("Maria", contactos));

        reparaciones.add(new Reparacion(clientes.get(0), "j7 prime","pin carga" , 1500));
        reparaciones.add(new Reparacion(clientes.get(1), "samsung a10", "MODULO",40000));
      
        final CrudCliente crudCli= new CrudCliente(clientes);
        final CrudReparacion crudRep = new CrudReparacion(reparaciones,clientes);

        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1) CRUD de Clientes");
            System.out.println("2) CRUD de Reparaciones");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String linea = crudCli.scanner.nextLine();
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    int op;
                    do {
                        crudCli.mostrarOpciones();
                        op = crudCli.leerEntero("");
                        switch (op) {
                            case 1 -> crudCli.crear();
                            case 2 -> crudCli.listar();
                            case 3 -> crudCli.actualizar();
                            case 4 -> crudCli.actualizarCuentaCorriente();
                            case 5 -> crudCli.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 2 -> {
                    int op;
                    do {
                        crudRep.mostrarOpciones();
                        op = crudRep.leerEntero("");
                        switch (op) {
                            case 1 -> crudRep.crear();
                            case 2 -> crudRep.listar();
                            case 3 -> crudRep.listarEntregados();
                            case 4 -> crudRep.actualizar();
                            case 5 -> crudRep.entregarReparacion();
                            case 6 -> crudRep.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}

