### Data Studio客户端工具

-   -   [写在前面](https://blog.csdn.net/dive668/article/details/117482110?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169492187016800215017887%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=169492187016800215017887&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-3-117482110-null-null.142^v94^control&utm_term=opengauss%20%E5%9B%BE%E5%BD%A2%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7&spm=1018.2226.3001.4187#_1)
    -   [1.3 Data Studio客户端工具](https://blog.csdn.net/dive668/article/details/117482110?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169492187016800215017887%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=169492187016800215017887&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-3-117482110-null-null.142^v94^control&utm_term=opengauss%20%E5%9B%BE%E5%BD%A2%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7&spm=1018.2226.3001.4187#13_Data_Studio_3)
    -   -   [1.3.1 准备连接环境](https://blog.csdn.net/dive668/article/details/117482110?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169492187016800215017887%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=169492187016800215017887&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-3-117482110-null-null.142^v94^control&utm_term=opengauss%20%E5%9B%BE%E5%BD%A2%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7&spm=1018.2226.3001.4187#131__26)
        -   [1.3.2 确定26000端口是否放开](https://blog.csdn.net/dive668/article/details/117482110?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169492187016800215017887%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=169492187016800215017887&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-3-117482110-null-null.142^v94^control&utm_term=opengauss%20%E5%9B%BE%E5%BD%A2%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7&spm=1018.2226.3001.4187#132_26000_96)
        -   [1.3.3 软件包下载及安装](https://blog.csdn.net/dive668/article/details/117482110?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169492187016800215017887%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=169492187016800215017887&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-3-117482110-null-null.142^v94^control&utm_term=opengauss%20%E5%9B%BE%E5%BD%A2%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7&spm=1018.2226.3001.4187#font_colorred133_font_101)
        -   [1.3.4 Data Studio用户界面](https://blog.csdn.net/dive668/article/details/117482110?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169492187016800215017887%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=169492187016800215017887&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-3-117482110-null-null.142^v94^control&utm_term=opengauss%20%E5%9B%BE%E5%BD%A2%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7&spm=1018.2226.3001.4187#134_Data_Studio_122)
        -   [1.3.5 获取工具使用手册](https://blog.csdn.net/dive668/article/details/117482110?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169492187016800215017887%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=169492187016800215017887&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-3-117482110-null-null.142^v94^control&utm_term=opengauss%20%E5%9B%BE%E5%BD%A2%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7&spm=1018.2226.3001.4187#135__141)

## 写在前面

> 因为博主并没有购买使用华为云的openGauss及openEurler。使用的是再VirtualBox上的镜像搭建起来的openGauss。因此对于1.3.2在华为云上配置安全策略，开放端口的操作等可以忽略。直接跳转到1.3.3软件包下载进行的后序操作。

## 1.3 Data Studio客户端工具

Data Studio是一个**集成开发环境（IDE）**，帮助数据库开发人员便捷地构建应用程序，以**图形化界面形式提供数据库关键特性**。  
数据库开发人员仅需掌握少量的编程知识，即可使用该工具进行数据库对象操作。  
**Data Studio提供丰富多样的特性，例如：**

-   创建和管理数据库对象
-   执行SQL语句/脚本
-   编辑和执行PL/SQL语句
-   图形化查看执行计划和开销
-   导出表数据等

**创建和管理数据库对象包括：**

-   数据库
-   模式
-   函数
-   过程
-   表
-   序列
-   索引
-   视图
-   表空间
-   同义词

Data Studio还提供**SQL助手**用于在**SQL终端**和**PL/SQLViewer**中**执行各种查询/过程/函数**。

### 1.3.1 准备连接环境

-   步骤 1修改数据库的`pg_hba.conf`文件。

在GS\_HOME中查找pg\_hba.conf文件，本实验中数据库GS\_HOME设置的为`/gaussdb/data/db1`(db1修改为自己的数据库名字，例如博主的db1997)，实际操作中GS\_HOME地址可以查看安装时的配置文件：`<PARAM name="dataNode1" value="/gaussdb/data/db1"/>`。

```
[root@db1 ~]# cd /gaussdb/data/db1
[root@ecs-b5cb db1]# vi pg_hba.conf
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602202925172.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602202717477.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RpdmU2Njg=,size_16,color_FFFFFF,t_70)

将以下内容添加进pg\_hba.conf文件。

```
host all all 0.0.0.0/0 sha256


host    all    all    192.168.66.0/24    sha256

```

具体如下：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602202902385.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RpdmU2Njg=,size_16,color_FFFFFF,t_70)  
切换至omm用户环境，使用gs\_ctl将策略生效。

```
[root@db1 db1]#su - omm
[omm@db1 ~]$gs_ctl reload -D /gaussdb/data/db1997/
```

返回结果为：  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602203040589.png)

-   步骤 2登陆数据库并创建“dboper”用户，密码为“dboper@123”（密码可自定义），同时进行授权，并退出数据库。

```
[omm@db1 ~]$gsql -d postgres -p 26000 -r
postgres=#CREATE USER dboper IDENTIFIED BY 'dboper@123';
CREATE ROLE
postgres=#alter user dboper sysadmin;
ALTER ROLE
postgres=# \q


aleter user peter sysadmin;


```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602203720810.png)

退出OMM用户环境

```
[omm@ecs-b5cb ~]$ exit
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602203732196.png)

-   步骤 3修改数据库监听地址。  
    在GS\_HOME中，本实验中数据库GS\_HOME设置的为`/gaussdb/data/db1997`。

```
[root@ecs-b5cb ecs-b5cb]# cd /gaussdb/data/db1997
[root@db1 ~]# vi postgresql.conf
```

将listen\_addresses的值修改成为 `*`

```
listen_addresses = '*'
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602204350195.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RpdmU2Njg=,size_16,color_FFFFFF,t_70)

修改完成后切换至OMM用户环境重启数据库生效（-D后面的数据库默认路径，需要根据**自己的数据库名字的实际情况**进行修改）。

```
[root@db1 db1]#su - omm
[omm@db1 ~]$gs_ctl restart -D /gaussdb/data/db1997/
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602204458377.png)

### 1.3.2 确定26000端口是否放开

-   步骤 1打开华为云首页，登录后进入“控制台”，点击“弹性云服务器ECS”进入ECS列表。
-   步骤 2在云服务器控制台找到安装数据库主机的ECS，点击查看基本信息，找到安全组。
-   步骤 3点击进入安全组，选择“入方向规则”并点“添加规则”，进行26000端口设置。

### 1.3.3 软件包下载及安装

-   步骤 1下载软件包。  
    获取参考地址：  
    [https://opengauss.obs.cn-south-1.myhuaweicloud.com/1.0.1/DataStudio\_win\_64.zip](https://opengauss.obs.cn-south-1.myhuaweicloud.com/1.0.1/DataStudio_win_64.zip)
    
-   步骤 2解压安装。  
    将下载的软件包（DataStudio\_win\_64.zip）解压到自己指定的位置，比如解压至D盘，具体如下：
    

> 名字是自己任意取  
> 主机一定是openGauss数据库安装所在的主机ip  
> 端口号是26000  
> 数据库，用户名和密码是三者互相对应的。

**注意不启用SSL**

### 1.3.4 Data Studio用户界面

Data Studio主界面包括：

1.  主菜单：提供使用Data Studio的基本操作；
2.  工具栏：提供常用操作入口；
3.  “SQL终端”页签：在该窗口，可以执行SQL语句和函数/过程；
4.  “PL/SQL Viewer”页签：显示函数/过程信息；
5.  编辑区域用于进行编辑操作；
6.  “调用堆栈”窗格：显示执行栈；  
    7.“断点“窗格：显示断点信息；
7.  “变量”窗格：显示变量及其变量值；
8.  “SQL助手”页签：显示“SQL终端”和“PL/SQL Viewer”页签中输入信息的建议或参考；
9.  “结果”页签：显示所执行的函数/过程或SQL语句的结果；
10.  “消息”页签：显示进程输出。显示标准输入、标准输出和标准错误；
11.  “对象浏览器”窗格：显示数据库连接的层级树形结构和用户有权访问的相关数据库对象；除公共模式外，所有默认创建的模式均分组在“系统模式”下，用户模式分组在相应数据库的“用户模式”下；
12.  “最小化窗口窗格”：用于打开“调用堆栈”和“变量”窗格。该窗格仅在“调用堆栈”、“变量”窗格中的一个或多个窗格最小化时显示。
13.  搜索工具栏：用于在“对象浏览器”窗格中搜索对象。  
    有些项不可见，除非触发特定功能。下图以openGauss界面为例说明：  
    ![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602213123296.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RpdmU2Njg=,size_16,color_FFFFFF,t_70)

### 1.3.5 获取工具使用手册

在Data Studio主界面的主菜单上点击帮助下的用户手册，具体如下：  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602213133268.png)

点击后即可得到使用手册，如下：  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210602213142163.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RpdmU2Njg=,size_16,color_FFFFFF,t_70)

本实验结束。