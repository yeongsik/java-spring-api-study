package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.entity.Menu;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.project.springapistudy.menu.entity.QMenu.menu;
import static com.project.springapistudy.menu.entity.QMenuLog.*;

@Repository
@RequiredArgsConstructor
public class MenuCustomRepositoryImpl implements MenuCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Menu> findAllMenu() {
        return jpaQueryFactory.selectFrom(menu)
                .innerJoin(menu.menuLogList, menuLog)
                .fetchJoin()
                .orderBy(menuLog.createLogTime.desc())
                .fetch().stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Optional<Menu> findMenuById(Menu req) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(menu)
                .innerJoin(menu.menuLogList, menuLog)
                .fetchJoin()
                .where(menu.id.eq(req.getId()))
                .orderBy(menuLog.createLogTime.desc())
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
