import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        Files.writeString(Path.of(filename), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
