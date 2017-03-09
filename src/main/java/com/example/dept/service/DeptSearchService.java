package com.example.dept.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Dept;
import com.example.mapper.DeptMapper;

@Service
public class DeptSearchService {
	
	static Log log = LogFactory.getLog(DeptSearchService.class);
	
	@Autowired
	DeptMapper deptmapper;
	
	public List<Dept> getListAll(){
		log.info("getListAll()");
		return getListAll(false);
	}
	
	public List<Dept> getListAll(boolean withEmp){
		log.info("getListAll(" + withEmp + ")");
		List<Dept> list = null;
		if(withEmp)
			list = deptmapper.selectAllWithEmp();
		else
			list = deptmapper.selectAll();
		return list;
	}
}
