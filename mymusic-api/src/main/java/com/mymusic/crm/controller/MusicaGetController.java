package com.mymusic.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymusic.crm.model.Musica;

@RestController
@RequestMapping(value = "/api/getMusic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class MusicaGetController {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@GetMapping
	public List<Musica> getAction(@RequestParam String id) {
		List<Musica> m = null;
		
		//SELECT ALL
		if(id.isEmpty() || id == "") {
			String sqlQuery = "SELECT * FROM musica";
			m = jdbc.query("SELECT * FROM musica",
					(resultSet, rowNum) -> new Musica(resultSet.getString("nome"), resultSet.getLong("id")));
			return m;
		}
		
		//SELECT AN SPECIFIC
		else if(id != null && id != "") {
			String sqlQuery = "SELECT * FROM musica";
			m = jdbc.query("SELECT * FROM musica WHERE id = '"+id+"'",
					(resultSet, rowNum) -> new Musica(resultSet.getString("nome"), resultSet.getLong("id")));
			return m;
		}
		
		
		else {
			return null;
		}
	}

}
