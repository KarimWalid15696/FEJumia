package com.PhoneNumbers.springboot.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoroccoCustomer extends Customer{
    public MoroccoCustomer(){

    }
    public MoroccoCustomer(String name , String phone,String country,String valid){
        super(name,phone,country,valid);
    }
    public void validateCustomer(){
        //Regex checking
        String regex;
        Pattern pattern;
        Matcher matcher;

            regex="\\(212\\)\\ ?[5-9]\\d{8}$";
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
