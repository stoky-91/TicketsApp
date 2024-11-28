package com.tickets.TicketsApp.controller;

import com.tickets.TicketsApp.domain.code.CodeDTO;
import com.tickets.TicketsApp.domain.code.CodeFilterDTO;
import com.tickets.TicketsApp.domain.code.CodeSummaryDTO;
import com.tickets.TicketsApp.domain.code.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/codes")
public class CodeViewController {

    private final CodeService codeService;

    @Autowired
    public CodeViewController(CodeService codeService) {
        this.codeService = codeService;
    }

    // Zobrazení HTML stránky s tabulkou
    @GetMapping
    public String showCodes(Model model) {
        List<CodeDTO> codes = codeService.getAllCodes();
        BigDecimal totalPrice = codes.stream()
                .map(CodeDTO::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("codes", codes);
        model.addAttribute("summary", new CodeSummaryDTO(totalPrice));
        model.addAttribute("filter", new CodeFilterDTO());
        return "code"; // Název Thymeleaf šablony (code.html)
    }

    // Zpracování filtru a zobrazení filtrovaných dat
    @GetMapping("/filter")
    public String filterCodes(@ModelAttribute CodeFilterDTO filter, Model model) {
        List<CodeDTO> filteredCodes = codeService.filterCodes(filter);
        BigDecimal totalPrice = filteredCodes.stream()
                .map(CodeDTO::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("codes", filteredCodes);
        model.addAttribute("summary", new CodeSummaryDTO(totalPrice));
        model.addAttribute("filter", filter);
        return "codes"; // Název Thymeleaf šablony (code.html)
    }
}
