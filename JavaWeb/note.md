
`web.xml`头
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    
</web-app>
```
网页输出乱码问题
```java
//        resp.setCharacterEncoding("GBK");
resp.setContentType("text/html");
resp.setCharacterEncoding("utf-8");
```


`Response` 下载文件
```java
//让浏览器支持(Content-Disposition)下载我们需要的东西
resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
// 中文文件名使用URLEncoder.encode(filename, "UTF-8")编码，否则可能乱码
```

