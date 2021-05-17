package com.mybatispulse;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatispulse.entity.User;
import com.mybatispulse.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatispulseApplicationTests {

	@Autowired
	private UserMapper userMapper;

	// 查询所有数据
	@Test
	public void testSelect(){
		// wrapper == MP内置的条件封装器
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

	// 插入数据
	@Test
	public void testInsert(){
		User user = new User();
		user.setName("kuangcheng");
		user.setAge(24);
		user.setEmail("635908933@qq.com");
		int result = userMapper.insert(user);
		System.out.println(result); //影响的行数
		System.out.println(user); //id自动回填
	}

	// 更新数据
	@Test
	public void testUpdate(){
		User user = new User();
		user.setId(1L);      // id 是长整型
		user.setAge(28);

		int result = userMapper.updateById(user);
		System.out.println(result);
	}

	// 删除数据
	@Test
	public void testDetele(){
		int result = userMapper.deleteById(5L);
		System.out.println(result);
	}

	// 测试乐观锁 -- 成功
	@Test
	public void testOptimisticLocker() {
		User user = userMapper.selectById(10L);  // 查询
		user.setName("kc");
		user.setEmail("helen@qq.com");
		userMapper.updateById(user); // 更新
	}

	// 测试乐观锁 -- 失败

	@Test
	public void testOptimisticLockerFail() {
		//查询
		User user = userMapper.selectById(10L);
		//修改数据
		user.setName("Helen Yao1");
		user.setEmail("helen@qq.com1");
		//模拟取出数据后，数据库中version实际数据比取出的值大，即已被其它线程修改并更新了version
		user.setVersion(user.getVersion() - 1);
		//执行更新
		userMapper.updateById(user);
	}

	// 根据id查询
	@Test
	public void testSelectById() {
		User user = userMapper.selectById(1L);
		System.out.println(user);
	}

	// 批次查询
	@Test
	public void testSelectBatchIds(){
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
		users.forEach(System.out::println);
	}

	// 通过map封装查询条件
	// map中的key对应的是数据库中的列名
	@Test
	public void testSelectByMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "kc");
		map.put("age", 24);
		List<User> users = userMapper.selectByMap(map);
		users.forEach(System.out::println);
	}

	// 分页
	@Test
	public void testSelectPage() {
		// current-当前页；size-每页显示的记录数
		Page<User> page = new Page<>(1,5);
		userMapper.selectPage(page, null);

		page.getRecords().forEach(System.out::println);   // 当前页的list集合
		System.out.println(page.getCurrent());            // 当前页
		System.out.println(page.getPages());              // 页数
		System.out.println(page.getSize());               // 每页显示的记录数
		System.out.println(page.getTotal());              // 总记录数

		System.out.println(page.hasNext());   // 当前页是否有下一页
		System.out.println(page.hasPrevious());
	}

	// 简单的条件查询删除
	@Test
	public void testDeleteByMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "kc");
		map.put("age", 24);
		int result = userMapper.deleteByMap(map);
		System.out.println(result);
	}


}
