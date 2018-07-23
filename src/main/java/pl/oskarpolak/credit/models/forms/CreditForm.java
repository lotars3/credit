package pl.oskarpolak.credit.models.forms;

import lombok.Data;


@Data
public class CreditForm {
    private double creditValue;
    private double creditTime;
    private double salary;
    private double costs;
}
