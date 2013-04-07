
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
     * Gets the named additional parameter that has been sent to 'Pixlr' via the 'Target URL'
     * parameter.
     * 
     * @param parameterName the parameter name
     * @return the parameter value
     */
    public String getAdditionalParameter(final String parameterName) {
        return additionalParameters.get(parameterName);
    }

    /**
     * Gets the map of additional parameters.
     * 
     * @return the additional parameters map
     */
    public Map<String, String> getAdditionalParameters() {
        return additionalParameters;
    }

    /**
     * Gets the input stream to the image, sent by 'Pixlr' (either as posted raw data or via its
     * URL) after the user has saved it.
     * 
     * @return the {@link InputStream} to the image
     */
    public InputStream getImage() {
        return image;
    }

    /**
     * Gets the state of the image, can be one of the values of {@link PixlrImageState}.
     * 
     * @return the image state
     */
    public PixlrImageState getState() {
        return state;
    }

    /**
     * Gets the title of the image the user typed in when saving..
     * 
     * @return the image title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the type of the image, can be one of the values of {@link PixlrImagetype}.
     * 
     * @return the image type
     */
    public PixlrImageType getType() {
        return type;
    }

    /**
     * Adds an additional parameter to the result.
     * 
     * @param parameterName the parameter name
     * @param parameterValue the parameter value
     */
    protected void putAdditionalParameter(final String parameterName, final String parameterValue) {
        additionalParameters.put(parameterName, parameterValue);
    }

    /**
     * Sets the input stream to image, sent by 'Pixlr' (either as posted raw data or via its URL)
     * after the user has saved it.
     * 
     * @param image the {@link InputStream} to the image
     */
    protected void setImage(final InputStream imageInputStream) {
        image = imageInputStream;
    }

    /**
     * Sets the state of the image, can be one of the values of {@link PixlrImageState}.
     * 
     * @param state the image state
     */
    protected void setState(final PixlrImageState state) {
        this.state = state;
    }

    /**
     * Sets the title of the image the user typed in when saving.
     * 
     * @param title the image title
     */
    protected void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Sets the type of the image, can be one of the values of {@link PixlrImagetype}.
     * 
     * @param type the image type
     */
    protected void setType(final PixlrImageType type) {
        this.type = type;
    }
}
