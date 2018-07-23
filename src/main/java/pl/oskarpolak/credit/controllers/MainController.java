package pl.oskarpolak.credit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.credit.models.forms.CreditForm;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("creditForm", new CreditForm());
        return "creditForm";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("creditForm") CreditForm creditForm,
                        Model model){
        if((creditForm.getSalary() - creditForm.getCosts()) * 0.70 > creditForm.getCreditValue() / creditForm.getCreditTime()){
             model.addAttribute("someInfo", "Udzielono kredytu");
        }
        model.addAttribute("someInfo", "Nie udzielono kredytu!!!");
        return "creditForm";
    }
}
