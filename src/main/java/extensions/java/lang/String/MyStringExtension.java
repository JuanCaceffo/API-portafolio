package extensions.java.lang.String;

import com.caceffo.APIportfolio.Errors.BussinesExeption;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

@Extension
public class MyStringExtension{
    public static void isBlankException(@This String str, String msg){
        if(str.isBlank()){
            throw new BussinesExeption(msg);
        }
    }
}
