package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptMapperTests {

	@Autowired
	DeptMapper mapper;
	
	@Test
	public void test00_cirfirmMapper(){
		System.out.println("mapper = " + mapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<Dept> dept = mapper.selectAll();
		
		for(Dept d : dept)
			System.out.println(d);
	}
	
	@Test
	public void test01_selectAllWithEmp(){
		List<Dept> dept = mapper.selectAllWithEmp();
		
		for(Dept d : dept)
			System.out.println(d);
	}
	
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Dept> dept = mapper.selectPage(paging);
		
		for(Dept d : dept)
			System.out.println(d);
	}
	
	@Test
	public void test02_selectPageWithEmp(){
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Dept> dept = mapper.selectPageWithEmp(paging);
		
		for(Dept d : dept)
			System.out.println(d);
	}
	
	@Test
	public void test03_selectByDeptno(){
		Dept dept = mapper.selectByDeptno(20);
		
		if(dept == null)
			throw new NotFoundRuntimeException("해당 부서가 없습니다.");
		
		System.out.println(dept);
	}
	
	@Test
	public void test03_selectByDeptnoWithEmp(){
		Dept dept = mapper.selectByDeptnoWithEmp(20);
		
		if(dept == null)
			throw new NotFoundRuntimeException("해당 부서가 없습니다.");
		
		System.out.println(dept);
	}
	
	@Test
	public void test04_insert(){
		Dept dept = new Dept();
		dept.setDeptno(60);
		dept.setDname("총무부");
		
		Dept d = mapper.selectByDeptno(dept.getDeptno());
		if(d != null){
			System.out.println("해당 부서는 존재합니다.");
			return;
		}		
		int cnt = mapper.insert(dept);
		System.out.println(mapper.selectByDeptno(dept.getDeptno()));
	}
}
