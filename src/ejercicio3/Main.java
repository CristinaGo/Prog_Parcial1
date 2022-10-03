package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Cristina Gómez Campos
 */

public class Main {
    public static void main(String[] args) {


        List<Persona> personas = new ArrayList<>();


        String ruta = "src\\ejercicio3\\personas.csv";
        File f = new File(ruta);

        try {
            Scanner lector = new Scanner(f);
            String linea = null;
            int numLinea = -1;
            while (lector.hasNextLine()){
                linea = lector.nextLine();
                numLinea++;
                String [] campos = linea.split(";");
                if (numLinea > 0){
                    personas.add(new Persona(campos[2],campos[3],campos[5], campos[6],campos[4],campos[0],campos[8],campos[1],campos[7]));

                }
            }

            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo " +e.getMessage());
            //e.printStackTrace();
        }
        System.out.println("Ordenadas por nombre");
        personas.stream()
                .filter(persona -> persona.ciudad.equalsIgnoreCase("Madrid"))
                .sorted((p1,p2)-> p1.nombre.compareTo(p2.nombre))
                .forEach(persona -> System.out.println(persona.cp + "-" + persona.nombre + " " +
                        persona.apellido1 + " " + persona.apellido2));

        System.out.println("\nOrdenadas por código postal");
        personas.stream()
                .filter(persona -> persona.ciudad.equalsIgnoreCase("Madrid"))
                .sorted((p1,p2)-> p1.cp.compareTo(p2.cp))
                .forEach(persona -> System.out.println(persona.cp + "-" + persona.nombre + " " +
                        persona.apellido1 + " " + persona.apellido2));


        Map<String, String> mapaPersonas = new HashMap<>();

        Iterator<Persona> it = personas.iterator();
        while (it.hasNext()){
            Persona p = it.next();
            mapaPersonas.put(p.DNI,p.nombre.concat(" ").concat(p.apellido1).concat(" ").concat(p.apellido2));
        }

        System.out.println("\nMostrar mapa");
        for(String clave: mapaPersonas.keySet()){
            String valor = mapaPersonas.get(clave);
            System.out.println(clave + " " + valor);
        }


    }
}
