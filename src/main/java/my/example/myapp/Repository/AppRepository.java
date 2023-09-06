package my.example.myapp.Repository;

import my.example.myapp.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
@Repository
public interface AppRepository extends JpaRepository<Operation, String> {

}
