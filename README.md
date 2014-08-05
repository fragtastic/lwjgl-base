Basic framework to get started with a LWJGL project.
This should open fine as a maven project in any IDE that supports maven, including Netbeans and Eclipse, as well as a CI server such has Hudson or Jenkins.

##A few things need to be changed.
* nbactions.xml - line 13 <exec.args> needs to be changed to your main class, or let this be handled by Netbeans. Should be fine though.
* pom.xml - mainClass - needs to be replaced with whatever your main class is.
* pom.xml - groupId - "will identify your project uniquely across all projects, so we need to enforce a naming schema. It has to follow the package name rules, what means that has to be at least as a domain name you control, and you can create as many subgroups as you want." (#2)
* pom.xml - artifactId - "is the name of the jar without version. If you created it then you can choose whatever name you want with lowercase letters and no strange symbols. If it's a third party jar you have to take the name of the jar as it's distributed." (#2)

##Resources
1: http://lwjgl.org/wiki/index.php?title=Main_Page

2: http://maven.apache.org/guides/mini/guide-naming-conventions.html
