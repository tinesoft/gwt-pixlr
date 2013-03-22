
package com.tinesoft.gwt.pixlr.showcase.client.place;

/**
 * Contains the unique identifiers of all presenters.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public final class NameTokens {

    /**
     * The 'error' presenter's unique identifier.
     */
    public static final String error = "!error";

    /**
     * The 'home' presenter's unique identifier.
     */
    public static final String home = "!home";

    /**
     * Hide utility class constructor.
     */
    private NameTokens() {}

    public static String getError() {
        return error;
    }

    public static String getHome() {
        return home;
    }

}
