package com.example.springbootconfig.context;

public class VarContext {
    private static final ThreadLocal<String> lang = new InheritableThreadLocal<>();

    public static String getLang() {
        return lang.get();
    }

    public static void setLang(String lang) {
        lang = "vi";
        VarContext.lang.set(lang);
    }
}
