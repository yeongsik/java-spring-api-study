package com.project.springapistudy.menu.controller;

import com.project.springapistudy.menu.dto.*;
import com.project.springapistudy.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<Void> createMenu(@Valid @RequestBody CreateMenuRequest createMenuRequest) {
        menuService.createMenu(createMenuRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<MenuResponse> readMenuOne(@PathVariable Long menuId, ReadMenuRequest readMenuRequest) {

        return null;
    }

    @GetMapping
    public ResponseEntity<List<MenuResponse>> readMenuList(ReadMenuRequest readMenuRequest) {

        return null;
    }

    @PatchMapping("/{menuId}")
    public ResponseEntity<Void> modifyMenu(@PathVariable Long id, ModifyMenuRequest modifyMenuRequest) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId, DeleteMenuRequest deleteMenuRequest) {

        return ResponseEntity.ok().build();
    }
}
