package com.project.springapistudy.menu.error;

import com.project.springapistudy.global.error.ApiException;
import com.project.springapistudy.global.error.ErrorCode;

public class DuplicateMenuNameException extends ApiException {

    public DuplicateMenuNameException() {
        super(MenuErrorCode.DUPLICATE_MENU_NAME);
    }
}
