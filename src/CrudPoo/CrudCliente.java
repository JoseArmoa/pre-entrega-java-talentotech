package CrudPoo;

import java.util.ArrayList;

public class CrudCliente extends CrudConsola<Cliente> {

    private final ArrayList<Cliente> clientes;

    public CrudCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("\n=== Menú CRUD ===");
        System.out.println("1) Crear");
        System.out.println("2) Listar");
        System.out.println("3) Actualizar");
        System.out.println("4) Actualizar Cuenta Corriente");
        System.out.println("5) Eliminar");
        System.out.println("0) Volver/Salir");
        System.out.print("Opción: ");
    }

    @Override
    public void crear() {
        Cliente cliente;
        String nombre = leerTexto("Nombre del cliente: ");
        ArrayList<String> contactos = new ArrayList<String>();
        agregarContacto(contactos);
        System.out.println("El cliente es del gremio??");
        System.out.println("1: Si \n0: No");
        while(true){
            int respuesta = leerEntero("opcion: ");

            if(respuesta == 1){
                cliente = new ClienteGremio(nombre, contactos);
                break;
            }else if(respuesta == 0){
                cliente = new ClienteFinal(nombre, contactos);
                break;
            }else{
                System.out.println("Opcion incorrecta, vuelva  ingresar...");
            }
        }

        clientes.add(cliente);
        System.out.println("Cliente creado con exito.");
    }

    @Override
    public void listar() {
        if (clientes.isEmpty()) {
            System.out.println("(sin clientes)");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void actualizar() {
        int opcion;
        int id = leerEntero("Id del cliente: ");
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                System.out.println("\n=== Seleccione una opcion ===");
                System.out.println("1) Editar cliente");
                System.out.println("2) Agregar contacto");
                System.out.println("0) Cancelar");
                System.out.print("Opción: ");
                opcion = leerEntero("");
                String nuevoNombre = c.getNombre();
                ArrayList<String> contactosNuevos = new ArrayList<>();
                switch (opcion) {
                    case 1:
                        nuevoNombre = leerTexto("Nuevo nombre: ");
                        contactosNuevos = new ArrayList<String>();
                        agregarContacto(contactosNuevos);
                        break;
                    case 2:
                        contactosNuevos = new ArrayList<String>();
                        agregarContacto(c.getContacto());
                    case 0:
                        return;

                    }
                    c.setNombre(nuevoNombre);
                    c.setContacto(contactosNuevos);
                    System.out.println("Cliente Actualizado: " + c);
                    return; 
                }
                 
            }        
            System.out.println("No se encontró cliente con id " + id);
        }
        
    
    public void actualizarCuentaCorriente(){
        
        int id = leerEntero("Id del cliente: ");
        for (Cliente c : clientes) {
            if(c.getId() == id){
                if (c instanceof ClienteGremio) {
                    Double saldo = leerDouble("Ingrese monto abonado: ");
                    ClienteGremio cliente = (ClienteGremio)c;
                   cliente.setSaldoCuentaCorriente(cliente.getSaldoCuentaCorriente() - saldo);

                    clientes.replaceAll(cli -> {
                                        if (cli.getId() == cliente.getId()) {
                                            // Reemplazamos por el cliente modificado (ya con saldo actualizado)
                                            return cli;
                                        }
                                        return cli; // si no coincide, lo dejamos igual
                                    });
                }else{
                System.out.println("El cliente no tiene disponible cuanta corriente");
                return;
                }
            }
                 
        }        
        System.out.println("No se encontró cliente con id " + id);
    }
    
    @Override
    public void eliminar() { 
        int id = leerEntero("Id del ciente a eliminar: ");
        boolean eliminado = clientes.removeIf(c -> c.getId() == id);
        System.out.println(eliminado ? "Cliente eliminado." : "No existía ese id.");
    }
    public void agregarContacto(ArrayList<String> contactos){
        int opcion;
        String contacto = new String();
        while(true){
            System.out.println("\n=== Seleccione una opcion ===");
            System.out.println("1) Agregar Telefono");
            System.out.println("2) Agregar mail");
            System.out.println("3)Agregar Domicilio");
            System.out.println("0) Cancelar");
            System.out.print("Opción: ");
            opcion = leerEntero("");
            switch (opcion) {
                case 1:
                    contacto = "Telefono: " + leerTexto("Ingrese un telefono: ");
                    break;
                case 2:
                    contacto = "Mail: " + leerTexto("Ingrese un mail: ");
                    break;
                case 3:
                    contacto = "Domicilio: " + leerTexto("Ingrese un domicilio: ");
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Opción invalida.");
                    break;
            }

            contactos.add(contacto);
            System.out.println("Desea agregar otro contacto?");
            System.out.println("1: Si \n0: No");
            opcion = leerEntero("");
            if(opcion == 0){ return;}
   
        }
    } 
}

