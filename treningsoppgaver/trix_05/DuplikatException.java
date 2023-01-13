public class DuplikatException extends Exception{

    public DuplikatException(String boktittel){
        super(boktittel + "fins allerede i bokhyllen!");
    }
    
}
