package extensions.java.lang.String;

import com.caceffo.APIportfolio.Errors.BusinessException;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Optional;

@Extension
public class MyStringExtension{
    public static void isBlankException(@This String str, BusinessException exception){
        if(str.isBlank()){
            throw exception;
        }
    }

    public static String emptyIfIsNull(@This String str){
        return Optional.ofNullable(str).orElse("");
    }
}
