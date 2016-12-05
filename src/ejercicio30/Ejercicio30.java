
package ejercicio30;

import cstio.*;
import java.awt.Color;
import java.io.*;
import java.text.DecimalFormat;

public class Ejercicio30 {
    boolean bandera = true;
    Temperatura t1 = new Temperatura();
    String r;
    int opc;
    double total;
    Dialog d = new Dialog();
    DecimalFormat formateador = new DecimalFormat("####.####");
   
    public boolean isNum(String cad){
        //Dialog d = new Dialog();
        try{
            Integer.parseInt(cad);
            return true;
        }catch(NumberFormatException nfe){
            System.out.println("Solo se aceptan valores numericos");
            return false;
        }
    }

    public void inicio(){
        //Dialog d = new Dialog();
        d.display("Para un calcular conversiones de grados Farenheit y Celsius\n"
                + "o viceversa");
        //System.out.println("Para un nadaro que ha ganado medallas en 5 competencias");
    }
    
    public void menu(){
        //Pizarra x = new Pizarra();
        //Dialog d = new Dialog();
        //String r;
        int numero;
        
        //x.setVisible(true);
        //while(opc>=3){
            r = d.readString("Que tipo de conversion deseas hacer?\n"
                    + "1)Convertir de F a C\n"
                    + "2)Convertir de C a F\n"
                    + "3)Salir");     
            opc=Character.getNumericValue(r.charAt(0));
        //}
    }
    
    //1. Ingreso de datos
    public void datos(Temperatura t1){
        //Pizarra x = new Pizarra();
        //Dialog d = new Dialog();
        String v;
        float numero;
        //char n;        
        //x.setVisible(true);
        //n = r.charAt(0);
        
        switch(opc){
            case 1:
                do
                    v = d.readString("Ingresa la temperatura en grados Farenheit");
                while(!isNum(v));
                numero=Float.parseFloat(v);
                t1.setFaren(numero);
                break;
            case 2:
                do
                    v = d.readString("Ingresa la temperatura en grados Celsius");
                while(!isNum(v));
                numero=Float.parseFloat(v);
                t1.setCelsius(numero);
                break;
        }
    }
    
    public void operaciones(){   
        switch(opc){
            case 1:
                total=((t1.getFaren()-32)*5)/9;   
                Math.round(total);
                formateador.format(total);
                break;
            case 2:
                total=((t1.getClsius()*9)/5)+32;
                formateador.format(total);
                break;
            case 3:
                bandera=false;
                break;
            default:
                d.display("No elegiste nunguna opcion establecida");
                break;
        }
    }
    
    public void resultados(){
        Pizarra p = new Pizarra();
        p.out("Bienvenidos al programa de conversiones\n");
        p.setVisible(true);
        
        switch(opc){
            case 1:
                p.out("La cantidad de grados Farenheit convertido a Celsius es: "+t1.getFaren()+"\n"
                + "y el resultado de la conversion es: "+formateador.format(total)+"°C");
                p.out("\n");
                p.ofoto("images/termometro.jpg");
                break;
            case 2:
                p.out("La cantidad de grados Celsius convertido a Farenheit es: "+t1.getClsius()+"\n"
                + "y el resultado de la conversion es: "+formateador.format(total)+"°F");
                p.out("\n");
                p.ofoto("images/termometro.jpg");
                break;
             //case 3:
               // p.setVisible(false);
                
                //break;
        }
    }
    
    public static void main(String[] args) {
        Ejercicio30 temp = new Ejercicio30();
        
        temp.inicio();
        temp.menu();
        temp.datos(temp.t1);
        temp.operaciones();
        if(temp.bandera)
            temp.resultados();
        else
            temp.d.display("Gracias por usar nuestro programa, ¡Hasta pronto!");
            
    }
    
}
