import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) throws IOException {
        String src = "image.jpg";
        String dest = "copy.jpg";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(src)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
        }
        byte[] imageBytes = baos.toByteArray();
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
        System.out.println("Done");
    }
}
