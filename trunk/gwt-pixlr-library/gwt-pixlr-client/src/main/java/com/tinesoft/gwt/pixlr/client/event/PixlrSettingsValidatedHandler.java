
package com.tinesoft.gwt.pixlr.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Custom event handler that fires {@link PixlrSettingsValidatedEvent}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public interface PixlrSettingsValidatedHandler extends EventHandler {

    void onSettingsChanged(PixlrSettingsValidatedEvent event);
}
