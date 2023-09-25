package com.project.springapistudy.menu.service;

import com.project.springapistudy.menu.dto.*;

import java.util.List;

public interface MenuService {

    void createMenu(CreateMenuRequest request);

    MenuResponse findOneMenuById(ReadMenuRequest readMenuRequest);

    List<MenuResponse> findAllMenu();

    void updateMenu(ModifyMenuRequest modifyMenuRequest);

    void deleteMenu(DeleteMenuRequest deleteMenuRequest);

}
