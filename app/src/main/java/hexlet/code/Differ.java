package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Path firstFile = Paths.get(filepath1).toAbsolutePath().normalize();
        Path secondFile = Paths.get(filepath2).toAbsolutePath().normalize();

        Map<String, Object> contentFirstFile = Parser.parsing(firstFile, filepath1);
        Map<String, Object> contentSecondFile = Parser.parsing(secondFile, filepath2);

        Set<String> allKeys = new TreeSet<>(contentFirstFile.keySet());
        allKeys.addAll(contentSecondFile.keySet());

        StringJoiner diffJoiner = new StringJoiner("\n", "{\n", "\n}");

        for (var key : allKeys) {
            Object value1 = contentFirstFile.get(key);
            Object value2 = contentSecondFile.get(key);

            if (value1 == null && value2 == null) {
                continue;
            }

            if (value1 != null && value2 == null) {
                diffJoiner.add(String.format("  - %s: %s", key, value1));
            } else if (value1 == null) {
                diffJoiner.add(String.format("  + %s: %s", key, value2));
            } else if (value1.equals(value2)) {
                diffJoiner.add(String.format("    %s: %s", key, value1));
            } else if (!value1.equals(value2)) {
                diffJoiner.add(String.format("  - %s: %s", key, value1));
                diffJoiner.add(String.format("  + %s: %s", key, value2));
            }
        }

        return diffJoiner.toString();
    }
}
