package com.project.springapistudy.menu.fixture;

import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.entity.MenuType;

public class MenuFixture {
    public static final CreateMenuRequest SUCCESS_CREATE_AMERICANO =
            CreateMenuRequest.builder()
            .name("AMERICANO")
            .price(4500)
            .menuType(MenuType.COFFEE)
            .isUse(true)
            .build();

    public static final CreateMenuRequest SUCCESS_CREATE_LATTE =
            CreateMenuRequest.builder()
                    .name("LATTE")
                    .price(4800)
                    .menuType(MenuType.COFFEE)
                    .isUse(true)
                    .build();

    public static final CreateMenuRequest SUCCESS_CREATE_MILKTEA =
            CreateMenuRequest.builder()
                    .name("MILKTEA")
                    .price(4800)
                    .menuType(MenuType.BEVERAGE)
                    .isUse(true)
                    .build();
}
