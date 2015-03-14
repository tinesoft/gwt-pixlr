# Table of Contents #



# Setup #

First, you need to add the gwt-pixlr jar files to your project's build path.

## Setting your project with Eclipse (without maven) ##

  1. Right-click on the project node in the Package Explorer and select 'Build Path > Add External Archives...'.
  1. Specify the downloaded **gwt-pixlr-all`<`version`>`.jar**

This jar contains everything you need to get started with both client and server side components of the library.

If you only need the client-side components, use this jar instead:
  * **gwt-pixlr-client`<`version`>`.jar**

If you only need the server-side components, use this jar instead:
  * **gwt-pixlr-server`<`version`>`.jar**

## Setting up your project with Maven ##
If you use Maven to build you project (what i personally recommend) you can easily set your project with gwt-pixlr by adding the following dependency to your **pom.xml**:

```
<dependency>
	<groupId>com.tinesoft</groupId>
	<artifactId>gwt-pixlr-all</artifactId>
	<version>1.0.0</version>
</dependency>
```

This dependency is a compound jar that contains both Client and Server side components of the library in a single jar.

  * If you only need the client-side components, use this dependency instead:
```
<dependency>
	<groupId>com.tinesoft</groupId>
	<artifactId>gwt-pixlr-client</artifactId>
	<version>1.0.0</version>
</dependency>
```

  * If you only need the server-side components, use this dependency instead:
```
<dependency>
	<groupId>com.tinesoft</groupId>
	<artifactId>gwt-pixlr-server</artifactId>
	<version>1.0.0</version>
</dependency>
```

The dependency will soon be published on Maven Central. So nothing more is required to have it working.

But if you want to use a snapshot (= under development) version of the library, you must add the following in the **`<`repositories`>`** section of your pom.xml:
```
<repository>
        <id>sonatype.snapshots</id>
        <name>Sonatype snapshot repository</name>
        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>  
        <layout>default</layout>
</repository>
```

## Configuring your  `*`.gwt.xml Module ##

Modify **`<`YourApplication`>`.gwt.xml** to inherit the gwt-pixlr module:
```
  <inherits name='com.tinesoft.gwt.pixlr.GWTPixlr' />
```


# Using the library (Client Side) #

Theses are the required steps to start using the library client-side:
  1. Create and add a **PixlrWidget** to your application UI.
  1. Create and configure a **PixlrSettings** object and affects it to the widget


## Adding the widget without uibinder ##

Easy. Just create and add the PixlrWidget in your application layout, as any  other GWT widget.

**MyView.java**:
```
...
PixlrWidget yourPixlrWidget = new PixlrWidget();
panel.add(yourPixlrWidget);
...
```

## Adding the widget with uibinder ##
**MyView.ui.xml:**
```
<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">

<ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'
    xmlns:g='urn:import:com.google.gwt.user.client.ui'
    xmlns:my='urn:import:com.tinesoft.gwt.pixlr.client.ui'
    ui:generateFormat='com.google.gwt.i18n.rebind.format.PropertiesFormat'
    ui:generateKeys='com.google.gwt.i18n.rebind.keygen.MD5KeyGenerator'
    ui:generateLocales='default'>


<g:FlowPanel>
  ...
  <my:PixlrWidget ui:field="pixlrWidget" width="600" height="600"/>
  ...
</g:FlowPanel>
<ui:Uibinder>

```

#### Explanation ####

  * Define the namespace prefix for widgets used to build the pixlr widget. Here i have chosen **my** as prefix, and the package containing the widgets is **com.tinesoft.gwt.pixlr.client.ui**. So the namespace definition will be:
```
xmlns:my='urn:import:com.tinesoft.gwt.pixlr.client.ui'
```
  * Add the pixlr widget
    * define the `ui:field` to later access to it in the java code
    * define widget's dimension (width and height):
```
<g:FlowPanel>
  ...
  <my:PixlrWidget ui:field="pixlrWidget" width="600" height="600"/>
  ...
</g:FlowPanel>
```


**MyView.java:**
```
...
@UiField
PixlrWidget pixlrWidget;
...

```

## Configuring the widget ##

**PixlrWidget** uses **PixlrSettings**, a class that defining the IN parameters sent to Pixlr. Among them, the following are required:
  * **service**: The Pixlr Service to contact
  * **method**: The HTTP method used to contact the service, either "GET" or "POST"
  * **image**: Depending on the send method used, contains either the URL to the image or the post raw data of the image to open.
  * **target**: The URL to which Pixlr will send the image information when saving

**Sample code:**

```
   ...
   PixlrSetting yourSettings = new PixlrSettings();
   //Setting main parameters:
   yoursettings.setService(PixlrService.EXPRESS);
   yourSettings.setMethod(PixlrSendMethod.GET);
   yourSettings.setImage("http://www.yoursite.com/yourimage.jpg");
   yourSettings.setTarget("http://www.yoursite.com/path-to-your-pixlr-servlet/");
   ...
   //Adding additionnal parameters (non-API parameters)
   yourSettings.putAdditionalParameter("userId","123");
   ...

   // Associate the widget with its settings
   yourPixlrWidget.setSettings(yourSettings);

```

# Using the library (Server Side) #

This part allows you to retrieve the information sent by **Pixlr** each time the user saves the image in the editor view. Those information include the saved image, its title, its state, and its type.

These are the required steps to get started:
  1. Create a Servlet by extending **PixlrServlet**
  1. Configure your **web.xml**

## Creating your servlet ##
```
public class MyPixlrServlet extends PixlrServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void handlePixlrResult(PixlrResult result) {

        // here, you can do whatever you want with the result, eg: save image to db, to file system,
        // etc...

        // result.getImage(); the saved image data, as a java.io.InputStream
        // result.getState(); the state of the image (new, replace or copy)
        // result.getTitle(); the title of the image as entered by the user after saving
        // result.getType(); the type of the saved image

        // result.getAdditionalParameters(); the map of additional values passed (if any)

    }
}
```

**PixlrServlet** does all the heavy work underneath (parsing the request, retrieving the parameters,..) and exposes you the result as a convenient **PixlrResult** object created and passed to the abstract method:  ` void handlePixlrResult(PixlrResult result)`. Inside this method, ou can then do whatever you want with the result, for example: save the image to database or to file system, etc.

## Configuring your web.xml ##
Modify your web.xml to declare your servlet, and the path to access it.

**web.xml**:

```
	<!-- Pixlr Servlet -->
	<servlet>
		<servlet-name>your-pixlr-servlet</servlet-name>
		<servlet-class>com.tinesoft.gwt.pixlr.showcase.server.YourPixlrServlet</servlet-class>

        <!-- Uncomment to set a max allowed request size, in bytes.-->
 	<!-	<init-param> -->
 	<!--		<param-name>maxRequestSize</param-name> -->
 	<!--		<param-value>10485760</param-value> -->
	<!-- 	</init-param> -->
	</servlet>

	<servlet-mapping>
		<servlet-name>your-pixlr-servlet</servlet-name>
		<url-pattern>/pixlr</url-pattern>
	</servlet-mapping>
```

In this example, the servlet will be available at: http://yoursite.com/pixlr

This is the  **target** URL you have to specify when configuring the **PixlrSettings** associated with the widget. **Pixlr** will send to that URL, the information about the saved image.