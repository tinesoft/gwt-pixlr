
package com.tinesoft.gwt.pixlr.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class PixlrServlet extends AbstractPixlrServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PixlrServlet.class);

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final int IO_BUFFER_SIZE = 8 * 1024;

    @Override
    protected void handlePixlrResult(PixlrResult result) {
        // TODO Auto-generated method stub

    }

    public void writeToStream(InputStream inputStream, OutputStream outputStream) {

        BufferedOutputStream out = null;
        BufferedInputStream in = null;

        try {

            in = new BufferedInputStream(inputStream, IO_BUFFER_SIZE);
            out = new BufferedOutputStream(outputStream, IO_BUFFER_SIZE);

            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (final IOException e) {
            LOG.error("I/O error occured", e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }

}
