
package com.tinesoft.gwt.pixlr.client.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates all parameters that can be send to 'Pixlr'.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public class PixlrSettings {

    private PixlrService service = PixlrService.EXPRESS;
    private PixlrSendMethod method = PixlrSendMethod.GET;
    private String referrer;
    private String icon;
    private String exit;
    private String image;
    private String title;
    private PixlrImageType type;
    private String target;
    private Boolean redirect;
    private Boolean lockTarget;
    private Boolean lockTitle;
    private PixlrImageType lockType;
    private Integer quality;
    private Boolean copy;
    private Integer maxWidth;
    private Integer maxHeight;
    private PixlrWmode wmode;

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
     * Indicates the visibility of a checkbox on the save dialog that lets the user select
     * "Save as copy".
     * 
     * @return <code>true</code> if the checkbox is visible on the save dialog, <code>false</code>
     *         otherwise
     */
    public Boolean getCopy() {
        return copy;
    }

    /**
     * Gets the URL to send the visitor if the user click exit/close.
     * 
     * @return the exit URL
     */
    public String getExit() {
        return exit;
    }

    /**
     * Gets the URL to a 16*16 icon to be shown at the save tab.
     * 
     * @return the icon URL
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Gets the URL to the image.
     * <p>
     * <b>NOTE: </b>This parameter is only valid when you send your request to 'Pixlr' via "GET"
     * method.
     * </p>
     * 
     * @return the image URL
     */
    public String getImage() {
        return image;
    }

    /**
     * Indicates if the user can "save to computer" and other service in Pixlr Editor.
     * 
     * @return <code>true</code> if the user can "save to computer", <code>false</code> otherwise
     */
    public Boolean getLockTarget() {
        return lockTarget;
    }

    /**
     * Indicates if the image title is locked, so the user can't change it.
     * 
     * @return <code>true</code> if the user can't change image title, <code>false</code> otherwise
     */
    public Boolean getLockTitle() {
        return lockTitle;
    }

    /**
     * Gets the "locked" save image format.
     * 
     * @return the locked save format
     */
    public PixlrImageType getLockType() {
        return lockType;
    }

    /**
     * Gets the maximum height of an image the user saves.
     * 
     * @return the maximum height of the image
     */
    public Integer getMaxHeight() {
        return maxHeight;
    }

    /**
     * Gets the maximum width of an image the user saves.
     * 
     * @return the maximum width of the image
     */
    public Integer getMaxWidth() {
        return maxWidth;
    }

    /**
     * Gets the way we send the image information, "GET" or "POST", default is "GET".
     * 
     * @return the send method
     */
    public PixlrSendMethod getMethod() {
        return method;
    }

    /**
     * Gets the jpg quality when the user saves the image, values are 0-100.
     * 
     * @return the jpg image quality
     */
    public Integer getQuality() {
        return quality;
    }

    /**
     * Indicates if the user stays in the editor after saving the image.
     * 
     * @return <code>true</code> if the user stays in the editor after saving the image,
     *         <code>false</code> otherwise
     */
    public Boolean getRedirect() {
        return redirect;
    }

    /**
     * Gets the name of the referring service for example "Your site name" or "Facebook".
     * 
     * @return the referrer
     */
    public String getReferrer() {
        return referrer;
    }

    /**
     * Gets the 'Pixlr' service to contact, one of the value of {@link PixlrService}.
     * 
     * @return the Pixlr service
     */
    public PixlrService getService() {
        return service;
    }

    /**
     * Gets the URL to which we send the image information when saving.
     * 
     * @return the target URL
     */
    public String getTarget() {
        return target;
    }

    /**
     * Gets the title of the opened image.
     * 
     * @return the image title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the filetype of the image, one of the values of {@link PixlrImageType}.
     * 
     * @return the image filetype
     */
    public PixlrImageType getType() {
        return type;
    }

    /**
     * Gets the Adobe Flash wmode, possible values are one of {@link PixlrWmode}.
     * 
     * @return the wmode
     */
    public PixlrWmode getWmode() {
        return wmode;
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
     * Sets the visibility of a checkbox on the save dialog that lets the user select "Save as copy"
     * 
     * @param copy <code>true</code> if the checkbox is visible on the save dialog,
     *            <code>false</code> otherwise
     */
    public void setCopy(final Boolean copy) {
        this.copy = copy;
    }

    /**
     * Sets the URL to send the visitor if the user click exit/close.
     * 
     * @param exit the exit URL
     */
    public void setExit(final String exit) {
        this.exit = exit;
    }

    /**
     * Sets the URL to a 16*16 icon to be shown at the save tab.
     * 
     * @param icon the icon URL
     */
    public void setIcon(final String icon) {
        this.icon = icon;
    }

    /**
     * Sets the URL to the image.
     * <p>
     * <b>NOTE:</b><br/>
     * You only need to set this parameter when you send your request to 'Pixlr' via the "GET"
     * method.<br/>
     * When using "POST", the raw data of the image is added by the user (by browsing to the file).
     * </p>
     * 
     * @param image the image URL
     */
    public void setImage(final String image) {
        this.image = image;
    }

    /**
     * Sets the possibility for the user to "save to computer" and other service in Pixlr Editor.
     * 
     * @param lockTarget <code>true</code> if the user can "save to computer", <code>false</code>
     *            otherwise
     */
    public void setLockTarget(final Boolean lockTarget) {
        this.lockTarget = lockTarget;
    }

    /**
     * Sets the possibility to lock the image title, so the user can't change it.
     * 
     * @param lockTitle <code>true</code> if the user can't change image title, <code>false</code>
     *            otherwise
     */
    public void setLockTitle(final Boolean lockTitle) {
        this.lockTitle = lockTitle;
    }

    /**
     * Sets/Locks the save image format, possible values are one of {@link PixlrImageType}. Leave it
     * <code>null</code> if you want it to be the same as the source image.
     * 
     * @param lockType
     */
    public void setLockType(final PixlrImageType lockType) {
        this.lockType = lockType;
    }

    /**
     * Sets the maximum height of an image the user saves.
     * 
     * @param maxHeight the maximum height of the image
     * @throws IllegalArgumentException if maxHeight <=0
     */
    public void setMaxHeight(final Integer maxHeight) {
        if ((maxHeight != null) && (maxHeight <= 0)) {
            throw new IllegalArgumentException("'maxHeight' must be greater than 0!");
        }
        this.maxHeight = maxHeight;
    }

    /**
     * Sets the maximum width of an image the user saves.
     * 
     * @param maxWidth the maximum width of the image throws {@link IllegalArgumentException} if
     *            maxWidth <=0
     */
    public void setMaxWidth(final Integer maxWidth) {
        if ((maxWidth != null) && (maxWidth <= 0)) {
            throw new IllegalArgumentException("'maxWidth' must be greater than 0!");
        }
        this.maxWidth = maxWidth;
    }

    /**
     * Sets the way we send the image information, "GET" or "POST", default is "GET".
     * <p>
     * <b>NOTE:</b><br/>
     * If using "POST" method, then you have to have a <b>crossdomain.xml</b> in the root of your
     * web application.<br/>
     * And you need to add pixlr.com to the list of valid domains. More info here: <a
     * href="http://goo.gl/tn9qu">http://goo.gl/tn9qu</a> .
     * </p>
     * 
     * @param method the send method
     */
    public void setMethod(final PixlrSendMethod method) {
        if (method != null) {
            this.method = method;
        }
    }

    /**
     * Sets the jpg quality when the user saves the image, values are 0-100.
     * 
     * @param quality the jpg image quality
     */
    public void setQuality(final Integer quality) {
        if ((quality != null) && ((quality < 0) || (quality > 100))) {
            throw new IllegalArgumentException("JPG  image 'quality' must be within [0-100]!");
        }
        this.quality = quality;
    }

    /**
     * Sets to <code>false</code> if you don't want the browser to follow the save post. i.e the
     * user stay in the editor after saving.
     * 
     * @param redirect <code>true</code> if the user stays in the editor after saving the image,
     *            <code>false</code> otherwise
     */
    public void setRedirect(final Boolean redirect) {
        this.redirect = redirect;
    }

    /**
     * Sets the name of the referring service for example "Your site name" or "Facebook".
     * 
     * @param referrer the referrer
     */
    public void setReferrer(final String referrer) {
        this.referrer = referrer;
    }

    /**
     * Sets the 'Pixlr' service to contact, one of the value of {@link PixlrService}.
     * 
     * @param service the Pixlr service to contact
     */
    public void setService(final PixlrService service) {
        if (service != null) {
            this.service = service;
        }
    }

    /**
     * Sets the URL to which we send the image information when saving.
     * 
     * @param target the target URL
     */
    public void setTarget(final String target) {
        this.target = target;
    }

    /**
     * Sets the title of the opened image.
     * 
     * @param title the image title
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Sets the filetype of the image, one of the values of {@link PixlrImageType}.
     * 
     * @param type the image filetype
     */
    public void setType(final PixlrImageType type) {
        this.type = type;
    }

    /**
     * Sets the Adobe Flash wmode when you need to use z-index and float HTML over the flash area.
     * 
     * @param wmode the wmode
     */
    public void setWmode(final PixlrWmode wmode) {
        this.wmode = wmode;
    }
}
