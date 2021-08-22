package homework11;

public class Main1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Runnable r = new Runnable() {

            @Override
            public void run() {
                boolean wait = true;
                while (true){
                    while (wait){
                        try {
                            synchronized (this) {
                                wait();
                                wait = false;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Прошло 5 секунд");
                    wait = true;
                }
            }
        };
        new Thread(r).start();

        // Set time to 1000 to notify the second thread each second
        long time = 5000;

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Прошло " + (System.currentTimeMillis() - startTime) / 1000.0 + " секунд");
            if(System.currentTimeMillis() - startTime >= time){
                synchronized (r){
                    r.notify();
                }
                time += 5000;
            }
        }
    }
}
