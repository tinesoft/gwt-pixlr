
package com.tinesoft.gwt.pixlr.showcase.client.core.presenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.showcase.client.core.event.PixlrSettingsValidatedEvent;
import com.tinesoft.gwt.pixlr.showcase.client.core.event.PixlrSettingsValidatedHandler;
import com.tinesoft.gwt.pixlr.showcase.client.core.handler.HomePageUiHandlers;
import com.tinesoft.gwt.pixlr.showcase.client.place.NameTokens;

/**
 * Home page presenter.
 * 
 * @author Tine Kondo
 */
public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> implements HomePageUiHandlers, PixlrSettingsValidatedHandler {

    public interface MyView extends View, HasUiHandlers<HomePageUiHandlers> {

        void setPixlrWidgetSettings(PixlrSettings settings);
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    public interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    @Inject
    public HomePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy, final PlaceManager placeManager) {
        super(eventBus, view, proxy);
        getView().setUiHandlers(this);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainPagePresenter.TYPE_CONTENT_SLOT, this);
    }

    @ProxyEvent
    @Override
    public void onSettingsChanged(PixlrSettingsValidatedEvent event) {
        this.getView().setPixlrWidgetSettings(event.getSettings());

    }
}
