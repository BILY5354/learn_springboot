# SpringBoot 学习笔记

## 0.环境说明

- Maven 3.6.1
- SpringBoot2.5.4

## 1.快速上手SpringBoot

SpringBoot从四个方面简化Spring开发

- parent：所有SpringBoot项目要继承的项目，定义了若干个坐标版本号，**依赖管理而非依赖**
- starter：原来写很多个依赖现在写一个就行了，**减少依赖冲突的**
- 引导类
- 内嵌tomcat

## 1.2REST加油站

- 使用REST风格对资源进行访问2称为RESTful

| 地址                     | 描述             | 功能            |
| ------------------------ | ---------------- | --------------- |
| http://localhost/users   | 查询全部用户信息 | GET(查询)       |
| http://localhost/users/1 | 查询指定用户信息 | GET(查询)       |
| http://localhost/users   | 添加用户信息     | POST(新增/保存) |
| http://localhost/users   | 修改用户信息     | PUT(修改/更新)  |
| http://localhost/users/1 | 删除用户信息     | DELETE(删除)    |



- 改造前的代码

  - ```java
    @Controller
    public class UserController {
        
        @RequestMapping("/save")
        @ResonseBody
        public String save(@RequestBody User user) {
            System.out.println("user save..." + user);
            return "{'module':'user save'}";
        }
        
        @RequestMapping("/delete")
        @ResonseBody
        public String delete(Integer id) {
            System.out.println("user delete..." + id);
            return "{'module':'user delete'}";
        }
        
        @RequestMapping("/update")
        @ResonseBody
        public String update(@RequestBody User user) {
            System.out.println("user update..." + user);
            return "{'module':'user update'}";
        }
        
        @RequestMapping("/getById")
        @ResonseBody
        public String getById(Integer id) {
            System.out.println("user getById..." + id);
            return "{'module':'user getById'}";
        }
        
        @RequestMapping("/getAll")
        @ResonseBody
        public String getAll() {
            System.out.println("user getAll...");
            return "{'module':'user getAll'}";
        }
    }
    ```

- 修改后

  - ```java
    @Controller
    public class UserController {
        
        @RequestMapping(value = "/users",method = RequestMethod.POST)
        @ResonseBody
        public String save() {//这里修改时先不传参数了
            System.out.println("user save..." + user);
            return "{'module':'user save'}";
        }
        
        @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
        @ResonseBody
        public String delete(@PathVariable Integer id) {//PathVariable 表示来自请求路径
            System.out.println("user delete..." + id);
            return "{'module':'user delete'}";
        }
        
        @RequestMapping(value = "/users",method = RequestMethod.PUT)
        @ResonseBody
        public String update(@RequestBody User user) {
            System.out.println("user update..." + user);
            return "{'module':'user update'}";
        }
        
        @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
        @ResonseBody
        public String getById(@PathVariable Integer id) {
            System.out.println("user getById..." + id);
            return "{'module':'user getById'}";
        }
        
        @RequestMapping(value = "/users",method = RequestMethod.GET)
        @ResonseBody
        public String getAll() {
            System.out.println("user getAll...");
            return "{'module':'user getAll'}";
        }
    }
    ```

- 还可以再简化

  - ```java
    @RestController
    @RequestMapping("/users")
    public class UserController {
        
        @PostMapping
        public String save() {//这里修改时先不传参数了
            System.out.println("user save..." + user);
            return "{'module':'user save'}";
        }
        
        @DeleteMapping("/{id}")
        public String delete(@PathVariable Integer id) {//PathVariable 表示来自请求路径
            System.out.println("user delete..." + id);
            return "{'module':'user delete'}";
        }
        
       @PutMapping
        public String update(@RequestBody User user) {
            System.out.println("user update..." + user);
            return "{'module':'user update'}";
        }
        
        @GetMapping("/{id}")
        public String getById(@PathVariable Integer id) {
            System.out.println("user getById..." + id);
            return "{'module':'user getById'}";
        }
        
        @GetMapping
        public String getAll() {
            System.out.println("user getAll...");
            return "{'module':'user getAll'}";
        }
    }
    ```



- @RequestBody @RequestParam @PathVariable
- 区别
  - @RequestParam 用于接受url地址传参或表单传参
  - @RequestBody 用于接受json数据
  - @PathVariable 用于接受路径参数，使用{参数名称}描述路径参数
- 应用
  - 后期开发中，发送请求参数超过1个时，以json格式为主，@RequestBody 应用较广
  - 如果发送非json格式数据，选用@RequestParam接收请求参数
  - 采用RESTful进行开发，当参数数量较少时，例如1个，可以采用@PathVariable接受请求路径变量，通常用于传递id值



## 1.3查看文档

在官网中点击learn-> Reference Doc -> 点击application Properties查看文档

### 1.3.1属性配置之修改

- 修改服务器端口

  ```properties
  server.port=80
  ```

- 关闭运行日志图标

  ```properties
  spring.main.banner-mode=off
  ```

- 设置日志相关

  ```properties
  logging.level.root=debug
  ```

  

### 1.3.2属性配置

SpringBoot提供了多种属性配置方式

- application.properties

  ```properties
  server.port=80
  ```

- application.yml **主流格式**

  ```yml
  server:
  	# 注意格式 有一个空格
  	port: 81 
  ```

- application.yaml

  ```yaml
  server:
  	port: 82
  ```



- 其中加载的优先级是 properties > yml > yaml
- 不同配置文件中相同配置按照加载优先级相互覆盖，不同配置文件中不同配置全部保留



## 1.4配置文件提示消失解决

是因为idea没有识别到yml文件，此时看pdf 自动提示功能小时解决方案



## 1.5yaml语法规则

- 大小写敏感
- 属性层级关系使用多行描述，每行结尾使用冒号结束
- 使用缩进表示层级关系，同层级左侧对齐，只允许使用空格（不允许使用Tab键）
- 属性值前面添加空格（属性名与属性值之间使用冒号+空格作为分隔）
- ```#``` 表示注释
- **支持转义字符，不过需要用引号**

**核心规则**：**数据前面要加空格与冒号隔开**



### 1.5.1字面值表示方式

```yml
boolean: TRUE #TRUE,true,True,FALSE,false，False均可
float: 3.14 #6.8523015e+5 #支持科学计数法
int: 123 #0b1010_0111_0100_1010_1110 #支持二进制、八进制、十六进制
null: ~ #使用~表示null
string: HelloWorld #字符串可以直接书写
string2: "Hello World" #可以使用双引号包裹特殊字符
date: 2018-02-17 #日期必须使用yyyy-MM-dd格式
datetime: 2018-02-17T15:02:31+08:00 #时间和日期之间使用T连接，最后使用+代表时区
```



### 1.5.2读取yml引用类型数据

1. 创建类，用于封装下面的数据
2. 由spring帮我们去加载数据到对象中，一定要告诉spring加载这组信息
3. 使用时候从spring中追节获取信息使用



## 1.6整合第三方技术

### 1.6.2MyBatis

- 核心配置：数据库连接相关信息
- 映射配置：SQL映射



步骤：

1. 导入对应的starter
2. 配置相关信息
3. **一般导入的坐标是对应的starter**

![image-20220407225308966](C:\Users\home\AppData\Roaming\Typora\typora-user-images\image-20220407225308966.png)



## 1.7案例整合
