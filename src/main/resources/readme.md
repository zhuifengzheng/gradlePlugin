gradle插件版本与idea版本的一些对应关系: https://github.com/JetBrains/gradle-intellij-plugin/releases?page=1

build.gradle文件
```
plugins {
    id 'org.jetbrains.intellij' version '1.3.0'
    id 'java'
}

intellij {
    version = '2021.3.3'
}
```

buildPlugin编译中文乱码GBK，build.gradle文件下添加如下配置
```

tasks.withType(JavaCompile) {
    options.encoding = "UTF-8"
}
```

控制台输出乱码参考：
https://blog.csdn.net/qq_61601793/article/details/125009791

gradle下载地址：https://services.gradle.org/distributions/

When targeting 2020.3 and later only, using Java 11 is required.
When targeting 2022.2 and later only, using Java 17 is required.

gradle-wrapper.properties文件指定了gradle版本
distributionUrl=https\://services.gradle.org/distributions/gradle-7.5.1-bin.zip









