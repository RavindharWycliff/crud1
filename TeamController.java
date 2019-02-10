package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody

	public ResponseEntity<Team> getTeam(@PathVariable(value = "id") String id) throws Exception {
		System.out.printf("PersonRestResponseEntityController  - getPerson - id: {}", id);
	
		    HttpHeaders responseHeaders = new HttpHeaders();
		    //responseHeaders.setLocation(location);
		    responseHeaders.add(id, id);
		Team team = teamService.getTeam(id);
		if (id.equals(null) || id.isEmpty()) {

			return new ResponseEntity<>(team,responseHeaders, HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<>(team, HttpStatus.FOUND);

	}

	@RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List addTeam(@RequestBody Team f) {
		return teamService.addTeam(f);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List deleteTeam(@PathVariable(value = "id") String id) {
		return teamService.deleteTeam(id);
	}
	
	//https://stackoverflow.com/questions/28228068/spring-boot-full-rest-crud-example

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	
	
	public List updateTeam(@RequestBody Team f) {
		return teamService.updateTeam(f);

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List insertTeam() {
		return teamService.insertTeam();
	}

}