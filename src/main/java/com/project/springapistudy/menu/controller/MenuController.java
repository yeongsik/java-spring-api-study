package com.project.springapistudy.menu.controller;

import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.dto.DeleteMenuRequest;
import com.project.springapistudy.menu.dto.MenuResponse;
import com.project.springapistudy.menu.dto.ReadMenuRequest;
import com.project.springapistudy.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/api/v1")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;


    // menus/

    @PostMapping("/menus")
    public void createMenu(@Valid CreateMenuRequest createMenuRequest) {
        // 유효성 검사
    }

    @GetMapping("/menus/{menuId}")
    public MenuResponse readMenuOne(@PathVariable Long menuId, ReadMenuRequest readMenuRequest) {

        return null;
    }

    @GetMapping("/menus")
    public List<MenuResponse> readMenuList(ReadMenuRequest readMenuRequest) {

        return null;
    }

    @DeleteMapping("/menus/{menuId}")
    public void deleteMenu(DeleteMenuRequest deleteMenuRequest) {

    }
}
