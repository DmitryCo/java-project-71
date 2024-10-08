package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Utils {
    public static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    public static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }

    public static String getPath(String fileName) {
        return String.format("src/test/resources/fixtures/%s", fileName);
    }
}
