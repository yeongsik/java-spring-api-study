package com.project.springapistudy.menu.fixture;

import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.dto.ReadMenuRequest;
import com.project.springapistudy.menu.entity.MenuType;

public class MenuFixture {
    public static final CreateMenuRequest SUCCESS_CREATE_MENU =
            CreateMenuRequest.builder()
            .name("AMERICANO")
            .price(4500)
            .menuType(MenuType.COFFEE)
            .isUse(true)
            .build();

}
