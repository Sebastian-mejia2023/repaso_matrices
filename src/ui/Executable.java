package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller matrixController;

	public static void main(String[] args) {

		System.out.println("Welcome to the Matrix Calculator");
		Executable matrixManager = new Executable();
		matrixManager.showMenu();

	}

	public Executable() {
		reader = new Scanner(System.in);
		matrixController = new Controller();
	}

	public void showMenu() {

		int option = 0;

		do {

			System.out.println(
					"Please pick an option\n" +
							"(1) Create an empty matrix \n" +
							"(2) Show the contents of all matrixes \n" +
							"(3) Create a Numeric matrix \n" +
							"(4) Create a String matrix \n" +
							"(5) crear una matriz con numeros aleatorios \n " +
							"(6) Llenar la diagonal de una matriz \n " +
							"(0) To leave the application");
			option = reader.nextInt();

			switch (option) {
				case 0:
					System.out.println("Thanks for using our services!");
					break;
				case 1:
					createEmptyMatrix();
					break;
				case 2:
					System.out.println(matrixController.getAllMatrixesInfo());
					break;
				case 3:
					createNumericMatrix();
					break;
				case 4:
					creatStringMatrix();
					break;
				case 5:
					System.out.println("ingresa el numero de filas ");
					int rows = reader.nextInt();
					reader.nextLine();
					System.out.println("ingresa el numero de columnas ");
					int columns = reader.nextInt();
					matrixController.addMatrixwithRandomNumbers(rows, columns);
					System.out.println(matrixController.getAllMatrixesInfo());
					break;
				case 6:
					System.out.println(
							"la matriz debe ser cuadrada, ingresa la cantidad de filas o columnas que esta tendra");
					int size = reader.nextInt();
					reader.nextLine();
					System.out.println("ahora escribe el numero que tendra la diagonal ");
					int numero = reader.nextInt();
					matrixController.addMatrixWithGivenNumber(size, numero);
					System.out.println(matrixController.getAllMatrixesInfo());
				default:
					System.out.println("Error, type a valid option");

			}

		} while (option != 0);

	}

	public void createEmptyMatrix() {

		int type, rows, columns;

		System.out.println("Please select the type of matrix " + " \n (1) Numeric matrix " + " \n (2) String matrix ");
		type = reader.nextInt();

		System.out.println("Please type the number of rows");
		rows = reader.nextInt();

		System.out.println("Please type the number of columns");
		columns = reader.nextInt();

		System.out.println("New matrix:");
		System.out.println(matrixController.createEmptyMatrix(type, rows, columns));
		System.out.println(" deseas llenarla? \n 1. Si \n 2. No");

	}

	public void createNumericMatrix() {

		int rows, columns, number;

		System.out.println("Please type the number of rows");
		rows = reader.nextInt();

		System.out.println("Please type the number of columns");
		columns = reader.nextInt();

		int matrixID = matrixController.addNumericMatrix(rows, columns);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.println("Type the number you want to register in the [" + i + "][" + j + "] position");
				number = reader.nextInt();
				matrixController.modifyCellInNumericMatrix(matrixID, i, j, number);
			}
		}

	}

	// String Matrix ( pending)
	private void creatStringMatrix() {

	}

}
