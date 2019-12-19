package com.java.general.ordenacion.metodos;

import java.util.Arrays;

public class Burbuja2 {

	public static void main(String args[]) {
		int[] numeros = new int[] { 4, 55, 1, 0, 9, 23, 1990, 2, 4, 17 };
		System.out.println("Arreglo a ordenar: " + Arrays.toString(numeros));
		int[] numerosDesc = metodoBurbujaDesc(numeros);
		System.out.println("Arreglo ordenado descendente: " + Arrays.toString(numerosDesc));
		int[] numerosAsc = metodoBurbujaAsc(numeros);
		System.out.println("Arreglo ordenado ascendente: " + Arrays.toString(numerosAsc));
	}

	public static int[] metodoBurbujaDesc(int[] num) {
		int i;
		boolean flag = true;
		int temp;

		while (flag) {
			flag = false;
			for (i = 0; i < num.length - 1; i++) {
				if (num[i] < num[i + 1]) {
					temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
					flag = true;
				}
			}
		}
		return num;
	}

	public static int[] metodoBurbujaAsc(int[] num) {
		int i;
		boolean flag = true;
		int temp;

		while (flag) {
			flag = false;
			for (i = 0; i < num.length - 1; i++) {
				if (num[i] > num[i + 1]) {
					temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
					flag = true;
				}
			}
		}
		return num;
	}

}
