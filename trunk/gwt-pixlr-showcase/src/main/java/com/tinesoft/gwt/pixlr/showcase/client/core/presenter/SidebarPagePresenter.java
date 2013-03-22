
package com.tinesoft.gwt.pixlr.showcase.client.core.presenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.client.event.PixlrSettingsValidatedEvent;
import com.tinesoft.gwt.pixlr.showcase.client.core.event.RevealNestedPresenterEvent;
import com.tinesoft.gwt.pixlr.showcase.client.core.event.RevealNestedPresenterHandler;
import com.tinesoft.gwt.pixlr.showcase.client.core.handler.SidebarPageUiHandlers;

/**
 * Sidebar page presenter.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class SidebarPagePresenter extends Presenter<SidebarPagePresenter.MyView, SidebarPagePresenter.MyProxy> implements SidebarPageUiHandlers, RevealNestedPresenterHandler {

    public interface MyView extends View, HasUiHandlers<SidebarPageUiHandlers> {
    }

    @ProxyStandard
    public interface MyProxy extends Proxy<SidebarPagePresenter> {
    }

    @Inject
    public SidebarPagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy, final PlaceManager placeManager) {
        super(eventBus, view, proxy);
        getView().setUiHandlers(this);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainPagePresenter.TYPE_SIDEBAR_SLOT, this);
    }

    @Override
    public void onPixlrSettingsValidated(PixlrSettings settings) {

        // fires the event on the bus, so that it can be handler by any interested presenter
        PixlrSettingsValidatedEvent.fire(this, settings);
    }

    @ProxyEvent
    @Override
    public void onRevealNestedPresenter(final RevealNestedPresenterEvent event) {
        /*
         * This is the only way to show multiple nested presenters that have no dependency between
         * themselves. The parent or container presenter fires an event when he is revealed and
         * tells all of his children to reveal themselves also.<br /> We could call {@code
         * #forceReveal()} but then we are not allowed to have 2nd level nested presenters.
         * Fortunately it seems that {@code #revealInParent()} works also.
         */
        revealInParent();
    }
}
