
package com.tinesoft.gwt.pixlr.client.resources;

import com.google.gwt.resources.client.CssResource;

/**
 * Base CssResource style.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public interface BaseStyle extends CssResource {

    /**
     * The path to the default CSS styles used by this resource.
     */
    String DEFAULT_CSS = "com/tinesoft/gwt/pixlr/client/resources/BaseStyle.css";

    /**
     * Defines the style to clear both left and right floating.
     * 
     * @return
     */
    String clear();

    /**
     * Defines the style to make contents float to the left.
     * 
     * @return
     */
    String left();

    /**
     * Defines the style to make contents float to the right.
     * 
     * @return
     */
    String right();
}
