package com.project.springapistudy.menu.entity;

import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.dto.MenuResponse;
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

    private String menuImage;

    private Long createAdminId; // 추후에 유저 API 시 연관관계 설정

    private Boolean isDelete;

    @OneToMany(mappedBy = "menu")
    private List<MenuLog> menuLogList = new ArrayList<>();

    @Builder
    public Menu(Long id, String name, MenuType menuType, Integer price, Boolean isUse, LocalDateTime createDate, LocalDateTime updateDate, String menuImage, Long createAdminId, Boolean isDelete, List<MenuLog> menuLogList) {
        this.id = id;
        this.name = name;
        this.menuType = menuType;
        this.price = price;
        this.isUse = isUse;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.menuImage = menuImage;
        this.createAdminId = createAdminId;
        this.isDelete = isDelete;
        this.menuLogList = menuLogList;
    }

    public static Menu of(CreateMenuRequest createMenuRequest) {
        if (createMenuRequest.getImage() != null) {
            return Menu.builder()
                    .id(1L)
                    .name(createMenuRequest.getName())
                    .menuType(createMenuRequest.getMenuType())
                    .price(createMenuRequest.getPrice())
                    .isUse(createMenuRequest.getIsUse())
                    .menuImage(createMenuRequest.getImage().getName())
                    .createDate(LocalDateTime.now())
                    .build();
        }
        return Menu.builder()
                .id(1L)
                .name(createMenuRequest.getName())
                .menuType(createMenuRequest.getMenuType())
                .price(createMenuRequest.getPrice())
                .isUse(createMenuRequest.getIsUse())
                .createDate(LocalDateTime.now())
                .build();
    }
}
