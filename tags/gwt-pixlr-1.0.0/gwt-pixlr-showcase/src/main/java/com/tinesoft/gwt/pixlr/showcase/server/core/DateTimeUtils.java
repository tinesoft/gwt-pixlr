
package com.tinesoft.gwt.pixlr.showcase.server.core;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Provides date and time utility methods.
 * 
 * @author Tine Kondo
 */
public final class DateTimeUtils {

    /**
     * Safe clone for dates.
     * 
     * @param date the date to clone or {@code null}.
     * @return the cloned date or {@code null}.
     */
    public static Date clone(final Date date) {
        Date clone = null;
        if (null != date) {
            clone = new Date(date.getTime());
        }
        return clone;
    }

    /**
     * Safe clone for dates that returns {@link Timestamp} instances.
     * <p>
     * Hibernate will use {@link Timestamp} instead of {@link Date} and since timestamps are more
     * accurate you will have problems with equals.
     * </p>
     * 
     * @param date the date to clone or {@code null}.
     * @return the cloned date or {@code null}.
     */
    public static Timestamp cloneToTimestamp(final Date date) {
        Timestamp clone = null;
        if (null != date) {
            clone = new Timestamp(date.getTime());
        }
        return clone;
    }

    /**
     * Hide utility class constructor.
     */
    private DateTimeUtils() {}
}
