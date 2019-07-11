package com.salazar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LectorDeDatos {
    public static int solicitarEntero(String mensaje){
        Scanner lector = new Scanner(System.in);
        System.out.print(mensaje);
        try{
            int numero = lector.nextInt();
            return numero;
        }catch (InputMismatchException e){
            System.out.println("El dato ingresado es INVALIDO");
            return solicitarEntero(mensaje);
        }
    }

    public static double solicitarDouble(String mensaje){
        Scanner lector = new Scanner(System.in);
        System.out.print(mensaje);
        try{
            double numero = lector.nextDouble();
            return numero;
        }catch (InputMismatchException e){
            System.out.println("El dato ingresado es INVALIDO");
            return solicitarDouble(mensaje);
        }
    }
}
