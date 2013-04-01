
package com.tinesoft.gwt.pixlr.client.core;

/**
 * Enumeration of 'Pixlr' available services.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public enum PixlrService {

    EXPRESS("express"), EDITOR("editor");

    private final String value;

    private PixlrService(String value) {
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

    /**
     * 
     * @param enumType
     * @param name
     * @return
     */
    public static PixlrService from(String name) {
        if (name == null)
            throw new NullPointerException("Name is null");
        return PixlrService.valueOf(name.trim().toUpperCase());
    }
}
