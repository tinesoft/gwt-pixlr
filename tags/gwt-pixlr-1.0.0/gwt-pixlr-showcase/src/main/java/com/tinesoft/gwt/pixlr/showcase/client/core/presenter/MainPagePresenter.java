
package com.tinesoft.gwt.pixlr.showcase.client.core.presenter;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;
import com.tinesoft.gwt.pixlr.showcase.client.core.event.RevealNestedPresenterEvent;

/**
 * Main page presenter.
 * 
 * @author Tine Kondo
 */
public class MainPagePresenter extends Presenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy> {

    /**
     * {@link Messages} for {@link MainPagePresenter}.
     */
    public interface I18nMessages extends Messages {

        /**
         * @return the i18n message.
         */
        @DefaultMessage("You are about to close or reload the application. Are you sure you want to proceed ?")
        String warning();
    }

    /**
     * {@link Proxy} for {@link MainPagePresenter}.
     */
    @ProxyStandard
    public interface MyProxy extends Proxy<MainPagePresenter> {
    }

    /**
     * {@link View} for {@link MainPagePresenter}.
     */
    public interface MyView extends View {
    }

    private static class WindowCloseHandler implements CloseHandler<Window> {

        @Override
        public void onClose(final CloseEvent<Window> event) {}
    }

    private static class WindowClosingHandler implements Window.ClosingHandler {

        private final I18nMessages i18n;

        WindowClosingHandler(final I18nMessages i18n) {
            super();
            this.i18n = i18n;
        }

        @Override
        public void onWindowClosing(final ClosingEvent event) {
            // event.setMessage(i18n.warning());
        }
    }

    /**
     * Main page 'content' slot.
     */
    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_CONTENT_SLOT = new Type<RevealContentHandler<?>>();

    /**
     * Main page 'header' slot.
     */
    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_HEADER_SLOT = new Type<RevealContentHandler<?>>();

    /**
     * Main page 'footer' slot.
     */
    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_FOOTER_SLOT = new Type<RevealContentHandler<?>>();

    /**
     * Main page 'sidebar' slot.
     */
    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_SIDEBAR_SLOT = new Type<RevealContentHandler<?>>();

    /**
     * Constructor.
     * 
     * @param eventBus the {@link EventBus}.
     * @param view the {@link MyView}.
     * @param proxy the {@link MyProxy}.
     * @param i18n the {@link I18nMessages}.
     */
    @Inject
    public MainPagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy, final I18nMessages i18n) {
        super(eventBus, view, proxy);

        // prevent the application from directly reloading when the user press 'F5' or click on
        // 'refresh'
        Window.addWindowClosingHandler(new WindowClosingHandler(i18n));
        Window.addCloseHandler(new WindowCloseHandler());
    }

    @Override
    public void onReveal() {
        super.onReveal();
        RevealNestedPresenterEvent.fire(this);
    }

    @Override
    protected void revealInParent() {
        // since we use a {@link DockLayoutPanel} we need to change this from
        // {@code RevealRootContentEvent.fire(this, this);} to
        // {@code RevealRootLayoutContentEvent.fire(this, this);}
        RevealRootLayoutContentEvent.fire(this, this);
    }
}
