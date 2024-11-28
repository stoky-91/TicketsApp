package com.tickets.TicketsApp.controller;

import com.tickets.TicketsApp.domain.bill.BillDTO;
import com.tickets.TicketsApp.domain.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bill")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService = billService;
    }

    @GetMapping
    public List<BillDTO> getAllBills() {
        return billService.getAllBills();
    }

    @PostMapping("/create")
    public ResponseEntity<BillDTO> createTicket(@RequestBody BillDTO billDTO) {
        BillDTO newBillDTO = billService.createBill(billDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBillDTO);
    }

    @PutMapping("/{billId}")
    public ResponseEntity<BillDTO> updateBill(@PathVariable("billId") int billId,
                                                        @RequestBody BillDTO billDTO) {
        BillDTO updatedBill = billService.updateBill(billId, billDTO);
        return new ResponseEntity<>(updatedBill, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted succesfully");
    }
}
