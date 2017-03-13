package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTests {

	@Autowired
	CityMapper cityMapper;
	
	@Autowired
	CountryMapper countryMapper;
	
	@Test
	public void test00_confirmCityMapper() {
		System.out.println("cityMapper= " + cityMapper);
	}
	
	@Test
	public void test00_confirmCountryMapper() {
		System.out.println("countryMapper= " + countryMapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<City> cities = cityMapper.selectAll();
		
		for(City c : cities)
			System.out.println(c);
	}
	
	@Test
	public void test01_selectAllWithCountry(){
		List<City> cities = cityMapper.selectAllWithCountry();
		
		for(City c : cities)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(1000);
		
		List<City> cities = cityMapper.selectPage(paging);
		
		for(City c : cities)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPageWithCountry(){
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(1000);
		
		List<City> cities = cityMapper.selectPageWithCountry(paging);
		
		for(City c : cities)
			System.out.println(c);
	}
	
	@Test
	public void test03_selectById(){
		City city = cityMapper.selectById(460000);
		
//		if(city == null){
//			throw new NotFoundRuntimeException("City 정보가 없습니다.");
//		}
		System.out.println(city);
	}
	
	@Test
	public void test03_selectByIdWithCountry(){
		City city = cityMapper.selectByIdWithCountry(1);
		
		if(city == null){
			throw new NotFoundRuntimeException("City 정보가 없습니다.");
		}
		
		System.out.println(city);
	}
	
	@Test
	public void test04_insert(){
		City city = new City();
		city.setName("xxx");
		city.setCountryCode("KOR");
		
		Country country = countryMapper.selectByCode(city.getCountryCode());
		
		if(country == null){
			System.out.println("error = " + "해당 Country Code가 없습니다");
			return;
		}
		int cnt = cityMapper.insert(city);
		System.out.println(cityMapper.selectById(city.getId()));
	}
}
