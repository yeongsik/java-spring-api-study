package com.project.springapistudy.menu.error;

import com.project.springapistudy.global.error.ApiException;

public class DuplicateMenuNameException extends ApiException {

    public DuplicateMenuNameException() {
        super(MenuErrorCode.DUPLICATE_MENU_NAME);
    }
}
