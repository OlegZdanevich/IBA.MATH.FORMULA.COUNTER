package com.iba.project.data;

public class Text implements Node {
    private StringBuilder text=null;

    public Text(String text)
    {
        this.text=new StringBuilder(text);
    }

    @Override
    public StringBuilder count() {
        return text;
    }
}
