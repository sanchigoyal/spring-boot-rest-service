package com.sanchi.java.rest.service;

import com.sanchi.java.rest.exception.RecordNotFoundException;
import com.sanchi.java.rest.model.Department;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDataService {

  public static final String ENTITY_DEPARTMENT = "department";
  public static Map<Integer, Department> data;
  public static int counter = 0;

  public DepartmentDataService() {
    doInit();
  }

  private void doInit() {
    data = new HashMap<>();
    data.put(++counter, new Department(1, "Computer Science"));
    data.put(++counter, new Department(2, "Electronics and Communication"));
    data.put(++counter, new Department(3, "Mechanical"));
  }

  /**
   * Returns all departments.
   */
  public List<Department> get() {
    return new ArrayList<>(data.values());
  }

  /**
   * Return a matching department.
   */
  public Department get(int id) throws RecordNotFoundException {

    if (data.get(id) == null) {
      throw new RecordNotFoundException(id, ENTITY_DEPARTMENT);
    }

    return data.get(id);
  }

  /**
   * Creates a new department.
   */
  public Department create(Department department) {
    department.setId(++counter);
    data.put(department.getId(), department);
    return department;
  }

  /**
   * Updates an existing department.
   */
  public Department update(Department department) throws RecordNotFoundException {

    if (data.get(department.getId()) == null) {
      throw new RecordNotFoundException(department.getId(), "department");
    }
    data.put(department.getId(), department);
    return department;
  }

  /**
   * Deletes a department.
   */
  public void delete(int id) {
    data.remove(id);
  }
}
