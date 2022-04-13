package proyecto.entornos;

import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * 
 * @author grupoEntornos
 */
public class ProyectoEntornos {

    static Scanner sc = new Scanner(System.in);
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        boolean continua;
        String anio = "años completos";
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int actualA, actualM, actualD, nacA, nacM=0, nacD=0, edad;
        actualA = LocalDate.now().getYear();
        actualM = LocalDate.now().getMonthValue();
        actualD = LocalDate.now().getDayOfMonth();
        
        JOptionPane.showMessageDialog(null,"Bienvenido");
        do {
            
            try{
                nacA = ingresarAnio();

                if (nacA > actualA) {
                    JOptionPane.showMessageDialog(null,"El año de nacimiento no puede ser posterior a la fecha de hoy.");
                }
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Debes introducir sólo números enteros");
                System.out.println("Excepción en el año: " + nfe);
                nacA=actualA+1;
            }
            
        } while (nacA > actualA);

        do {
            continua = false;
            try{
                nacM = ingresarMes();

                if (nacM > 12 || nacM<1) {
                    JOptionPane.showMessageDialog(null,"El mes debe ser un número entre 1 y 12.");
                    continua = true;
                } else if (nacA == actualA && nacM > actualM) {

                    JOptionPane.showMessageDialog(null,"El mes no puede ser posterior al actual estando "
                            + "en el mismo año.");
                    continua = true;
                }
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Debes introducir sólo números enteros");
                System.out.println("Excepción en el mes: " + nfe);
                continua = true;
            }

        } while (continua);

        if (nacA % 4 == 0) {
            dias[1]++;
        }

        do {
            continua = false;
            try{
            nacD = ingresarDia();

            if (nacD > dias[nacM - 1] || nacD<1) {
                JOptionPane.showMessageDialog(null,"No existe ese día en " + meses[nacM - 1]);
                continua = true;
            } else if (nacA == actualA && nacM == actualM && nacD > actualD) {

                JOptionPane.showMessageDialog(null,"El día no puede ser posterior al actual estando "
                        + "en el mismo mes y año.");
                continua = true;
            }
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Debes introducir sólo números enteros");
                System.out.println("Excepción en el día: " + nfe);
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
        
        JOptionPane.showMessageDialog(null, "La edad es " + edad + " " + anio + ".");
                
    }
    /**
     * 
     * @return
     * @throws NumberFormatException 
     */
    public static int ingresarAnio() throws NumberFormatException {
        int anio;
        
        anio  = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de nacimiento."));
        //System.out.println("Introduce el año de nacimiento.");
        //anio = sc.nextInt();

        return anio;
    }
    /**
     * 
     * @return 
     */
    public static int ingresarMes() throws NumberFormatException {
        int mes;
        
        mes  = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de nacimiento."));
        /*System.out.println("Introduce el mes de nacimiento.");
        mes = sc.nextInt();*/

        return mes;
    }
    /**
     * 
     * @return el dia como int
     */
    public static int ingresarDia() throws NumberFormatException {
        int dia;
        
        dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el día de nacimiento."));
        /*System.out.println("Introduce el día de nacimiento.");
        dia = sc.nextInt();*/

        return dia;
    }
}
