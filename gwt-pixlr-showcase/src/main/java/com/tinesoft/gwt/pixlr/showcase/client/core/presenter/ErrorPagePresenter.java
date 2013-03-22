
package com.tinesoft.gwt.pixlr.showcase.client.core.presenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.tinesoft.gwt.pixlr.showcase.client.core.handler.ErrorPageUiHandlers;
import com.tinesoft.gwt.pixlr.showcase.client.place.NameTokens;

/**
 * Default error presenter.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class ErrorPagePresenter extends Presenter<ErrorPagePresenter.MyView, ErrorPagePresenter.MyProxy> implements ErrorPageUiHandlers {

    /**
     * {@link ProxyPlace} for {@link ErrorPagePresenter}.
     */
    @ProxyStandard
    @NameToken(NameTokens.error)
    public interface MyProxy extends ProxyPlace<ErrorPagePresenter> {
    }

    /**
     * {@link View} for {@link ErrorPagePresenter}.
     */
    public interface MyView extends View, HasUiHandlers<ErrorPageUiHandlers> {
    }

    private final PlaceManager placeManager;

    /**
     * Constructor.
     * 
     * @param eventBus the {@link EventBus}.
     * @param view the {@link MyView}.
     * @param proxy the {@link MyProxy}.
     * @param placeManager the {@link PlaceManager}.
     */
    @Inject
    public ErrorPagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy, final PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
    }

    @Override
    public void onReTryClicked() {
        placeManager.revealDefaultPlace();
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}
