
package com.tinesoft.gwt.pixlr.client.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates all parameters that can be send to 'Pixlr'.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class PixlrSettings {

    private String referrer;
    private String icon;
    private String exit;
    private String image;
    private String title;
    private PixlrImageType type;
    private PixlrSendMethod method = PixlrSendMethod.POST;
    private String target;
    private boolean redirect = false;
    private boolean lockTarget;
    private boolean lockTitle;
    private PixlrImageType lockType;
    private Integer quality;
    private boolean copy;
    private Integer maxWidth;
    private Integer maxHeight;
    private PixlrWmode wmode;
    private PixlrService service = PixlrService.EXPRESS;

    /**
     * A map of additional parameters that can be passed via 'Target URL'
     */
    private final Map<String, String> moreParams = new HashMap<String, String>();

    /**
     * Gets the name of the referring service for example "Your site name" or "Facebook".
     * 
     * @return
     */
    public String getReferrer() {
        return referrer;
    }

    /**
     * Sets the name of the referring service for example "Your site name" or "Facebook".
     * 
     * @param referrer
     */
    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    /**
     * Gets the URL to a 16*16 icon to be shown at the save tab.
     * 
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the URL to a 16*16 icon to be shown at the save tab.
     * 
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Gets the URL to send the visitor if the user click exit/close.
     * 
     * @return
     */
    public String getExit() {
        return exit;
    }

    /**
     * Sets the URL to send the visitor if the user click exit/close.
     * 
     * @param exit
     */
    public void setExit(String exit) {
        this.exit = exit;
    }

    /**
     * Gets the URL to the image.
     * <p>
     * <b>NOTE: </b>This parameter is only valid when you send your request to 'Pixlr' via "GET"
     * method.
     * </p>
     * 
     * @return
     */
    public String getImage() {
        return image;
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
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the title of the opened image.
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the opened image.
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the filetype of the image, one of the values of {@link PixlrImageType}.
     * 
     * @return
     */
    public PixlrImageType getType() {
        return type;
    }

    /**
     * Sets the filetype of the image, one of the values of {@link PixlrImageType}.
     * 
     * @param type
     */
    public void setType(PixlrImageType type) {
        this.type = type;
    }

    /**
     * Gets the way we send the image information, "GET" or "POST", default is "GET".
     * 
     * @return
     */
    public PixlrSendMethod getMethod() {
        return method;
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
     * @param method
     */
    public void setMethod(PixlrSendMethod method) {
        this.method = method;
    }

    /**
     * Gets the URL to which we send the image information when saving.
     * 
     * @return
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the URL to which we send the image information when saving.
     * 
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Indicates if the user stay in the editor after saving the image.
     * 
     * @return
     */
    public boolean isRedirect() {
        return redirect;
    }

    /**
     * Sets to <code>false</code> if you don't want the browser to follow the save post. i.e the
     * user stay in the editor after saving.
     * 
     * @param redirect
     */
    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }

    /**
     * Indicates if the user can "save to computer" and other service in Pixlr Editor.
     * 
     * @return
     */
    public boolean isLockTarget() {
        return lockTarget;
    }

    /**
     * Sets the possibility for the user to "save to computer" and other service in Pixlr Editor.
     * 
     * @param lockTarget
     */
    public void setLockTarget(boolean lockTarget) {
        this.lockTarget = lockTarget;
    }

    /**
     * Indicates if the image title is locked, so the user can't change it.
     * 
     * @return
     */
    public boolean isLockTitle() {
        return lockTitle;
    }

    /**
     * Sets the possibility to lock the image title, so the user can't change it.
     * 
     * @param lockTitle
     */
    public void setLockTitle(boolean lockTitle) {
        this.lockTitle = lockTitle;
    }

    /**
     * Gets the "locked" save image format.
     * 
     * @return
     */
    public PixlrImageType getLockType() {
        return lockType;
    }

    /**
     * Sets/Locks the save image format, possible values are one of {@link PixlrImageType}. Use
     * {@link PixlrImageType#NONE} if you want it to be the same as the source image.
     * 
     * @param lockType
     */
    public void setLockType(PixlrImageType lockType) {
        this.lockType = lockType;
    }

    /**
     * Gets the jpg quality when the user saves the image, values are 0-100.
     * 
     * @return
     */
    public Integer getQuality() {
        return quality;
    }

    /**
     * Sets the jpg quality when the user saves the image, values are 0-100.
     * 
     * @param quality
     */
    public void setQuality(Integer quality) {
        if ((quality != null) && (quality < 0 || quality > 100))
            throw new IllegalArgumentException("JPG  image 'quality' must be within [0-100]!");
        this.quality = quality;
    }

    /**
     * Indicates the visibility of a checkbox on the save dialog that lets the user select
     * "Save as copy".
     * 
     * @return
     */
    public boolean isCopy() {
        return copy;
    }

    /**
     * Sets the visibility of a checkbox on the save dialog that lets the user select "Save as copy"
     * 
     * @param copy
     */
    public void setCopy(boolean copy) {
        this.copy = copy;
    }

    /**
     * Gets the maximum width of an image the user saves.
     * 
     * @return
     */
    public Integer getMaxWidth() {
        return maxWidth;
    }

    /**
     * Sets the maximum width of an image the user saves.
     * 
     * @param maxWidth
     */
    public void setMaxWidth(Integer maxWidth) {
        if (maxWidth != null && maxWidth <= 0)
            throw new IllegalArgumentException("'maxWidth' must be greater than 0!");
        this.maxWidth = maxWidth;
    }

    /**
     * Gets the maximum height of an image the user saves.
     * 
     * @return
     */
    public Integer getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the maximum height of an image the user saves.
     * 
     * @param maxHeight
     */
    public void setMaxHeight(Integer maxHeight) {
        if (maxHeight != null && maxHeight <= 0)
            throw new IllegalArgumentException("'maxHeight' must be greater than 0!");
        this.maxHeight = maxHeight;
    }

    /**
     * Gets the flash wmode, possible values are one of {@link PixlrWmode}.
     * 
     * @return
     */
    public PixlrWmode getWmode() {
        return wmode;
    }

    /**
     * Sets the flash wmode when you need to use z-index and float HTML over the flash area.
     * 
     * @param wmode
     */
    public void setWmode(PixlrWmode wmode) {
        this.wmode = wmode;
    }

    /**
     * Gets the 'Pixlr' service, one of the value of {@link PixlrService}.
     */
    public PixlrService getService() {
        return service;
    }

    /**
     * Sets the 'Pixlr' service, one of the value of {@link PixlrService}.
     * 
     * @param service
     */
    public void setService(PixlrService service) {
        this.service = service;
    }

    /**
     * Adds an additional parameter to the result.
     * 
     * @param parameterName
     * @param parameterValue
     */
    protected void addParameter(String parameterName, String parameterValue) {
        moreParams.put(parameterName, parameterValue);
    }

    /**
     * Gets the named additional parameter that has been sent to 'Pixlr' via the 'Target URL'
     * parameter.
     * 
     * @param parameterName
     * @return
     */
    public String getParameter(String parameterName) {
        return moreParams.get(parameterName);
    }

    /**
     * Gets the map of additional parameters.
     * 
     * @return
     */
    public Map<String, String> getAdditionalParameters() {
        return moreParams;
    }
}
