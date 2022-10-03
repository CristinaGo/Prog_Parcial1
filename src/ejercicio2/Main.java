package ejercicio2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Cristina Gómez Campos
 */

public class Main {

    public static void main(String[] args) {
        crearCarpeta();
        crearFicha();
        crearFicha();
        crearFicha();
        //Poner el nombre de la mascota
        eliminarFicha(" ");
    }

    public static void crearCarpeta(){
        String ruta = "src\\ejercicio2\\Archivador";
        File f = new File(ruta);

        if (f.exists()){
            System.out.println("La carpeta ya existía");
        }else {
            boolean carpetasOK = f.mkdir();
            if (carpetasOK){
                System.out.println("Se ha creado la carpeta");
            }else {
                System.out.println("Ha ocurrido un error al crear la carpeta");
            }
        }
    }

    public static void crearFicha(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre:");
        String nombre = sc.nextLine();
        System.out.print("Mascota:");
        String animal = sc.nextLine();
        System.out.print("Edad:");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Color:");
        String color = sc.nextLine();

        String ruta = "src\\ejercicio2\\Archivador" + "\\" + nombre + ".txt";

        File ficha = new File(ruta);

        try {
            FileWriter fw = new FileWriter(ficha,true);
            fw.write(String.valueOf(LocalDate.now()));
            fw.append("\nNombre: " + nombre);
            fw.append("\nAnimal: " + animal);
            fw.append("\nEdad: " + String.valueOf(edad));
            fw.append("\nColor: " + color);
            fw.close();
            System.out.println("GENERANDO FICHA");
        } catch (IOException e) {
            System.out.println("Se ha producido un error " + e.getMessage());
            //e.printStackTrace();
        }

    }

    public static void eliminarFicha(String mascota){

        String ruta = "src\\ejercicio2\\Archivador" + "\\" + mascota + ".txt";

        File f = new File(ruta);
        if (f.exists()){
            boolean eliminarOK = f.delete();
            if (eliminarOK){
                System.out.println("La ficha de la mascota " + mascota + " ha sido eliminada con éxito");
            } else{
                System.out.println("Ha ocurrio un error al eliminar la ficha");
            }
        }else {
            System.out.println("Esa ficha no existe en el sistema");
        }


    }
}
