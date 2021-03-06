
package com.tinesoft.gwt.pixlr.showcase.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Client bundle for the application css and image resources.
 * 
 * @author Tine Kondo
 */
public interface ShowcaseResources extends ClientBundle {

    /**
     * @return css bundle.
     */
    interface Style extends CssResource {

        String left();

        String right();

        String title();

        String clear();

        String content();

        String container();

        String button();

        String grid();

        String row();

        String parameterCell();

        String valueCell();

        String selectedButton();

        String notSelectable();

        String inline();

        String middle();
    }

    @Source({ "Style.css" })
    Style css();

}
