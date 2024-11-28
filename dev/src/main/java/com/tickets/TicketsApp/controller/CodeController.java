package com.tickets.TicketsApp.controller;

import com.tickets.TicketsApp.domain.code.CodeDTO;
import com.tickets.TicketsApp.domain.code.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/code")
public class CodeController {

    private final CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService){
        this.codeService = codeService;
    }

    @GetMapping
    public List<CodeDTO> getAllCodes() {
        return codeService.getAllCodes();
    }

    @PostMapping("/create")
    public ResponseEntity<CodeDTO> createBill(@RequestBody CodeDTO codeDTO) {
        CodeDTO newCodeDTO = codeService.createCode(codeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCodeDTO);
    }

    @PutMapping("/{codeId}")
    public ResponseEntity<CodeDTO> updateBill(@PathVariable("codeId") int codeId,
                                              @RequestBody CodeDTO codeDTO) {
        CodeDTO updatedCode = codeService.updateCode(codeId, codeDTO);
        return new ResponseEntity<>(updatedCode, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCode(@PathVariable Long id) {
        codeService.deleteCode(id);
        return ResponseEntity.ok("Code deleted succesfully");
    }
}
