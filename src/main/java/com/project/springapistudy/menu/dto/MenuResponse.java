package com.project.springapistudy.menu.dto;

import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.MenuLog;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MenuResponse {

    private final Long id;

    private final String name;

    private final Integer price;

    private final Long createUserId;

    private final Boolean isUse;

    private final List<MenuLog> menuLogs;

    @Builder
    public MenuResponse(Long id, String name, Integer price, Long createUserId, Boolean isUse, List<MenuLog> menuLogs) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createUserId = createUserId;
        this.isUse = isUse;
        this.menuLogs = menuLogs;
    }



    public static MenuResponse of(Menu menu) {
        return MenuResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .price(menu.getPrice())
                .createUserId(menu.getCreateAdminId())
                .isUse(menu.getIsUse())
                .menuLogs(menu.getMenuLogList())
                .build();
    }
}
