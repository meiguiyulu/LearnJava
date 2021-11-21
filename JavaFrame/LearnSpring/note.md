# 笔记

## `pom.xml` 中需要配置 `junit`

```xml
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>

```

## 注解说明

- @AutoWired: 自动配置类型。按照类型（`ByType`）装配依赖对象。如果我们想使用按照名称（`ByName`）来装配，可以结合 `@Qualifier` 注解一起使用。
- @Nullable: 标记该注解的字段可以为null
- @Resource: 默认按照 `ByName` 装配

- @Component: 放在类上，说明这个类被Spring管理了!

