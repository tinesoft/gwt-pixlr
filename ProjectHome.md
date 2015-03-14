_Last Update_: **gwt-pixlr 1.0.0 has just been released, and is now available on [Maven central](http://search.maven.org/#search|ga|1|gwt-pixlr)!**

# Summary #

A library for easily integrating popular online photo editor **Pixlr**<sup>TM</sup> in your GWT web applications.

# What is Pixlr? #

**Pixlr**<sup>TM</sup> is a suite of online photo editing services: [Pixlr Editor](http://pixlr.com/editor/), [Pixlr Express](http://pixlr.com/express/) and [Pixlr-o-matic](http://pixlr.com/o-matic/). Those applications are built in Flash.

# How does the library works? #

**Pixlr**<sup>TM</sup> exposes those editing services via an [API](http://pixlr.com/developer/api). First, you configure the service to call via input parameters sent to it (as querystring or form parameters). Then, via the service's editor, the user edits the image that has been sent as part of the input parameters. Finally, when it saves the image, the service sends it back to the URL you have specified in the calling parameters. Typically, behind this URL, lies a server component of your webapp (servlet, web service,etc) that will handle the edited image.

**GWT-Pixlr** is based on that API and leverages it to provide a seamless integration in an existing GWT web application, by providing client-side components to display the service'editor, server-side components to retrieve edited images, and few other nice features :) listed below.

# Features #

  * Simple configuration and call to the Pixlr' services via type-safe Java parameters and methods
  * Support for additional parameters
  * Components to integrate the editor inside your web application:
    * **PixlrWidget**: To add the editor view in your layout, just like any GWT widget (client-side).
    * **PixlrServlet**: To retrieve information about the edited image from Pixlr (server-side).
  * Support of Google App Engine platform
  * Display of loading indicator while contacting the service
  * Easy customization of the editor view via exposed css and image resources

# Showcase #
A **showcase** of the project is available here: http://gwt-pixlr.appspot.com.

# Feedback #
Please let me know what you think. Suggestions are always welcome!

# Other GWT projects by the same author #

| **Project** | **Description** |
|:------------|:----------------|
| [gwt-socmedia](http://code.google.com/p/gwt-socialmedia) | A library for easily integrating social media inside your GWT applications |
| [gwt-dialogs](http://code.google.com/p/gwt-dialogs) | A set of highly customizable standard dialog boxes powered by UiBinder, and CSS. |

