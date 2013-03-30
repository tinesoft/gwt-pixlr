
package com.tinesoft.gwt.pixlr.showcase.client.core.view;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import com.tinesoft.gwt.pixlr.showcase.client.core.presenter.MainPagePresenter;
import com.tinesoft.gwt.pixlr.showcase.client.util.GWTLog;

/**
 * Main page view.
 * <p>
 * This view only contains custom slots and we can change their content at will.
 * </p>
 * 
 * @author Tine Kondo
 */
public class MainPageView extends ViewImpl implements MainPagePresenter.MyView {

    /**
     * {@link UiBinder} for {@link MainPageView}.
     */
    public interface MyUiBinder extends UiBinder<Widget, MainPageView> {
    }

    private final Widget widget;

    @UiField
    ComplexPanel content;

    @UiField
    ComplexPanel header;

    @UiField
    ComplexPanel footer;

    @UiField
    ComplexPanel sidebar;

    /**
     * Constructor.
     * 
     * @param ui the {@link UiBinder}.
     */
    @Inject
    public MainPageView(final MyUiBinder ui) {
        widget = ui.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    @Override
    public void setInSlot(final Object slot, final Widget widget) {
        /*
         * Override the parent method to add widgets into custom slots. This allows us to share the
         * same layout on all pages since we will just override the content of the slot we want to
         * use.
         */
        if (slot == MainPagePresenter.TYPE_CONTENT_SLOT) {
            setContent(widget);
        } else if (slot == MainPagePresenter.TYPE_HEADER_SLOT) {
            setHeader(widget);
        } else if (slot == MainPagePresenter.TYPE_FOOTER_SLOT) {
            setFooter(widget);
        } else if (slot == MainPagePresenter.TYPE_SIDEBAR_SLOT) {
            setSidebar(widget);
        } else {
            GWTLog.debug("'slot' did not match any of the existing slots, default slot was used instead");
            super.setInSlot(slot, widget);
        }
    }

    private void setContent(final Widget widget) {
        GWTLog.debug("add widget in 'content' slot");
        content.clear();
        if (null != widget) {
            content.add(widget);
        }
    }

    private void setFooter(final Widget widget) {
        GWTLog.debug("add widget in 'footer' slot");
        footer.clear();
        if (null != widget) {
            footer.add(widget);
        }
    }

    private void setHeader(final Widget widget) {
        GWTLog.debug("add widget in 'header' slot");
        header.clear();
        if (null != widget) {
            header.add(widget);
        }
    }

    private void setSidebar(final Widget widget) {
        GWTLog.debug("add widget in 'sidebar' slot");
        sidebar.clear();
        if (null != widget) {
            sidebar.add(widget);
        }
    }

}
