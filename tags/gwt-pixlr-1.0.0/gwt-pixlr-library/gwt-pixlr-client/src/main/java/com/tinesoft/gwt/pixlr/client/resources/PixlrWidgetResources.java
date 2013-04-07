
package com.tinesoft.gwt.pixlr.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;

import com.tinesoft.gwt.pixlr.client.ui.PixlrWidget;

/**
 * Client bundle for the {@link PixlrWidget} css and image resources.
 * 
 * @author Tine Kondo
 */
public interface PixlrWidgetResources extends ClientBundle {

    /**
     * CSS Style for the PixlrWidget.
     * 
     * @author Tine Kondo
     * @version $Id$
     */
    interface PixlrWidgetStyle extends BaseStyle {

        /**
         * Defines the style of a button.
         * 
         * @return the 'button' css class name
         */
        String button();

        /**
         * Defines the style of form panel used to send parameters to 'Pixlr' service.
         * 
         * @return the 'formPanel' css class name
         */
        String formPanel();

        /**
         * Defines the style of a large button (used for the 'upload button')
         * 
         * @return the 'largeButton' css class name
         */
        String largeButton();

        /**
         * Defines the style of the loading indicator that appears when calling 'Pixlr' service.
         * 
         * @return the 'loadingIcon' css class name
         */
        String loadingIcon();

        /**
         * Defines the style of the target iframe that displays the 'Pixlr' service view.
         * 
         * @return the 'targetFrame' css class name
         */
        String targetFrame();

        /**
         * Defines the style of the 'upload button', displayed when using 'POST' method to contact
         * 'Pixlr'.
         * 
         * @return the 'uploadButton' css class name
         */
        String uploadButton();

        /**
         * Defines the style of the 'upload icon', displayed next to the button text.
         * 
         * @return the 'uploadIcon' css class name
         */
        String uploadIcon();

        /**
         * Defines the style of panel containing the 'upload button', displayed when using 'POST'
         * method to contact 'Pixlr'.
         * 
         * @return the 'uploadPanel' css class name
         */
        String uploadPanel();

        /**
         * Defines the style of the 'upload button' text.
         * 
         * @return the 'uploadText' css class name
         */
        String uploadText();
    }

    /**
     * The path to the default CSS styles used by this resource.
     */
    String DEFAULT_CSS = "com/tinesoft/gwt/pixlr/client/resources/PixlrWidgetStyle.css";

    @Source({ BaseStyle.DEFAULT_CSS, DEFAULT_CSS })
    @NotStrict
    PixlrWidgetStyle css();

    @Source("images/loading.gif")
    ImageResource loading();

    @Source("images/upload.png")
    ImageResource upload();
}
