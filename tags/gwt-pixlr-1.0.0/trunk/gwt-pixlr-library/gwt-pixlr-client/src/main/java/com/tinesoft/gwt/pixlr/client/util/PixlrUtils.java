
package com.tinesoft.gwt.pixlr.client.util;

import java.util.Map.Entry;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.client.resources.PixlrWidgetResources;

/**
 * Utility class for Pixlr
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public class PixlrUtils {

    public static final String PIXLR_BASE_URL = "http://pixlr.com/";

    /**
     * The name of the referring service for example "Your site name" or "Facebook"
     */
    public static final String REFERRER_PARAM = "referrer";
    /**
     * A url to a 16*16 icon to be shown at the save tab
     */
    public static final String ICON_PARAM = "icon";
    /**
     * The URL to send the visitor if the user click exit/close
     */
    public static final String EXIT_PARAM = "exit";
    /**
     * A URL to the image or the post raw data of the image to open
     */
    public static final String IMAGE_PARAM = "image";
    /**
     * The title of the opened image
     */
    public static final String TITLE_PARAM = "title";
    /**
     * The filetype of the image, just type no ".", the apps will try to get the type from the URL
     * if type param is not provided.
     */
    public static final String TYPE_PARAM = "type";

    /**
     * The URL to which we send the image information when saving
     */
    public static final String TARGET_PARAM = "target";
    /**
     * Set to "false" if you don't want the browser to follow the save post. i.e the user stay in
     * the editor after saving.
     */
    public static final String REDIRECT_PARAM = "redirect";
    /**
     * Remove the possibility for the user to "save to computer" and other service in Pixlr Editor
     */
    public static final String LOCK_TARGET_PARAM = "locktarget";
    /**
     * Lock the image title so the user can't change it
     */
    public static final String LOCK_TITLE_PARAM = "locktitle";
    /**
     * Lock the save format, values are jpg, png, bmp, pxd or source, do not include "."
     */
    public static final String LOCK_TYPE_PARAM = "locktype";
    /**
     * Set the jpg quality when the user saves the image, values are 0-100
     */
    public static final String QUALITY_PARAM = "quality";
    /**
     * Shows a checkbox on the save dialog that lets the user select "Save as copy"
     */
    public static final String COPY_PARAM = "copy";
    /**
     * Set the maximum width of an image the user saves
     */
    public static final String MAX_WIDTH_PARAM = "maxwidth";
    /**
     * Set the maximum height of an image the user saves
     */
    public static final String MAX_HEIGHT_PARAM = "maxheight";
    /**
     * (Advanced) Change the flash wmode (transparent, opaque, window etc) when you need to use
     * z-index and float HTML over the flash area
     */
    public static final String WMODE_PARAM = "wmode ";

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
     * @param formPanel the form panel
     * @param settings the parameters used to call 'Pixlr'
     * @param resources the resources used to stylish the widget
     */
    public static void buildFormPanel(final FormPanel formPanel, final PixlrSettings settings, final PixlrWidgetResources resources) {

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
            assert formPanel.getWidget() instanceof VerticalPanel : "'formPanel' inner widget must be an instance of 'VerticalPanel'";
            formFieldsHolder = (VerticalPanel) formPanel.getWidget();
            formFieldsHolder.clear();

        }

        // setting the form panel method and encoding
        switch (settings.getMethod()) {
            case POST:
                formPanel.setMethod(FormPanel.METHOD_POST);
                formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);

                // when using "POST", we must submit the image to 'Pixlr' as raw data attached
                // to the form. This means that the user must be able to select a file from his
                // computer and then upload it.This can be done via a FileUpload widget (<input
                // type="file"...>)

                final FileUpload fileUploadField = new FileUpload();
                fileUploadField.setName(PixlrUtils.IMAGE_PARAM);

                fileUploadField.addStyleName(resources.css().button());
                fileUploadField.addStyleName(resources.css().largeButton());
                fileUploadField.addStyleName(resources.css().uploadButton());
                // FIXME: fileUploadField.getElement().setPropertyString("accept", mimeList);

                // we auto submit the form once a valid image has been chosen
                fileUploadField.addChangeHandler(new ChangeHandler() {

                    @Override
                    public void onChange(ChangeEvent event) {
                        if (StringUtils.isNotBlank(fileUploadField.getFilename()))
                            // FIXME: check uploaded file type against supported image types
                            fileUploadField.setVisible(false);
                        formPanel.submit();
                    }
                });

                formFieldsHolder.add(fileUploadField);
                break;
            default:
                formPanel.setMethod(FormPanel.METHOD_GET);
                formPanel.setEncoding(FormPanel.ENCODING_URLENCODED);

                // add the 'image' parameter
                if (StringUtils.isNotBlank(settings.getImage())) {
                    Hidden imageField = new Hidden(IMAGE_PARAM, settings.getImage());
                    formFieldsHolder.add(imageField);
                } else
                    throw new IllegalArgumentException(
                            "'image' parameter cannot be null when using 'GET' method to request 'Pixlr'!");

        }

        // add the 'referrer' parameter when defined
        if (StringUtils.isNotBlank(settings.getReferrer())) {
            Hidden referrerField = new Hidden(REFERRER_PARAM, settings.getReferrer());
            formFieldsHolder.add(referrerField);
        }

        // add the 'icon' parameter when defined
        if (StringUtils.isNotBlank(settings.getIcon())) {
            Hidden iconField = new Hidden(ICON_PARAM, settings.getIcon());
            formFieldsHolder.add(iconField);
        }

        // add the 'exit' parameter when defined
        if (StringUtils.isNotBlank(settings.getExit())) {
            Hidden exitField = new Hidden(EXIT_PARAM, settings.getExit());
            formFieldsHolder.add(exitField);
        }

        // add the 'title' parameter when defined
        if (StringUtils.isNotBlank(settings.getTitle())) {
            Hidden titleField = new Hidden(TITLE_PARAM, settings.getTitle());
            formFieldsHolder.add(titleField);
        }

        // add the 'type' parameter when defined
        if (settings.getType() != null) {
            Hidden typeField = new Hidden(TYPE_PARAM, settings.getType().toString().toLowerCase());
            formFieldsHolder.add(typeField);
        }

        // add the 'redirect' parameter when defined and true
        if (Boolean.TRUE.equals(settings.getRedirect()))
            formFieldsHolder.add(new Hidden(REDIRECT_PARAM, "true"));

        // add the 'lockTarget' parameter when defined and true
        if (Boolean.TRUE.equals(settings.getLockTarget()))
            formFieldsHolder.add(new Hidden(LOCK_TARGET_PARAM, "true"));

        // add the 'lockTitle' parameter when defined and true
        if (Boolean.TRUE.equals(settings.getLockTitle()))
            formFieldsHolder.add(new Hidden(LOCK_TITLE_PARAM, "true"));

        // add the 'lockType' parameter when defined
        if (settings.getLockType() != null) {
            Hidden lockTypeField = new Hidden(LOCK_TYPE_PARAM,
                    settings.getLockType().toString().toLowerCase());
            formFieldsHolder.add(lockTypeField);
        }

        // add the 'quality' parameter when valid
        if (settings.getQuality() != null) {
            Hidden qualityField = new Hidden(QUALITY_PARAM, String.valueOf(settings.getQuality()));
            formFieldsHolder.add(qualityField);
        }

        // add the 'copy' parameter when defined and true
        if (Boolean.TRUE.equals(settings.getCopy()))
            formFieldsHolder.add(new Hidden(COPY_PARAM, "true"));

        // add the 'maxWidth' parameter when valid
        if (settings.getMaxWidth() != null) {
            Hidden maxWidthField = new Hidden(MAX_WIDTH_PARAM,
                    String.valueOf(settings.getMaxWidth()));
            formFieldsHolder.add(maxWidthField);
        }

        // add the 'maxHeight' parameter when valid
        if (settings.getMaxHeight() != null) {
            Hidden maxHeightField = new Hidden(MAX_HEIGHT_PARAM,
                    String.valueOf(settings.getMaxHeight()));
            formFieldsHolder.add(maxHeightField);
        }

        // add the 'wmode' parameter when defined
        if (settings.getWmode() != null) {
            Hidden wmodeField = new Hidden(WMODE_PARAM,
                    settings.getWmode().toString().toLowerCase());
            formFieldsHolder.add(wmodeField);
        }

        // add the 'target' parameter when defined
        if (StringUtils.isNotBlank(settings.getTarget())) {

            StringBuilder target = new StringBuilder(settings.getTarget());

            // add any additional parameter to the target URL, so that they can be
            // passed along by 'Pixlr' to your handler (specified as target): that
            // is the only way, as for now (27/03/2013) to send non-API parameters
            boolean first = !target.toString().contains("?");
            for (Entry<String, String> entry : settings.getAdditionalParameters().entrySet()) {
                if (!first)
                    target.append("&");
                else {
                    target.append("?");
                    first = false;
                }

                target.append(entry.getKey());
                target.append("=");
                target.append(entry.getValue());
                target.append(";");
            }

            Hidden targetField = new Hidden(TARGET_PARAM, target.toString());
            formFieldsHolder.add(targetField);
        } else if (!settings.getAdditionalParameters().isEmpty())
            throw new IllegalArgumentException(
                    "'target' URL must be defined to send additional parameters!");

    }
}
