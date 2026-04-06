package ru.test.demonstrator.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.demonstrator.CFG;

public interface CFGRepository extends JpaRepository<CFG, Long> {
}
