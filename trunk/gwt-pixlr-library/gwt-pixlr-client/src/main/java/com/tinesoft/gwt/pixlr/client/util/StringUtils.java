
package com.tinesoft.gwt.pixlr.client.util;

/**
 * A Simple String utility class (inspired from Apache commons-lang's StringUtils)
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public class StringUtils {

    /**
     * <p>
     * Checks if the String contains only unicode letters.
     * </p>
     * 
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String ("") will return
     * <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isAlpha(null)   = false
     * StringUtils.isAlpha("")     = true
     * StringUtils.isAlpha("  ")   = false
     * StringUtils.isAlpha("abc")  = true
     * StringUtils.isAlpha("ab2c") = false
     * StringUtils.isAlpha("ab-c") = false
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains letters, and is non-null
     */
    public static boolean isAlpha(final String str) {
        if (str == null) {
            return false;
        }
        final int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetter(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Checks if the String contains only unicode letters or digits.
     * </p>
     * 
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String ("") will return
     * <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isAlphanumeric(null)   = false
     * StringUtils.isAlphanumeric("")     = true
     * StringUtils.isAlphanumeric("  ")   = false
     * StringUtils.isAlphanumeric("abc")  = true
     * StringUtils.isAlphanumeric("ab c") = false
     * StringUtils.isAlphanumeric("ab2c") = true
     * StringUtils.isAlphanumeric("ab-c") = false
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains letters or digits, and is non-null
     */
    public static boolean isAlphanumeric(final String str) {
        if (str == null) {
            return false;
        }
        final int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetterOrDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Checks if the String contains only unicode letters, digits or space (<code>' '</code>).
     * </p>
     * 
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String ("") will return
     * <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isAlphanumeric(null)   = false
     * StringUtils.isAlphanumeric("")     = true
     * StringUtils.isAlphanumeric("  ")   = true
     * StringUtils.isAlphanumeric("abc")  = true
     * StringUtils.isAlphanumeric("ab c") = true
     * StringUtils.isAlphanumeric("ab2c") = true
     * StringUtils.isAlphanumeric("ab-c") = false
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains letters, digits or space, and is non-null
     */
    public static boolean isAlphanumericSpace(final String str) {
        if (str == null) {
            return false;
        }
        final int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isLetterOrDigit(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Checks if a String is whitespace, empty ("") or null.
     * </p>
     * 
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     * @since 2.0
     */
    public static boolean isBlank(final String str) {

        if ((str == null) || (str.trim().length() == 0)) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * Checks if a String is empty ("") or null.
     * </p>
     * 
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     * 
     * <p>
     * NOTE: This method does not trim the String. That functionality is available in isBlank().
     * </p>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is empty or null
     */
    public static boolean isEmpty(final String str) {
        return (str == null) || (str.length() == 0);
    }

    /**
     * <p>
     * Checks if a String is not empty (""), not null and not whitespace only.
     * </p>
     * 
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is not empty and not null and not whitespace
     */
    public static boolean isNotBlank(final String str) {
        return !StringUtils.isBlank(str);
    }

    /**
     * <p>
     * Checks if a String is not empty ("") and not null.
     * </p>
     * 
     * <pre>
     * StringUtils.isNotEmpty(null)      = false
     * StringUtils.isNotEmpty("")        = false
     * StringUtils.isNotEmpty(" ")       = true
     * StringUtils.isNotEmpty("bob")     = true
     * StringUtils.isNotEmpty("  bob  ") = true
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is not empty and not null
     */
    public static boolean isNotEmpty(final String str) {
        return !StringUtils.isEmpty(str);
    }

    /**
     * <p>
     * Checks if the String contains only unicode digits. A decimal point is not a unicode digit and
     * returns false.
     * </p>
     * 
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String ("") will return
     * <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isNumeric(null)   = false
     * StringUtils.isNumeric("")     = true
     * StringUtils.isNumeric("  ")   = false
     * StringUtils.isNumeric("123")  = true
     * StringUtils.isNumeric("12 3") = false
     * StringUtils.isNumeric("ab2c") = false
     * StringUtils.isNumeric("12-3") = false
     * StringUtils.isNumeric("12.3") = false
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains digits, and is non-null
     */
    public static boolean isNumeric(final String str) {
        if (str == null) {
            return false;
        }
        final int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Checks if the String contains only unicode digits or space (<code>' '</code>). A decimal
     * point is not a unicode digit and returns false.
     * </p>
     * 
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String ("") will return
     * <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isNumeric(null)   = false
     * StringUtils.isNumeric("")     = true
     * StringUtils.isNumeric("  ")   = true
     * StringUtils.isNumeric("123")  = true
     * StringUtils.isNumeric("12 3") = true
     * StringUtils.isNumeric("ab2c") = false
     * StringUtils.isNumeric("12-3") = false
     * StringUtils.isNumeric("12.3") = false
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains digits or space, and is non-null
     */
    public static boolean isNumericSpace(final String str) {
        if (str == null) {
            return false;
        }
        final int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isDigit(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Utility class No public constructor
     **/
    public StringUtils() {

    }

}
