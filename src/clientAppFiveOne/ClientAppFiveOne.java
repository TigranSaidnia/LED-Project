package clientAppFiveOne;

import ch.hslu.prg.leds.proxy.LedService;

import java.util.Random;
import java.util.Scanner;

public class ClientAppFiveOne {
    public static void main(String[] args) {
        showBorder();
    }

    public static void showBorder() {
        LedService ledService = new LedService();

        int maxRows = LedService.MAX_ROWS;
        int maxColumns = LedService.MAX_COLUMNS;
        ledService.addLeds(maxRows * maxColumns);
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
}
