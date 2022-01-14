package com.done.RegistrationService.controller.routes;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class Controller {
    protected static final String CURSOR_TOKEN_PARAM_KEY = "cursor_token";
    protected static final String LIMIT_PARAM_KEY = "limit";
    protected static final String DEFAULT_LIMIT = "12";
}
