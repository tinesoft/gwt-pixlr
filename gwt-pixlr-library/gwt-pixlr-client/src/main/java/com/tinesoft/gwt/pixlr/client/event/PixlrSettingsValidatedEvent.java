
package com.tinesoft.gwt.pixlr.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import com.tinesoft.gwt.pixlr.client.core.PixlrSettings;

/**
 * Custom event fired by a {@link PixlrSettingsValidatedHandler} when its settings has changed.
 * 
 * @author Tine Kondo
 */
public class PixlrSettingsValidatedEvent extends GwtEvent<PixlrSettingsValidatedHandler> {

    private static GwtEvent.Type<PixlrSettingsValidatedHandler> TYPE;

    private final PixlrSettings settings;

    public PixlrSettingsValidatedEvent(PixlrSettings settings) {
        this.settings = settings;
    }

    public static GwtEvent.Type<PixlrSettingsValidatedHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<PixlrSettingsValidatedHandler>();
        }
        return TYPE;
    }

    @Override
    public GwtEvent.Type<PixlrSettingsValidatedHandler> getAssociatedType() {
        return getType();
    }

    @Override
    protected void dispatch(PixlrSettingsValidatedHandler handler) {
        handler.onSettingsChanged(this);
    }

    public PixlrSettings getSettings() {
        return settings;
    }

    /**
     * Fires a {@link PixlrSettingsValidatedEvent} with a specific
     * {@link com.google.gwt.event.shared.GwtEvent.Type} into a source that has access to an
     * {@link com.google.web.bindery.event.shared.EventBus}.
     * 
     * @param source The source that fires this event ({@link HasHandlers}).
     * @param settings The 'Pixlr' settings.
     */
    public static void fire(final HasHandlers source, PixlrSettings settings) {
        source.fireEvent(new PixlrSettingsValidatedEvent(settings));
    }

}
