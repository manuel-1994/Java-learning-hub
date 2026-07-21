package com.ejercicios.basicos.e2_sueldodeempleados;

import java.util.Scanner;

public class SueldoEmpleados {
    public static void main(String[] args) {
        SueldoEmpleados miObjeto = new SueldoEmpleados();
        int cargoEmpleado = miObjeto.cargarCargo();
        miObjeto.calcularSueldo(cargoEmpleado);
    }

    public int cargarCargo() {
        int cargo;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese el cargo del empleado \n 1. Repositor \n 2. Cajero \n 3. Supervisor");
            if (scanner.hasNextInt()) {
                cargo = scanner.nextInt();
                if (cargo >= 1 && cargo <= 3) {
                    return cargo;
                }
            } else {
                scanner.next();
            }
            System.out.println("El cargo ingresado no es valido. Por favor, ingrese un cargo valido.");
        }
    }

    public void calcularSueldo(int cargoEmpleado) {
        double sueldo = 0;
        switch (cargoEmpleado) {
            case 1:
                sueldo = 15890 + (15890 * 0.10);
                break;
            case 2:
                sueldo = 26630.89;
                break;
            case 3:
                sueldo = 35560.20 - (35560.20 * 0.11);
                break;
        }

        System.out.println("El sueldo correspondiente a su cargo es: $" + sueldo);
    }

}
