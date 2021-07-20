package com.PhoneNumbers.springboot.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UgandaCustomer extends Customer{
    public UgandaCustomer(){

    }
    public UgandaCustomer(String name , String phone,String country,String valid){
        super(name,phone,country,valid);
    }
    public void validateCustomer(){
        //Regex checking
        String regex;
        Pattern pattern;
        Matcher matcher;

        regex="\\(256\\)\\ ?\\d{9}$";
        pattern=Pattern.compile(regex);
        matcher= pattern.matcher(this.getPhone());
        if(matcher.matches()) {
            this.setValid("Valid");
        }
        else {
            this.setValid("Not Valid");
        }

    }
}
