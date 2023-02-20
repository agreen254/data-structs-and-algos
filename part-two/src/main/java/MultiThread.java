public class MultiThread implements Runnable { // or extends Thread
    private final int threadNumber;

    public MultiThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 5; i >= 0; i--) {
            System.out.println(i + " from thread number " + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        // another useful method is join(), where the program will wait for that individual thread to finish
        // before continuing to execute

    }
}
