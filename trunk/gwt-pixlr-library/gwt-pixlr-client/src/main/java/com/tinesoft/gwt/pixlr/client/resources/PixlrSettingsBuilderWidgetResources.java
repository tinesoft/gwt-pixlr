
package com.tinesoft.gwt.pixlr.client.resources;

import com.google.gwt.resources.client.ClientBundle;

import com.tinesoft.gwt.pixlr.client.ui.PixlrSettingsBuilderWidget;

/**
 * Client bundle for the {@link PixlrSettingsBuilderWidget} css and image resources.
 * 
 * @author Tine Kondo
 */
public interface PixlrSettingsBuilderWidgetResources extends ClientBundle {

    interface PixlrSettingsBuilderWidgetStyle extends BaseStyle {

        String grid();

        String row();

        String parameterCell();

        String valueCell();
    }

    @Source({ "BaseStyle.css", "PixlrSettingsBuilderWidgetStyle.css" })
    PixlrSettingsBuilderWidgetStyle css();

}
