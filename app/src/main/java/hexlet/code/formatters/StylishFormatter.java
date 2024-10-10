package hexlet.code.formatters;

import hexlet.code.DiffTreeBuilder.ChangeType;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String stylishFormat(List<Map<String, Object>> diffTree) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> diff : diffTree) {
            ChangeType changeType = (ChangeType) diff.get("changeType");
            switch (changeType) {
                case REMOVED:
                    result.append("  - ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("value1"))
                            .append("\n");
                    break;
                case ADDED:
                    result.append("  + ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("value2"))
                            .append("\n");
                    break;
                case UNCHANGED:
                    result.append("    ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("value1"))
                            .append("\n");
                    break;
                case CHANGED:
                    result.append("  - ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("value1"))
                            .append("\n");
                    result.append("  + ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("value2"))
                            .append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown difference tree type: " + diffTree);
            }
        }
        return result.append("}").toString();
    }
}
