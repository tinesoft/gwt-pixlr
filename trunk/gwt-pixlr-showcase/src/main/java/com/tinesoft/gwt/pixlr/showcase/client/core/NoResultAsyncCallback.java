
package com.tinesoft.gwt.pixlr.showcase.client.core;

import com.gwtplatform.mvp.client.proxy.PlaceManager;

/**
 * Custom AsyncCallback that is used when there is no result to return.
 * 
 * @param <T> callback result.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class NoResultAsyncCallback<T> extends DefaultAsyncCallback<T> {

    /**
     * Constructor.
     * 
     * @param placeManager the {@link PlaceManager}.
     */
    public NoResultAsyncCallback(final PlaceManager placeManager) {
        super(placeManager);
    }

    @Override
    public void onSuccess(final T result) {
        // nothing to do since we have an empty result
    }
}
