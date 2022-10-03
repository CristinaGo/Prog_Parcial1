package ejercicio3;

/**
 * @author Cristina Gómez Campos
 */

public class Persona {
    String apellido1;
    String apellido2;
    String ciudad;
    String cp;
    String direccion;
    String DNI;
    String fechaNAC;
    String nombre;
    String telefono;

    public Persona(String apellido1, String apellido2, String ciudad, String cp, String direccion, String DNI, String fechaNAC, String nombre, String telefono) {
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.ciudad = ciudad;
        this.cp = cp;
        this.direccion = direccion;
        this.DNI = DNI;
        this.fechaNAC = fechaNAC;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return  apellido1 + " " + apellido2 + " " + ciudad +  " " + cp + " " + direccion + " " + DNI + " " + fechaNAC + " " + nombre + " " + telefono;
    }
}
