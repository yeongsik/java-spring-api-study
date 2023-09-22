package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.entity.MenuLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuLogRepository extends JpaRepository<MenuLog, Long> {
}
