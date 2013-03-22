
package com.tinesoft.gwt.pixlr.showcase.client.place;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;
import com.tinesoft.gwt.pixlr.showcase.client.util.GWTLog;

/**
 * Client {@link com.gwtplatform.mvp.client.proxy.PlaceManager}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class ClientPlaceManager extends PlaceManagerImpl {

    private final PlaceRequest defaultPlaceRequest;
    private final PlaceRequest errorPlaceRequest;

    /**
     * Constructor.
     * 
     * @param eventBus the {@link EventBus}.
     * @param tokenFormatter the {@link TokenFormatter}.
     * @param defaultPlaceNameToken the default place token.
     */
    @Inject
    public ClientPlaceManager(final EventBus eventBus, final TokenFormatter tokenFormatter, @DefaultPlace final String defaultPlaceNameToken, @ErrorPlace final String errorPlaceNameToken) {
        super(eventBus, tokenFormatter);
        defaultPlaceRequest = new PlaceRequest(defaultPlaceNameToken);
        errorPlaceRequest = new PlaceRequest(errorPlaceNameToken);
    }

    @Override
    public void revealDefaultPlace() {
        revealPlace(defaultPlaceRequest);
    }

    @Override
    public void revealErrorPlace(final String token) {
        revealPlace(errorPlaceRequest);
    }

    @Override
    public void revealPlace(final PlaceRequest request, final boolean updateBrowserUrl) {
        GWTLog.debug("reveal: {}", request.getNameToken());
        super.revealPlace(request, updateBrowserUrl);
    }

    @Override
    public void revealUnauthorizedPlace(final String token) {
        revealPlace(new PlaceRequest(NameTokens.home));
    }

}
