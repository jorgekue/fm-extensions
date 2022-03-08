# fm-extensions

##Usage in Freemarker template file
It's a dependency with one Freemarker Extentions only.
You can delegate apart from main output file temporarily again and again to different  files as shown in the example Freemarker template file (*.ftl) below:
```javascript
...
<#assign output = "de.jk.fm.ext.output.OutputDirective"?new()>
...
content of main output file
...
<@output file="./file1.txt">
...
content of file1.txt
...
</@output>
...
content of main output file
...
<@output file="./file2.txt">
...
content of file2.txt
...
</@output>
...
again content of main output file
...
```

##Usage with plugin yaml-codegen-maven
It's designed for use in conjunction with plugin yaml-codegen-maven as a freemarker extension too:
```javascript
...
<build>
	<plugins>
		<plugin>
			<groupId>com.github.vboxnick</groupId>
			<artifactId>yaml-codegen-maven</artifactId>
			<version>0.0.10</version>
			<configuration>
...
			</configuration>
			<dependencies>
				<dependency>
					<groupId>de.jk.freemarker.ext</groupId>
					<artifactId>OutputSplitter</artifactId>
					<version>${version.outputsplitter}</version>
				</dependency>
			</dependencies>
			<executions>
				<execution>
					<goals>
						<goal>generate</goal>
					</goals>
					<phase>generate-sources</phase>
				</execution>
			</executions>
		</plugin>
	</plugins>
...    
...
```
##Links
Freemarker: https://freemarker.apache.org/  
Maven-Plugin yaml-codegen-maven: https://github.com/VboxNick/yaml-codegen-maven
