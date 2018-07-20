2018-07-12 此版本完全可以用。更换了目录，cmd 方式，ojdbc14 的驱动程序。

java -jar -D"loader.path"="lib" dlamq.jar

部署在d:/amq 
运行cmd /k D:\Java\jdk1.8\bin\java -Djava.ext.dirs=lib -jar dlamq-1.jar

JDK1.8 下，ojdbc14.jar 才行，ojdbc6.jar 不行。
windows 10 下用
cmd /k D:\Java\jdk1.8\bin\java -Djava.ext.dirs=lib -jar dlamq-1.jar
安装oracle java 包到本地仓库
     <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc6</artifactId>
            <version>11.2.0</version>
        </dependency>

runas /user:administrator "cmd /k"
 mvn install:install­file ­Dfile=D:\acdmTool\ojdbc6.jar  ­DgroupId=com.oracle  ­DartifactId=ojdbc6 ­Dversion=11.2.0 ­Dpackaging=jar
