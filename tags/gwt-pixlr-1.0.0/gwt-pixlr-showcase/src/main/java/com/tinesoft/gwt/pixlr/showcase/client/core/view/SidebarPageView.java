
package com.tinesoft.gwt.pixlr.showcase.client.core.view;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.LocalizableResource.Generate;
import com.google.gwt.i18n.client.LocalizableResource.GenerateKeys;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import com.tinesoft.gwt.pixlr.client.core.PixlrImageType;
import com.tinesoft.gwt.pixlr.client.core.PixlrSendMethod;
import com.tinesoft.gwt.pixlr.client.core.PixlrService;
import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;
import com.tinesoft.gwt.pixlr.client.core.PixlrWmode;
import com.tinesoft.gwt.pixlr.client.util.StringUtils;
import com.tinesoft.gwt.pixlr.showcase.client.core.handler.SidebarPageUiHandlers;
import com.tinesoft.gwt.pixlr.showcase.client.core.presenter.SidebarPagePresenter;
import com.tinesoft.gwt.pixlr.showcase.client.resources.ShowcaseResources;

/**
 * Sidebar page view.
 * 
 * @author Tine Kondo
 */
public class SidebarPageView extends ViewWithUiHandlers<SidebarPageUiHandlers> implements SidebarPagePresenter.MyView {

    public interface Binder extends UiBinder<Widget, SidebarPageView> {
    }

    @Generate(format = "com.google.gwt.i18n.rebind.format.PropertiesFormat")
    @GenerateKeys("com.google.gwt.i18n.rebind.keygen.MD5KeyGenerator")
    @DefaultLocale
    interface I18nMessages extends Messages {

        @DefaultMessage("Shows a checkbox on the save dialog that lets the user select \"Save as copy\".")
        String copy();

        @DefaultMessage("The URL to send the visitor if the user click exit/close.")
        String exit();

        @DefaultMessage("A url to a 16*16 icon to be shown at the save tab.")
        String icon();

        @DefaultMessage("A URL to the image or the post raw data of the image to open.")
        String image();

        @DefaultMessage("Remove the possibility for the user to \"Save to computer\" and other service in Pixlr Editor.")
        String lockTarget();

        @DefaultMessage("Lock the image title so the user can''t change it.")
        String lockTitle();

        @DefaultMessage("Lock the save format, values are jpg, png, bmp, pxd or source.")
        String lockType();

        @DefaultMessage("Set the maximum height of an image the user saves.")
        String maxHeight();

        @DefaultMessage("Set the maximum width of an image the user saves.")
        String maxWidth();

        @DefaultMessage("The way we send the image information, \"GET\" or \"POST\", default is \"GET\".")
        String method();

        @DefaultMessage("Set the jpg quality when the user saves the image, values are 0-100.")
        String quality();

        @DefaultMessage("Set to False if you don''t want the browser to follow the save post. i.e the user stay in the editor after saving.")
        String redirect();

        @DefaultMessage("The name of the referring service for example \"Your site name\" or \"Facebook\".")
        String referrer();

        @DefaultMessage("The Pixlr service to contact.")
        String service();

        @DefaultMessage("The URL to which we send the image information when saving.")
        String target();

        @DefaultMessage("The title of the opened image.")
        String title();

        @DefaultMessage("The filetype of the image. The apps will try to get the type from the URL if type param is not provided.")
        String type();

        @DefaultMessage("(Advanced) Change the flash wmode (transparent, opaque, window etc) when you need to use z-index and float HTML over the flash area.")
        String wmode();
    }

    private final Widget widget;
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

    private PixlrSettings settings;

    final ShowcaseResources resources;

