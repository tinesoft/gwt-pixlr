
package com.tinesoft.gwt.pixlr.showcase.server;

import java.util.Date;
import java.util.Map;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

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
        // etc.

        // result.getImage(); the saved image data, as a java.io.InputStream
        // result.getState(); the state of the image (new, replace or copy)
        // result.getTitle(); the title of the image as entered by the user after saving
        // result.getType(); the type of the saved image

        // result.getAdditionalParameters(); the map of additional values passed (if any)

        // save the basic information about the image in the data store
        Long id = System.currentTimeMillis();

        Entity entity = new Entity("PixlrResult", id);
        entity.setProperty("title", result.getTitle());
        entity.setProperty("type", result.getType().toString());
        entity.setProperty("state", result.getState().toString());
        entity.setProperty("createdAt", new Date());

        // deactivated to avoid billing costs on GAE, but you get the idea :)
        // Blob blob = new Blob(IOUtils.toByteArray(result.getImage()));
        // entity.setProperty("image", blob);

        for (Map.Entry<String, String> entry : result.getAdditionalParameters().entrySet())
            entity.setProperty(entry.getKey(), entry.getValue());

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(entity);

    }
}
