package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.dto.MenuResponse;
import com.project.springapistudy.menu.dto.ReadMenuRequest;
import com.project.springapistudy.menu.entity.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuCustomRepository {

    List<Menu> findAllMenu();

    Optional<Menu> findMenuById(Menu req);

    Optional<Menu> findMenuByNameNotSameId(Menu req);
}
