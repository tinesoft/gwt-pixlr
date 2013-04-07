
package com.tinesoft.gwt.pixlr.server;

/**
 * Enumeration of all states of image that can be returned by 'Pixlr'.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public enum PixlrImageState {

    /**
     * New is when the user open/creates the image in the editor.
     */
    NEW,
    /**
     * Copy is when the image is from the API and the user checked "Save as copy".
     */
    COPY,
    /**
     * TODO: document this
     */
    REPLACE;

    /**
     * Returns the enum constant of type {@link PixlrImageState} with the specified name (case
     * insensitive).
     * 
     * @param name the name of the enum constant
     * @return the enum constant of type {@link PixlrImageState} with the specified name
     * @throws IllegalArgumentException if enum type {@link PixlrImageState} has no constant with
     *             the specified name
     * @throws NullPointerException if <tt>name</tt> is null
     */
    public static PixlrImageState from(final String name) {
        if (name == null) {
            throw new NullPointerException("Name is null");
        }
        return PixlrImageState.valueOf(name.trim().toUpperCase());
    }
}
