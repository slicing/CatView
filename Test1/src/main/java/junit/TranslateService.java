package junit;

import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TranslateService {
    private Map<String,String> dictioinary = new HashMap<>();
    TranslateService(){
        initDict();
    }
    public String translate(String text){
        if(StringUtils.isBlank(text)){
            throw new IllegalArgumentException("Translating ....");
        }
        return fromEnglishToFrench(text);
    }

    private void initDict() {
        dictioinary.put("hello","Bonjour");
        dictioinary.put("yes","Qui");
        dictioinary.put("no","Non");
        dictioinary.put("goodbye","Au revoir");
        dictioinary.put("good night","Bonne nuit");
        dictioinary.put("thank you","Merci");

    }

    private String fromEnglishToFrench(String text){
        String textLowerCase = text.toLowerCase();
        return dictioinary.getOrDefault(textLowerCase,"No fount");
    }
}
