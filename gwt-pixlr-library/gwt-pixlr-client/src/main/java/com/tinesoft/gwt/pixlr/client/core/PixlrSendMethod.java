
package com.tinesoft.gwt.pixlr.client.core;

/**
 * Enumeration of methods by which image information are sent.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
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
    POST
}
