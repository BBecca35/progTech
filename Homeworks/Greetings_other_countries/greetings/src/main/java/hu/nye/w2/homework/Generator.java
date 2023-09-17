package hu.nye.w2.homework;

public class Generator {
    public String geni(final String o){
        if(o.equals("hun")){
            return "Szia";
        }if(o.equals("eng")){
            return "Hello";
        }if(o.equals("de")){
            return "Hallo";
        }else{
            return "Szia";
        }
    }
}
