package ait.tarakansrace.model;

import java.util.Random;

public class Tarakan implements Runnable {
    private int tarakanNumber;

    public static int andWinnerIs = 0;
    public static int distance;
    private Random random = new Random();

    public Tarakan(int tarakanNumber) {
        this.tarakanNumber = tarakanNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < distance; i++) {
            //Tarakan sleeps a random amount of milliseconds [2-5]
            try {
                Thread.sleep(2 + random.nextInt(4));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tarakan #" + tarakanNumber + " ran iteration " + (i + 1));
        }

        if (andWinnerIs == 0) {
            andWinnerIs = tarakanNumber;
        }
    }
}
