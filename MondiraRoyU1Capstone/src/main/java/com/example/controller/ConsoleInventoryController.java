package com.example.controller;

import com.example.service.InventoryService;
import com.example.viewModel.ConsoleViewModel;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleInventoryController {

    @Autowired
    InventoryService inventoryService;

    // Creating a simple test without service layer
//@RequestMapping(value = "/console", method = RequestMethod.POST)
//@ResponseStatus(value = HttpStatus.CREATED)
//public Console createConsole(@RequestBody @Valid Console console) {
//    Random rnd = new Random();
//
//    console.setConsoleId(rnd.nextInt(9999));
//
//    return console;
//}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel console) {
        System.out.print(console);
        return inventoryService.saveConsole(console);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int consoleId) throws NotFoundException {
        ConsoleViewModel console = inventoryService.findConsole(consoleId);
        if (console == null)
            throw new NotFoundException("Item could not be retrieved for id " + consoleId);
        return console;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles()  {

        return inventoryService.findAllConsoles();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int consoleId) {
        inventoryService.removeConsole(consoleId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int consoleId, @RequestBody @Valid ConsoleViewModel consoleviewModel) {
        if (consoleviewModel.getConsoleId() == 0)
            consoleviewModel.setConsoleId(consoleId);
        if (consoleId != consoleviewModel.getConsoleId()) {
            throw new IllegalArgumentException("Item ID on path must match the ID in the Item object");
        }
        inventoryService.updateConsole(consoleviewModel);
    }
}
