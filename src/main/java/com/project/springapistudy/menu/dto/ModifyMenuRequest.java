package com.project.springapistudy.menu.dto;

import com.project.springapistudy.menu.entity.MenuType;
import lombok.Getter;

@Getter
public class ModifyMenuRequest {

    private final Long id;

    private final String name;

    private final MenuType menuType;

    private final Integer price;

    private final Boolean isUse;

    public ModifyMenuRequest(Long id, String name, MenuType menuType, Integer price, Boolean isUse) {
        this.id = id;
        this.name = name;
        this.menuType = menuType;
        this.price = price;
        this.isUse = isUse;
    }
}
