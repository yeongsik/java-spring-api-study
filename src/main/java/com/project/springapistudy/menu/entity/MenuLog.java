package com.project.springapistudy.menu.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class MenuLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;


    private LocalDateTime createLogTime;

    private Long adminId;

    private String action; // Create, Update, Delete

    private String changeContents;

    @Builder
    public MenuLog(Menu menu, LocalDateTime createLogTime, Long adminId, String action, String changeContents) {
        this.menu = menu;
        this.createLogTime = createLogTime;
        this.adminId = adminId;
        this.action = action;
        this.changeContents = changeContents;
    }

    public static MenuLog of(Menu menu, String action) {
        return MenuLog.builder()
                .menu(menu)
                .createLogTime(LocalDateTime.now())
                .adminId(menu.getCreateAdminId())
                .action(action)
                .build();
    }
}
