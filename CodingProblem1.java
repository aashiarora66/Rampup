public class Main {
   

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            public void run() {

                for (int itr = 1; itr < 51; itr = itr + 2) {
                    synchronized (lock) {
                        System.out.print(" " + itr);
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {

                for (int itr = 2; itr < 51; itr = itr + 2) {
                    synchronized (lock) {
                        System.out.print(" " + itr);
                        try {
                            lock.notify();
                            if(itr==50)
                                break;
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        try {
            t1.start();
            t2.start();
        } catch (Exception e) {

        }
    }
}