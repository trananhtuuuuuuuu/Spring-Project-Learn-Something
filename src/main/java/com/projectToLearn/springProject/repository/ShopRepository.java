package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectToLearn.springProject.domain.Shop;
import java.util.List;


public interface ShopRepository extends JpaRepository<Shop, Long> {
  List<Shop> findByAddress(String address);
  List<Shop> findByName(String name);

  @Query("select s from Shop s where year(s.dateOriginal) = :year")
  List<Shop> findByYear(@Param("year") int year);

  @Query("select s from Shop s where year(s.dateOriginal) = :year And month(s.dateOriginal) = :month")
  List<Shop> findByMonthAndYear(@Param("month") int month,
  @Param("year") int year);
}
