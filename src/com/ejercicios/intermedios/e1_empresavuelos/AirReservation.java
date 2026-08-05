package com.ejercicios.intermedios.e1_empresavuelos;

import java.util.Scanner;

public class AirReservation {
    private enum Schedules {
        MAÑANA, TARDE, NOCHE
    }

    private String[] destinations;
    private String[] schedules;
    private int[][] seats;

    public static void main(String[] args) {
        AirReservation airReservation = new AirReservation();

        airReservation.loadApplication();
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void initDestinations(Scanner scanner) {
        int destinationCount;

        System.out.println(
                "Por favor ingrese la cantidad de destinos del día de hoy.");
        while (true) {
            if (scanner.hasNextInt()) {
                destinationCount = scanner.nextInt();
                if (destinationCount <= 0) {
                    System.out.println("La cantidad de destino debe ser mayor a 0");
                    continue;
                }
                break;
            } else {
                System.out.println("Valor no valido, por favor ingrese un cantidad de destino correcta");
            }
        }

        destinations = new String[destinationCount];
    }

    private void initSeats(int destinationsCount, int schedulesCount) {
        seats = new int[destinationsCount][schedulesCount];
    }

    private void generateSchedules() {
        Schedules[] schedules = Schedules.values();

        this.schedules = new String[schedules.length];

        for (int i = 0; i < schedules.length; i++) {
            this.schedules[i] = schedules[i].name();
        }
    }

    private void addSeat(int destination, int schedule, Scanner scanner) {
        int seat;
        while (true) {
            if (scanner.hasNextInt()) {
                seat = scanner.nextInt();
                if (seat < 0) {
                    System.out.println("La cantidad de asientos debe ser mayor o igual a 0");
                    continue;
                }
                break;
            }
        }
        seats[destination][schedule] = seat;
    }

    public void loadApplication() {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        generateSchedules();
        initDestinations(scannerInt);
        initSeats(destinations.length, schedules.length);

        for (int i = 0; i < destinations.length; i++) {
            System.out.println("Ingrese el destino nº: " + (i + 1));
            destinations[i] = scannerStr.nextLine();

            for (int j = 0; j < 3; j++) {
                System.out.println("Ingrese la cantidad de asientos en el horario: " + schedules[j]);
                addSeat(i, j, scannerInt);
            }
        }

        clearConsole();
        String closedApplication = "";
        while (!closedApplication.equalsIgnoreCase("Finish")) {

            System.out.println("Bienvenidos a AIR EXPRESS SERVICE. Presione cualquier tecla para continuar.");
            closedApplication = scannerStr.nextLine();

            if (closedApplication.equalsIgnoreCase("Finish")) {
                System.out.println("Gracias por usar nuestro servicio. Hasta pronto");
                break;
            }

            int destination;
            while (true) {
                System.out.println("Por favor seleccione su destino:");

                for (int i = 0; i < destinations.length; i++) {
                    System.out.println((i + 1) + ") " + destinations[i]);
                }

                if (scannerInt.hasNextInt()) {
                    destination = scannerInt.nextInt();
                    if (destination > 0 && destination <= destinations.length) {
                        clearConsole();
                        break;
                    }
                }

                System.out.println("Por favor ingrese un destino valido.");
                clearConsole();
            }

            int schedule;
            while (true) {
                System.out.println("Seleccione el horario de vuelo:");

                for (int i = 0; i < schedules.length; i++) {
                    System.out.println(
                            (i + 1) + ") " + schedules[i]
                                    + (seats[destination - 1][i] > 0
                                            ? " - Asientos disponibles: " + seats[destination - 1][i]
                                            : " - No hay asientos disponibles"));
                }

                if (scannerInt.hasNextInt()) {
                    schedule = scannerInt.nextInt();
                    if (schedule > 0 && schedule <= schedules.length) {
                        if (seats[destination - 1][schedule - 1] == 0) {
                            System.out.println(
                                    "Lo sentimos, no hay asientos disponibles en este horario. Presione cualquier tecla para continuar");
                            scannerStr.nextLine();
                            clearConsole();
                            continue;
                        }
                        clearConsole();
                        break;
                    }
                }
                System.out.println("Por favor ingrese un horario valido.");
                clearConsole();
            }

            int seatsToReserve;
            while (true) {
                System.out.println("Ingrese la cantidad de asientos que desea reservar: ");
                if (scannerInt.hasNextInt()) {
                    seatsToReserve = scannerInt.nextInt();
                    if (seatsToReserve < 0) {
                        System.out.println("La cantidad de asientos a reservar debe ser mayor a 0");
                        continue;
                    }

                    if (seatsToReserve == 0) {
                        System.out
                                .println("No se ha realizado ninguna reserva. Presione cualquier tecla para continuar");
                        scannerStr.nextLine();
                        clearConsole();
                        break;
                    }

                    if (seatsToReserve > seats[destination - 1][schedule - 1]) {
                        System.out.println(
                                "Lo sentimos, no hay suficientes asientos disponibles en este horario. Presione cualquier tecla para continuar");
                        scannerStr.nextLine();
                        clearConsole();
                        continue;
                    }
                    seats[destination - 1][schedule - 1] -= seatsToReserve;
                    System.out.println("Reserva realizada con éxito. Presione cualquier tecla para continuar");
                    scannerStr.nextLine();
                    clearConsole();
                    break;
                }
            }
        }

    }
}
