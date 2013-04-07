
package com.tinesoft.gwt.pixlr.client.core;

/**
 * Enumeration of 'Pixlr' available services.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public enum PixlrService {

    EXPRESS("express"), EDITOR("editor");

    /**
     * Returns the enum constant of type {@link PixlrService} with the specified name (case
     * insensitive).
     * 
     * @param name the name of the enum constant
     * @return the enum constant of type {@link PixlrService} with the specified name
     * @throws IllegalArgumentException if enum type {@link PixlrService} has no constant with the
     *             specified name
     * @throws NullPointerException if <tt>name</tt> is null
     */
    public static PixlrService from(final String name) {
        if (name == null) {
            throw new NullPointerException("Name is null");
        }
        return PixlrService.valueOf(name.trim().toUpperCase());
    }

    private final String value;

    private PixlrService(final String value) {
        this.value = value;
    }

    /**
     * Returns the name of the 'Pixlr' service.
     * 
     * @return
     */
    public String getValue() {
        return value;
    }
}
