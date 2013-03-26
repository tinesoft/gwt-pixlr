
package com.tinesoft.gwt.pixlr.server;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates the result sent back by the 'Pixlr' service when saving an image.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public class PixlrResult {

    private String title;
    private PixlrImageType type;
    private PixlrImageState state;
    private InputStream image;

    /**
     * A map of additional parameters that can be passed via 'Target URL'
     */
    private final Map<String, String> additionalParameters = new HashMap<String, String>();

    /**
     * Gets the title of the image the user typed in when saving..
     * 
     * @retur the titlee
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the image the user typed in when saving.
     * 
     * @param title the new title
     */
    protected void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the type of the image, can be one of the values of {@link PixlrImagetype}.
     * 
     * @return the type
     */
    public PixlrImageType getType() {
        return type;
    }

    /**
     * Sets the type of the image, can be one of the values of {@link PixlrImagetype}.
     * 
     * @param type the new type
     */
    protected void setType(PixlrImageType type) {
        this.type = type;
    }

    /**
     * Gets the state of the image, can be one of the values of {@link PixlrImageState}.
     * 
     * @return the state
     */
    public PixlrImageState getState() {
        return state;
    }

    /**
     * Sets the state of the image, can be one of the values of {@link PixlrImageState}.
     * 
     * @param state the new state
     */
    protected void setState(PixlrImageState state) {
        this.state = state;
    }

    /**
     * Adds an additional parameter to the result.
     * 
     * @param parameterName the parameter name
     * @param parameterValue the parameter value
     */
    protected void putAdditionalParameter(String parameterName, String parameterValue) {
        additionalParameters.put(parameterName, parameterValue);
    }

    /**
     * Gets the named additional parameter that has been sent to 'Pixlr' via the 'Target URL'
     * parameter.
     * 
     * @param parameterName the parameter name
     * @return
     */
    public String getAdditionalParameter(String parameterName) {
        return additionalParameters.get(parameterName);
    }

    /**
     * Gets the input stream to the image, sent by 'Pixlr' (either as posted raw data or via its
     * URL) after the user has saved it.
     * 
     * @return
     */
    public InputStream getImage() {
        return image;
    }

    /**
     * Sets the input stream to image, sent by 'Pixlr' (either as posted raw data or via its URL)
     * after the user has saved it.
     * 
     * @param image
     */
    protected void setImage(InputStream imageInputStream) {
        this.image = imageInputStream;
    }

    /**
     * Gets the map of additional parameters.
     * 
     * @return
     */
    public Map<String, String> getAdditionalParameters() {
        return additionalParameters;
    }
}
