package clientAppOneOne;

import ch.hslu.prg.leds.proxy.LedService;

import java.util.Random;
import java.util.Scanner;

public class ClientAppOneOne {
    public static void main(String[] args) {
        LedService ledService = new LedService();
        ledsOnOff(ledService);
    }

    private static void ledsOnOff(LedService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie die Anzahl der LEDs ein: ");
        int numLEDs = scanner.nextInt();
        service.addLeds(numLEDs);
        service.stopExecutionFor(2000);
        for (int i = 0; i < numLEDs; i++) {
            int ledNumber = numLEDs - 1 - i;
            service.turnLedOn(ledNumber);
        }
        service.stopExecutionFor(250);
        for (int i = 0; i < numLEDs; i++) {
            service.turnLedOff(i);
        }
        service.stopExecutionFor(250);
        for (int repeat = 0; repeat < 3; repeat++) {
            for (int i = 0; i < numLEDs; i++) {
                int ledNumber = numLEDs - 1 - i;
                service.turnLedOn(ledNumber);
            }
            service.stopExecutionFor(250);

            for (int i = 0; i < numLEDs; i++) {
                service.turnLedOff(i);
            }
            service.stopExecutionFor(250);
        }
        service.stopExecutionFor(2000);
        service.reset();
    }
}
