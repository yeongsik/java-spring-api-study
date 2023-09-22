package com.project.springapistudy.menu.dto;

import com.project.springapistudy.menu.entity.MenuType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;


@Getter
@AllArgsConstructor
public class CreateMenuRequest {

    @NotBlank(message = "메뉴명을 입력해주세요.")
    private final String name;

    @NotBlank(message = "메뉴 타입을 선택해주세요.")
    private final MenuType menuType;

    @NotBlank(message = "가격을 입력해주세요.")
    private final Integer price;

    @NotBlank(message = "사용 유무룰 선택해주세요.")
    private final Boolean isUse;

    private final MultipartFile image;

}
