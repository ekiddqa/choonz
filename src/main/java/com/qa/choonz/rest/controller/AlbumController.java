package com.qa.choonz.rest.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.rest.dto.AlbumDTO;
import com.qa.choonz.service.AlbumService;

@RestController
@RequestMapping("/albums")
@CrossOrigin("https://localhost:8082")
public class AlbumController {

	private AlbumService service;

	public AlbumController(AlbumService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<AlbumDTO> create(@RequestBody Album album) {
		return new ResponseEntity<>(this.service.create(album), HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<AlbumDTO>> read() {
		return new ResponseEntity<>(this.service.read(), HttpStatus.OK);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<AlbumDTO> read(@PathVariable long id) {
		return new ResponseEntity<>(this.service.read(id), HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<AlbumDTO> update(@RequestBody Album album, @PathVariable long id) {
		return new ResponseEntity<>(this.service.update(album, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AlbumDTO> delete(@PathVariable long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/read/name/{name}")
	public ResponseEntity<List<AlbumDTO>> read(@PathVariable String name) {
		return new ResponseEntity<>(this.service.read(name), HttpStatus.OK);
	}

}
