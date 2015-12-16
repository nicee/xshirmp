package psn.lotus.core.util;

/**
 * @author nicee
 * @since 2015/9/15
 */
public class AssertUtils {

    /**
     * @param expression
     * @param message
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * @param expression
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - the argument must be true.");
    }

    /**
     * @param expression
     * @param message
     */
    public static void isFalse(boolean expression, String message) {
        isTrue(!expression, message);
    }

    /**
     * @param expression
     */
    public static void isFalse(boolean expression) {
        isFalse(expression, "[Assertion failed] - the argument must be false.");
    }

    /**
     * @param object
     * @param message
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * @param object
     */
    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the argument must be null.");
    }

    /**
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * @param object
     */
    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - the argument must be not null.");
    }

    public static void noNullElement(Object[] array) {
        noNullElement(array, "[Assertion failed ] - the argument must be not contain an null element.");
    }

    /**
     * @param array
     * @param message
     */
    public static void noNullElement(Object[] array, String message) {
        if (array != null) {
            for (Object obj : array) {
                if (obj == null) {
                    throw new IllegalArgumentException(message);
                }
            }
        }
    }

    /**
     * @param text
     * @param message
     */
    public static void hasText(String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * @param text
     */
    public static void hasText(String text) {
        hasText(text, "[Assertion failed] - the argument must has content of text.");
    }

}
