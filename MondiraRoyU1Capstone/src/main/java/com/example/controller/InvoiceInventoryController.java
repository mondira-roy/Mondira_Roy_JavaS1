package com.example.controller;


import com.example.service.InventoryService;
import com.example.viewModel.InvoiceViewModel;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceInventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody InvoiceViewModel invoice) {
        return inventoryService.saveInvoice(invoice);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public InvoiceViewModel getInvoice(@PathVariable("id") int id) throws NotFoundException {
        InvoiceViewModel invoice = inventoryService.findInvoice(id);
        if (invoice == null)
            throw new NotFoundException("Invoice could not be retrieved for id " + id);
        return invoice;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable int id) {
        inventoryService.removeInvoice(id);
    }

    @PutMapping("/{id}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable("id") int invoiceId, @RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        if (invoiceViewModel.getInvoiceId() == 0)
            invoiceViewModel.setInvoiceId(invoiceId);
        if (invoiceId != invoiceViewModel.getInvoiceId()) {
            throw new IllegalArgumentException("Invoice ID on path must match the ID in the Invoice object");
        }
        inventoryService.updateInvoice(invoiceViewModel);
    }

}