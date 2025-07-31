import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String src = "source.txt";
        String dest = "destination.txt";
        try (FileInputStream fis = new FileInputStream(src); FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("File copied successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
