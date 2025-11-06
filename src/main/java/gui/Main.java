/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui;

import Logic.HotelService;
import Model.Pieza;
import Repository.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author johan
 */
public class Main {

    private static final IClienteRepository clienteRepo = new ClienteRepositoryImpl();
    private static final IPiezaRepository piezaRepo = new PiezaRepositoryImpl();
    private static final IReservacionRepository reservacionRepo = new ReservacionRepositoryImpl();
    private static final HotelService hotelService = new HotelService(clienteRepo, piezaRepo, reservacionRepo);
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(true){
            System.out.println("--- SISTEMA DE HOTEL ---");
            System.out.println("1. Acceder como Recepcionista");
            System.out.println("2. Acceder como Administrador");
            System.out.println("0. Salir");
            
            int opcion = leerEntero("Seleccione un rol: ");
            
            switch(opcion){
                case 1: menuRecepcionista(); break;
                case 2: menuAdministrador(); break;
                case 0: System.exit(0);
                default: System.out.println("Opcion no valida");
            }
        }
    }
    
    private static void menuRecepcionista(){
        System.out.println("--- MENU RECEPCIONISTA ---");
        System.out.println("1. colsultar precio total");
        System.out.println("2. reservar pieza");
        System.out.println("3. eliminar reserva");
        System.out.println("4. ver piezas disponibles por tipo");
        System.out.println("5. ver foto de pieza");
        System.out.println("0. volver");
        
        int opcion = leerEntero("Seleccione una opcion: ");
        
        switch (opcion){
            case 1:
                String rut = leerTexto("RUT del cliente: ");
                String tipo = leerTexto("Tipo de pieza (Simple, Doble, Matrimonial)");
                int noches = leerEntero("Numero de noches: ");
                double total = hotelService.consultarPrecioTotal(rut, tipo, noches);
                System.out.println("El precio total es: "+ total);
                break;
            case 2:
                String tipoR = leerTexto("Tipo de pieza (Simple, Doble, Matrimonial): ");
                String rutR = leerTexto("RUT del cliente: ");
                String nombreR = leerTexto("Nombre del cliente: ");
                int diasR = leerEntero("Numero de dias: ");
                if(hotelService.reservarPieza(tipoR, rutR, nombreR, diasR)) {
                    System.out.println("Reserva realizada con exito");
                } else {
                    System.out.println("No hay piezas disponibles");
                }
                break;
            case 3:
                String numPieza = leerTexto("Numero de pieza a liberar");
                if(hotelService.eliminarReservacion(numPieza)){
                    System.out.println("Reserva eliminada y pieza liberada");
                } else {
                    System.out.println("No se encontro una reserva en esta pieza");
                }
                break;
            case 4:
                String tipoD = leerTexto("Tipo de pieza (Simple, Doble, Matrimonial)");
                List<Pieza> disponibles = hotelService.getPiezasDisponibles(tipoD);
                System.out.println("Piezas disponibles" + tipoD + disponibles.size());
                for(Pieza p : disponibles) System.out.println("Pieza numero: " + p.getNumeroPieza());
                break;
            case 5:
                String tipoF = leerTexto("Tipo de pieza (Simple, Doble, Matrimonial)");
                hotelService.dibujarFotoPieza(tipoF);
                break;
            case 0: break;
            default: System.out.println("Opcion no valida");
        }
    }

    private static void menuAdministrador() {
        System.out.println("--- MENU ADMINISTRADOR ---");
        System.out.println("1. cambiar precio de pieza");
        System.out.println("2. cambiar descuento habitual");
        System.out.println("3. calcular ganancias del mes");
        System.out.println("0. volver");
        
        int opcion = leerEntero("Seleccione una opcion");
        
        switch (opcion){
            case 1:
                String tipo = leerTexto("Tipo de pieza (Simple, Doble, Matrimonial)");
                double precio = leerDoble("Nuevo precio base: ");
                hotelService.cambiarPrecioPieza(tipo, precio);
                System.out.println("Precio de "+ tipo +" actualizado a "+ precio);
                break;
            case 2:
                double desc = leerDoble("Nuevo descuento");
                hotelService.cambiarDescuentoHabitua(desc);
                System.out.println("Descuento de clientes habituales actualiazado a: "+ desc * 100);
                break;
            case 3:
                int mes = leerEntero("Numero de mes (Ej. 11 para noviembre)");
                double ganancias = hotelService.calcularGananciasMes(mes);
                System.out.println("Las ganancias totales del mes "+ mes + "son de " + ganancias);
                break;
            case 0: break;
            default: System.out.println("Opcion no valida");
        }
    }

    private static String leerTexto(String mensaje){
        System.out.println(mensaje + " ");
        return sc.nextLine();
    }
    
    private static int leerEntero(String mensaje) {
        try{
            return Integer.parseInt(leerTexto(mensaje));
        } catch (NumberFormatException e) {
            System.out.println("Error: ingresa un numero valido");
            return leerEntero(mensaje);
        }
    }
    
    private static double leerDoble(String mensaje){
        try{
            return Double.parseDouble(leerTexto(mensaje));
        } catch (NumberFormatException e){
            System.out.println("Error: ingrese un numero validp");
            return leerDoble(mensaje);
        }
    }
}
