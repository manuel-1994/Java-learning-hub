package com.ejercicios.basicos.e5_tempciudades;

import java.util.Scanner;

public class TempCity {
    public static void main(String[] args) {
        TempCity tempCity = new TempCity();

        int cityCount = tempCity.getCityCount();
        String[] cityNames = tempCity.saveCityNames(cityCount);
        double[] minTemps = new double[cityCount];
        double[] maxTemps = new double[cityCount];
        tempCity.saveTemps(minTemps, maxTemps);
        tempCity.showCityTemps(cityNames, minTemps, maxTemps);
    }

    private void saveMinTemp(Scanner scanner, double[] minTemps, int index) {
        while (true) {
            System.out.println("Ingrese la temperatura mínima de la ciudad " + (index + 1));
            if (scanner.hasNextDouble()) {
                minTemps[index] = scanner.nextDouble();
                break;
            } else {
                System.out.println("Por favor ingrese un número válido");
                scanner.next();
            }
        }
    }

    private void saveMaxTemp(Scanner scanner, double[] maxTemps, int index) {
        while (true) {
            System.out.println("Ingrese la temperatura máxima de la ciudad " + (index + 1));
            if (scanner.hasNextDouble()) {
                maxTemps[index] = scanner.nextDouble();
                break;
            } else {
                System.out.println("Por favor ingrese un número válido");
                scanner.next();
            }
        }
    }

    private int getIndexTempMax(double[] maxTemps) {
        double tempMax = -9999;
        int index = 0;
        for (int i = 0; i < maxTemps.length; i++) {
            if (maxTemps[i] > tempMax) {
                tempMax = maxTemps[i];
                index = i;
            }
        }
        return index;
    };

    private int getIndexTempMin(double[] minTemps) {
        double tempMin = 9999;
        int index = 0;
        for (int i = 0; i < minTemps.length; i++) {
            if (minTemps[i] < tempMin) {
                tempMin = minTemps[i];
                index = i;
            }
        }
        return index;
    };

    public int getCityCount() {
        Scanner scanner = new Scanner(System.in);
        int cityCount;
        System.out.println("Ingrese la cantidad de ciudades");

        while (true) {
            if (scanner.hasNextInt()) {
                cityCount = scanner.nextInt();
                if (cityCount > 0) {
                    return cityCount;
                } else {
                    System.out.println("Por favor ingrese una cantidad valida mayor a 0");
                }
            } else {
                System.out.println("Por favor ingrese un número válido");
                scanner.next();
            }
        }
    }

    public String[] saveCityNames(int cityCount) {
        Scanner scanner = new Scanner(System.in);
        String[] cityNames = new String[cityCount];

        for (int i = 0; i < cityNames.length; i++) {
            System.out.println("Ingrese el nombre de la ciudad " + (i + 1));
            if (scanner.hasNextLine()) {
                cityNames[i] = scanner.nextLine();
            } else {
                System.out.println("Por favor ingrese un nombre válido");
                scanner.next();
                i--;
            }
        }

        return cityNames;
    }

    public void saveTemps(double[] minTemps, double[] maxTemps) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < maxTemps.length; i++) {
            saveMinTemp(scanner, minTemps, i);
            saveMaxTemp(scanner, maxTemps, i);
        }
    }

    public void showCityTemps(String[] cityNames, double[] minTemps, double[] maxTemps) {
        int indexTempMax = getIndexTempMax(maxTemps);
        int indexTempMin = getIndexTempMin(minTemps);

        System.out.println("La ciudad con la temperatura mas alta en la semana es: " + cityNames[indexTempMax]
                + " con una temperatura de " + maxTemps[indexTempMax] + " grados");
        System.out.println("La ciudad con la temperatura mas baja en la semana es: " + cityNames[indexTempMin]
                + " con una temperatura de " + minTemps[indexTempMin] + " grados");
    }
}
