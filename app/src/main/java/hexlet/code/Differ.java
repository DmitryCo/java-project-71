package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Map;
import java.util.List;
import java.io.IOException;

public class Differ {
    public static String generate(String file1, String file2, String formatType) throws IOException {
        String data1 = getData(file1);
        String data2 = getData(file2);

        Map<String, Object> contentFile1 = Parser.parse(data1, getDataFormat(file1));
        Map<String, Object> contentFile2 = Parser.parse(data2, getDataFormat(file2));

        List<Map<String, Object>> diffTree = DiffTreeBuilder.generateDiffTree(contentFile1, contentFile2);
        return Formatter.format(diffTree, formatType);
    }

    public static void validateFileExists(Path filePath) throws IOException {
        if (!Files.exists(filePath)) {
            throw new IOException("File '" + filePath + "' does not exist");
        }
    }

    public static String getData(String file) throws IOException {
        Path filePath = Paths.get(file).toAbsolutePath().normalize();
        validateFileExists(filePath);
        return Files.readString(filePath);
    }

    public static String getDataFormat(String filePath) {
        int indexOfFileExtension = filePath.lastIndexOf(".");
        if (indexOfFileExtension == -1 || indexOfFileExtension == filePath.length() - 1) {
            throw new IllegalArgumentException("File '" + filePath + "' does not have a valid format");
        }
        return filePath.substring(indexOfFileExtension + 1);
    }

    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }
}
