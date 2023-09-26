package com.project.springapistudy.menu.dto;

import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.MenuType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MenuResponse {

    private final Long id;

    private final String name;

    private final MenuType menuType;

    private final Integer price;

    private final Long createUserId;

    private final Boolean isUse;

    private final Boolean isDelete;

    private final List<MenuLogResponse> menuLogs;

    @Builder
    public MenuResponse(Long id, String name, MenuType menuType, Integer price, Long createUserId, Boolean isUse, Boolean isDelete, List<MenuLogResponse> menuLogs) {
        this.id = id;
        this.name = name;
        this.menuType = menuType;
        this.price = price;
        this.createUserId = createUserId;
        this.isUse = isUse;
        this.isDelete = isDelete;
        this.menuLogs = menuLogs;
    }

    public static MenuResponse of(Menu menu) {
        return MenuResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .menuType(menu.getMenuType())
                .price(menu.getPrice())
                .createUserId(menu.getCreateAdminId())
                .isUse(menu.getIsUse())
                .isDelete(menu.getIsDelete())
                .menuLogs(menu.getMenuLogList().stream().map(MenuLogResponse::of).collect(Collectors.toList()))
                .build();
    }

}
