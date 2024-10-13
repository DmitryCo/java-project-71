package hexlet.code.formatters;

import hexlet.code.DiffTreeBuilder.ChangeType;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String plainFormat(List<Map<String, Object>> diffTree) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> diff : diffTree) {
            ChangeType changeType = (ChangeType) diff.get("changeType");
            switch (changeType) {
                case REMOVED:
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was removed")
                            .append("\n");
                    break;
                case ADDED:
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was added with value: ")
                            .append(checkValue(diff.get("value2")))
                            .append("\n");
                    break;
                case UNCHANGED:
                    break;
                case CHANGED:
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was updated. From ")
                            .append(checkValue(diff.get("value1")))
                            .append(" to ")
                            .append(checkValue(diff.get("value2")))
                            .append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown difference tree type: " + diffTree);
            }
        }
        return result.toString().trim();
    }

    public static String checkValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return null;
        } else if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        } else {
            return value.toString();
        }
    }
}
