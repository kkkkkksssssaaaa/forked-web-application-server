package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestValidator {

    public static final Pattern REQUEST_PATTERN =
            Pattern.compile("(GET|POST|PUT|DELETE)\\s+([^?\\s]+)((?:[?&][^&\\s]+)*)\\s+(HTTP/.*)");

    public static boolean isContainQueryParameter(String requestedStr) {
        Matcher m = REQUEST_PATTERN.matcher(requestedStr);

        if (!m.find()) {
            throw new IllegalArgumentException();
        }

        return !m.group(3).isEmpty();
    }

    public static boolean isRequestPatternMatched(String requestedStr) {
        return REQUEST_PATTERN.matcher(requestedStr).find();
    }

    public static Matcher matcher(String requestedStr) {
        return REQUEST_PATTERN.matcher(requestedStr);
    }

}
