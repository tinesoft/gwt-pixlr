
package com.tinesoft.gwt.pixlr.showcase.server;

import com.tinesoft.gwt.pixlr.server.PixlrResult;
import com.tinesoft.gwt.pixlr.server.PixlrServlet;

/**
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public class MyPixlrServlet extends PixlrServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void handlePixlrResult(PixlrResult result) {

        // here, you can do whatever you want with the result, eg: save image to db, to file system,
        // etc...

        // result.getImage(); the saved image data, as a java.io.InputStream
        // result.getState(); the state of the image (new, replace or copy)
        // result.getTitle(); the title of the image as entered by the user after saving
        // result.getType(); the type of the saved image

        // result.getAdditionalParameters(); the map of additional values passed (if any)

    }
}
