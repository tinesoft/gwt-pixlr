
package com.tinesoft.gwt.pixlr.server;

/**
 * Enumeration of all image types supported by 'Pixlr'
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public enum PixlrImageType {

    JPG(".jpg"), BMP(".bmp"), PNG(".png"), PXD(".pxd");

    private final String extension;

    private PixlrImageType(final String extension) {
        this.extension = extension;
    }

    /**
     * Gets the extension of the given given image type.
     * 
     * @return
     */
    public String getExtension() {
        return extension;
    }
}
