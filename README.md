# Sample project to highlight MyBatis issue with Spring-Boot

## Issue

When using `records` plus `constructor` mappings, `MyBatis` throws an error during application startup.

```java
at org.apache.ibatis.session.Configuration.addMapper(Configuration.java:872)
	at org.mybatis.spring.mapper.MapperFactoryBean.checkDaoConfig(MapperFactoryBean.java:80)
	... 96 more
	Caused by: org.apache.ibatis.builder.BuilderException: Error in result map 'com.example.demo.FooRepository.foo_map'. Failed to find a constructor in 'com.example.demo.Foo' by arg names [id, name]. There might be more info in debug log.
	at org.apache.ibatis.mapping.ResultMap$Builder.build(ResultMap.java:130)
	at org.apache.ibatis.builder.MapperBuilderAssistant.addResultMap(MapperBuilderAssistant.java:208)
	at org.apache.ibatis.builder.ResultMapResolver.resolve(ResultMapResolver.java:47)
	at org.apache.ibatis.builder.xml.XMLMapperBuilder.resultMapElement(XMLMapperBuilder.java:289)
	at org.apache.ibatis.builder.xml.XMLMapperBuilder.resultMapElement(XMLMapperBuilder.java:254)
	at org.apache.ibatis.builder.xml.XMLMapperBuilder.resultMapElements(XMLMapperBuilder.java:246)
	at org.apache.ibatis.builder.xml.XMLMapperBuilder.configurationElement(XMLMapperBuilder.java:119)
	... 102 more
```

## Testing

### Boot/MyBatis-3.5.11

Running `./mvnw clean test` will fail with the error above.

### Boot/MyBatis-3.5.9

Running `./mvnw clean test` works as expected without any errors.

### Workarounds
* adding `javaType` to the `*.xml` mapper configs
* using `class` instead of `record`
