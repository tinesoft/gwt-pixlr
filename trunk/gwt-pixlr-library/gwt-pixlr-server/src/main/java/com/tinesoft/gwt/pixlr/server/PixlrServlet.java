
package com.tinesoft.gwt.pixlr.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class PixlrServlet extends HttpServlet {

    // FIXME : Improve javadoc
    /**
     * The content of this parameter depends on the value of the "method" in-parameter. If method
     * was GET the value of image is an url to where we saved the image. If method was POST the
     * value of image is the actual image.
     */
    private static final String IMAGE_PARAM = "image";
    /**
     * The title of the image the user typed in when saving.
     */
    private static final String TITLE_PARAM = "title";
    /**
     * The type of image can be: jpg, png, bmp or pxd.
     */
    private static final String TYPE_PARAM = "type";
    /**
     * The state of the image, can be "new", "copy", "replace". New is when the user open/creates
     * the image in the editor. Copy is when the image is from the API and the image checked
     * "Save as copy".
     */
    private static final String STATE_PARAM = "state";

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : items) {
                String fieldName = item.getFieldName();

                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select,
                    // etc).
                    String fieldValue = item.getString();
                    // ... (do your job here)
                } else if (IMAGE_PARAM.equalsIgnoreCase(fieldName)) {
                    // Process form file field (input type="file").
                    String filename = FilenameUtils.getName(item.getName());
                    InputStream fileContent = item.getInputStream();
                    // ... (do your job here)
                }
            }
        } catch (FileUploadException e) {
            throw new ServletException("Cannot parse multipart request.", e);
        }
    }
}
