package hexlet.code;

import hexlet.code.formatters.StylishFormatter;
import hexlet.code.formatters.PlainFormatter;

import java.util.Map;
import java.util.List;
import java.io.IOException;

public class Formatter {
    public static String format(List<Map<String, Object>> diffTree, String formatType) throws IOException {
        return switch (formatType) {
            case "stylish" -> StylishFormatter.stylishFormat(diffTree);
            case "plain" -> PlainFormatter.plainFormat(diffTree);
            default -> throw new IllegalArgumentException("Unsupported format type: " + formatType);
        };
    }
}
