package com.example.crud.repository;

import com.example.crud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> { //Чтобы дергать энити. Spring сам создаст реализацию.
    //Person deleteById(Long id);


    @Query(value = "select max(id) from person", nativeQuery = true)
    Long getMaxId();


}
