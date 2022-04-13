package proyecto.entornos;

import java.time.LocalDate;
import java.util.Scanner;

public class ProyectoEntornos {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continua;
        String anio = "años completos";
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int actualA, actualM, actualD, nacA, nacM, nacD, edad;
        actualA = Integer.parseInt(LocalDate.now().toString().substring(0, 4));
        actualM = Integer.parseInt(LocalDate.now().toString().substring(5, 7));
        actualD = Integer.parseInt(LocalDate.now().toString().substring(8, 10));

        System.out.println("Bienvenido");

        do {
            nacA = ingresarAnio();

            if (nacA > actualA) {
                System.out.println("El año de nacimiento no puede ser posterior a la fecha de hoy.");
            }

        } while (nacA > actualA);

        do {
            continua = false;

            nacM = ingresarMes();

            if (nacM > 12) {
                System.out.println("El mes debe ser un número entre 1 y 12.");
                continua = true;
            } else if (nacA == actualA && nacM > actualM) {

                System.out.println("El mes no puede ser posterior al actual estando "
                        + "en el mismo año.");
                continua = true;
            }

        } while (continua);

        if (nacA % 4 == 0) {
            dias[1]++;
        }

        do {
            continua = false;
            
            nacD = ingresarDia();

            if (nacD > dias[nacM - 1]) {
                System.out.println("No existe ese día en " + meses[nacM - 1]);
                continua = true;
            } else if (nacA == actualA && nacM == actualM && nacD > actualD) {

                System.out.println("El día no puede ser posterior al actual estando "
                        + "en el mismo mes y año.");
                continua = true;
            }

        } while (continua);

        edad = actualA - nacA;

        if (nacM > actualM) {
            edad--;
        }
        if (nacM == actualM) {
            if (nacD > actualD) {
                edad--;
            }
        }

        if (edad == 1) {
            anio = "año completo";
        }

        System.out.println("La edad es " + edad + " " + anio + ".");
    }

    public static int ingresarAnio() {
        int anio;
        System.out.println("Introduce el año de nacimiento.");
        anio = sc.nextInt();

        return anio;
    }
    
    public static int ingresarMes() {
        int mes;
        System.out.println("Introduce el mes de nacimiento.");
        mes = sc.nextInt();

        return mes;
    }
    
    public static int ingresarDia() {
        int dia;
        System.out.println("Introduce el día de nacimiento.");
        dia = sc.nextInt();

        return dia;
    }
}
