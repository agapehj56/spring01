package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryMapperTests {

	@Autowired
	CountryMapper mapper;
	
	@Test
	public void test00_cirfirmMapper(){
		System.out.println("mapper = " + mapper);
	}
	
	@Test
	public void test00_selectTotalCount(){
		System.out.println("totalCount = " + mapper.selectTotalCount());
	}
	
	@Test
	public void test01_selectAll(){
		List<Country> country = mapper.selectAll();
		
		for(Country c : country)
			System.out.println(c);
	}
	
	@Test
	public void test01_selectAllWithCity(){
		List<Country> country = mapper.selectAllWithCity();
		
		for(Country c : country)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Country> country = mapper.selectPage(paging);
		
		for(Country c : country)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPageWithCity(){
		
	}
	
	@Test
	public void test03_selectByCode(){
		Country country = mapper.selectByCode("KOR");
		
		if(country == null)
			throw new NotFoundRuntimeException("country가 없습니다.");
		
		System.out.println(country);
	}
	
	@Test
	public void test03_selectByCodeWithCity(){
		Country country = mapper.selectByCodeWithCity("KOR");
		
		if(country == null)
			throw new NotFoundRuntimeException("country가 없습니다.");
		
		System.out.println(country);
	}
}