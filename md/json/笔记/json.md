

# 2、JSON的处理

## 2.1、JSON回顾

- JSON(JavaScript Object Notation)：是一种轻量级的数据交换格式。 

- 它是基于 ECMAScript 规范的一个子集，采用完全独立于编程语言的文本格式来存储和表示数据。

- 简洁和清晰的层次结构使得 JSON 成为理想的数据交换语言。易于人阅读和编写，同时也易于计算机解析和生成，并有效的 提升网络传输效率。

  ![](.\img\json回顾.png)

  ```txt
  https://www.bejson.com/knownjson/webInterface/
  
  http://suggest.taobao.com/sug?code=utf-8&q=商品关键字&callback=cb
  
  
  https://www.bejson.com/  格式化 校验
  ```

  

- **创建格式**

  ![](.\img\创建格式.png)

  ```txt
  #   javaBean, User,  id, name, age
  对象类型
  {
  	"id":100,
  	"name":"tiger",
  	"age":18
  }
  数组类型：
    简单
  ["apple", "orange", "waterfall"]
  
  混合类型：
   数组包含对象
  [
     {
  	"id":100,
  	"name":"tiger",
  	"age":18
  	},
   {
  	"id":103,
  	"name":"pig",
  	"age":18
  	},
      
  ]
  
  混合类型： 对象里面包含数组
  {
  	"id":100,
  	"name":"tiger",
  	"age":18,
  	"dogList":["xiaoming","laowang"]
  }
  ```

  

- **常用方法** （Javascript JSON对象）

  ![](.\img\json-常用方法.png)

## 2.2、JSON转换工具的介绍

- 我们除了可以在 JavaScript 中来使用 JSON 以外，在 JAVA 中同样也可以使用 JSON。

- JSON 的转换工具是通过 JAVA 封装好的一些 JAR 工具包。 

- 可以将 JAVA 对象或集合转换成 JSON 格式的字符串，也可以将 JSON 格式的字符串转成 JAVA 对象。

- Jackson：开源免费的 JSON 转换工具，SpringMVC 转换默认使用 Jackson。

  - 1. 导入 jar 包。 
    
       ```txt
        <dependency>
                   <groupId>junit</groupId>
                   <artifactId>junit</artifactId>
                   <version>4.12</version>
               </dependency>
               <dependency>
                   <groupId>org.jsoup</groupId>
                   <artifactId>jsoup</artifactId>
                   <version>1.13.1</version>
               </dependency>
               <dependency>
                   <groupId>com.fasterxml.jackson.core</groupId>
                   <artifactId>jackson-databind</artifactId>
                   <version>2.13.0</version>
               </dependency>
         <dependency>
                   <groupId>org.projectlombok</groupId>
                   <artifactId>lombok</artifactId>
                   <version>1.18.22</version>
               </dependency>
       ```
    
       
    
    2. 创建核心对象。
    
    3. 调用方法完成转换。

- **常用类**

  ![](.\img\json转换工具-常用类.png)

- **ObjectMapper常用方法**

  ![](.\img\json转换工具-objectMapper.png)

## 2.3、JSON转换练习

1. **对象转 JSON, JSON 转对象。** 

   ```java
   /*
       JSON转换工具的使用
    */
   public class ObjectMapperTest {    
   	private ObjectMapper mapper = new ObjectMapper();
       /*
           1.User对象转json, json转User对象
             json字符串 = {"name":"张三","age":23}
             user对象 = User{name='张三', age=23}
        */
       @Test
       public void test01() throws Exception{
           //User对象转json
           User user = new User("张三",23);
           String json = mapper.writeValueAsString(user);
           System.out.println("json字符串：" + json);
   
           //json转User对象
           User user2 = mapper.readValue(json, User.class);
           System.out.println("java对象：" + user2);
       }
   }
   ```

2. **Map转 JSON, JSON 转 Map。**

   ```java
   /*
     2.map<String,String>转json, json转map<String,String>
     json字符串 = {"姓名":"张三","性别":"男"}
     map对象 = {姓名=张三, 性别=男}
   */
   @Test
   public void test02() throws Exception{
       //map<String,String>转json
       HashMap<String,String> map = new HashMap<>();
       map.put("姓名","张三");
       map.put("性别","男");
       String json = mapper.writeValueAsString(map);
       System.out.println("json字符串：" + json);
   
       //json转map<String,String>
       HashMap<String,String> map2 = mapper.readValue(json, HashMap.class);
       System.out.println("java对象：" + map2);
   }
   ```

