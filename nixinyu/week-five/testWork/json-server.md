# JSON Server 前后端分离开发
##
##### 1.下载安装
  
`npm install -g json-server`

**安装完成后我们可以输入 `json-server` 来查看他的所有命令**
#
![如图](https://upload-images.jianshu.io/upload_images/574653-4be6b3a3f9a36552.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)

##### 2.简单使用
#
规范起见创建一个目录存放 `data.json` 数据
#

	{
		"posts": [
			{
				"id": 1, 
				"title": "json-server", 
				"author": "typicode" 
			}
		],
		"comments": [
			{ 
				"id": 1, 
				"body": "some comment",
				"postId": 1   
			} 
		], 
		"profile":  { 
				"name": "typicode" 
		}
	}

#
在这里我们创建了简单的测试数据
接下来我们需要启动json-server 并告诉json-server监视db.json

    json-server --watch data.json
##
如果没有错误终端将出现如下提示：
#
![json-server启动成功的提示](https://upload-images.jianshu.io/upload_images/574653-6752d92d931bbf80.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)
#
我们在浏览器中访问[http://localhost:3000](http://localhost:3000)地址 将看到如下内容
#
![http://localhost:3000](https://upload-images.jianshu.io/upload_images/574653-576036281b347920.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)
#
##
可以看到在Routes(路由)选项出 列举了 `data.json` 字典的所有 `keys` 
我们点击 `posts` 
#
![posts](https://upload-images.jianshu.io/upload_images/574653-864dc15744746201.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)
#
##
是不是访问到 `posts` 对应的数据了 ~~
你是不是突然间明白了？
 `json-server` 把 `data.json` 根节点的每个 `key`  当做一个 `router(路由)` 
也就是我们的 `API` 所有你存放编写测试数据时 要注意这个规则
我们也可以访问整个 `data.json` 的数据
  
`http://localhost:3000/db`<br /> 
**注意路由后面一定是 `db` 哦！不是文件名**
#
![访问整个数据](https://upload-images.jianshu.io/upload_images/574653-c10ff58d82330e2e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)

#
##
##### 3.能否通过id访问某个posts呢？
#
很简单 在浏览器中访问如下地址：
	
	http://localhost:3000/posts/1
#
![通过id访问](https://upload-images.jianshu.io/upload_images/574653-41d4f2176ebd77b0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)
#
通过这种方式访问 你必须确保posts中有个id为1的post
想要获得更高的灵活度 我们还可以属性过滤
比如上面的地址可以改为如下方式

	http://localhost:3000/posts?id=1
#
这种方式是不是很喜欢？ 这样我们就可以模拟接口参数了
当然也可以指定多个参数	

![通过多个参数访问](https://upload-images.jianshu.io/upload_images/574653-de6331b3ebf49823.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)
#
##
##### 4.分页

分页查询是非常常见的需求 json-server提供了如下关键字参数

**\_start**: 起始位置 从 `0` 开始
**\_end**: 结束位置 从 `0` 开始
**\_limit**: 每页数量

为了更好的演示该功能 我们需要向 `data.json` 中添加一点测试数据
如下:

	{
		"posts": [
			{ "id": 1, "title": "json-server", "author": "typicode" },  
			{ "id": 2, "title": "我是posts2", "author": "typicode" },      
			{ "id": 3, "title": "我是posts3", "author": "typicode" }, 
			{ "id": 4, "title": "我是posts4", "author": "typicode" }, 
			{ "id": 2, "title": "我是posts2", "author": "typicode" }, 
			{ "id": 5, "title": "我是posts5", "author": "typicode" }, 
			{ "id": 6, "title": "我是posts6", "author": "typicode" }, 
			{ "id": 7, "title": "我是posts7", "author": "typicode" }, 
			{ "id": 8, "title": "我是posts8", "author": "typicode" }, 
			{ "id":9, "title": "我是posts9", "author": "typicode" }, 
			{ "id":10, "title": "我是posts10", "author": "typicode" }
		],
		"comments": [
			{ "id": 1, "body": "some comment", "postId": 1 }
		],
		"profile": 
			{ "name": "typicode" }
	}

#
修改 `data.json` 后需要停止 `json-server` 并再次执行

	json-server --watch data.json

接着在浏览器中访问如下链接 （从 `0` 开始到 `5` 结束）

	http://localhost:3000/posts?_start=0&_end=5

![分页查询](https://upload-images.jianshu.io/upload_images/574653-5a504ae4a9e2624b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)
#
或者使用 `_limit` 关键字 获取固定数量的 `posts`

	http://localhost:3000/posts?_start=0&_limit=5

这样我们通过 `_start` 和 `_limit` 就可以实现分页功能
并可以添加其他查询条件比如
	
	http://localhost:3000/posts??title=json-server&_start=0&_limit=5

**以上我们还添加了 `title=json-server` 查询添加**

#

##### 5.排序
#

