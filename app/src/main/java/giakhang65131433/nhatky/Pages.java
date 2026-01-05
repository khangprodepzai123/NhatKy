package giakhang65131433.nhatky;

import java.util.HashMap;

public class Pages {
   String tittle;
   String date;
   String content;
   String key;

    public Pages(String tittle, String date, String content) {
        this.tittle = tittle;
        this.date = date;
        this.content = content;

    }

    public Pages(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String, String>toFirebase(){
        HashMap<String,String> pagesObject = new HashMap<String,String>();
        pagesObject.put("tittle",tittle);
        pagesObject.put("content",content);
        pagesObject.put("date",date);
        return pagesObject;

    }
}
