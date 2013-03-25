
package com.tinesoft.gwt.pixlr.client.core;

/**
 * Enumeration of all Flash Wmodes.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public enum PixlrWmode {

    TRANSPARENT, OPAQUE, WINDOW;

    public static PixlrWmode from(String name) {
        if (name == null)
            throw new NullPointerException("Name is null");
        return PixlrWmode.valueOf(name.trim().toUpperCase());
    }
}
