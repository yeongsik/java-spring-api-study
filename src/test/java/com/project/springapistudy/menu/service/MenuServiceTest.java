package com.project.springapistudy.menu.service;


import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.MenuType;
import com.project.springapistudy.menu.repository.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuRepository menuRepository;


    /*
        메뉴 엔티티 정리
        Id
        name
        menuType ( enum 처리 : 커피, 음료, 디저트 )
        price
        isUse
        등록일
        createDate
        updateDate
        메뉴 썸네일 ( menuFile )
        createAdminId
        isDelete


        기능 정리
        시나리오 : 사이렌 오더 앱을 사용하는데 어드민 페이지에서 카페에서 사용할 메뉴 CRUD 기능이 필요하다.

        메뉴 CRUD 요구사항 정리

        1. Create
           어드민 계정이 메뉴를 추가할 수 있다.
           추가할 때 메뉴 타입은 셀렉트 타입으로 골라서 추가
           사용유무를 체크해서 진행할 수 있다. (테스트 중이거나, 문제가 발생한 음료는 사용유무 체크를 하지 않음으로 변경할 수 있는 기능)

           유효성 검사


        2. Read
           어드민 계정 및 사용자가 볼 수 있는 메뉴 목록

           List Read

           Select One Read

        3. Update
           어드민 계정에서 메뉴를 수정할 수 있다.

        4. Delete
           어드민 계정에서 메뉴 삭제
           삭제 했을 떄 real 삭제되는 것이 아니라 -> 삭제여부가 true 값으로 변경된다. YN 으로 할 지 true false로 할지 고민해보자



    */

    @Test
    @DisplayName("메뉴 생성 - 성공")
    void successCreateMenu () throws Exception {

        //given
        CreateMenuRequest americano = new CreateMenuRequest("americano", MenuType.COFFEE, 4500, true, null);

        //when
        Menu save = menuRepository.save(Menu.of(americano));

        //then
        Assertions.assertEquals(americano.getName(), save.getName());

    }






}
