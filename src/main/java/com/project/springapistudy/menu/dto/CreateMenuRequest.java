package com.project.springapistudy.menu.dto;

import com.project.springapistudy.menu.entity.MenuType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class CreateMenuRequest {

    @NotBlank(message = "메뉴명을 입력해주세요.")
    private String name;

    @NotNull(message = "메뉴 타입을 선택해주세요.")
    private MenuType menuType;

    @NotNull(message = "가격을 입력해주세요.")
    private Integer price;

    @NotNull(message = "사용 유무룰 선택해주세요.")
    private Boolean isUse;

//    private final MultipartFile image;

    @Builder
    public CreateMenuRequest(String name, MenuType menuType, Integer price, Boolean isUse) {
        this.name = name;
        this.menuType = menuType;
        this.price = price;
        this.isUse = isUse;
    }
}
