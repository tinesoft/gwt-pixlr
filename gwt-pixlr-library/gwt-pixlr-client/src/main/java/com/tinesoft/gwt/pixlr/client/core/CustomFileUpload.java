
package com.tinesoft.gwt.pixlr.client.core;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.LocalizableResource.Generate;
import com.google.gwt.i18n.client.LocalizableResource.GenerateKeys;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import com.tinesoft.gwt.pixlr.client.resources.PixlrWidgetResources;

/**
 * Custom widget representing a {@link FileUpload} that is easily customizable.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public class CustomFileUpload extends Composite implements HasName, HasChangeHandlers {

    interface CustomizableFileUploadUiBinder extends UiBinder<Widget, CustomFileUpload> {
    }

    @Generate(format = "com.google.gwt.i18n.rebind.format.PropertiesFormat")
    @GenerateKeys("com.google.gwt.i18n.rebind.keygen.MD5KeyGenerator")
    @DefaultLocale
    interface I18nMessages extends Messages {

        @DefaultMessage("Choose image...")
        String uploadText();

    }

    @UiField
    FileUpload realFileUpload;

    @UiField
    FlowPanel fakeFileUpload;

    @UiField
    Label uploadText;

    @UiField(provided = true)
    final PixlrWidgetResources resources;

    private static CustomizableFileUploadUiBinder uiBinder = GWT.create(CustomizableFileUploadUiBinder.class);

    public CustomFileUpload(final PixlrWidgetResources resources) {
        this.resources = resources;
        initWidget(uiBinder.createAndBindUi(this));
        initHandlers();
    }

    @Override
    public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
        // we just forward the handler to the inner FileUpload
        return realFileUpload.addChangeHandler(handler);
    }

    /**
     * Gets the filename selected by the user. This property has no mutator, as browser security
     * restrictions preclude setting it.
     * 
     * @return the widget's filename
     */
    public String getFilename() {
        return realFileUpload.getFilename();
    }

    /**
     * Returns the inner {@link FileUpload} widget.
     * 
     * @return the file upload widget
     */
    public FileUpload getFileUpload() {
        return realFileUpload;
    }

    @Override
    public String getName() {
        return realFileUpload.getName();
    }

    @UiHandler("realFileUpload")
    protected void onFileChosen(final ChangeEvent event) {
        uploadText.setText(realFileUpload.getFilename());
    }

    @Override
    public void setName(final String name) {
        realFileUpload.setName(name);

    }

    private boolean stopFileUploadClickPropagation = false;
    private boolean simulatedClicked = false;

    private void initHandlers() {

        realFileUpload.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                // this is required to avoid "click event" be fired recursively on FF
                if (simulatedClicked)
                    stopFileUploadClickPropagation = true;
            }
        }, ClickEvent.getType());

        fakeFileUpload.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (!stopFileUploadClickPropagation) {
                    // when the 'fakeFileUpload' is clicked, we simulate
                    // the click on the 'realFileUpload' to open the dialog
                    simulatedClicked = true;
                    realFileUpload.getElement().<ButtonElement> cast().click();
                    // this is required to avoid the 'too many recursions' problem
                    // on FF, due to the 'click event' being indefinitely fired by
                    // 'fakeFileUpload' on simulated click on 'realFileUpload'
                    stopFileUploadClickPropagation = false;
                    simulatedClicked = false;
                }
            }
        }, ClickEvent.getType());
    }

}
