package com.salazar;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cuenta>cuentas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        System.out.println("********************");
        System.out.println("\tBienvenido");
        System.out.println("********************");
        while (true)
        {
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar informacion de una cuenta");
            System.out.println("5. Mostrar Cuenta");
            System.out.println("6. Salir");
            int opcion = LectorDeDatos.solicitarEntero("Ingrese una opcion: ");

            switch (opcion) {
                case 1:
                    System.out.println("**Creando una cuenta**");
                    Random rand = new Random();
                    int numeroCuenta = rand.nextInt(1000);
                    System.out.println("Su numero de cuenta sera : "+numeroCuenta);
                    System.out.println("Especifique que tipo de cuenta desea crear");
                    System.out.println("\t 1. Cuenta de Ahorro");
                    System.out.println("\t 2. Cuenta a Largo Plazo");
                    int tipocuenta = LectorDeDatos.solicitarEntero("Especifique que tipo de cuenta desea crear");
                    double saldo = LectorDeDatos.solicitarDouble("Ingrese el saldo inicial: ");

                    if (tipocuenta==1) {

                        CuentaAhorro nuevaCuenta = new CuentaAhorro();
                        nuevaCuenta.numCuenta=numeroCuenta;
                        nuevaCuenta.saldo= saldo;
                        cuentas.add(nuevaCuenta);
                        System.out.println("La cuenta ha sido creada");
                    }else if (tipocuenta==2){
                        CuentaLargoPlazo nuevaCuenta= new CuentaLargoPlazo();
                        nuevaCuenta.numCuenta=numeroCuenta;
                        nuevaCuenta.saldo= saldo;
                        cuentas.add(nuevaCuenta);
                        System.out.println("La cuenta ha sido creada");
                    }else{
                        System.out.println("Tipo de cuenta no existe");
                    }
                    break;

                case 2:
                    int s = 0;
                    while (s == 0) {
                        System.out.println("**************");
                        System.out.println("Ingrese su numero de Cuenta :");
                        int indicecuenta = LectorDeDatos.solicitarEntero("Ingrese su numero de Cuenta :");


                        if (cuentas.isEmpty()) {
                            System.out.println("<===El numero de cuenta que ingreso no existe===>");
                        }

                        for (Cuenta c : cuentas) {
                            if (indicecuenta == c.numCuenta) {
                                System.out.println("Ingrese el monto a depositar:");
                                double montoDeposito = LectorDeDatos.solicitarDouble("Ingrese el monto a depositar :");

                                System.out.println("\t El saldo que tenia anteriormente es:" + c.saldo);

                                if (!c.depositar(montoDeposito)) {
                                    System.out.println("--El monto que ingreso sobrepasa los limites de ingreso--");
                                } else {
                                    System.out.println("\t Saldo monto:" + montoDeposito);
                                    System.out.println("\t Saldo actual:" + c.saldo);
                                    System.out.println("\n ---El deposito fue exitoso--- ");
                                }
                            } else {
                                System.out.println("----El numero de cuenta que ingreso no existe----");
                            }
                        }
                        System.out.println("Desea realizar otro deposito: Si(0) // No(-1)");
                        s = lector.nextInt();
                    }
                    break;

                case 3:

                    int h = 0;
                    while (h == 0) {
                        System.out.println("**************");
                        System.out.println("Ingrese su numero de Cuenta:");
                        int indcuenta = LectorDeDatos.solicitarEntero("Ingrese su numero de Cuenta :");

                        if (cuentas.isEmpty()) {
                            System.out.println("El numero de cuenta que ingreso no existe");
                        }

                        for (Cuenta g : cuentas) {
                            if (indcuenta == g.numCuenta) {
                                System.out.println("Ingrese el monto que desea retirar:");
                                double montoRetiro = LectorDeDatos.solicitarDouble("Ingrese el monto que desea retirar :");

                                System.out.println("\t Su saldo anterior es:" + g.saldo);
                                if (!g.retirar(montoRetiro)) {
                                    System.out.println("**No tiene suficientes fondos para realizar esta accion**");
                                }else{
                                    System.out.println("\t Su retiro fue de:" + montoRetiro);
                                    System.out.println("\t Saldo actual:" + g.saldo);
                                    System.out.println("\n ---El retiro fue exitoso--- ");
                                }
                            }else{
                                System.out.println("----El numero de cuenta que ingreso no existe----");
                            }
                        }
                        System.out.println("Desea Realizar otro Retiro: Si(0) // No(-1)");
                        h= lector.nextInt();
                    }
                    break;

                case 4:
                    //Mostrar información de cuenta

                    int d = 0;
                    while (d == 0) {
                        System.out.println("**************");
                        System.out.println("Ingrese su numero de Cuenta:");
                        int icuenta = LectorDeDatos.solicitarEntero("Ingrese su numero de cuenta :");

                        for (Cuenta t : cuentas) {
                            String tipo = "";
                            if (icuenta == t.numCuenta) {
                                if (t instanceof CuentaAhorro)
                                    tipo = "Cuentas de Ahorro";

                                else if (t instanceof CuentaLargoPlazo)
                                    tipo = "Cuenta a Largo Plazo";
                                System.out.println("<===Mostrando Datos de Cuenta===>");
                                System.out.println("\t Numero de Cuenta:" + t.numCuenta);
                                System.out.println("\t Tipo de cuenta:" + tipo);
                                System.out.println("\t Su Saldo Actual es de:" + t.saldo);
                            }else{
                                System.out.println("El numero de cuenta que ingreso no existe");
                            }
                        }
                        System.out.println("Desea Ingresar a otra Cuenta: Si(0)-- No(-1)");
                        d = lector.nextInt();
                    }
                    break;
                case 5:
                    //numero de cuenta - tipo de cuenta
                    if (cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas --");
                    }else{
                        System.out.println("** Mostrando cuentas **");
                    }
                    for(Cuenta c : cuentas){
                        String tipo = "";
                        if(c instanceof CuentaAhorro)
                            tipo = "Cuenta de Ahorro";
                            else if (c instanceof CuentaLargoPlazo)
                                tipo = "Cuenta a Largo Plazo";
                        System.out.println(c.numCuenta+"-"+tipo);
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion ==6)
            {
                break;
            }
        }

    }
}