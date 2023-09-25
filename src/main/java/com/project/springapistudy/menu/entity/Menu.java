package com.project.springapistudy.menu.entity;

import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.dto.MenuResponse;
import com.project.springapistudy.menu.dto.ModifyMenuRequest;
import com.project.springapistudy.menu.dto.ReadMenuRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MenuType menuType;

    private Integer price;

    private Boolean isUse;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private Long createAdminId; // 추후에 유저 API 시 연관관계 설정

    private Boolean isDelete;

    @OneToMany(mappedBy = "menu")
    private List<MenuLog> menuLogList = new ArrayList<>();

    @Builder
    public Menu(Long id, String name, MenuType menuType, Integer price, Boolean isUse, LocalDateTime createDate, LocalDateTime updateDate, Long createAdminId, Boolean isDelete, List<MenuLog> menuLogList) {
        this.id = id;
        this.name = name;
        this.menuType = menuType;
        this.price = price;
        this.isUse = isUse;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createAdminId = createAdminId;
        this.isDelete = isDelete;
        this.menuLogList = menuLogList;
    }

    public static Menu of(CreateMenuRequest createMenuRequest) {

        return Menu.builder()
                .id(1L)
                .name(createMenuRequest.getName())
                .menuType(createMenuRequest.getMenuType())
                .price(createMenuRequest.getPrice())
                .isUse(createMenuRequest.getIsUse())
                .createDate(LocalDateTime.now())
                .build();
    }

    public static Menu of(ReadMenuRequest readMenuRequest) {
        return Menu.builder()
                .id(readMenuRequest.getId())
                .build();
    }

    public void updateFrom(ModifyMenuRequest modifyMenuRequest) {
        name = modifyMenuRequest.getName();
        menuType = modifyMenuRequest.getMenuType();
        price = modifyMenuRequest.getPrice();
        isUse = modifyMenuRequest.getIsUse();
        updateDate = LocalDateTime.now();
    }

    public void delete() {
        isDelete = true;
    }
}
