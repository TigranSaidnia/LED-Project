package clientAppFourTwo;

import ch.hslu.prg.leds.proxy.LedService;

import java.util.Random;
import java.util.Scanner;

public class ClientAppFourTwo {
    public static void main(String[] args) {
        showBinaryWithRoundedLEDs();
    }

    public static void showBinaryWithRoundedLEDs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine positive ganze Zahl ein: ");
        int decimalNumber = scanner.nextInt();

        if (decimalNumber < 0) {
            System.out.println("Die eingegebene Zahl ist nicht positiv.");
            return;
        }
        String binaryString = Integer.toBinaryString(decimalNumber);

        LedService ledService = new LedService();
        int numLEDs = (binaryString.length() + 7) / 8 * 8;
        ledService.addLeds(numLEDs);
        for (int i = 0; i < binaryString.length(); i++) {
            char binaryDigit = binaryString.charAt(i);
            if (binaryDigit == '1') {
                ledService.turnLedOn(i);
            }
        }
        ledService.stopExecutionFor(3000);
        ledService.reset();
    }
}
