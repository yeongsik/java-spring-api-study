package com.project.springapistudy.menu.service;


import com.project.springapistudy.menu.dto.*;
import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.MenuLog;
import com.project.springapistudy.menu.entity.MenuType;
import com.project.springapistudy.menu.error.DuplicateMenuNameException;
import com.project.springapistudy.menu.error.MenuNotFoundException;
import com.project.springapistudy.menu.fixture.MenuFixture;
import com.project.springapistudy.menu.repository.MenuLogRepository;
import com.project.springapistudy.menu.repository.MenuRepository;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuLogRepository menuLogRepository;

    @AfterEach
    void clean() {
        menuLogRepository.deleteAll();
        menuRepository.deleteAll();
    }

    @Test
    @DisplayName("메뉴 생성 - 성공")
    void successCreateMenu () throws Exception {

        //given
        CreateMenuRequest createMenuRequest = MenuFixture.SUCCESS_CREATE_AMERICANO;

        //when
        menuService.createMenu(createMenuRequest);
    }


    @Test
    @DisplayName("한 메뉴 조회 - 성공")
    void successFindOneMenu () throws Exception {

        //given
        Menu save = menuRepository.save(Menu.of(MenuFixture.SUCCESS_CREATE_AMERICANO));
        menuLogRepository.save(MenuLog.of(save, "CREATE"));
        ReadMenuRequest readMenuRequest = new ReadMenuRequest(save.getId());

        //when
        MenuResponse resultMenu = menuService.findOneMenuById(readMenuRequest);

        //then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(resultMenu.getId()).as("MenuId").isEqualTo(save.getId());
        softly.assertThat(resultMenu.getPrice()).as("Price").isEqualTo(save.getPrice());
        softly.assertThat(resultMenu.getMenuType()).as("MenuType").isEqualTo(save.getMenuType());
        softly.assertThat(resultMenu.getIsUse()).as("IsUse").isEqualTo(save.getIsUse());
        softly.assertAll();
    }

    @Test
    @DisplayName("한 메뉴 조회 - 실패(존재하지 않는 메뉴)")
    void failFindOneMenuWhenNotFoundMenu () throws Exception {

        //given
        Menu save = menuRepository.save(Menu.of(MenuFixture.SUCCESS_CREATE_AMERICANO));
        menuLogRepository.save(MenuLog.of(save, "CREATE"));
        ReadMenuRequest readMenuRequest = new ReadMenuRequest(save.getId() + 1L);

        //when
        Assertions.assertThrows(MenuNotFoundException.class, () -> {
            menuService.findOneMenuById(readMenuRequest);
        });

    }

    @Test
    @DisplayName("전체 메뉴 조회 - 성공")
    void successFindAllMenu() throws Exception {

        //given
        menuService.createMenu(MenuFixture.SUCCESS_CREATE_AMERICANO);
        menuService.createMenu(MenuFixture.SUCCESS_CREATE_LATTE);
        menuService.createMenu(MenuFixture.SUCCESS_CREATE_MILKTEA);

        //when
        List<MenuResponse> result = menuService.findAllMenu();

        //then
        SoftAssertions softly = new SoftAssertions();

        CreateMenuRequest[] testExpectArr = {MenuFixture.SUCCESS_CREATE_MILKTEA, MenuFixture.SUCCESS_CREATE_LATTE, MenuFixture.SUCCESS_CREATE_AMERICANO};
        for (int i = 0; i < testExpectArr.length; i++) {
            softly.assertThat(result.get(i).getName()).isEqualTo(testExpectArr[i].getName());
            softly.assertThat(result.get(i).getPrice()).isEqualTo(testExpectArr[i].getPrice());
            softly.assertThat(result.get(i).getMenuType()).isEqualTo(testExpectArr[i].getMenuType());
            softly.assertThat(result.get(i).getMenuLogs().get(0).getAction()).isEqualTo("CREATE");
        }
        softly.assertAll();
    }

    @Test
    @DisplayName("메뉴 수정 - 성공")
    void successModifyMenu() throws Exception {

        //given
        Menu save = menuRepository.save(Menu.of(MenuFixture.SUCCESS_CREATE_AMERICANO));
        menuLogRepository.save(MenuLog.of(save, "CREATE"));
        ModifyMenuRequest modifyRequest = ModifyMenuRequest.builder()
                .id(save.getId())
                .menuType(MenuType.BEVERAGE)
                .name(MenuFixture.SUCCESS_CREATE_MILKTEA.getName())
                .price(MenuFixture.SUCCESS_CREATE_MILKTEA.getPrice())
                .build();

        //when
        menuService.updateMenu(modifyRequest);

        //then
        ReadMenuRequest readMenuRequest = new ReadMenuRequest(save.getId());
        MenuResponse resultResponse = menuService.findOneMenuById(readMenuRequest);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(resultResponse.getPrice()).as("Price").isEqualTo(modifyRequest.getPrice());
        softly.assertThat(resultResponse.getMenuType()).as("MenuType").isEqualTo(modifyRequest.getMenuType());
        softly.assertThat(resultResponse.getName()).as("MenuName").isEqualTo(modifyRequest.getName());
        softly.assertThat(resultResponse.getIsUse()).as("IsUse").isEqualTo(modifyRequest.getIsUse());
        softly.assertAll();
    }

    @Test
    @DisplayName("메뉴 수정 - 실패 (존재하지 않는 메뉴)")
    void failModifyMenuNotFoundMenu() throws Exception {

        //given
        ModifyMenuRequest modifyRequest = ModifyMenuRequest.builder()
                .id(1L)
                .menuType(MenuType.BEVERAGE)
                .name(MenuFixture.SUCCESS_CREATE_MILKTEA.getName())
                .price(MenuFixture.SUCCESS_CREATE_MILKTEA.getPrice())
                .build();
        //when
        Assertions.assertThrows(MenuNotFoundException.class, () -> {
            menuService.updateMenu(modifyRequest);
        });
    }

    @Test
    @DisplayName("메뉴 수정 - 실패 (메뉴 이름 중복)")
    void failModifyMenuDuplicateOtherMenu() throws Exception {

        //given
        Menu save = menuRepository.save(Menu.of(MenuFixture.SUCCESS_CREATE_AMERICANO));
        menuLogRepository.save(MenuLog.of(save, "CREATE"));
        menuService.createMenu(MenuFixture.SUCCESS_CREATE_MILKTEA);

        ModifyMenuRequest modifyRequest = ModifyMenuRequest.builder()
                .id(save.getId())
                .menuType(MenuType.BEVERAGE)
                .name(MenuFixture.SUCCESS_CREATE_MILKTEA.getName())
                .price(MenuFixture.SUCCESS_CREATE_MILKTEA.getPrice())
                .build();

        //when
        Assertions.assertThrows(DuplicateMenuNameException.class, () -> {
            menuService.updateMenu(modifyRequest);
        });
    }

    @Test
    @DisplayName("메뉴 삭제 - 성공")
    void successDeleteMenu() throws Exception {

        //given
        Menu save = menuRepository.save(Menu.of(MenuFixture.SUCCESS_CREATE_AMERICANO));
        menuLogRepository.save(MenuLog.of(save, "CREATE"));

        //when
        menuService.deleteMenu(new DeleteMenuRequest(save.getId()));
        MenuResponse actualMenu = menuService.findOneMenuById(new ReadMenuRequest(save.getId()));

        //then
        Assertions.assertTrue(actualMenu.getIsDelete());
    }

    @Test
    @DisplayName("메뉴 삭제 실패 (존재하지 않는 메뉴")
    void failDeleteMenu() throws Exception {

        //given
        Menu save = menuRepository.save(Menu.of(MenuFixture.SUCCESS_CREATE_AMERICANO));
        menuLogRepository.save(MenuLog.of(save, "CREATE"));

        //when
        Assertions.assertThrows(MenuNotFoundException.class, () -> {
            menuService.deleteMenu(new DeleteMenuRequest(save.getId() + 2L));
        });
    }

}
