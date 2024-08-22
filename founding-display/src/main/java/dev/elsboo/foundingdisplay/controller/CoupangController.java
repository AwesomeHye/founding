package dev.elsboo.foundingdisplay.controller;

import dev.elsboo.foundingdisplay.service.BestCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/coupang")
@RequiredArgsConstructor
public class CoupangController {

    private final BestCategoryService bestCategoryService;

    @GetMapping("/bestcategories")
    private Flux<Map<String, Object>> getBestCategories() {
        return bestCategoryService.findAll();
    }
}
