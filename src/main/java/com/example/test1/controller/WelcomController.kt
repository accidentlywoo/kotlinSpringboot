package com.example.test1.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/welcome")
class WelcomController {

    @GetMapping("/")
    fun welcome(model: Model) = "welcome"
}