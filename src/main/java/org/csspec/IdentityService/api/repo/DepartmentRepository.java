package org.csspec.IdentityService.api.repo;

import org.csspec.IdentityService.db.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jatinder Dhawan on 10/12/2016.
 */
public interface DepartmentRepository extends MongoRepository<Department,String>{
    public Department findDepartmentByDepartmentId(String departmentId);
}
