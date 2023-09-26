package com.project.springapistudy.menu.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.dto.ReadMenuRequest;
import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.MenuLog;
import com.project.springapistudy.menu.fixture.MenuFixture;
import com.project.springapistudy.menu.repository.MenuLogRepository;
import com.project.springapistudy.menu.repository.MenuRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MenuControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuLogRepository menuLogRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

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

        //expected
        mvc.perform(MockMvcRequestBuilders.post("/menus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createMenuRequest)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("메뉴 생성 - 실패 (InValid Request)")
    void failCreateMenu () throws Exception {

        //given
        CreateMenuRequest createMenuRequest = CreateMenuRequest.builder()
                .build();

        //expected
        mvc.perform(MockMvcRequestBuilders.post("/menus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createMenuRequest)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


    @Test
    @DisplayName("한 메뉴 조회 - 성공")
    void successFindOneMenu () throws Exception {

        //given
        Menu save = menuRepository.save(Menu.of(MenuFixture.SUCCESS_CREATE_AMERICANO));
        menuLogRepository.save(MenuLog.of(save, "CREATE"));

        ReadMenuRequest req = new ReadMenuRequest(save.getId());
    }

    @Test
    @DisplayName("한 메뉴 조회 - 실패(존재하지 않는 메뉴)")
    void failFindOneMenuWhenNotFoundMenu () throws Exception {

    }

    @Test
    @DisplayName("전체 메뉴 조회 - 성공")
    void successFindAllMenu() throws Exception {

    }

    @Test
    @DisplayName("메뉴 수정 - 성공")
    void successModifyMenu() throws Exception {

    }

    @Test
    @DisplayName("메뉴 수정 - 실패 (존재하지 않는 메뉴)")
    void failModifyMenuNotFoundMenu() throws Exception {

    }

    @Test
    @DisplayName("메뉴 수정 - 실패 (메뉴 이름 중복)")
    void failModifyMenuDuplicateOtherMenu() throws Exception {

    }

    @Test
    @DisplayName("메뉴 수정 - 실패 (유효성 실패)")
    void failModifyMenuInValid() throws Exception {

    }

    @Test
    @DisplayName("메뉴 삭제 - 성공")
    void successDeleteMenu() throws Exception {

    }

    @Test
    @DisplayName("메뉴 삭제 실패 (존재하지 않는 메뉴")
    void failDeleteMenu() throws Exception {

    }

}
