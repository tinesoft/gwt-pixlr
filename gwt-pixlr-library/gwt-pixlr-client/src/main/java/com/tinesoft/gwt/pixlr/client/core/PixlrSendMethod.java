
package com.tinesoft.gwt.pixlr.client.core;

/**
 * Enumeration of methods by which image information are sent.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public enum PixlrSendMethod {

    /**
     * Image information are sent by HTTP GET method.
     */
    GET,
    /**
     * Image information are sent by HTTP POST method.
     * <p>
     * <b>NOTE:</b><br/>
     * If using this method, then you have to have a <b>crossdomain.xml</b> in the root of your web
     * application.<br/>
     * And you need to add pixlr.com to the list of valid domains. More info here: <a
     * href="http://goo.gl/tn9qu">http://goo.gl/tn9qu</a> .
     * </p>
     */
    POST;

    /**
     * Returns the enum constant of type {@link PixlrSendMethod} with the specified name (case
     * insensitive).
     * 
     * @param name the name of the enum constant
     * @return the enum constant of type {@link PixlrSendMethod} with the specified name
     * @throws IllegalArgumentException if enum type {@link PixlrSendMethod} has no constant with
     *             the specified name
     * @throws NullPointerException if <tt>name</tt> is null
     */
    public static PixlrSendMethod from(final String name) {
        if (name == null) {
            throw new NullPointerException("Name is null");
        }
        return PixlrSendMethod.valueOf(name.trim().toUpperCase());
    }
}
