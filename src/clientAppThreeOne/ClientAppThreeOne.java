package clientAppThreeOne;

import ch.hslu.prg.leds.proxy.LedService;

import java.util.Random;
import java.util.Scanner;

public class ClientAppThreeOne {
    public static void main(String[] args) {
        switchRandom();
    }

    public static void switchRandom() {
        Scanner scanner = new Scanner(System.in);
        int numLEDs;
        do {
            System.out.print("Geben Sie die Anzahl LEDs (Vielfaches von 16) ein: ");
            numLEDs = scanner.nextInt();
        } while (numLEDs % 16 != 0);

        LedService ledService = new LedService();
        ledService.addLeds(numLEDs);

        Random random = new Random();

        for (int repetition = 0; repetition < 3; repetition++) {
            ledService.stopExecutionFor(2000);
            for (int i = 0; i < numLEDs / 2; i++) {
                int randomLED = random.nextInt(numLEDs);
                ledService.turnLedOn(randomLED);
            }
            ledService.stopExecutionFor(1000);
            for (int i = 0; i < numLEDs; i++) {
                if (ledService.isOn(i)) {
                    ledService.turnLedOff(i);
                } else {
                    ledService.turnLedOn(i);
                }
            }
            ledService.stopExecutionFor(1000);
            for (int i = 0; i < numLEDs; i++) {
                ledService.turnLedOff(i);
            }
        }
        ledService.reset();
    }
}
