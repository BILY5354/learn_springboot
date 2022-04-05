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



