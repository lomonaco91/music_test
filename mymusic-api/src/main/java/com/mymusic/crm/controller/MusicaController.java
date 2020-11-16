package com.mymusic.crm.controller;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymusic.crm.model.Musica;

@RestController
@RequestMapping(value = "/api/addMusic", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class MusicaController {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@PostMapping
	public ResponseEntity postAction(@RequestBody Musica m) {
		//If name is not empty or null
		if(m.getNome() != null && m.getNome() != "") {
			long uniqueID = new Random().nextLong();
			String sqlQuery = "INSERT INTO musica (id,nome) VALUES ('"+uniqueID+"', '"+m.getNome()+"')";
			jdbc.execute(sqlQuery);
			return new ResponseEntity(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
