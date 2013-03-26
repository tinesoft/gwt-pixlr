
package com.tinesoft.gwt.pixlr.showcase.client.core.view;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.client.ui.PixlrWidget;
import com.tinesoft.gwt.pixlr.showcase.client.core.handler.HomePageUiHandlers;
import com.tinesoft.gwt.pixlr.showcase.client.core.presenter.HomePagePresenter;
import com.tinesoft.gwt.pixlr.showcase.client.resources.ShowcaseResources;

/**
 * Home page view.
 * 
 * @author Tine Kondo
 */
public class HomePageView extends ViewWithUiHandlers<HomePageUiHandlers> implements HomePagePresenter.MyView {

    private final Widget widget;

    final ShowcaseResources res;

    @UiField
    PixlrWidget pixlrWidget;

    public interface Binder extends UiBinder<Widget, HomePageView> {
    }

    @Inject
    public HomePageView(final Binder binder, final ShowcaseResources resources) {
        widget = binder.createAndBindUi(this);
        res = resources;
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    /**
     * Sets the settings used by the inner PixlrWidget.
     * 
     * @param settings
     */
    public void setPixlrWidgetSettings(PixlrSettings settings) {
        pixlrWidget.setSettings(settings);
    }
}
