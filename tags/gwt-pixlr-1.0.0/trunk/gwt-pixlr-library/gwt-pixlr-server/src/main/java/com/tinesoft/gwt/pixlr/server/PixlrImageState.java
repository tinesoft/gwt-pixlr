
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

    public static PixlrImageState from(String name) {
        if (name == null)
            throw new NullPointerException("Name is null");
        return PixlrImageState.valueOf(name.trim().toUpperCase());
    }
}
