package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.dto.CreateMenuRequest;
import com.project.springapistudy.menu.dto.MenuResponse;
import com.project.springapistudy.menu.dto.ReadMenuRequest;
import com.project.springapistudy.menu.entity.Menu;
import com.project.springapistudy.menu.entity.QMenu;
import com.querydsl.core.Tuple;
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
    public List<Menu> findAllMenu() {
        return jpaQueryFactory.selectFrom(menu)
                .innerJoin(menu.menuLogList)
                .fetchJoin()
                .fetch();
    }

    @Override
    public Optional<Menu> findMenuById(Menu req) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(QMenu.menu)
                .innerJoin(QMenu.menu.menuLogList)
                .fetchJoin()
                .where(QMenu.menu.id.eq(req.getId()))
                .fetchOne());
    }

    @Override
    public Optional<Menu> findMenuByNameNotSameId(Menu req) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(menu)
                .where(menu.name.eq(req.getName())
                        .and(menu.id.notIn(req.getId())))
                .fetchOne());
    }

}
