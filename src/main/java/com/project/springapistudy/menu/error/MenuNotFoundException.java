package com.project.springapistudy.menu.error;

import com.project.springapistudy.global.error.ApiException;
import com.project.springapistudy.global.error.ErrorCode;

public class MenuNotFoundException extends ApiException {
    public MenuNotFoundException() {
        super(MenuErrorCode.NOT_FOUND_MENU);
    }
}
