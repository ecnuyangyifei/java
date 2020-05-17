IoC容器
1. IoC容器的功能？ 
  参考答案： 管理着 Bean 的生命周期，控制着 Bean 的依赖注入
2. 控制反转（依赖注入）概念，优点？
  参考答案：它把传统上由程序代码直接操控的对象的调用权交给容器，通过容器来实现对象组件的装配和管理；
          优点：解耦
3. 如何从Spring容器中获取bean?
  参考答案： 可以从通过bean name或类型等从ApplicationContext获取


AOP
1. 什么是AOP？
  参考答案： 面向切面编程，是把业务逻辑和横切的问题进行分离，从而达到解耦的目的，使代码的重用性和开发效率高
2. AOP体现了哪种设计模式？ 静态代理与动态代理有什么区别？（JDK动态代理局限性？）
  参考答案： 代理模式； 动态代理是运行时动态创建代理类； JDK动态代理需要实现类通过接口定义方法
3. Spring有哪些不同的通知类型？
  参考答案： Before, After, After Returning, After Throw, Around


Spring Beans
1. Bean的生命周期？如何在bean初始化结束后执行特定方法？
  参考答案： 实例化、属性赋值、初始化、销毁; 适用PostConstruct注解
2. 默认情况下bean的作用域？
  参考答案： 单例，当前容器范围内
3. @Qualifier注解的作用？
  参考答案：Spring默认通过类型来装配，当同一类型出现多个bean时装配失败，通过Qualifier可以指定具体的bean

Spring MVC
1. MVC是什么? MVC设计模式的好处是什么？
参考答案： mvc是一种设计模式。模型（model）-视图（view）-控制器（controller），三层架构的设计模式。用于实现前端页面的展现与后端业务数据处理的分离。好处：分层设计，解耦合，易于拓展和维护，并行开发，提升效率
2. 如何在controller方法中拿到Request，Response，Session对象？
参考答案：在方法的参数中声明，Spring会自动注入
3. @Controller与@RestController区别？
参考答案：@RestControllrt相当于@ResponseBody + @Controller

Spring JPA
1. 如何自定义查询？
参考答案： 使用@Query
2. jpa, Spring Data jpa, hibernate三者关系？
参考答案： jpa是一种规范，spring data jpa在jpa上进行了封装，heibernate实现了jpa
3. 如何写jpa方法限制某列的值在给定list中
参考答案：findColumnIn


事务管理
1. 什么是事务？
参考答案： 数据库事务( transaction)是访问并可能操作各种数据项的一个数据库操作序列，这些操作要么全部执行,要么全部不执行，是一个不可分割的工作单位
2. Spring 事务隔离级别？
参考答案： READ_UNCOMITTED，READ_COMMITED，REPEATABLE_READ，SERLALIZABLE

