package com.project.springapistudy.menu.service;


import com.project.springapistudy.menu.dto.*;
import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.MenuLog;
import com.project.springapistudy.menu.error.DuplicateMenuNameException;
import com.project.springapistudy.menu.error.MenuNotFoundException;
import com.project.springapistudy.menu.repository.MenuLogRepository;
import com.project.springapistudy.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuLogRepository menuLogRepository;

    @Override
    @Transactional
    public void createMenu(CreateMenuRequest createMenuRequest) {

        menuRepository.findByName(createMenuRequest.getName())
                .orElseThrow(DuplicateMenuNameException::new);

        Menu savedMenu = menuRepository.save(Menu.of(createMenuRequest));
        menuLogRepository.save(MenuLog.of(savedMenu , "CREATE"));
    }

    @Override
    public MenuResponse findOneMenuById(ReadMenuRequest readMenuRequest) {

        Menu selectedMenu = menuRepository.findMenuById(Menu.of(readMenuRequest))
                .orElseThrow(MenuNotFoundException::new);

        return MenuResponse.of(selectedMenu);
    }

    @Override
    public List<MenuResponse> findAllMenu(ReadMenuRequest readMenuRequest) {
        return menuRepository.findAllMenu().stream()
                .map(MenuResponse::of)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateMenu(ModifyMenuRequest modifyMenuRequest) {
        // 수정 시 메뉴이름이 다른 메뉴랑 겹칠 때 , id 값이 다른데 name가 같을 때

        Menu menu = menuRepository.findById(modifyMenuRequest.getId())
                .orElseThrow(MenuNotFoundException::new);

        menu.updateFrom(modifyMenuRequest);
        menuLogRepository.save(MenuLog.of(menu, "UPDATE"));
    }

    @Override
    @Transactional
    public void deleteMenu(DeleteMenuRequest deleteMenuRequest) {
        Menu menu = menuRepository.findById(deleteMenuRequest.getId())
                .orElseThrow(MenuNotFoundException::new);

        menu.delete();
        menuLogRepository.save(MenuLog.of(menu, "DELETE"));
    }
}
