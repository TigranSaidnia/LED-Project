package clientAppTwoOne;

import ch.hslu.prg.leds.proxy.LedService;

import java.util.Random;
import java.util.Scanner;

public class ClientAppTwoOne {
    public static void main(String[] args) {
        LedService ledService = new LedService();
        switchEvenOdd(ledService);
    }

    private static void switchEvenOdd(LedService service) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie die Anzahl LEDs (Vielfaches von 16) ein: ");
        int numLEDs = scanner.nextInt();
        service.addLeds(numLEDs);
        service.stopExecutionFor(2000);

        for (int i = 0; i < 3; i++) {
            for (int ledNumber = 0; ledNumber < numLEDs; ledNumber += 2) {
                service.turnLedOn(ledNumber);
            }
            service.stopExecutionFor(1000);
            for (int ledNumber = 0; ledNumber < numLEDs; ledNumber++) {
                if (service.isOn(ledNumber)) {
                    service.turnLedOff(ledNumber);
                } else {
                    service.turnLedOn(ledNumber);
                }
            }
            service.stopExecutionFor(1000);
            for (int ledNumber = 0; ledNumber < numLEDs; ledNumber++) {
                service.turnLedOff(ledNumber);
            }
            service.stopExecutionFor(1000);
        }
        service.reset();
    }
}
