package com.example.bfhl.controller;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import com.example.bfhl.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*")
public class BfhlController {

    private final BfhlService bfhlService;

    @Autowired
    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> processPost(@RequestBody(required = false) RequestDto requestDto) {
        ResponseDto response = bfhlService.processData(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<java.util.Map<String, Integer>> processGet() {
        java.util.Map<String, Integer> response = new java.util.HashMap<>();
        response.put("operation_code", 1);
        return ResponseEntity.ok(response);
    }
}
