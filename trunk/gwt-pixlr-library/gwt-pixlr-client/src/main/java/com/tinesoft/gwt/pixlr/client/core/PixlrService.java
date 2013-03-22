
package com.tinesoft.gwt.pixlr.client.core;

/**
 * Enumeration of 'Pixlr' available services.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public enum PixlrService {

    EDITOR("editor"), EXPRESS("express"), O_MATIC("o-matic");

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

}
