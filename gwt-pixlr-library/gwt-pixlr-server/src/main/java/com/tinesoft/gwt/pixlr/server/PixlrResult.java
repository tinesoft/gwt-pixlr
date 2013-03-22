
package com.tinesoft.gwt.pixlr.server;

/**
 * Encapsulates the result sent back by the 'Pixlr' service when saving an image.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class PixlrResult {

    private byte[] image;
    private String title;
    private PixlrImageType type;
    private PixlrImageState state;

    /**
     * The content of this parameter depends on the value of the "method" in-parameter.
     * <ul>
     * <li>If method was GET the value of image is an url to where we saved the image.</li>
     * <li>If method was POST the value of image is the actual image.</li>
     * </ul>
     * 
     * @param image
     */
    protected void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * The content of this parameter depends on the value of the "method" in-parameter.
     * <ul>
     * <li>If method was GET the value of image is an url to where we saved the image.</li>
     * <li>If method was POST the value of image is the actual image.</li>
     * </ul>
     * 
     * @return
     */
    public byte[] getImage() {
        return image;
    }

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

}
