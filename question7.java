public class ThreadBug {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Running in another thread");
        });

        t.start(); 
    }
}
