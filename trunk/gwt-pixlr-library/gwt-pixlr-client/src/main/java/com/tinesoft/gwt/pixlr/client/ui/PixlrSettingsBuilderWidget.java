
package com.tinesoft.gwt.pixlr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.LocalizableResource.Generate;
import com.google.gwt.i18n.client.LocalizableResource.GenerateKeys;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import com.tinesoft.gwt.pixlr.client.core.PixlrImageType;
import com.tinesoft.gwt.pixlr.client.core.PixlrSendMethod;
import com.tinesoft.gwt.pixlr.client.core.PixlrService;
import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.client.core.PixlrWmode;
import com.tinesoft.gwt.pixlr.client.event.PixlrSettingsValidatedEvent;
import com.tinesoft.gwt.pixlr.client.event.PixlrSettingsValidatedHandler;
import com.tinesoft.gwt.pixlr.client.resources.PixlrSettingsBuilderWidgetResources;
import com.tinesoft.gwt.pixlr.client.util.StringUtils;

/**
 * Simple user interface for generating the {@link PixlrSettings}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class PixlrSettingsBuilderWidget extends Composite {

    @UiField
    ListBox serviceListBox;
    @UiField
    ListBox methodListBox;
    @UiField
    TextBox referrerTextBox;
    @UiField
    TextBox iconTextBox;
    @UiField
    TextBox exitTextBox;
    @UiField
    TextBox imageTextBox;
    @UiField
    TextBox titleTextBox;
    @UiField
    ListBox typeListBox;
    @UiField
    TextBox targetTextBox;
    @UiField
    ListBox redirectListBox;
    @UiField
    ListBox lockTargetListBox;
    @UiField
    ListBox lockTitleListBox;
    @UiField
    ListBox lockTypeListBox;
    @UiField
    IntegerBox qualityIntegerBox;
    @UiField
    ListBox copyListBox;
    @UiField
    IntegerBox maxWidthIntegerBox;
    @UiField
    IntegerBox maxHeightIntegerBox;
    @UiField
    ListBox wmodeListBox;

    @UiField
    Button okButton;
    @UiField
    Button resetButton;

    @UiField
    I18nMessages i18n;

    @UiField(provided = true)
    PixlrSettingsBuilderWidgetResources resources;

    private final PixlrSettings settings;

    private static PixlrSettingsBuilderWidgetUiBinder uiBinder = GWT.create(PixlrSettingsBuilderWidgetUiBinder.class);
    private static PixlrSettingsBuilderWidgetResources DEFAULT_RESOURCES = null;

    interface PixlrSettingsBuilderWidgetUiBinder extends UiBinder<Widget, PixlrSettingsBuilderWidget> {
    }

    @Generate(format = "com.google.gwt.i18n.rebind.format.PropertiesFormat")
    @GenerateKeys("com.google.gwt.i18n.rebind.keygen.MD5KeyGenerator")
    @DefaultLocale
    interface I18nMessages extends Messages {

        @DefaultMessage("The Pixlr service to contact.")
        String service();

        @DefaultMessage("The name of the referring service for example \"Your site name\" or \"Facebook\".")
        String referrer();

        @DefaultMessage("A url to a 16*16 icon to be shown at the save tab.")
        String icon();

        @DefaultMessage("The URL to send the visitor if the user click exit/close.")
        String exit();

        @DefaultMessage("A URL to the image or the post raw data of the image to open.")
        String image();

        @DefaultMessage("The title of the opened image.")
        String title();

        @DefaultMessage("The filetype of the image. The apps will try to get the type from the URL if type param is not provided.")
        String type();

        @DefaultMessage("The way we send the image information, \"GET\" or \"POST\", default is \"GET\".")
        String method();

        @DefaultMessage("The URL to which we send the image information when saving.")
        String target();

        @DefaultMessage("Set to False if you don''t want the browser to follow the save post. i.e the user stay in the editor after saving.")
        String redirect();

        @DefaultMessage("Remove the possibility for the user to \"Save to computer\" and other service in Pixlr Editor.")
        String lockTarget();

        @DefaultMessage("Lock the image title so the user can''t change it.")
        String lockTitle();

        @DefaultMessage("Lock the save format, values are jpg, png, bmp, pxd or source.")
        String lockType();

        @DefaultMessage("Set the jpg quality when the user saves the image, values are 0-100.")
        String quality();

        @DefaultMessage("Shows a checkbox on the save dialog that lets the user select \"Save as copy\".")
        String copy();

        @DefaultMessage("Set the maximum width of an image the user saves.")
        String maxWidth();

        @DefaultMessage("Set the maximum height of an image the user saves.")
        String maxHeight();

        @DefaultMessage("(Advanced) Change the flash wmode (transparent, opaque, window etc) when you need to use z-index and float HTML over the flash area.")
        String wmode();
    }

    public PixlrSettingsBuilderWidget() {
        this(getDefaultResources());
    }

    public PixlrSettingsBuilderWidget(PixlrSettingsBuilderWidgetResources resources) {
        this.settings = new PixlrSettings();
        this.resources = resources;
        initWidget(uiBinder.createAndBindUi(this));

        // make sure that the css get injected
        resources.css().ensureInjected();
    }

    @UiHandler("okButton")
    protected void onOkButtonClicked(ClickEvent event) {

        final String service = serviceListBox.getValue(serviceListBox.getSelectedIndex());
        settings.setService(PixlrService.valueOf(service));

        final String method = methodListBox.getValue(methodListBox.getSelectedIndex());
        settings.setMethod(PixlrSendMethod.valueOf(method));

        settings.setReferrer(referrerTextBox.getValue());
        settings.setIcon(iconTextBox.getValue());
        settings.setExit(exitTextBox.getValue());
        settings.setImage(imageTextBox.getValue());
        settings.setTitle(titleTextBox.getValue());

        final String type = typeListBox.getValue(typeListBox.getSelectedIndex());
        if (StringUtils.isBlank(type))
            settings.setType(null);
        else
            settings.setType(PixlrImageType.valueOf(type));

        settings.setTarget(targetTextBox.getValue());

        final String redirect = redirectListBox.getValue(redirectListBox.getSelectedIndex());
        settings.setRedirect(Boolean.valueOf(redirect));

        final String lockTarget = lockTargetListBox.getValue(lockTargetListBox.getSelectedIndex());
        settings.setLockTarget(Boolean.valueOf(lockTarget));

        final String lockTitle = lockTitleListBox.getValue(lockTitleListBox.getSelectedIndex());
        settings.setLockTitle(Boolean.valueOf(lockTitle));

        final String lockType = lockTypeListBox.getValue(lockTypeListBox.getSelectedIndex());
        if (StringUtils.isBlank(lockType))
            settings.setLockType(null);
        else
            settings.setLockType(PixlrImageType.valueOf(lockType));

        settings.setQuality(qualityIntegerBox.getValue());

        final String copy = copyListBox.getValue(copyListBox.getSelectedIndex());
        settings.setCopy(Boolean.valueOf(copy));

        settings.setMaxWidth(maxWidthIntegerBox.getValue());
        settings.setMaxHeight(maxHeightIntegerBox.getValue());

        final String wmode = wmodeListBox.getValue(wmodeListBox.getSelectedIndex());
        if (StringUtils.isBlank(wmode))
            settings.setWmode(null);
        else
            settings.setWmode(PixlrWmode.valueOf(wmode));

        // fires the event that the settings have changed
        fireEvent(new PixlrSettingsValidatedEvent(settings));
    }

    @UiHandler("resetButton")
    protected void onResetButtonClicked(ClickEvent event) {
        serviceListBox.setSelectedIndex(0);
        methodListBox.setSelectedIndex(0);

        referrerTextBox.setValue("");
        iconTextBox.setValue("");
        exitTextBox.setValue("");
        imageTextBox.setValue("");
        titleTextBox.setValue("");
        typeListBox.setSelectedIndex(0);
        targetTextBox.setValue("");
        redirectListBox.setSelectedIndex(0);
        lockTargetListBox.setSelectedIndex(0);
        lockTitleListBox.setSelectedIndex(0);
        lockTypeListBox.setSelectedIndex(0);
        qualityIntegerBox.setText("");
        copyListBox.setSelectedIndex(0);
        maxWidthIntegerBox.setText("");
        maxHeightIntegerBox.setText("");
        wmodeListBox.setSelectedIndex(0);

    }

    @UiHandler("methodListBox")
    protected void onMethodChanged(ChangeEvent event) {
        final int selectedIndex = methodListBox.getSelectedIndex();
        if (selectedIndex == 1)// 'POST' method selected
            imageTextBox.setValue("");

        imageTextBox.setEnabled(selectedIndex == 0);
    }

    /**
     * Gets the inner {@link PixlrSettings}.
     * 
     * @return
     */
    public PixlrSettings getSettings() {
        return settings;
    }

    /**
     * Adds an hander to the {@link PixlrSettingsValidatedEvent} event.
     * 
     * @param handler
     * @return
     */
    public HandlerRegistration addPixlrSettingsValidatedHandler(PixlrSettingsValidatedHandler handler) {
        return addHandler(handler, PixlrSettingsValidatedEvent.getType());
    }

    private static PixlrSettingsBuilderWidgetResources getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            DEFAULT_RESOURCES = GWT.create(PixlrSettingsBuilderWidgetResources.class);
        }
        return DEFAULT_RESOURCES;
    }
}
