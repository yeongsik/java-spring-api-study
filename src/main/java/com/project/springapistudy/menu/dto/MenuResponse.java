package com.project.springapistudy.menu.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MenuResponse {

    private final String name;

    private final String price;

    private final Long createUserId;

    private final Boolean isUse;

    private final List<MenuLogResponse> menuLogs;

    @Builder
    public MenuResponse(String name, String price, Long createUserId, Boolean isUse, List<MenuLogResponse> menuLogs) {
        this.name = name;
        this.price = price;
        this.createUserId = createUserId;
        this.isUse = isUse;
        this.menuLogs = menuLogs;
    }
}
