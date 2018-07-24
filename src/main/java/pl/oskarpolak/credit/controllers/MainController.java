package pl.oskarpolak.credit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.credit.models.forms.CreditForm;

import javax.validation.Valid;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("creditForm", new CreditForm());
        return "creditForm";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("creditForm") @Valid CreditForm creditForm,
                        BindingResult bindingResult,
                        Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("someInfo", "Uzupełnij popranwie pola");
            return "creditForm";
        }
        if((creditForm.getSalary() - creditForm.getCosts()) * 0.30 > creditForm.getCreditValue() / creditForm.getCreditTime()){
             model.addAttribute("someInfo", "Udzielono kredytu");
             return "creditForm";
        }
        model.addAttribute("someInfo", "Nie udzielono kredytu!!!");
        return "creditForm";
    }
}
