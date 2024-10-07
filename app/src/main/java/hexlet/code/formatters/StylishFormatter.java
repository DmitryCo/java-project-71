package hexlet.code.formatters;

import java.util.List;
import hexlet.code.Diff;

public class FormatStylish {
    public static String stylish(Diff diff) {
        StringBuilder result = new StringBuilder("{\n");
        for (Changes change : diff.getChanges()) {
            String formattedLine = formatChanges(change);
            result.append(formattedLine).append("\n");
        }
        return result.append("}").toString();
    }

    private static String formatChanges(Changes change) {
        String prefix;
        switch (change.typeOfChange) {
            case ADDED:
                prefix = "  + ";
                break;
            case REMOVED:
                prefix = "  - ";
                break;
            case CHANGED:
                prefix = "  - ";
                break;
            case UNCHANGED:
                prefix = "    ";
                break;
            default:
                prefix = "    ";
                break;
        }
        return String.format("%s%s: %s", prefix, change.key, change.value);
    }
}
