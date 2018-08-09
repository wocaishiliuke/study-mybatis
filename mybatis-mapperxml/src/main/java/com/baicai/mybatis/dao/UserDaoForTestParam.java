package com.baicai.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baicai.mybatis.pojo.User;

/**
 * 该接口用来测试mybatis的传参接参
 * @author yuzhou
 * @since 1.0.0
 */
public interface UserDaoForTestParam {
	
	/**
	 * 单个非表字段参数:
	 * 只能使用${},使用#{}报错;
	 * 1.不使用@Param: 只能使用${value}和${_parameter},不能使用${0}/${arg0}和${param1}
	 * 		此时的_parameter=参数
	 * 2.使用@Param时: 只能使用${param1}和${tableName},不能使用${0}/${arg0}、${value}和${_parameter}
	 * 		此时的_parameter是个map={param1=tb_user, tableName=tb_user}
	 */
	public List<User> queryAllByTableName(String tableName);
	public List<User> queryAllByTableNameWithAnno(@Param("tableName") String tableName);
	
	/**
	 * 单个表字段参数: 
	 * 推荐使用#{},${}也能用但不推荐
	 * 1.不使用@Param: #{任意字符}; 也可以使用${value}和${_parameter}但不推荐,不能使用${0}/${arg0}
	 * 		此时的_parameter=参数
	 * 2.使用@Param时: #{id}和#{param1}; 也可以使用${id}和${param1}但不推荐,不能使用${0}/${arg0}
	 * 		此时的_parameter是个map={id=1, param1=1}
	 */
	public User queryUserById(Long id);
	public User queryUserByIdWithAnno(@Param("id") Long id);
	
	/**
	 * 多个非表字段和表字段参数混合: 非表字段用${},表字段推荐用#{}
	 * 1.不使用@Param: 只能使用#{arg0}、${arg0}或#{param1}、${param1},两种key可以混用
	 * 		此时的_parameter是个map={arg3=张三, arg2=1, arg1=tb_user, arg0=tb_user, param3=1, param4=张三, param1=tb_user, param2=tb_user}
	 * 2.使用@Param时: 只能使用#{参数别名}、${参数别名}或#{param1}、${param1},两种key可以混用,不能使用${arg0}或#{arg0}
	 *  	此时的_parameter是个map={table2=tb_user, table1=tb_user, name=张三, id=1, param3=1, param4=张三, param1=tb_user, param2=tb_user}
	 */
	public List<User> queryAllByTableNamesAndIdName(String tableName1, String tableName2, Long id, String name);
	public List<User> queryAllByTableNamesAndIdNameWithAnno(@Param("table1") String tableName1, @Param("table2") String tableName2, @Param("id") Long id, @Param("name") String name);
	
	/**
	 * 单个Map: 此时不推荐使用@Param,会多此一举
	 * 1.不使用@Param: 只能使用#{变量名}(也能使用${变量名}但不推荐),变量名=map中的key
	 * 		此时的_parameter是个map=paramMap={name=张三, tableName=tb_user, id=1}
	 * 2.使用@Param时: 只能使用#{参数别名.变量名}或#{param1.变量名} (也能使用${参数别名.变量名}或${param1.变量名}但不推荐)
	 * 		此时的_parameter是个map={paramMap={name=张三, tableName=tb_user, id=1}, param1={name=张三, tableName=tb_user, id=1}}
	 */
	public List<User> queryAllByMap(Map<String, Object> map);
	public List<User> queryAllByMapWithAnno(@Param("paramMap") Map<String, Object> map);
	
	/**
	 * 单个POJO: 此时不推荐使用@Param,会多此一举
	 * 1.不使用@Param: 只能使用#{变量名}(也能使用${变量名}但不推荐),变量名=POJO中的属性
	 * 		此时的_parameter是个pojo=User[id=1, username=null, password=null, name=张三, age=null, sex=null, birthday=null, created=null, updated=null]
	 * 2.使用@Param时: 只能使用#{参数别名.变量名}或#{param1.变量名} (也能使用${参数别名.变量名}或${param1.变量名}但不推荐)
	 * 		此时的_parameter是个map={user=User [id=1, username=null, password=null, name=张三, age=null, sex=null, birthday=null, created=null, updated=null], param1=User [id=1, username=null, password=null, name=张三, age=null, sex=null, birthday=null, created=null, updated=null]}
	 */
	public List<User> queryAllByUser(User user);
	public List<User> queryAllByUserWithAnno(@Param("user") User user);
	
	/**
	 * 混合参数:String、POJO、Map
	 * 1.不使用@Param: 只能使用#{arg0}、${arg0}或#{param1}、${param1},两种key可以混用
	 * 		此时的_parameter是个map={arg3={name=白菜饼0}, arg2=User [id=6, username=null, password=null, name=null, age=null, sex=null, birthday=null, created=null, updated=null], arg1=baicai, arg0=tb_user, param3=User [id=6, username=null, password=null, name=null, age=null, sex=null, birthday=null, created=null, updated=null], param4={name=白菜饼0}, param1=tb_user, param2=baicai}
	 * 2.使用@Param时: 只能使用#{参数别名.变量名}或#{param1.变量名} (也能使用${参数别名.变量名}或${param1.变量名}但不推荐)
	 * 		此时的_parameter是个map={userName=baicai, param3=User [id=6, username=null, password=null, name=null, age=null, sex=null, birthday=null, created=null, updated=null], user=User [id=6, username=null, password=null, name=null, age=null, sex=null, birthday=null, created=null, updated=null], map={name=白菜饼0}, param4={name=白菜饼0}, param1=tb_user, tableName=tb_user, param2=baicai}
	 * 3.混合使用@Param: 
	 * {arg3={name=白菜饼0}, arg2=User [id=6, username=null, password=null, name=null, age=null, sex=null, birthday=null, created=null, updated=null], userName=baicai, param3=User [id=6, username=null, password=null, name=null, age=null, sex=null, birthday=null, created=null, updated=null], param4={name=白菜饼0}, param1=tb_user, tableName=tb_user, param2=baicai}
	 */
	public List<User> queryAllByMixed(String tableName, String userName, User paramUser, Map<String, Object> map);
	public List<User> queryAllByMixedWithAnno(@Param("tableName") String tableName, @Param("userName") String userName, @Param("user") User paramUser, @Param("map") Map<String, Object> map);
	public List<User> queryAllByMixedWithMixedAnno(@Param("tableName") String tableName, @Param("userName") String userName, User paramUser, Map<String, Object> map);
	
}
