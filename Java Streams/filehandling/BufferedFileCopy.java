import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) throws IOException {
        String src = "largefile.dat";
        String dest1 = "copy_unbuffered.dat";
        String dest2 = "copy_buffered.dat";
        long start, end;
        start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src); FileOutputStream fos = new FileOutputStream(dest1)) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
        end = System.nanoTime();
        System.out.println("Unbuffered: " + (end - start) / 1_000_000 + " ms");
        start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2))) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }
        end = System.nanoTime();
        System.out.println("Buffered: " + (end - start) / 1_000_000 + " ms");
    }
}
