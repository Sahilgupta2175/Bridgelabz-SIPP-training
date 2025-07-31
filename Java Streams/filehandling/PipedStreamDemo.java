import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos);
        Thread writer = new Thread(() -> {
            try {
                pos.write("Hello from writer thread".getBytes());
                pos.close();
            } catch (IOException e) {
            }
        });
        Thread reader = new Thread(() -> {
            try {
                int x;
                while ((x = pis.read()) != -1) {
                    System.out.print((char) x);
                }
                pis.close();
            } catch (IOException e) {
            }
        });
        writer.start();
        reader.start();
        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
        }
    }
}
