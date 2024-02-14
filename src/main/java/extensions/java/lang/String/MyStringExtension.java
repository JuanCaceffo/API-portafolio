package extensions.java.lang.String;

import com.caceffo.APIportfolio.Errors.BusinessException;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Optional;

@Extension
public class MyStringExtension{
    public static void isBlankException(@This String str, String msg){
        if(str.isBlank()){
            System.out.println("jode");
            throw new BusinessException(msg);
        }
    }

    public static String emptyIfIsNull(@This String str){
        return Optional.ofNullable(str).orElse("");
    }
}
