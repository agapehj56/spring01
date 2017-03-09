package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTests {

	@Autowired
	EmpMapper mapper;
	
	@Test
	public void test01_confirmMapper() {
		System.out.println("mapper= " + mapper);
	}
	
	@Test
	public void test01_selectAll() {
		List<Emp> emps = mapper.selectAll();
		
		for(Emp e : emps)
			System.out.println(e);
	}	
	
	@Test
	public void test01_selectAllWithDept() {
		List<Emp> emps = mapper.selectAllWithDept();
		
		for(Emp e : emps)
			System.out.println(e);
	}
	
	@Test
	public void test02_selectPage() {
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Emp> emps = mapper.selectPage(paging);
		
		for(Emp e : emps)
			System.out.println(e);
	}
	
	@Test
	public void test02_selectPageWithDept(){
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Emp> emps = mapper.selectPageWithDept(paging);
		
		for(Emp e : emps)
			System.out.println(e);		
	}
	
	@Test
	public void test03_selectByEmpno(){
		Emp emp = mapper.selectByEmpno(7566);
		
		if(emp == null){
			throw new NotFoundRuntimeException("Emp 정보가 없습니다");
		}
		System.out.println(emp);
	}
	
	@Test
	public void test03_selectByEmpnoWithDept(){
		Emp emp = mapper.selectByEmpnoWithDept(7566);
		
		if(emp == null){
			throw new NotFoundRuntimeException("Emp 정보가 없습니다");
		}
		System.out.println(emp);
	}
}
