package com.tickets.TicketsApp.controller;

import com.tickets.TicketsApp.domain.bill.BillDTO;
import com.tickets.TicketsApp.domain.bill.BillFilterDTO;
import com.tickets.TicketsApp.domain.bill.BillSummaryDTO;
import com.tickets.TicketsApp.domain.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/bills")
public class BillViewController {

    private final BillService billService;

    @Autowired
    public BillViewController(BillService billService) {
        this.billService = billService;
    }

    // Zobrazení HTML stránky s tabulkou
    @GetMapping
    public String showBills(Model model) {
        List<BillDTO> bills = billService.getAllBills();
        BigDecimal totalPrice = bills.stream()
                .map(BillDTO::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("bills", bills);
        model.addAttribute("summary", new BillSummaryDTO(totalPrice));
        model.addAttribute("filter", new BillFilterDTO());
        return "bill"; // Název Thymeleaf šablony (bill.html)
    }

    // Zpracování filtru a zobrazení filtrovaných dat
    @GetMapping("/filter")
    public String filterBills(@ModelAttribute BillFilterDTO filter, Model model) {
        List<BillDTO> filteredBills = billService.filterBills(filter);
        BigDecimal totalPrice = filteredBills.stream()
                .map(BillDTO::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("bills", filteredBills);
        model.addAttribute("summary", new BillSummaryDTO(totalPrice));
        model.addAttribute("filter", filter);
        return "bill"; // Název Thymeleaf šablony (bill.html)
    }
}
