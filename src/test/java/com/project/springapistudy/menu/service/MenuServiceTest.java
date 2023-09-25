package com.project.springapistudy.menu.service;


import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.dto.MenuResponse;
import com.project.springapistudy.menu.dto.ReadMenuRequest;
import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.fixture.MenuFixture;
import com.project.springapistudy.menu.repository.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuRepository menuRepository;

    @BeforeEach
    void clean() {
        menuRepository.deleteAll();
    }

    @Test
    @DisplayName("메뉴 생성 - 성공")
    void successCreateMenu () throws Exception {

        //given
        CreateMenuRequest createMenuRequest = MenuFixture.SUCCESS_CREATE_MENU;

        //when
        menuService.createMenu(createMenuRequest);
    }


    @Test
    @DisplayName("한 메뉴 조회 - 성공")
    void successFindOneMenu () throws Exception {

        //given
        Menu save = menuRepository.save(Menu.of(MenuFixture.SUCCESS_CREATE_MENU));
        ReadMenuRequest readMenuRequest = new ReadMenuRequest(save.getId());

        //when
        MenuResponse resultMenu = menuService.findOneMenuById(readMenuRequest);

        //then
        Assertions.assertEquals(save.getId() , resultMenu.getId());
        Assertions.assertEquals(save.getMenuType() , resultMenu.getMenuType());
        Assertions.assertEquals(save.getPrice() , resultMenu.getPrice());
        Assertions.assertEquals(save.getIsUse() , resultMenu.getIsUse());


    }

    @Test
    @DisplayName("한 메뉴 조회 - 실패(존재하지 않는 메뉴)")
    void failFindOneMenuWhenNotFoundMenu () throws Exception {

        //given

        //when

        //then


    }

    @Test
    @DisplayName("전체 메뉴 조회 - 성공")
    void successFindAllMenu() throws Exception {

        //given

        //when

        //then

    }

    @Test
    @DisplayName("메뉴 수정 - 성공")
    void successModifyMenu() throws Exception {

        //given

        //when

        //then
    }

    @Test
    @DisplayName("메뉴 수정 - 실패 (존재하지 않는 메뉴)")
    void failModifyMenu() throws Exception {

        //given

        //when

        //then
    }

    @Test
    @DisplayName("메뉴 삭제 - 성공")
    void successDeleteMenu() throws Exception {

        //given

        //when

        //then
    }

    @Test
    @DisplayName("메뉴 삭제 실패 (존재하지 않는 메뉴")
    void failDeleteMenu() throws Exception {

        //given

        //when

        //then
    }

}
