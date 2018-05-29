package com.judekayode.jumTask.controllers;

import com.judekayode.jumTask.api.response.CardSchemeResponse;
import com.judekayode.jumTask.services.CardSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "v1/card-scheme", produces = "application/json")
public class SchemeControllers {

    @Autowired
    private CardSchemeService cardSchemeService;

    @RequestMapping(method = RequestMethod.GET, value = "/verify/{cardPan}")
    public CardSchemeResponse decrypt(@PathVariable("cardPan") String cardPan) {
        return cardSchemeService.getCardScheme(cardPan);
    }
}
