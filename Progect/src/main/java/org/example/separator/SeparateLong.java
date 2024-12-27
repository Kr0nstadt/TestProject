package org.example.separator;
import java.util.regex.Pattern;

public class SeparateLong implements ICanSeparate<Long> {
    @Override
    public boolean isMatch(String txt) {
        if(txt == null||
                txt.isEmpty()||
                txt.length() == 0){
            return false;
        }
        else{
            return Pattern.matches("^-?\\d+$",txt);
        }
    }

    @Override
    public Long getValue(String txt) {
        Long res = 0L;
        if(txt == null||
                txt.isEmpty()||
                txt.length() == 0 ||
                !this.isMatch(txt)){
            return res;
        }
        else {
            try {
                res = Long.parseLong(txt);
            } catch (NumberFormatException e) {
            }
            return res;
        }
    }
}
