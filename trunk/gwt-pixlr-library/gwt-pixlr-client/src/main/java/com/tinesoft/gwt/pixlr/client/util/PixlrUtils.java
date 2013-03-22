
package com.tinesoft.gwt.pixlr.client.util;

import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;

/**
 * Utility class for Pixlr
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class PixlrUtils {

    public static final String PIXLR_BASE_URL = "http://pixlr.com/";

    /**
     * The name of the referring service for example "Your site name" or "Facebook"
     */
    public static final String REFERRER = "referrer";
    /**
     * A url to a 16*16 icon to be shown at the save tab
     */
    public static final String ICON = "icon";
    /**
     * The URL to send the visitor if the user click exit/close
     */
    public static final String EXIT = "exit";
    /**
     * A URL to the image or the post raw data of the image to open
     */
    public static final String IMAGE = "image";
    /**
     * The title of the opened image
     */
    public static final String TITLE = "title";
    /**
     * The filetype of the image, just type no ".", the apps will try to get the type from the URL
     * if type param is not provided.
     */
    public static final String TYPE = "type";

    /**
     * The URL to which we send the image information when saving
     */
    public static final String TARGET = "target";
    /**
     * Set to "false" if you don't want the browser to follow the save post. i.e the user stay in
     * the editor after saving.
     */
    public static final String REDIRECT = "redirect";
    /**
     * Remove the possibility for the user to "save to computer" and other service in Pixlr Editor
     */
    public static final String LOCK_TARGET = "locktarget";
    /**
     * Lock the image title so the user can't change it
     */
    public static final String LOCK_TITLE = "locktitle";
    /**
     * Lock the save format, values are jpg, png, bmp, pxd or source, do not include "."
     */
    public static final String LOCK_TYPE = "locktype";
    /**
     * Set the jpg quality when the user saves the image, values are 0-100
     */
    public static final String QUALITY = "quality";
    /**
     * Shows a checkbox on the save dialog that lets the user select "Save as copy"
     */
    public static final String COPY = "copy";
    /**
     * Set the maximum width of an image the user saves
     */
    public static final String MAX_WIDTH = "maxwidth";
    /**
     * Set the maximum height of an image the user saves
     */
    public static final String MAX_HEIGHT = "maxheight";
    /**
     * (Advanced) Change the flash wmode (transparent, opaque, window etc) when you need to use
     * z-index and float HTML over the flash area
     */
    public static final String WMODE = "wmode ";

    /**
     * Utility class. No public constructor.
     */
    private PixlrUtils() {

    }

    /**
     * Initializes the given {@link FormPanel formPanel} used to send the request to 'Pixlr', based
     * on the given {@link PixlrSettings settings}.
     * <p>
     * It automatically sets the form's method and encoding and only adds to it defined parameters.
     * </p>
     * 
     * @param formPanel the formPanel
     * @param settings the parameters used to call 'Pixlr'
     */
    public static void buildFormPanel(FormPanel formPanel, PixlrSettings settings) {

        if (settings == null)
            throw new IllegalArgumentException(
                    "PixlrUtils.buildFormPanel(): 'settings' cannot be null!");

        if (formPanel == null)
            throw new IllegalArgumentException(
                    "PixlrUtils.buildFormPanel(): 'formPanel' cannot be null!");

        if (settings.getService() == null) {
            throw new IllegalArgumentException(
                    "PixlrUtils.buildFormPanel(): 'PixlrSettings.getService()' cannot be null!");
        }

        final StringBuilder sb = new StringBuilder();
        sb.append(PIXLR_BASE_URL);
        sb.append(settings.getService().getValue());
        sb.append("/");

        // setting the form panel action URL
        formPanel.setAction(sb.toString());

        Panel formFieldsHolder;
        if (formPanel.getWidget() == null) {
            formFieldsHolder = new VerticalPanel();
            formPanel.setWidget(formFieldsHolder);
        } else {
            assert formPanel.getWidget() instanceof Panel : "'formPanel' inner widget must be an instance of 'VerticalPanel'";
            formFieldsHolder = (VerticalPanel) formPanel.getWidget();
            formFieldsHolder.clear();

        }

        // setting the form panel method and encoding
        switch (settings.getMethod()) {
            case POST:
                formPanel.setMethod(FormPanel.METHOD_POST);
                formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
                break;
            default:
                formPanel.setMethod(FormPanel.METHOD_GET);
                formPanel.setEncoding(FormPanel.ENCODING_URLENCODED);

                // add the 'image' parameter
                if (StringUtils.isNotBlank(settings.getImage())) {
                    Hidden imageField = new Hidden(IMAGE, settings.getImage());
                    formFieldsHolder.add(imageField);
                } else
                    throw new IllegalArgumentException(
                            "'image' parameter cannot be null when using 'GET' method to request 'Pixlr'!");

        }

        // add the 'referrer' parameter when defined
        if (StringUtils.isNotBlank(settings.getReferrer())) {
            Hidden referrerField = new Hidden(REFERRER, settings.getReferrer());
            formFieldsHolder.add(referrerField);
        }

        // add the 'icon' parameter when defined
        if (StringUtils.isNotBlank(settings.getIcon())) {
            Hidden iconField = new Hidden(ICON, settings.getIcon());
            formFieldsHolder.add(iconField);
        }

        // add the 'exit' parameter when defined
        if (StringUtils.isNotBlank(settings.getExit())) {
            Hidden exitField = new Hidden(EXIT, settings.getExit());
            formFieldsHolder.add(exitField);
        }

        // add the 'title' parameter when defined
        if (StringUtils.isNotBlank(settings.getTitle())) {
            Hidden titleField = new Hidden(TITLE, settings.getTitle());
            formFieldsHolder.add(titleField);
        }

        // add the 'type' parameter when defined
        if (settings.getType() != null) {
            Hidden typeField = new Hidden(TYPE, settings.getType().toString().toLowerCase());
            formFieldsHolder.add(typeField);
        }

        // add the 'target' parameter when defined
        if (StringUtils.isNotBlank(settings.getTarget())) {
            Hidden targetField = new Hidden(TARGET, settings.getTitle());
            formFieldsHolder.add(targetField);
        }

        // add the 'redirect' parameter
        formFieldsHolder.add(new Hidden(REDIRECT, settings.isRedirect() ? "true" : "false"));

        // add the 'lockTarget' parameter
        formFieldsHolder.add(new Hidden(LOCK_TARGET, settings.isLockTarget() ? "true" : "false"));

        // add the 'lockTitle' parameter
        formFieldsHolder.add(new Hidden(LOCK_TITLE, settings.isLockTitle() ? "true" : "false"));

        // add the 'lockType' parameter when defined
        if (settings.getLockType() != null) {
            Hidden lockTypeField = new Hidden(LOCK_TYPE,
                    settings.getLockType().toString().toLowerCase());
            formFieldsHolder.add(lockTypeField);
        }

        // add the 'quality' parameter when valid
        if (settings.getQuality() != null) {
            Hidden qualityField = new Hidden(QUALITY, String.valueOf(settings.getQuality()));
            formFieldsHolder.add(qualityField);
        }

        // add the 'copy' parameter
        formFieldsHolder.add(new Hidden(COPY, settings.isCopy() ? "true" : "false"));

        // add the 'maxWidth' parameter when valid
        if (settings.getMaxWidth() != null) {
            Hidden maxWidthField = new Hidden(MAX_WIDTH, String.valueOf(settings.getMaxWidth()));
            formFieldsHolder.add(maxWidthField);
        }

        // add the 'maxHeight' parameter when valid
        if (settings.getMaxHeight() != null) {
            Hidden maxHeightField = new Hidden(MAX_HEIGHT, String.valueOf(settings.getMaxHeight()));
            formFieldsHolder.add(maxHeightField);
        }

        // add the 'wmode' parameter when defined
        if (settings.getWmode() != null) {
            Hidden wmodeField = new Hidden(WMODE, settings.getWmode().toString().toLowerCase());
            formFieldsHolder.add(wmodeField);
        }
    }
}
