
package com.tinesoft.gwt.pixlr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.Widget;

import com.tinesoft.gwt.pixlr.client.core.PixlrSendMethod;
import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.client.resources.PixlrWidgetResources;
import com.tinesoft.gwt.pixlr.client.util.PixlrUtils;

/**
 * Main widget that allows to integrate 'Pixlr' editor view as GWT widget.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public class PixlrWidget extends Composite {

    interface PixlrWidgetUiBinder extends UiBinder<Widget, PixlrWidget> {
    }

    private static PixlrWidgetResources getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            DEFAULT_RESOURCES = GWT.create(PixlrWidgetResources.class);
        }
        return DEFAULT_RESOURCES;
    }

    @UiField(provided = true)
    NamedFrame targetFrame;

    @UiField(provided = true)
    FormPanel formPanel;

    @UiField(provided = true)
    PixlrWidgetResources resources;

    private PixlrSettings settings;

    private static PixlrWidgetUiBinder uiBinder = GWT.create(PixlrWidgetUiBinder.class);

    private static PixlrWidgetResources DEFAULT_RESOURCES = null;

    private static final String GWTP_TARGET_IFRAME_NAME = "gwtp-target-iframe";

    /**
     * Default constructor.
     */
    public PixlrWidget() {
        this(null, getDefaultResources());
    }

    /**
     * 
     * @param settings
     * @param resources a custom {@link PixlrWidgetResources} to change css, images used by the
     *            widget
     */
    public PixlrWidget(final PixlrSettings settings, final PixlrWidgetResources resources) {
        this.settings = settings;
        this.resources = resources;
        targetFrame = new NamedFrame(GWTP_TARGET_IFRAME_NAME);
        formPanel = new FormPanel(targetFrame);
        formPanel.setWidget(new FlowPanel());
        initWidget(uiBinder.createAndBindUi(this));

        // make sure that the css get injected
        resources.css().ensureInjected();
    }

    /**
     * Gets the inner {@link PixlrSettings settings} used by the widget.
     * 
     * @return the Pixlr settings
     */
    public PixlrSettings getSettings() {
        return settings;
    }

    private void initialize() {

        // initialize the form panel based on given settings
        PixlrUtils.buildFormPanel(formPanel, settings, resources);

        // when using GET, the image is defined via URL, so we can directly submit the form
        // otherwise, it will be automatically submitted once the user chooses a file from its
        // computer.

        if (PixlrSendMethod.GET.equals(settings.getMethod())) {
            formPanel.submit();
        }
    }

    @UiHandler("formPanel")
    protected void onFormSubmitCompleted(final SubmitCompleteEvent submitCompleteEvent) {
        targetFrame.removeStyleName(resources.css().loadingIcon());
    }

    @UiHandler("formPanel")
    protected void onFormSubmitted(final SubmitEvent submitEvent) {
        targetFrame.addStyleName(resources.css().loadingIcon());
    }

    @UiHandler("targetFrame")
    protected void onFrameLoad(final LoadEvent loadEvent) {
        targetFrame.removeStyleName(resources.css().loadingIcon());
    }

    @Override
    protected void onLoad() {
        targetFrame.setWidth(getElement().getStyle().getWidth());
        targetFrame.setHeight(getElement().getStyle().getHeight());

        // initialize();
    }

    /**
     * Sets the inner {@link PixlrSettings settings} used by the widget and reloads it.
     * 
     * @param settings the Pixlr settings
     */
    public void setSettings(final PixlrSettings settings) {
        this.settings = settings;
        initialize();
    }

}
