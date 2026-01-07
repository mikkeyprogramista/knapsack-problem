package pl.gornik;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Podaj liczbę produktów: ");
//        int size = Integer.parseInt(SCANNER.nextLine());
        int size = 4;

        int[] values = { 1, 3, 5, 2 };
        int[] weights = { 1, 2, 3, 3 };

//        fillArrays(values, weights);
        bubbleSort(values, weights);

        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(weights));

        System.out.println("Podaj wagę plecaka: ");
        int weight = Integer.parseInt(SCANNER.nextLine());
        int[] products = new int[size];
        pack(values, weights, weight, products);

        for (int i = 0; i < size; i++) {
            if (products[i] != 0) {
                System.out.printf("w%d : v%d - %d sztuk\n", weights[i], values[i], products[i]);
            }
        }
    }

    private static void fillArrays(int[] values, int[] weights) {
        int maxValue = 30;
        int minValue = 1;
        int maxWeight = 5;
        int minWeight = 1;

        for (int i = 0; i < values.length; i++) {
            values[i] = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        }

        for (int i = 0; i < weights.length; i++) {
            weights[i] = (int) (Math.random() * (maxWeight - minWeight + 1)) + minWeight;
        }
    }

    private static void bubbleSort(int[] values, int[] weights) {
        int tempValue;
        int tempWeight;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1; j++) {
                if ((double) values[j] / weights[j]
                        < (double) values[j + 1] / weights[j + 1]) {
                    tempValue = values[j];
                    tempWeight = weights[j];

                    values[j] = values[j + 1];
                    weights[j] = weights[j + 1];

                    values[j + 1] = tempValue;
                    weights[j + 1] = tempWeight;
                }
            }
        }
    }

    private static int pack(
            int[] values,
            int[] weights,
            int weight,
            int[] products) {
        int value = 0;

        for (int i = 0; i < values.length; i++) {
            products[i] = weight / weights[i];
            value += products[i] * values[i];
            weight -= products[i] * weights[i];
            if (weight == 0) break;
        }

        return value;
    }
}
