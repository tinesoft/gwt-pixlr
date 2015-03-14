# Introduction #

This page gives you a quick overview of the main components(modules) that compose the **gwt-pixlr** library.


## Components ##

GWT-Pixlr offers the following components:
  * **gwt-pixlr-client**: The client part of the library, it contains everything you need to add the Pixlr' editior view in your UI
  * **gwt-pixlr-server**: The server side of the libary, it contains a servlet that you can extends to retrieve info about the edited image
  * **gwt-pixlr-all**: Convenient bundle containing the two above components

# gwt-pixlr-client #

The **gwt-pixlr-client** component is the core component of the library, given that it is the one that allows to integrate the Pixlr editor view in your UI. It is constituted of the main following elements:
  * **PixlrWidget**: A widget to add the view in your layout, as a GWT widget
  * **PixlrSettings**: A class encapsulating the IN parameters sent to Pixlr
  * **PixlrWidgetResources**: A [ClientBundle](https://developers.google.com/web-toolkit/doc/latest/DevGuideClientBundle) that you can extend to customize the css and images used by the PixlrWidget

# gwt-pixlr-server #

The **gwt-pixlr-server** component is the optional server-side component of the libary. It contains elements that allows you to retrieve the information about the image being edited, after the user saves his modifications.
  * **PixlrServlet**: Abstract servlet that parses each request sent by 'Pixlr' (after user saves an image in the editor), and provides the information about the saved image via a **PixlrResult** object. You can extend this class and implement the following method: ```java
protected void handlePixlrResult(PixlrResult result)``` to handle the result (for e.g save it to file system, to database, etc)
  * **PixlrResult** A class encapsulating the information about the edited image ( image data as input stream, title, type, state) and any additional parameters you may have passed when calling the Pixlr's service.