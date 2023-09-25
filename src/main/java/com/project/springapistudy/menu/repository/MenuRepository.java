package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long>, MenuCustomRepository {

    Optional<Menu> findByName(String name);

}
