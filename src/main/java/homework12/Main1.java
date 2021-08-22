package homework12;

import java.util.concurrent.*;

public class Main1 {
    public static CountDownLatch molecule;

    public static void main(String[] args) {
        Semaphore semaphoreOxygen = new Semaphore(1, true);
        Semaphore semaphoreHydrogen = new Semaphore(2, true);
        molecule = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 100; i++){
            if(i % 2 == 0)
//                new Thread(new Hydrogen(semaphoreHydrogen)).start();
                executor.execute(new Hydrogen(semaphoreHydrogen));
            else
                executor.execute(new Oxygen(semaphoreOxygen));
//                new Thread(new Oxygen(semaphoreOxygen)).start();
            if(molecule.getCount() == 0)
                molecule = new CountDownLatch(3);
        }

        executor.shutdown();
    }
}
