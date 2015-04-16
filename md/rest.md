#  版本
* api.example.com/v1
* 将版本号放入头部

# endpoint
* 路径，又称终点，表示api的具体网址
* 网址中不能出现动词,只能出现名词,多个用复数
```
// ok
api.example.com/v1/zoos
api.example.com/v1/animals

// bad
/getProducts
/listOrders
/retreiveClientByOrder?orderId=1

```

# http动词
* GET（SELECT）：从服务器取出资源（一项或多项）。
* POST（CREATE）：在服务器新建一个资源。
* PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
* PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
* DELETE（DELETE）：从服务器删除资源。
```
GET /zoos
POST /zoos
GET /zoos/ID
PUT /zoos/ID 客户端提供完整的信息
PATCH /zoos/ID 客户端提供部分信息
DELETE /zoos/ID
```

# 过滤信息
* 如果记录较多，服务器不可能全部返回给用户，api提供参数，过滤返回结果
```
?limit=10
?offset=10
?page=2&per_page=10
?sortby=name&order=asc
?animal_type_id=1 指定筛选条件
```

# 状态码
```
200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
204 NO CONTENT - [DELETE]：用户删除数据成功。
400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
```

# 错误处理
* 如果状态码是4xx,应该向用户返回出错信息
```
{
	error: "Invalid API key"
}

HTTP/1.1 401 Unauthorized
{
    "status": "Unauthorized",
    "message": "No access token provided.",
    "request_id": "594600f4-7eec-47ca-8012-02e7b89859ce"
}
```

# HATEOAS
* 能够列出所有的api
```
eg: https://api.github.com/
或者 api.example.com/v1/*

```
* https://github.com/thovid/play-hateoas-client
* https://github.com/mikekelly/hal_specification/wiki/Libraries

# 实用网址
* https://bourgeois.me/rest/
* http://codeplanet.io/principles-good-restful-api-design/
