/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gholeydon.gholi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author farnaz
 */
@Named
@RequestScoped
public class User {


    private double param1;
    private double param2;
    private double result;

    public String add(){
        result = param1 + param2;
        return "";
    }

    public String subtract(){
        result = param1 - param2;
        return "";
    }

    public String multiply(){
        result = param1 * param2;
        return "";
    }

    public String divide(){
        result = param1 / param2;
        return "";
    }

    public double getParam1() {
        return param1;
    }
    public void setParam1(double param1) {
        this.param1 = param1;
    }

    public double getParam2() {
        return param2;
    }
    public void setParam2(double param2) {
        this.param2 = param2;
    }

    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
    
}
