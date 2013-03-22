
package com.tinesoft.gwt.pixlr.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtplatform.mvp.client.DelayedBindRegistry;
import com.tinesoft.gwt.pixlr.showcase.client.gin.ClientGinjector;
import com.tinesoft.gwt.pixlr.showcase.client.resources.ShowcaseResources;
import com.tinesoft.gwt.pixlr.showcase.client.util.GWTLog;

/**
 * Entry point to GWT Dialogs Showcase Application.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class ShowcaseApp implements EntryPoint {

    private static final ClientGinjector GINJECTOR = GWT.create(ClientGinjector.class);

    /**
     * Returns the GIN dependency injector container.
     * 
     * @return the GIN-jector container.
     */
    public static ClientGinjector getClientGinjector() {
        return GINJECTOR;
    }

    @Override
    public void onModuleLoad() {

        // defer all application initialization code to onDeferredLoad() so that the
        // UncaughtExceptionHandler can catch any unexpected exceptions.
        GWTLog.setUncaughtExceptionHandler();

        // we ensure that css are injected
        ((ShowcaseResources) GWT.create(ShowcaseResources.class)).css().ensureInjected();

        Scheduler.get().scheduleDeferred(new Command() {

            @Override
            public void execute() {
                onDeferredLoad();
            }
        });

    }

    private void onDeferredLoad() {
        long startTimeMillis = 0;
        try {
            // use a code guard e.g. "if (Log.isDebugEnabled() {...}"
            // to ensure unnecessary code is compiled out when log_level=OFF
            // or any log_level higher than DEBUG
            if (GWTLog.isDebugEnabled()) {
                startTimeMillis = System.currentTimeMillis();
            }
            // no code guard necessary as the code will be
            // compiled out when log_level=OFF
            GWTLog.debug("GWT Dialogs Showcase - onDeferredLoad()");

            // required by gwt-platform proxy's generator
            DelayedBindRegistry.bind(GINJECTOR);

            // hide the animated 'loading.gif'
            RootPanel.get("loading").setVisible(false);

            // display page
            getClientGinjector().getPlaceManager().revealCurrentPlace();

            if (GWTLog.isDebugEnabled()) {
                final long endTimeMillis = System.currentTimeMillis();
                final float durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
                GWTLog.debug("Duration: " + durationSeconds + " seconds");
            }
        } catch (final Exception ex) {
            GWTLog.error("INITIALIZATION FAILURE: ", ex);
        }
    }
}
