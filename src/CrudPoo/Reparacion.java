package CrudPoo;

public class Reparacion {
    //Clase que representa las reparaciones dejadas en el local.
    private int id;
    private Cliente cliente;
    private String modelo;
    private String descripcionReparacion;
    private String estadoReparacion; //"Recibido,En Taller,Reparado,Sin Solucion, Presupuestado"
    private double costoReparacion;
    private boolean entregado;

    private static int contador = 1;

    public Reparacion(Cliente cliente, String modelo,String descripcion,double costo){
        this.id = contador++;
        this.cliente = cliente;
        this.modelo = modelo;
        this.descripcionReparacion = descripcion;
        this.estadoReparacion = "RECIBIDO";
        this.costoReparacion = costo;
        this.entregado = false;
    }

    public int getId(){
        return id;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcionReparacion() {
        return descripcionReparacion;
    }

    public void setDescripcionReparacion(String descripcionReparacion) {
        this.descripcionReparacion = descripcionReparacion;
    }

    public String getEstadoReparacion() {
        return estadoReparacion;
    }

    public void setEstadoReparacion(String estadoReparacion) {
        this.estadoReparacion = estadoReparacion;
    }

    public double getCostoReparacion() {
        return costoReparacion;
    }

    public void setCostoReparacion(double costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString(){
        String reparacion = "Id: " + id + "\n" + 
                        "Nombre Cliente: " + cliente.getNombre() + "\n" +
                        "Modelo: " + modelo + "\n" + 
                        "Descripcion: " + descripcionReparacion + "\n" +
                        "Estado Reparacion: " + estadoReparacion + "\n" + 
                        "Costo: " + costoReparacion + "\n";   
        return reparacion;

    }
}
