
package com.tinesoft.gwt.pixlr.client.core;

/**
 * Enumeration of all Flash Wmodes.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public enum PixlrWmode {

    OPAQUE, WINDOW, TRANSPARENT, ;

    /**
     * Returns the enum constant of type {@link PixlrWmode} with the specified name (case
     * insensitive).
     * 
     * @param name the name of the enum constant
     * @return the enum constant of type {@link PixlrWmode} with the specified name
     * @throws IllegalArgumentException if enum type {@link PixlrWmode} has no constant with the
     *             specified name
     * @throws NullPointerException if <tt>name</tt> is null
     */
    public static PixlrWmode from(String name) {
        if (name == null)
            throw new NullPointerException("Name is null");
        return PixlrWmode.valueOf(name.trim().toUpperCase());
    }
}
