package homework12;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Oxygen implements Runnable{

    private Semaphore semaphoreOxygen;
    private Main1 main;

    public Oxygen(Semaphore semaphoreOxygen){
        this.semaphoreOxygen = semaphoreOxygen;
        this.main = main;
    }

    @Override
    public void run() {
        try {
            semaphoreOxygen.acquire();
            releaseOxygen();
            semaphoreOxygen.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void releaseOxygen() throws InterruptedException {
        while(Main1.molecule.getCount() == 0)
            Thread.sleep(100);
        CountDownLatch molecule = Main1.molecule;
        molecule.countDown();
        molecule.await();
        System.out.print("O");
    }
}
