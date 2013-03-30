
package com.tinesoft.gwt.pixlr.showcase.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;

/**
 * Server guice module.
 * 
 * @author Tine Kondo
 */
public class ServerModule extends HandlerModule {

    protected void configureDAOs() {

    }

    @Override
    protected void configureHandlers() {
        configureDAOs();

        // auth module

    }
}
