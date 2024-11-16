package org.study.sst2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostAccountingController {

    @GetMapping("/user/{id}")
    public void arr(@PathVariable Long id) {

    }
}
