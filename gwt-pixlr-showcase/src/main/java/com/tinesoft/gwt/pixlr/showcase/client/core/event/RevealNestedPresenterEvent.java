
package com.tinesoft.gwt.pixlr.showcase.client.core.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Fired by the root presenter to notify it's nested presenters to reveal themselves. <br />
 * <br />
 * 
 * On the root presenter:
 * 
 * <pre>
 * <code>
 * &#064;Override
 * public void onReveal() {
 *     super.onReveal();
 *     RevealNestedPresenterEvent.fire(this);
 * }
 * </code>
 * </pre>
 * 
 * On the nested presenter:
 * 
 * <pre>
 * <code>
 * &#064;ProxyEvent 
 * &#064;Override
 * public void onRevealNestedPresenter(RevealNestedPresenterEvent event) {
 *     revealInParent();
 * }
 * </code>
 * </pre>
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class RevealNestedPresenterEvent extends GwtEvent<RevealNestedPresenterHandler> {

    /**
     * Identifier for this event.
     */
    public static final Type<RevealNestedPresenterHandler> TYPE = new Type<RevealNestedPresenterHandler>();

    /**
     * Fire the event.
     * 
     * @param source the {@link HasHandlers} (usually the
     *            {@link com.google.web.bindery.event.shared.EventBus}).
     */
    public static void fire(final HasHandlers source) {
        source.fireEvent(new RevealNestedPresenterEvent());
    }

    /**
     * Returns the type of this event.
     * <p>
     * We need this static method in order to use
     * {@link com.gwtplatform.mvp.client.annotations.ProxyEvent} annotations.
     * </p>
     * 
     * @return the {@link GwtEvent.Type}.
     */
    public static Type<RevealNestedPresenterHandler> getType() {
        return TYPE;
    }

    @Override
    public Type<RevealNestedPresenterHandler> getAssociatedType() {
        return RevealNestedPresenterEvent.TYPE;
    }

    @Override
    protected void dispatch(final RevealNestedPresenterHandler handler) {
        handler.onRevealNestedPresenter(this);
    }
}
