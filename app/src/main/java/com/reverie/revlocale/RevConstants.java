package com.reverie.revlocale;

import java.util.ArrayList;

/**
 * Created by ranjan_mac on 31/01/17.
 */

public class RevConstants {

    // LANGUAGE ID CONSTANTS
    public static final int LANG_ID_ENGLISH = 20;
    public static final int LANG_ID_HINDI = 0;
    public static final int LANG_ID_GUJARATI = 1;
    public static final int LANG_ID_PUNJABI = 2;
    public static final int LANG_ID_MALAYALAM = 3;
    public static final int LANG_ID_TAMIL = 4;
    public static final int LANG_ID_TELUGU = 5;
    public static final int LANG_ID_KANNADA = 6;
    public static final int LANG_ID_ODIA = 7;
    public static final int LANG_ID_BENGALI = 8;
    public static final int LANG_ID_ASSAMESE = 9;
    public static final int LANG_ID_MAARTHI = 10;


    // LANGUAGE NAME CONSTANTS
    public static final String LANG_NAME_ENGLISH = "English";
    public static final String LANG_NAME_HINDI = "Hindi";
    public static final String LANG_NAME_GUJARATI = "Gujarati";
    public static final String LANG_NAME_PUNJABI = "Punjabi";
    public static final String LANG_NAME_MALAYALAM = "Malayalam";
    public static final String LANG_NAME_TAMIL = "Tamil";
    public static final String LANG_NAME_TELUGU = "Telugu";
    public static final String LANG_NAME_KANNADA = "Kannada";
    public static final String LANG_NAME_ODIA = "Odia";
    public static final String LANG_NAME_BENGALI = "Bengali";
    public static final String LANG_NAME_ASSAMESE = "Assamese";
    public static final String LANG_NAME_MAARTHI = "Marathi";


    // LANGUAGE LOCALE CODE CONSTANTS
    public static final String LANG_CODE_ENGLISH = "en";
    public static final String LANG_CODE_HINDI = "hi";
    public static final String LANG_CODE_GUJARATI = "gu";
    public static final String LANG_CODE_PUNJABI = "pa";
    public static final String LANG_CODE_MALAYALAM = "ml";
    public static final String LANG_CODE_TAMIL = "ta";
    public static final String LANG_CODE_TELUGU = "te";
    public static final String LANG_CODE_KANNADA = "kn";
    public static final String LANG_CODE_ODIA = "or";
    public static final String LANG_CODE_BENGALI = "bn";
    public static final String LANG_CODE_ASSAMESE = "as";
    public static final String LANG_CODE_MAARTHI = "mr";


    public static ArrayList<LangModel> getLangs() {
        ArrayList<LangModel> langs = new ArrayList<LangModel>();
        langs.add(new LangModel(LANG_ID_ENGLISH, LANG_NAME_ENGLISH, LANG_CODE_ENGLISH));
        langs.add(new LangModel(LANG_ID_HINDI, LANG_NAME_HINDI, LANG_CODE_HINDI));
        langs.add(new LangModel(LANG_ID_GUJARATI, LANG_NAME_GUJARATI, LANG_CODE_GUJARATI));
        langs.add(new LangModel(LANG_ID_PUNJABI, LANG_NAME_PUNJABI, LANG_CODE_PUNJABI));
        langs.add(new LangModel(LANG_ID_MALAYALAM, LANG_NAME_MALAYALAM, LANG_CODE_MALAYALAM));
        langs.add(new LangModel(LANG_ID_TAMIL, LANG_NAME_TAMIL, LANG_CODE_TAMIL));
        langs.add(new LangModel(LANG_ID_TELUGU, LANG_NAME_TELUGU, LANG_CODE_TELUGU));
        langs.add(new LangModel(LANG_ID_KANNADA, LANG_NAME_KANNADA, LANG_CODE_KANNADA));
        langs.add(new LangModel(LANG_ID_ODIA, LANG_NAME_ODIA, LANG_CODE_ODIA));
        langs.add(new LangModel(LANG_ID_BENGALI, LANG_NAME_BENGALI, LANG_CODE_BENGALI));
        langs.add(new LangModel(LANG_ID_ASSAMESE, LANG_NAME_ASSAMESE, LANG_CODE_ASSAMESE));
        langs.add(new LangModel(LANG_ID_MAARTHI, LANG_NAME_MAARTHI, LANG_CODE_MAARTHI));

        return langs;
    }

}
