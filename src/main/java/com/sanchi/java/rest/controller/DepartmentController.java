package com.sanchi.java.rest.controller;

import com.sanchi.java.rest.exception.RecordNotFoundException;
import com.sanchi.java.rest.model.Department;
import com.sanchi.java.rest.service.DepartmentDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  @Autowired
  DepartmentDataService dataService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseEntity<List<Department>> get() {
    List<Department> departments = dataService.get();
    return ResponseEntity.ok(departments);
  }

  @RequestMapping(value = "/{department-id}", method = RequestMethod.GET)
  public ResponseEntity<Department> get(@PathVariable("department-id") int id)
      throws RecordNotFoundException {
    return ResponseEntity.ok(dataService.get(id));
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity<Department> create(@RequestBody Department department) {
    return ResponseEntity.status(HttpStatus.CREATED).body(dataService.create(department));
  }

  @RequestMapping(value = "/{department-id}", method = RequestMethod.PUT)
  public ResponseEntity<Department> update(@PathVariable("department-id") int id,
      @RequestBody Department department) throws RecordNotFoundException {
    department.setId(id);
    return ResponseEntity.ok(dataService.update(department));
  }

  @RequestMapping(value = "/{department-id}", method = RequestMethod.DELETE)
  public ResponseEntity delete(@PathVariable("department-id") int id) {
    dataService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
