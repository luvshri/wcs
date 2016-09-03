# wcs
project for lianyungang water conservation management

## api 接口说明:
### 1.用户登录
#### request:
* url:/user/login
* HTTP 1.1/POST
* 参数名称	    取值	    说明	    required
  userName	    String	用户名	TRUE</br>
  password	    String	密码	    TRUE</br>

#### response:
{
	code: 200,						//业务码，200成功
	data: {
		projectCategories: [			//工程种类
					{
						id: 1,
						createTime: "2016-08-15 10:37:12",
						updateTime: "2016-08-15 10:37:11",
						isDelete: 0,
						name: "泵站"
					},…
					],
				user: {			//用户信息
						id: 1,
						createTime: "2016-08-15 10:37:11",
						updateTime: "2016-09-03 14:39:14",
						isDelete: 0,
						name: "weck",		//用户名
						password:””
						salt: "",
						token: “", //重要字段，登录后的每次请求需要
						county: {		//用户所在县的信息
								id: 1,
								createTime: "",
								updateTime: "",
								isDelete: 0,
								name: "nankang",	//县名称
								isActive: 1,
								location: null	//地图信息
								},
						roles: [			//用户的角色信息
							{
								id: 1,
								createTime: "",
								updateTime: "",
								isDelete: 0,
								name: "admin",	//角色名称
								isActive: 1
							},…
							],
						phone: null,
						isActive: 1,
						email: null,
						realName: "weck"		//用户真实姓名
					}
				},
	error: null				//错误信息
}     