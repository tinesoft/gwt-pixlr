
package com.tinesoft.gwt.pixlr.showcase.client.core.view;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import com.tinesoft.gwt.pixlr.client.event.PixlrSettingsValidatedEvent;
import com.tinesoft.gwt.pixlr.client.ui.PixlrSettingsBuilderWidget;
import com.tinesoft.gwt.pixlr.showcase.client.core.handler.SidebarPageUiHandlers;
import com.tinesoft.gwt.pixlr.showcase.client.core.presenter.SidebarPagePresenter;
import com.tinesoft.gwt.pixlr.showcase.client.resources.ShowcaseResources;

/**
 * Sidebar page view.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
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
