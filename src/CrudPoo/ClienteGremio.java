package CrudPoo;

import java.util.ArrayList;

public class ClienteGremio extends Cliente {
    //Cliente Gremio agrega un atributo CuentaCorriente, donde se guarda su deuda en reparaciones.
    private double cuentaCorriente;

    public ClienteGremio(String nombre, ArrayList<String> contacto){
        super(nombre,contacto);
        cuentaCorriente = 0;
    };

    public void setSaldoCuentaCorriente(double saldo){
        this.cuentaCorriente = saldo;
    }

    public double getSaldoCuentaCorriente(){
        return cuentaCorriente;
    }

    @Override
    public String toString(){
         return super.toString() + "Cuenta: $" + cuentaCorriente + "\n"; 
    }
}
