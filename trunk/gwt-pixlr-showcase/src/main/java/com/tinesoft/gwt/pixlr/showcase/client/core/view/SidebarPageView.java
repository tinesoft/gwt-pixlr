
package com.tinesoft.gwt.pixlr.showcase.client.core.view;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.client.event.PixlrSettingsValidatedEvent;
import com.tinesoft.gwt.pixlr.client.ui.PixlrSettingsBuilderWidget;
import com.tinesoft.gwt.pixlr.showcase.client.core.handler.SidebarPageUiHandlers;
import com.tinesoft.gwt.pixlr.showcase.client.core.presenter.SidebarPagePresenter;
import com.tinesoft.gwt.pixlr.showcase.client.resources.ShowcaseResources;

/**
 * Sidebar page view.
 * 
 * @author Tine Kondo
 */
public class SidebarPageView extends ViewWithUiHandlers<SidebarPageUiHandlers> implements SidebarPagePresenter.MyView {

    private final Widget widget;

    @UiField
    PixlrSettingsBuilderWidget pixlrSettingsBuilderWidget;

    public interface Binder extends UiBinder<Widget, SidebarPageView> {
    }

    @Inject
    public SidebarPageView(final Binder binder, final ShowcaseResources resources) {
        widget = binder.createAndBindUi(this);

        // default settings,
        final PixlrSettings settings = new PixlrSettings();
        final int i = 1 + Random.nextInt(2);

        // we pick 1 random picture of the 3 from demo page: http://developer.pixlr.com
        settings.setImage("http://developer.pixlr.com/_image/example" + i + ".jpg");
        // we set the path to our servlet, that will handle the result from 'Pixlr'
        settings.setTarget("http://gwt-pixlr.appspot.com/showcase/pixlr");

        pixlrSettingsBuilderWidget.setSettings(settings);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    @UiHandler("pixlrSettingsBuilderWidget")
    protected void onPixlrSettingsValidated(PixlrSettingsValidatedEvent event) {
        if (null != getUiHandlers()) {
            getUiHandlers().onPixlrSettingsValidated(event.getSettings());
        }
    }
}
