wildfly-pax-url-mvn-test
========================

Test Bundle to deploy programatically on WildFly using Pax URL.


1. Install [WildFly-8.0.0.Beta1](http://download.jboss.org/wildfly/8.0.0.Beta1/wildfly-8.0.0.Beta1.zip)
2. Install [JBossOSGi-2.1.0](http://jbossosgi.blogspot.com/2013/07/jbossosgi-210-released.html)
3. Configure the [OSGi subsystem](https://docs.jboss.org/author/display/AS7/OSGi+Subsystem+Configuration)
```xml

    <extensions>
        ...
        <extension module="org.jboss.as.osgi"/>
    </extensions>
    <profile>
        ...
        <subsystem xmlns="urn:jboss:domain:osgi:1.2" activation="eager"/>
    </profile>
    <socket-binding-group ...>
        ...
        <socket-binding name="osgi-http" interface="management" port="8090"/>
    </socket-binding-group>

```
4. Start WildFly.
5. Build and deploy:
```
    mvn clean install
```
