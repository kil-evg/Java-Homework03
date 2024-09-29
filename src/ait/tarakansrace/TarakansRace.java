package ait.tarakansrace;

import ait.tarakansrace.model.Tarakan;

import java.util.Scanner;

public class TarakansRace {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number of tarakans: ");
        int numTarakans = scanner.nextInt();

        System.out.print("Enter a distance (iterations): ");
        Tarakan.distance = scanner.nextInt();

        Tarakan[] tarakans = new Tarakan[numTarakans];
        Thread[] tasks = new Thread[numTarakans];

        for (int i = 0; i < numTarakans; i++) {
            tarakans[i] = new Tarakan(i + 1);
            tasks[i] = new Thread(tarakans[i]);
        }
        for (int i = 0; i < numTarakans; i++) {
            tasks[i].start();
        }
        for (int i = 0; i < numTarakans; i++) {
            tasks[i].join();
        }
        System.out.println("Congratulations to tarakan #" + Tarakan.andWinnerIs + " (winner)");
    }
}
