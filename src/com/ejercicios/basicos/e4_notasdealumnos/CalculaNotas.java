package com.ejercicios.basicos.e4_notasdealumnos;

import java.util.Scanner;

public class CalculaNotas {
    public static void main(String[] args) {
        CalculaNotas calculaNotas = new CalculaNotas();

        int studentCount = calculaNotas.getStudendsCount();
        int gradeCount = calculaNotas.getGradeCount();
        double[][] grades = calculaNotas.loadMatrix(studentCount, gradeCount);
        calculaNotas.showGrades(grades);
    }

    public int getStudendsCount() {
        Scanner scanner = new Scanner(System.in);
        int studensCount;
        System.out.println("Ingrese el numero de alumnos");

        while (true) {
            if (scanner.hasNextInt()) {
                studensCount = scanner.nextInt();
                if (studensCount > 0) {
                    return studensCount;
                } else {
                    System.out.println("Por favor ingrese un numero mayor a 0");
                }
            } else {
                System.out.println("Por favor ingrese un numero valido");
                scanner.next();
            }
        }
    }

    public int getGradeCount() {
        Scanner scanner = new Scanner(System.in);
        int gradeCount;
        System.out.println("Ingrese el numero de notas por alumno");

        while (true) {
            if (scanner.hasNextInt()) {
                gradeCount = scanner.nextInt();
                if (gradeCount > 0) {
                    return gradeCount + 1;
                } else {
                    System.out.println("Por favor ingrese un numero mayor a 0");
                }
            } else {
                System.out.println("Por favor ingrese un numero valido");
                scanner.next();
            }
        }
    }

    public double[][] loadMatrix(int studensCount, int gradeCount) {
        Scanner scanner = new Scanner(System.in);
        double[][] grades = new double[studensCount][gradeCount];

        for (int i = 0; i < grades.length; i++) {
            System.out.println("Notas del alumno Nº " + (i + 1) + ":");

            for (int j = 0; j < grades[i].length - 1; j++) {
                System.out.println("Ingrese la nota " + (j + 1) + ":");

                if (scanner.hasNextDouble()) {
                    grades[i][j] = scanner.nextDouble();
                    if (grades[i][j] < 0 || grades[i][j] > 10) {
                        System.out.println("Por favor ingrese un numero entre 0 y 10");
                        j--;
                    } else {
                        grades[i][grades[i].length - 1] += grades[i][j] / (grades[i].length - 1);
                    }
                } else {
                    System.out.println("Por favor ingrese un numero valido");
                    scanner.next();
                    j--;
                }
            }
        }
        return grades;
    }

    public void showGrades(double[][] grades) {
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Notas del alumno Nº " + (i + 1) + ":");
            for (int j = 0; j < grades[i].length - 1; j++) {
                System.out.println("Nota " + (j + 1) + ": " + grades[i][j]);
            }
            System.out.println("Promedio: " + grades[i][grades[i].length - 1]);
            System.out.println("-----------------------------");
        }
    }
}
