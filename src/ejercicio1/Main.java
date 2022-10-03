package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Cristina Gómez Campos
 */

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1,"Gregorio Antúnez","Director gerente"));
        empleados.add(new Empleado(2,"Victoria de la Vega","Directora de marketing"));
        empleados.add(new Empleado(3,"Mónica Salazar","Subdirectora de marketing"));
        empleados.add(new Empleado(4,"Mari Carmen Cañizares","Secretaria"));
        empleados.add(new Empleado(5,"Julián Palacios","Responsable de compras"));
        empleados.add(new Empleado(6,"Jesús Quesada","Responsable de ventas"));
        empleados.add(new Empleado(7,"Bernardo Marín","Contabilidad"));
        empleados.add(new Empleado(8,"Nacha Ruiz","Administrativa"));
        empleados.add(new Empleado(9,"Arturo Cañas","Chófer"));


        System.out.println("Lista de empleados");
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()){
            Empleado e = it.next();
            System.out.println(e);
        }

        System.out.println("\nEmpleados ordenados por nombre");
        empleados.stream()
                .sorted((e1,e2)-> e1.getNombre().compareTo(e2.getNombre()))
                .forEach(empleado -> System.out.println(empleado));

        System.out.println("\nEmpleados ordenados por id en orden inverso");
        empleados.stream()
                .sorted((e1,e2)-> e2.getId() - e1.getId())
                .forEach(empleado -> System.out.println(empleado));
    }
}
