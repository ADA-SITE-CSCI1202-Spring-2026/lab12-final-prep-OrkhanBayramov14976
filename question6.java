public class ThreadLambdaTask {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
            }
        });

        t.start();

        System.out.println("Main method finished.");
    }
}
