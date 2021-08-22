package homework12;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Hydrogen implements Runnable{

    private Semaphore semaphoreHydrogen;

    public Hydrogen(Semaphore semaphoreHydrogen){
        this.semaphoreHydrogen = semaphoreHydrogen;
    }

    @Override
    public void run() {
        try {
            semaphoreHydrogen.acquire();
            releaseHydrogen();
            semaphoreHydrogen.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void releaseHydrogen() throws InterruptedException {
        while (Main1.molecule.getCount() == 0)
            Thread.sleep(100);
        CountDownLatch molecule = Main1.molecule;
        molecule.countDown();
        molecule.await();
        System.out.print("H");
    }
}
