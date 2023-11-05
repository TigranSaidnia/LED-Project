package clientAppThreeTwo;

import ch.hslu.prg.leds.proxy.LedColor;
import ch.hslu.prg.leds.proxy.LedService;

import java.util.Random;
import java.util.Scanner;

public class ClientAppThreeTwo {
    public static void main(String[] args) {
        switchRandomWithRandomColors();
    }

    public static void switchRandomWithRandomColors() {
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
                LedColor randomColor = LedColor.values()[random.nextInt(LedColor.values().length)];
                ledService.turnLedOn(randomLED);
                //ledService.setLedColor(randomLED, randomColor);
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
