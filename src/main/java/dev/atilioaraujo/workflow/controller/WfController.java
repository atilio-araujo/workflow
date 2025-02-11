package dev.atilioaraujo.workflow.controller;

import dev.atilioaraujo.workflow.model.core.ProductRequest;
import dev.atilioaraujo.workflow.service.WorkflowService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WfController {

    private final WorkflowService service;

    public WfController(WorkflowService service) {
        this.service = service;
    }

    @PostMapping(value = "/start", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> start(@RequestBody ProductRequest payload) {
        this.service.startWorkflow(payload);
        return ResponseEntity.ok("{\"message\": \"OK\"}");
    }

}
