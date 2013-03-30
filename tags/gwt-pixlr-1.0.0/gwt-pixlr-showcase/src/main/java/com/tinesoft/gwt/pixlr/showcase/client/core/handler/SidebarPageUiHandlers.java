
package com.tinesoft.gwt.pixlr.showcase.client.core.handler;

import com.gwtplatform.mvp.client.UiHandlers;

import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;

/**
 * Sidebar page handler.
 * 
 * @author Tine Kondo
 */
public interface SidebarPageUiHandlers extends UiHandlers {

    /**
     * Fired when the Pixlr settings have been changed and validated.
     * 
     * @param settings
     */
    void onPixlrSettingsValidated(PixlrSettings settings);

}
