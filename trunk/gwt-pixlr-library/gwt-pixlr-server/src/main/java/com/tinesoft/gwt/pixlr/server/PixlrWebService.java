
package com.tinesoft.gwt.pixlr.server;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("pixlr")
public class PixlrWebService {

    // FIXME : Improve javadoc
    /**
     * The content of this parameter depends on the value of the "method" in-parameter. If method
     * was GET the value of image is an url to where we saved the image. If method was POST the
     * value of image is the actual image.
     */
    private static final String IMAGE_PARAM = "image";
    /**
     * The title of the image the user typed in when saving.
     */
    private static final String TITLE_PARAM = "title";
    /**
     * The type of image can be: jpg, png, bmp or pxd.
     */
    private static final String TYPE_PARAM = "type";
    /**
     * The state of the image, can be "new", "copy", "replace". New is when the user open/creates
     * the image in the editor. Copy is when the image is from the API and the image checked
     * "Save as copy".
     */
    private static final String STATE_PARAM = "state";

    /**
     * Additionnal parameterers sent to 'Pixlr'
     */
    private static final String MORE_PARAM = "more";

    /**
     * Handles the response sent by 'Pixlr' service when "GET" method was used to contact it.
     * 
     * @param image The URL to the edited image
     * @param title The title of the image the user typed in when saving
     * @param type The type of image can be: jpg, png, bmp or pxd
     * @param state The state of the image, can be "new", "copy", "replace"
     * @param moreParams A map containg addtionnal parameters sent to 'Pixlr'
     */
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void get(@QueryParam(IMAGE_PARAM) final String image, @QueryParam(TITLE_PARAM) final String title, @QueryParam(TYPE_PARAM) final String type, @QueryParam(STATE_PARAM) final String state, @QueryParam(MORE_PARAM) final MultivaluedMap<String, String> moreParams) {

    }

    /**
     * Handles the response sent by 'Pixlr' service when "POST" method was used to contact it.
     * 
     * @param image The edited image as a {@link java.io.File}
     * @param title The title of the image the user typed in when saving
     * @param type The type of image can be: jpg, png, bmp or pxd
     * @param state The state of the image, can be "new", "copy", "replace"
     * @param moreParams A map containg addtionnal parameters sent to 'Pixlr'
     */
    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void post(@QueryParam(IMAGE_PARAM) final File image, @QueryParam(TITLE_PARAM) final String title, @QueryParam(TYPE_PARAM) final String type, @QueryParam(STATE_PARAM) final String state, @QueryParam(MORE_PARAM) final MultivaluedMap<String, String> moreParams) {

    }

}
