package com.codeup.repositories;
import com.codeup.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by rubenvarela on 2/13/17.
 */
@Repository
public interface Roles extends CrudRepository<UserRole, Long> {
    @Query("SELECT ur.role FROM UserRole ur, User u WHERE u.username=?1 AND ur.userId = u.id")
    public List<String> ofUserWith(String username);
}
