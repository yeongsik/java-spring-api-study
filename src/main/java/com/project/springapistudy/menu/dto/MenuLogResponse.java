package com.project.springapistudy.menu.dto;

import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.MenuLog;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
public class MenuLogResponse {

    private LocalDateTime createLogTime;

    private Long adminId;

    private String action; // Create, Update, Delete

    private String changeContents;

    @Builder
    public MenuLogResponse(LocalDateTime createLogTime, Long adminId, String action, String changeContents) {
        this.createLogTime = createLogTime;
        this.adminId = adminId;
        this.action = action;
        this.changeContents = changeContents;
    }

    public static MenuLogResponse of(MenuLog menuLog) {
        return MenuLogResponse.builder()
                .action(menuLog.getAction())
                .adminId(menuLog.getAdminId())
                .createLogTime(menuLog.getCreateLogTime())
                .changeContents(menuLog.getChangeContents())
                .build();
    }
}