    @Inject
    public SidebarPageView(final Binder binder, final ShowcaseResources resources) {
        this.widget = binder.createAndBindUi(this);

        this.resources = resources;
        this.resources.css().ensureInjected();

        // default settings,
        this.settings = new PixlrSettings();
        final int i = 1 + Random.nextInt(2);

        // we pick 1 random picture of the 3 from demo page: http://developer.pixlr.com
        this.settings.setImage("http://developer.pixlr.com/_image/example" + i + ".jpg");
        // we set the path to our servlet, that will handle the result from 'Pixlr'
        this.settings.setTarget("http://gwt-pixlr.appspot.com/showcase/pixlr");

        setSettings(settings);

    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    /**
     * Gets the inner {@link PixlrSettings}.
     * 
     * @return
     */
    public PixlrSettings getSettings() {
        return settings;
    }

    @UiHandler("methodListBox")
    protected void onMethodChanged(final ChangeEvent event) {
        final int selectedIndex = methodListBox.getSelectedIndex();
        if (selectedIndex == 1) {
            imageTextBox.setValue("");
        }

        imageTextBox.setEnabled(selectedIndex == 0);
    }

    @UiHandler("okButton")
    protected void onOkButtonClicked(final ClickEvent event) {

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
        if (StringUtils.isBlank(type)) {
            settings.setType(null);
        } else {
            settings.setType(PixlrImageType.valueOf(type));
        }

        settings.setTarget(targetTextBox.getValue());

        final String redirect = redirectListBox.getValue(redirectListBox.getSelectedIndex());
        settings.setRedirect(Boolean.valueOf(redirect));

        final String lockTarget = lockTargetListBox.getValue(lockTargetListBox.getSelectedIndex());
        settings.setLockTarget(Boolean.valueOf(lockTarget));

        final String lockTitle = lockTitleListBox.getValue(lockTitleListBox.getSelectedIndex());
        settings.setLockTitle(Boolean.valueOf(lockTitle));

        final String lockType = lockTypeListBox.getValue(lockTypeListBox.getSelectedIndex());
        if (StringUtils.isBlank(lockType)) {
            settings.setLockType(null);
        } else {
            settings.setLockType(PixlrImageType.valueOf(lockType));
        }

        settings.setQuality(qualityIntegerBox.getValue());

        final String copy = copyListBox.getValue(copyListBox.getSelectedIndex());
        settings.setCopy(Boolean.valueOf(copy));

        settings.setMaxWidth(maxWidthIntegerBox.getValue());
        settings.setMaxHeight(maxHeightIntegerBox.getValue());

        final String wmode = wmodeListBox.getValue(wmodeListBox.getSelectedIndex());
        if (StringUtils.isBlank(wmode)) {
            settings.setWmode(null);
        } else {
            settings.setWmode(PixlrWmode.valueOf(wmode));
        }

        // fires the event that the settings have changed
        if (null != this.getUiHandlers())
            this.getUiHandlers().onPixlrSettingsValidated(settings);
    }

    @UiHandler("resetButton")
    protected void onResetButtonClicked(final ClickEvent event) {

        resetSettings();
    }

    /**
     * Resets all settings displayed in the widget, to their default values.
     */
    public void resetSettings() {
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

    /**
     * Sets all the settings displayed in the widget
     * 
     * @param settings
     */
    public void setSettings(final PixlrSettings settings) {
        serviceListBox.setSelectedIndex(settings.getService().ordinal());
        methodListBox.setSelectedIndex(settings.getMethod().ordinal());

        referrerTextBox.setValue(settings.getReferrer());
        iconTextBox.setValue(settings.getIcon());
        exitTextBox.setValue(settings.getExit());
        imageTextBox.setValue(settings.getImage());
        titleTextBox.setValue(settings.getTitle());
        typeListBox.setSelectedIndex((settings.getType() == null) ? 0 : 1 + settings.getType().ordinal());
        targetTextBox.setValue(settings.getTarget());
        final Boolean redirect = settings.getRedirect();
        redirectListBox.setSelectedIndex((redirect == null) ? 0 : redirect ? 1 : 2);
        final Boolean lockTarget = settings.getLockTarget();
        lockTargetListBox.setSelectedIndex((lockTarget == null) ? 0 : lockTarget ? 1 : 2);
        final Boolean lockTitle = settings.getLockTitle();
        lockTitleListBox.setSelectedIndex((lockTitle == null) ? 0 : lockTitle ? 1 : 2);
        lockTypeListBox.setSelectedIndex((settings.getLockType() == null) ? 0 : 1 + settings.getLockType().ordinal());
        qualityIntegerBox.setText((settings.getQuality() == null) ? "" : String.valueOf(settings.getQuality()));
        final Boolean copy = settings.getCopy();
        copyListBox.setSelectedIndex((copy == null) ? 0 : copy ? 1 : 2);
        maxWidthIntegerBox.setText((settings.getMaxWidth() == null) ? "" : String.valueOf(settings.getMaxWidth()));
        maxHeightIntegerBox.setText((settings.getMaxHeight() == null) ? "" : String.valueOf(settings.getMaxHeight()));
        wmodeListBox.setSelectedIndex((settings.getWmode() == null) ? 0 : 1 + settings.getWmode().ordinal());

        this.settings = settings;
    }
}
