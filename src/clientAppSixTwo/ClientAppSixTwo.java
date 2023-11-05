package clientAppSixTwo;

import ch.hslu.prg.leds.proxy.LedService;

import java.util.Scanner;

public class ClientAppSixTwo {
    public static void main(String[] args) {
        showSquare();
    }

    public static void showSquare() {
        LedService ledService = new LedService();
        int maxRows = LedService.MAX_ROWS;
        int maxColumns = LedService.MAX_COLUMNS;
        ledService.addLeds(maxRows * maxColumns);
        int topLeft = readTopLeft(maxRows, maxColumns);
        int sideLength = readSideLength(maxRows, maxColumns, topLeft);
        drawSquare(ledService, topLeft, sideLength, maxColumns);
        drawDiagonals(ledService, topLeft, sideLength, maxColumns);
        ledService.stopExecutionFor(5000);
        ledService.reset();
    }

    private static int readTopLeft(int maxRows, int maxColumns) {
        Scanner scanner = new Scanner(System.in);
        int topLeft;

        while (true) {
            System.out.print("Geben Sie die Nummer des LEDs für die linke obere Ecke (topLeft) ein: ");
            topLeft = scanner.nextInt();

            if (topLeft >= 0 && topLeft < maxRows * maxColumns) {
                break;
            } else {
                System.out.println("Ungültige Eingabe. Die Nummer muss innerhalb des Steckboards liegen.");
            }
        }

        return topLeft;
    }

    private static int readSideLength(int maxRows, int maxColumns, int topLeft) {
        Scanner scanner = new Scanner(System.in);
        int sideLength;

        while (true) {
            System.out.print("Geben Sie die Länge der Seite des Quadrats ein: ");
            sideLength = scanner.nextInt();

            if (topLeft % maxColumns + sideLength <= maxColumns && topLeft / maxColumns + sideLength <= maxRows) {
                break;
            } else {
                System.out.println("Ungültige Eingabe. Das Quadrat würde außerhalb des Steckboards liegen.");
            }
        }

        return sideLength;
    }

    private static void drawSquare(LedService ledService, int topLeft, int sideLength, int maxColumns) {
        for (int i = 0; i < sideLength; i++) {
            int row = topLeft / maxColumns + i;
            int column = topLeft % maxColumns;

            for (int j = 0; j < sideLength; j++) {
                int ledNumber = (row + i) * maxColumns + column + j;
                ledService.turnLedOn(ledNumber);
            }
        }
    }

    private static void drawDiagonals(LedService ledService, int topLeft, int sideLength, int maxColumns) {
        for (int i = 0; i < sideLength; i++) {
            int row = topLeft / maxColumns + i;
            int column = topLeft % maxColumns;
            int ledNumber = (row + i) * maxColumns + column + i;
            ledService.turnLedOn(ledNumber);
        }

        for (int i = 0; i < sideLength; i++) {
            int row = topLeft / maxColumns + i;
            int column = topLeft % maxColumns;
            int ledNumber = (row + i) * maxColumns + column + (sideLength - 1 - i);
            ledService.turnLedOn(ledNumber);
        }
    }
}
