import java.io.*;

public class UpperToLowerFile {
    public static void main(String[] args) {
        String src = "input.txt";
        String dest = "output.txt";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src), "UTF-8"));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
