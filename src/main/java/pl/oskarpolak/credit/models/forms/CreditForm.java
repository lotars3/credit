package pl.oskarpolak.credit.models.forms;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
public class CreditForm {
    @Min(250) 
    @Max(1000000)
    private double creditValue;
    @Min(1)
    @Max(1200)
    //@Pattern(regexp = "i lecisz regexem")
    private double creditTime;
    @Min(0)
    @Max(10000000)
    private double salary;
    @Min(0)
    @Max(10000000)
    private double costs;
}
