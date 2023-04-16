package com.management.project_managment.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.management.project_managment.dto.HistoricDTO;
import com.management.project_managment.services.HistoricService;

@RestController
@RequestMapping(value = "/historical")
public class HistoricResource {
	
	@Autowired
	private HistoricService historicService;
	
	
	@PostMapping
	public ResponseEntity<HistoricDTO> InsertNewHistoric(@RequestBody HistoricDTO dto) {
		dto = historicService.InsertHistorical(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HistoricDTO> findById(@PathVariable Long id) {
		HistoricDTO dto = historicService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
}