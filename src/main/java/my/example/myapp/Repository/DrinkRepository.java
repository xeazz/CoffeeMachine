package my.example.myapp.Repository;

import my.example.myapp.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    @Query("SELECT drink.name FROM Drink drink WHERE drink.name = :name")
    Optional<String> findByName(@Param("name") String name);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Drink drink SET drink.cost = :cost WHERE drink.name = :name")
    void updateCostByName(@Param("name") String name, @Param("cost") Long cost);

}
