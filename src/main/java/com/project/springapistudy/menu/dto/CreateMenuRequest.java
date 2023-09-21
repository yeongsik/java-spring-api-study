package com.project.springapistudy.menu.dto;

import com.project.springapistudy.menu.entity.MenuType;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;


@Getter
public class CreateMenuRequest {
    private String name;
    private MenuType menuType;
    private Integer price;
    private Boolean isUse;
    private MultipartFile image;


    public CreateMenuRequest(String name, MenuType menuType, Integer price, Boolean isUse, MultipartFile image) {
        this.name = name;
        this.menuType = menuType;
        this.price = price;
        this.isUse = isUse;
        this.image = image;
    }
}
