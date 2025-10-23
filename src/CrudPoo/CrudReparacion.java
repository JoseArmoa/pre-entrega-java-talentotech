package CrudPoo;

import java.util.ArrayList;

public class CrudReparacion extends CrudConsola<Reparacion>{
    private final ArrayList<Reparacion> reparaciones;
    private final ArrayList<Cliente> clientes;

    public CrudReparacion(ArrayList<Reparacion> reparaciones, ArrayList<Cliente> clientes) {
        this.reparaciones = reparaciones;
        this.clientes = clientes;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("\n=== Menú CRUD ===");
        System.out.println("1) Crear");
        System.out.println("2) Listar");
        System.out.println("3) Listar Reparaciones Entregadas");
        System.out.println("4) Actualizar");
        System.out.println("5) Entregar Reparacion");
        System.out.println("6) Eliminar");
        System.out.println("0) Volver/Salir");
        System.out.print("Opción: ");
    }

    @Override
    public void crear() {
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes. Creá una primero.");
                return;
            }
            int idCliente = leerEntero("Ingresa id del cliente: ");
            Cliente seleccionado = null;
            for (Cliente c : clientes) {
                if (c.getId() == idCliente) { seleccionado = c; break; }
            }
            if (seleccionado == null) {
                System.out.println("Cliente inexistente, agregarlo antes de cargar la reparacion.");
            }
            String modelo = leerTexto("Modelo: ");
            String descripcion = leerTexto("Descripcion: ");
            double precio = leerDouble("Precio: ");

            Reparacion reparacion = new Reparacion(seleccionado, modelo, descripcion, precio);
            reparaciones.add(reparacion);
            System.out.println("Reparacion cargada con exito.");

    }

    
    @Override
    public void listar() {
        if (reparaciones.isEmpty()) {
            System.out.println("(sin reparaciones)");
        } else {
            for (Reparacion p : reparaciones) {
                if(!p.isEntregado()){
                System.out.println(p);}
            }
        }
    }

    public void listarEntregados(){
        if (reparaciones.isEmpty()) {
            System.out.println("(sin reparaciones)");
        } else {

            boolean bandera = false;
            for (Reparacion p : reparaciones) {
                if(p.isEntregado()){
                System.out.println(p);
                bandera = true;   
                }
            }

        if(!bandera) System.out.println("No hay reparaciones entregadas.");
        }
    }

    
    @Override
    public void actualizar() {/*Voy usar el metodo para solo actualizar el estado de la reparacion en caso de que halla un
                             cambio en esta y cambios en el precio si hace falta.  */
        int id = leerEntero("Id de reparacion: ");
        for (Reparacion r : reparaciones) {
            if (r.getId() == id) {
                String nuevoEstado = leerTexto("Ingrese Estado de la reparacion: ");
                r.setEstadoReparacion(nuevoEstado);
                
                System.out.println("Desea actualizar el precio? 1:SI / 0:NO");
                int op = leerEntero("opcion: ");
                if(op == 1){
                    double nuevoPrecio = leerDouble("Nuevo precio: ");
                    r.setCostoReparacion(nuevoPrecio);
                }
                
                System.out.println("Actualizado exitosamente");
                return;    
            }
            
            System.out.println("No se encontró la reparacion con id " + id);        
        }  
    }       

    @Override
    public void eliminar() {
        int id = leerEntero("Id de la reparacion a eliminar: ");
        boolean eliminado = reparaciones.removeIf(p -> p.getId() == id);
        System.out.println(eliminado ? "Reparacion eliminado." : "No existía ese id.");
    }
      
    public void entregarReparacion(){
        int id = leerEntero("Id de reparacion: ");
        for (Reparacion r : reparaciones) {
            if (r.getId() == id) {
                r.setEntregado(true);
                r.setEstadoReparacion("ENTREGADO");//Se cambia el estado de la reparacion a ENTREGADO
                
                
                if(r.getCliente() instanceof ClienteGremio){//Si el Cliente es del gremio, se guarda el costo de la reparacion en su cuenta corriente.
                    ClienteGremio c = (ClienteGremio)r.getCliente();

                    System.out.println("El cliente deja dinero? 1:Si / 0:No");
                    int op = leerEntero("opcion: ");
                    double dineroAbonado = 0;
                    if(op == 1){
                        dineroAbonado = leerDouble("Ingrese Monto Abonado: ");
                    }
                    c.setSaldoCuentaCorriente(c.getSaldoCuentaCorriente() + r.getCostoReparacion() - dineroAbonado);

                    clientes.replaceAll(cli -> {
                                        if (cli.getId() == c.getId()) {
                                            // Reemplazamos por el cliente modificado (ya con saldo actualizado)
                                            return cli;
                                        }
                                        return cli; // si no coincide, lo dejamos igual
                                    });
                    System.out.println("Saldo cargado correctamente al cliente con id: " + c.getId());
                    
                }
                System.out.println("Reparacion entregada correctamente:" + id);
                return;
            }
                    
        }
        System.out.println("No se encontró la reparacion con id " + id);
    }
}


