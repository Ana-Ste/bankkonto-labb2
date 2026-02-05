package se.ithogskolan.ana.bankkontolabb2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.ithogskolan.ana.bankkontolabb2.atm.ATMService;

@Controller
public class BalanceController {

    private final ATMService atmService;

    public BalanceController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/")
    public String showBalance(Model model) {

        int balance = atmService.getBalance();

        model.addAttribute("balance", balance);

        return "balance";
    }
}
