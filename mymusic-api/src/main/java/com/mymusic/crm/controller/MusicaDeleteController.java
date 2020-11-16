package com.mymusic.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/delMusic", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class MusicaDeleteController {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@DeleteMapping
	public ResponseEntity delAction(@RequestParam String id) {
		//If id is not empty or null
		if(id != null && id != "") {
			String sqlQuery = "DELETE FROM musica WHERE id = '"+id+"'";
			jdbc.execute(sqlQuery);
			return new ResponseEntity(HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
