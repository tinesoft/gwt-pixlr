
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
     * The path to the default CSS styles used by this resource.
     */
    String DEFAULT_CSS = "com/tinesoft/gwt/pixlr/client/resources/PixlrWidgetStyle.css";

    /**
     * CSS Style for the PixlrWidget.
     * 
     * @author Tine Kondo
     * @version $Id$
     */
    interface PixlrWidgetStyle extends BaseStyle {

        /**
         * Defines the style of the target iframe that displays the 'Pixlr' service view.
         * 
         * @return
         */
        String targetFrame();

        /**
         * Defines the style of form panel used to send parameters to 'Pixlr' service.
         * 
         * @return
         */
        String formPanel();

        /**
         * Defines the style of the 'upload button', displayed when using 'POST' method to contact
         * 'Pixlr'.
         * 
         * @return
         */
        String uploadButton();

        /**
         * Defines the style of a large button (used for the 'upload button')
         * 
         * @return
         */
        String largeButton();

        /**
         * Defines the style of a button.
         * 
         * @return
         */
        String button();

        /**
         * Defines the style of the loading indicator that appears when calling 'Pixlr' service.
         * 
         * @return
         */
        String loading();
    }

    @Source({ BaseStyle.DEFAULT_CSS, DEFAULT_CSS })
    @NotStrict
    PixlrWidgetStyle css();

    @Source("images/loading.gif")
    ImageResource loading();

}
