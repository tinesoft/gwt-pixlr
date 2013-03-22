
package com.tinesoft.gwt.pixlr.showcase.client.core;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.tinesoft.gwt.pixlr.showcase.client.util.GWTLog;

/**
 * Custom AsyncCallback that will display automatically the error page on failure.
 * 
 * @param <T> callback result.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public abstract class DefaultAsyncCallback<T> implements AsyncCallback<T> {

    private final PlaceManager placeManager;

    /**
     * Constructor.
     * 
     * @param placeManager the {@link PlaceManager}.
     */
    public DefaultAsyncCallback(final PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    @Override
    public void onFailure(final Throwable caught) {
        final String token = placeManager.getCurrentPlaceRequest().getNameToken();
        GWTLog.error("FAILURE: {}", token);
        GWTLog.error("  exception: ", caught);
        placeManager.revealErrorPlace(token);
    }
}
