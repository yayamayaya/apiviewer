package ru.test.demonstrator.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.demonstrator.CFG;

import java.util.List;

@RestController
@RequestMapping("api/cfgs")
public class CFGController {
    @Autowired
    private CFGRepository cfgRepository;

    @GetMapping
    public List<CFG> getAll() {
        return cfgRepository.findAll();
    }
}
