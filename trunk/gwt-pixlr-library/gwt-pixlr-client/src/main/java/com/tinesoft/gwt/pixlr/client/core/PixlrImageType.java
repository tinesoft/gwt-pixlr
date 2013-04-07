
package com.tinesoft.gwt.pixlr.client.core;

/**
 * Enumeration of all image types supported by 'Pixlr'
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public enum PixlrImageType {

    JPG(".jpg"), PNG(".png"), BMP(".bmp"), PXD(".pxd");

    /**
     * Returns the enum constant of type {@link PixlrImageType} with the specified name (case
     * insensitive).
     * 
     * @param name the name of the enum constant
     * @return the enum constant of type {@link PixlrImageType} with the specified name
     * @throws IllegalArgumentException if enum type {@link PixlrImageType} has no constant with the
     *             specified name
     * @throws NullPointerException if <tt>name</tt> is null
     */
    public static PixlrImageType from(final String name) {
        if (name == null) {
            throw new NullPointerException("Name is null");
        }
        return PixlrImageType.valueOf(name.trim().toUpperCase());
    }

    private final String extension;

    private PixlrImageType(final String extension) {
        this.extension = extension;
    }

    /**
     * Gets the extension of the given given image type.
     * 
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }
}
