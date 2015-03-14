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

The dependencies are published on Maven Central. So nothing more is required to have it working.

But if you want to use a snapshot (= under development) version of the library, you must add the following in the **`<`repositories`>`** section of your pom.xml:
```
<repository>
        <id>sonatype.snapshots</id>
        <name>Sonatype snapshot repository</name>
        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>  
        <layout>default</layout>
</repository>
```