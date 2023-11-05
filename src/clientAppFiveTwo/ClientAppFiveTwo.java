package clientAppFiveTwo;

import ch.hslu.prg.leds.proxy.LedColor;
import ch.hslu.prg.leds.proxy.LedService;

import java.util.Random;
import java.util.Scanner;

public class ClientAppFiveTwo {
    public static void main(String[] args) {
        showBorderWithUserColor();
    }

    public static void showBorderWithUserColor() {
        LedService ledService = new LedService();
        int maxRows = LedService.MAX_ROWS;
        int maxColumns = LedService.MAX_COLUMNS;
        LedColor selectedColor = readLedColor();
        ledService.addLeds(maxRows * maxColumns, selectedColor);
        ledService.stopExecutionFor(2000);
        for (int row = 0; row < maxRows; row++) {
            for (int column = 0; column < maxColumns; column++) {
                if (row == 0 || row == maxRows - 1 || column == 0 || column == maxColumns - 1) {
                    int ledNumber = row * maxColumns + column;
                    ledService.turnLedOn(ledNumber);
                }
            }
        }
        ledService.stopExecutionFor(5000);
        for (int row = 0; row < maxRows; row++) {
            for (int column = 0; column < maxColumns; column++) {
                if (row == 0 || row == maxRows - 1 || column == 0 || column == maxColumns - 1) {
                    int ledNumber = row * maxColumns + column;
                    ledService.turnLedOff(ledNumber);
                }
            }
        }
        ledService.stopExecutionFor(2000);
        ledService.reset();
    }

    private static LedColor readLedColor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wählen Sie die gewünschte LED-Farbe:");
        System.out.println("1 - Rot");
        System.out.println("2 - Grün");
        System.out.println("3 - Blau");
        System.out.println("4 - Gelb");
        System.out.println("5 - Zufällig (Random)");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return LedColor.RED;
            case 2:
                return LedColor.GREEN;
            case 3:
                return LedColor.BLUE;
            case 4:
                return LedColor.YELLOW;
            case 5:
                return LedColor.RANDOM;
            default:
                System.out.println("Ungültige Auswahl. Standardmäßig wird die Farbe Rot verwendet.");
                return LedColor.RED;
        }
    }
}
