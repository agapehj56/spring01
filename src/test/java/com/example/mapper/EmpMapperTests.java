package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.domain.Emp;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTests {

	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	DeptMapper deptMapper;
	
	@Test
	public void test00_confirmMapper() {
		System.out.println("empMapper= " + empMapper);
	}
	
	@Test
	public void test01_selectAll() {
		List<Emp> emps = empMapper.selectAll();
		
		for(Emp e : emps)
			System.out.println(e);
	}	
	
	@Test
	public void test01_selectAllWithDept() {
		List<Emp> emps = empMapper.selectAllWithDept();
		
		for(Emp e : emps)
			System.out.println(e);
	}
	
	@Test
	public void test02_selectPage() {
		Pagination paging = new Pagination();
		paging.setTotalItem(empMapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Emp> emps = empMapper.selectPage(paging);
		
		for(Emp e : emps)
			System.out.println(e);
	}
	
	@Test
	public void test02_selectPageWithDept(){
		Pagination paging = new Pagination();
		paging.setTotalItem(empMapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Emp> emps = empMapper.selectPageWithDept(paging);
		
		for(Emp e : emps)
			System.out.println(e);		
	}
	
	@Test
	public void test03_selectByEmpno(){
		Emp emp = empMapper.selectByEmpno(7566);
		
		if(emp == null){
			throw new NotFoundRuntimeException("Emp 정보가 없습니다");
		}
		System.out.println(emp);
	}
	
	@Test
	public void test03_selectByEmpnoWithDept(){
		Emp emp = empMapper.selectByEmpnoWithDept(7566);
		
		if(emp == null){
			throw new NotFoundRuntimeException("Emp 정보가 없습니다");
		}
		System.out.println(emp);
	}
	
	@Test
	public void test04_insert(){
		Emp emp = new Emp();
		emp.setEname("xyz");
		emp.setDeptno(10);
		
		Dept dept = deptMapper.selectByDeptno(emp.getDeptno());
		
		if(dept == null){
			System.out.println("error = " + "해당 부서가 없습니다.");
			return;
		}
		
		int cnt = empMapper.insert(emp);
		System.out.println(empMapper.selectByEmpno(emp.getEmpno()));
	}
}
