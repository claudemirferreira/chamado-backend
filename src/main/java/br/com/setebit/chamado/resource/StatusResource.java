package br.com.setebit.chamado.resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.setebit.chamado.model.entity.Status;
import br.com.setebit.chamado.model.repository.StatusRepository;
import br.com.setebit.chamado.util.CustomErrorType;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/status/")
@Api(value = "Greeting", description = "Greeting people")
public class StatusResource {

	public static final Logger logger = LoggerFactory.getLogger(StatusResource.class);

	@Autowired
	private StatusRepository repository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Status>> findAll() {
		List<Status> list = repository.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Status>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable("id") long id) {
		logger.info("Fetching Status with id {}", id);
		Optional<Status> status = repository.findById(id);
		if (status.isPresent()) {
			logger.error("Course with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("status with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Status>(status.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Status entity, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Course : {}", entity);

		if (repository.existsById(entity.getId())) {
			logger.error("Unable to create. A Course with name {} already exist", entity.getNome());
			return new ResponseEntity(
					new CustomErrorType("Unable to create. A Course with name " + entity.getNome() + " already exist."),
					HttpStatus.CONFLICT);
		}
		repository.save(entity);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("{id}").buildAndExpand(entity.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Status entity) {
		logger.info("Updating Course with id {}", id);

		Optional<Status> status = repository.findById(id);

		if (status.isPresent()) {
			logger.error("Unable to update. Course with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Status with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		entity.setNome(entity.getNome());

		repository.save(entity);
		return new ResponseEntity<Status>(entity, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCourse(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Course with id {}", id);

		Optional<Status> course = repository.findById(id);
		if (course == null) {
			logger.error("Unable to delete. Course with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Status with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		repository.delete(new Status(id, null));

		return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
	}

}