3.  **Map转 JSON, JSON 转 Map。**

   ```java
   /*
     3.map<String,User>转json, json转map<String,User>
       json字符串 = {"中软一班":{"name":"张三","age":23},"中软二班":{"name":"李四","age":24}}
       map对象 = {中软一班=User{name='张三', age=23}, 中软二班=User{name='李四', age=24}}
    */
   @Test
   public void test03() throws Exception{
       //map<String,User>转json
       HashMap<String,User> map = new HashMap<>();
       map.put("中软一班",new User("张三",23));
       map.put("中软二班",new User("李四",24));
       String json = mapper.writeValueAsString(map);
       System.out.println("json字符串：" + json);
   
       //json转map<String,User>
       HashMap<String,User> map2 = mapper.readValue(json,new TypeReference<HashMap<String,User>>(){});
       System.out.println("java对象：" + map2);
   }
   ```

4. **List转 JSON, JSON 转 List。**(作业)

   ```java
   /*
     4.List<String>转json, json转 List<String>
       json字符串 = ["张三","李四"]
       list对象 = [张三, 李四]
   */
   @Test
   public void test04() throws Exception{
       //List<String>转json
       ArrayList<String> list = new ArrayList<>();
       list.add("张三");
       list.add("李四");
       String json = mapper.writeValueAsString(list);
       System.out.println("json字符串：" + json);
   
       //json转 List<String>
       ArrayList<String> list2 = mapper.readValue(json,ArrayList.class);
       System.out.println("java对象：" + list2);
   }
   ```

5. **List转 JSON, JSON 转 List。**

   ```java
   /*
     5.List<User>转json, json转List<User>
       json字符串 = [{"name":"张三","age":23},{"name":"李四","age":24}]
       list对象 = [User{name='张三', age=23}, User{name='李四', age=24}]
        */
   @Test
   public void test05() throws Exception{
       //List<User>转json
       ArrayList<User> list = new ArrayList<>();
       list.add(new User("张三",23));
       list.add(new User("李四",24));
       String json = mapper.writeValueAsString(list);
       System.out.println("json字符串：" + json);
   
       //json转List<User>
       ArrayList<User> list2 = mapper.readValue(json,new TypeReference<ArrayList<User>>(){});
       System.out.println("java对象：" + list2);
   }
   ```

将网页的结果由json 转换为 javaBean

```txt

http://localhost/json/object
http://localhost/json/array
http://localhost/json/users
```



```txt
 @Test
    public void testPostJson() throws Exception{
        String url = "http://git.gzpeter.com:8888/api/private/v1/login";
        String jsonBody = "{\"username\":\"zhang\",\"password\":\"mall123\"}";

        Connection conn = Jsoup.connect(url)
                .header("content-type", "application/json; charset=utf-8")
                .requestBody(jsonBody)
                .method(Connection.Method.POST);
        Connection.Response response = conn.ignoreContentType(true).execute();
        if (response.statusCode() == 200) {
//            String html = new String(response.bodyAsBytes(), "gbk");
            String html = new String(response.bodyAsBytes(), "utf-8");
//            Document doc = response.parse();
            System.out.println(html);
            ObjectMapper mapper = new ObjectMapper();
            Rbody rbody = mapper.readValue(html, Rbody.class);
            System.out.println(rbody);
            System.out.println(rbody.getData().getToken());
            Map map = mapper.readValue(html, Map.class);
            System.out.println(map);
            System.out.println(map.get("data"));
        }
```



## 2.4、小结

- **Jackson：**开源免费的 JSON 转换工具，SpringMVC 转换默认使用 Jackson。

- **可以将 JAVA 对象或集合转换成 JSON 格式的字符串，也可以将 JSON 格式的字符串转成 JAVA 对象。**

- **常用类**

  ![](.\img\json转换工具-objectMapper.png)

## 项目实践

```txt
http://www.qinghuayuan.net/forum-2-1.html

读取论坛的列表， 并且 读取论坛的 内容 。
```

