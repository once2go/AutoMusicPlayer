package once2go.com.musicplayer.utill;

import java.util.regex.Pattern;

/**
 * Created by once2go on 27.02.16.
 */
public class Validator {

    public static void checkArgument(Object obj, String errorMsg) {
        if (obj == null) {
            throw new NullPointerException(errorMsg);
        }
    }

    public static void checkOnNullOrEmpty(String obj, String errorMsg) {
        if (obj == null || obj.isEmpty()) {
            throw new NullPointerException(errorMsg);
        }
    }
    public static void validateArgumentString(String obj, String errorMsg) {
        if (obj == null || obj.isEmpty()) {
            throw new IllegalArgumentException(errorMsg);
        }
    }
    public static void validateArgument(Object obj, String errorMsg) {
        if (obj == null) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public static void validateArgumentBiggerThan(int value, int than, String errorMsg) {
        if (value <= than) {
            throw new IllegalArgumentException(errorMsg);
        }
    }
    public static void checkOnNull(Object obj, String errorMsg) {
        if (obj == null) {
            throw new NullPointerException(errorMsg);
        }
    }

    public static void checkOnIllegalStateException(boolean expression, String errorMsg) {
        if (!expression) {
            throw new IllegalStateException(errorMsg);
        }
    }

    public static void validateArgumentStringWithRegularExpression(String obj, String errorMessage, Pattern pattern) {
        if (obj == null || obj.isEmpty() || (pattern != null && !pattern.matcher(obj).matches())) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
