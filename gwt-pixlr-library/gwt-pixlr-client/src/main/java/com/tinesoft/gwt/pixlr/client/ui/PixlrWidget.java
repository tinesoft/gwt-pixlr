
package com.tinesoft.gwt.pixlr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import com.tinesoft.gwt.pixlr.client.core.PixlrSendMethod;
import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.client.resources.PixlrWidgetResources;
import com.tinesoft.gwt.pixlr.client.util.PixlrUtils;

/**
 * Main widget that allows to integrate 'Pixlr' editor as GWT widget.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public class PixlrWidget extends Composite {

    interface PixlrWidgetUiBinder extends UiBinder<Widget, PixlrWidget> {
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
    public PixlrWidget(final PixlrSettings settings, PixlrWidgetResources resources) {
        this.settings = settings;
        this.resources = resources;
        this.targetFrame = new NamedFrame(GWTP_TARGET_IFRAME_NAME);
        this.formPanel = new FormPanel(targetFrame);
        this.formPanel.setWidget(new VerticalPanel());
        initWidget(uiBinder.createAndBindUi(this));

        // make sure that the css get injected
        resources.css().ensureInjected();
    }

    @Override
    protected void onLoad() {
        targetFrame.setWidth(this.getElement().getStyle().getWidth());
        targetFrame.setHeight(this.getElement().getStyle().getHeight());

        // initialize();
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
    public void onFormSubmitted(SubmitEvent submitEvent) {
        targetFrame.addStyleName(resources.css().loading());
    }

    @UiHandler("formPanel")
    public void onFormSubmitCompleted(SubmitCompleteEvent submitCompleteEvent) {
        targetFrame.removeStyleName(resources.css().loading());
    }

    /**
     * Gets the inner {@link PixlrSettings settings} used by the widget.
     * 
     * @return
     */
    public PixlrSettings getSettings() {
        return settings;
    }

    /**
     * Sets the inner {@link PixlrSettings settings} used by the widget and reloads it.
     * 
     * @param settings
     */
    public void setSettings(PixlrSettings settings) {
        this.settings = settings;
        initialize();
    }

    private static PixlrWidgetResources getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            DEFAULT_RESOURCES = GWT.create(PixlrWidgetResources.class);
        }
        return DEFAULT_RESOURCES;
    }

}
