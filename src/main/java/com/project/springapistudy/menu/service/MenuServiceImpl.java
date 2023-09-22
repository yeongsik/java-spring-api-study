package com.project.springapistudy.menu.service;


import com.project.springapistudy.menu.dto.*;
import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.MenuLog;
import com.project.springapistudy.menu.repository.MenuLogRepository;
import com.project.springapistudy.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuLogRepository menuLogRepository;

    @Override
    @Transactional
    public void createMenu(CreateMenuRequest createMenuRequest) {
        Menu savedMenu = menuRepository.save(Menu.of(createMenuRequest));
        menuLogRepository.save(MenuLog.of(savedMenu , "CREATE"));
    }

    @Override
    public MenuResponse findOneMenuById(ReadMenuRequest readMenuRequest) {
        menuRepository.findMenuById(readMenuRequest);
        return null;
    }

    @Override
    public List<MenuResponse> findAllMenu(ReadMenuRequest readMenuRequest) {
        menuRepository.findAllMenu();
        return null;
    }

    @Override
    public void updateMenu(ModifyMenuRequest modifyMenuRequest) {

    }

    @Override
    @Transactional
    public void deleteMenu(DeleteMenuRequest deleteMenuRequest) {
        menuRepository.deleteById(deleteMenuRequest.getId());
    }
}
