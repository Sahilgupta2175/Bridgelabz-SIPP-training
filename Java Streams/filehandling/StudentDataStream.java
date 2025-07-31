import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String file = "students.dat";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(1);
            dos.writeUTF("John");
            dos.writeDouble(8.5);
            dos.writeInt(2);
            dos.writeUTF("Jane");
            dos.writeDouble(9.1);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println(roll + " " + name + " " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
