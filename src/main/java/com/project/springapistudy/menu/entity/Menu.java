package com.project.springapistudy.menu.entity;

import com.project.springapistudy.menu.dto.CreateMenuRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
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

    public Menu(Long id, String name, MenuType menuType, Integer price, Boolean isUse, LocalDateTime createDate, LocalDateTime updateDate, String menuImage, Long createAdminId, Boolean isDelete) {
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
    }

    public static Menu of(CreateMenuRequest createMenuRequest) {
        if (createMenuRequest.getImage() != null) {
            return new Menu(1L, createMenuRequest.getName(), createMenuRequest.getMenuType(), createMenuRequest.getPrice(), createMenuRequest.getIsUse()
                    , LocalDateTime.now(), null, createMenuRequest.getImage().getName(), 1L, false);
        }
        return new Menu(1L, createMenuRequest.getName(), createMenuRequest.getMenuType(), createMenuRequest.getPrice(), createMenuRequest.getIsUse()
                , LocalDateTime.now(), null, null, 1L, false);
    }
}
