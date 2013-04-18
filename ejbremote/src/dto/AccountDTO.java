/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Aks
 */
public class AccountDTO implements Serializable{
    protected String AccNum;

    public String getAccNum() {
        return AccNum;
    }

    public void setAccNum(String AccNum) {
        this.AccNum = AccNum;
    }
    
    
    
}
