package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.dto.MenuResponse;
import com.project.springapistudy.menu.dto.ReadMenuRequest;
import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.QMenu;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.project.springapistudy.menu.entity.QMenu.menu;

@Repository
@RequiredArgsConstructor
public class MenuCustomRepositoryImpl implements MenuCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<List<MenuResponse>> findAllMenu() {
        List<Menu> fetch = jpaQueryFactory.selectFrom(menu)
                .innerJoin(menu.menuLogList)
                .fetchJoin()
                .fetch();
        return null;
    }

    @Override
    public Optional<MenuResponse> findMenuById(ReadMenuRequest readMenuRequest) {

        jpaQueryFactory.selectFrom(menu)
                .innerJoin(menu.menuLogList)
                .fetchJoin()
                .where(menu.id.eq(readMenuRequest.getId()))
                .fetch();
        return null;
    }

}
