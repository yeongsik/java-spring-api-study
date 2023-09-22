package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.dto.MenuResponse;
import com.project.springapistudy.menu.dto.ReadMenuRequest;

import java.util.List;
import java.util.Optional;

public interface MenuCustomRepository {

    Optional<List<MenuResponse>> findAllMenu();

    Optional<MenuResponse> findMenuById(ReadMenuRequest readMenuRequest);
}
