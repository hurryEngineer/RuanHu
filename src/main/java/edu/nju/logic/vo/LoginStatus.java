package edu.nju.logic.vo;

import edu.nju.data.util.VerifyResult;
import lombok.Data;

@Data
public class LoginStatus {
    
    VerifyResult result;
    String formerUrl ="";
    
}
