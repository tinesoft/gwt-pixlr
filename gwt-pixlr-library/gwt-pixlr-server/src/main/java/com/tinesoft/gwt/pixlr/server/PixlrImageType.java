
package com.tinesoft.gwt.pixlr.server;

/**
 * Enumeration of all image types supported by 'Pixlr'
 * 
 * @author Tine Kondo
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

    public static PixlrImageType from(String name) {
        if (name == null)
            throw new NullPointerException("Name is null");
        return PixlrImageType.valueOf(name.trim().toUpperCase());
    }
}
