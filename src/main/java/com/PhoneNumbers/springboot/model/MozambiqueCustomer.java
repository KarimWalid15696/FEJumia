package com.PhoneNumbers.springboot.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MozambiqueCustomer extends Customer{
    public MozambiqueCustomer(){

    }
    public MozambiqueCustomer(String name , String phone,String country,String valid) {
        super(name, phone, country, valid);
    }
    public MozambiqueCustomer(int id,String name , String phone,String country,String valid) {
        super(name, phone, country, valid);
        this.setId(id);

    }
    public void validateCustomer(){
        //Regex checking
        String regex;
        Pattern pattern;
        Matcher matcher;

        regex="\\(258\\)\\ ?[28]\\d{7,8}$";
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
