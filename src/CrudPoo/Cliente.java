package CrudPoo;

import java.util.ArrayList;



public abstract class Cliente {
    //Clase abstracta donde represento la base del cliente
    //De esta clase desprenden ClienteFinal y ClienteGremio.
    //Un Cliente Final es quien repara algo slo cuando necesita.
    //Un Cliente Gremio es alguien que tiene negocio y por falta de conocimiento o tiempo nos confia las reparaciones de sus clientes.
    private int id;
    private String nombre;
    private ArrayList<String> contacto; //Datos de contacto (telefono, email, domicilio), puede teneruno o mas.

    private static int contador = 1;

    public Cliente(String nombre, ArrayList<String> contacto){
        this.id = contador++;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public int getId() {
         return id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public ArrayList<String> getContacto(){
        return contacto;
    }

    public void setContacto(ArrayList<String> contacto){
        this.contacto = contacto;
    }

    @Override
    public String toString(){
        String cliente = "Id: " + id + "\n" + 
                        "Nombre: " + nombre + "\n" +
                        "Contacto: " + "\n";
        for (String string : contacto) {
            cliente = cliente + " " + string + "\n";
        }                
        return cliente;
    }
    

}
