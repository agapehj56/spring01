package com.example.country.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.mapper.CountryMapper;
import com.example.util.Pagination;

@Service
public class CountrySearchService {

	static Log log = LogFactory.getLog(CountrySearchService.class);
	
	@Autowired
	CountryMapper countryMapper;
	
	public List<Country> getListAll(){
		log.info("getListAll()");
		return getListAll(false);
	}
	
	public List<Country> getListAll(boolean withCity){
		log.info("getListAll(" + withCity + ")");
		List<Country> list = null;
		if(withCity)
			list = countryMapper.selectAllWithCity();
		else
			list = countryMapper.selectAll();
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo){
		return getPage(pageNo, false);
	}
	
	public Map<String, Object> getPage(int pageNo, boolean withCity){
		Pagination paging = new Pagination();
		paging.setTotalItem(countryMapper.selectTotalCount());
		paging.setPageNo(pageNo);
		
		List<Country> list = null;
		if(withCity)
			list = countryMapper.selectPageWithCity(paging);
		else
			list = countryMapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("countrys", list);
		map.put("paging", paging);
		
		return map;
	}
	
	public Country getCountryByCode(String code){
		log.info("getCountryByCode(" + code + ")");
		return getCountryByCode(code, false);
	}
	
	public Country getCountryByCode(String code, boolean withCity){
		log.info("getCountryByCode(" + code + ", " + withCity + ")");
		Country country = null;
		if(withCity)
			country = countryMapper.selectByCodeWithCity(code);
		else
			country = countryMapper.selectByCode(code);
		
		return country;
	}
}
