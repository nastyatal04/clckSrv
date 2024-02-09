package com.example.clck.controller;

import com.example.clck.domain.URLDomain;
import com.example.clck.service.URLService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://clck.ru/38WABW
//https://clck.ru/38gGLM
@RestController
@RequiredArgsConstructor
@RequestMapping("/url_clck")
public class URLController {
    private final URLService service;

    @GetMapping
    public List<URLDomain> getAddresses() {
        return service.getAllURL();
    }

    @GetMapping("/{id}")
    public URLDomain getAddress(@PathVariable Long id) {
        return service.getURL(id);
    }

    @PostMapping()
    public URLDomain addAddress(@RequestBody URLDomain address) {
        return service.addURL(address);
    }

    @PutMapping()
    public URLDomain updateAddress(@RequestBody URLDomain address) {
        return service.updateURL(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        service.deleteURL(id);
    }
}
