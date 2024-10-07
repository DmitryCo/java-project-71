package hexlet.code;

import hexlet.code.formatters.StylishFormatter;

import java.util.Map;
import java.util.List;
import java.io.IOException;

public class Formatter {
    public static String format(List<Map<String, Object>> diffTree, String formatType) throws IOException {
        return switch (formatType) {
            case "stylish" -> StylishFormatter.stylishFormat(diffTree);
            default -> throw new IllegalArgumentException("Unsupported format type: " + formatType);
        };
    }
}
