package com.yq.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.JoinusDao;

@Service
public class JoinusService{
	@Autowired
	private JoinusDao joinusDao;
	
	public int insert(Map<String,Object> map ){
		return joinusDao.insert(map);
	}
	
	
}
