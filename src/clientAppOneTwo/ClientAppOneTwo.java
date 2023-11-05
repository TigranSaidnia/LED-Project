package clientAppOneTwo;

import ch.hslu.prg.leds.proxy.LedColor;
import ch.hslu.prg.leds.proxy.LedService;

import java.util.Random;
import java.util.Scanner;

public class ClientAppOneTwo {
    public static void main(String[] args) {
        LedService ledService = new LedService();
        int numLEDs = 16;

        addRandomColoredLeds(ledService, numLEDs);
    }

    private static void addRandomColoredLeds(LedService service, int numLEDs) {
        Random random = new Random();

        for (int i = 0; i < numLEDs; i++) {
            LedColor randomColor = LedColor.values()[random.nextInt(LedColor.values().length)];
            service.addLeds(1, randomColor);
        }
    }


}