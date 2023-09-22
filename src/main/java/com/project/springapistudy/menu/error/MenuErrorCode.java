package com.project.springapistudy.menu.error;

import com.project.springapistudy.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MenuErrorCode implements ErrorCode {

    NOT_FOUND_MENU(HttpStatus.BAD_REQUEST, "해당 메뉴가 존재하지 않습니다."),
    DUPLICATE_MENU_NAME(HttpStatus.BAD_REQUEST, "중복된 메뉴 이름입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
