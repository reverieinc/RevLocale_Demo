package com.reverie.revlocale;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity {

    private TextView homeMsgTV;
    private ImageView revLangPickerIV;
    private RelativeLayout homeLangPickerRL;
    private ListView langPickerLV;

    ArrayList<LangModel> langs = new ArrayList<LangModel>();
    private LangAdapter langAdapter;

    private int selectedLangId = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeMsgTV = (TextView) findViewById(R.id.homeMsgTV);
        revLangPickerIV = (ImageView) findViewById(R.id.revLangPickerIV);
        homeLangPickerRL = (RelativeLayout) findViewById(R.id.homeLangPickerRL);

        langPickerLV = (ListView) findViewById(R.id.langPickerLV);
        langAdapter = new LangAdapter(MainActivity.this);
        langPickerLV.setAdapter(langAdapter);


        initLangPicker();

        revLangPickerIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(View.VISIBLE == homeLangPickerRL.getVisibility()) {
                    hideLangPicker();
                }
                else if(View.GONE == homeLangPickerRL.getVisibility()) {
                    showLangPicker();
                    initLangPicker();
                }
            }
        });

        homeLangPickerRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(View.VISIBLE == homeLangPickerRL.getVisibility()) {
                    hideLangPicker();
                }
            }
        });

    }


    @Override
    public void onBackPressed() {
        if(View.VISIBLE == homeLangPickerRL.getVisibility()) {
            hideLangPicker();
        }
        else {
            super.onBackPressed();
        }
    }


    public void setResources() {
        homeMsgTV.setText(R.string.sample_text);
    }



    public void showLangPicker() {
        homeLangPickerRL.setVisibility(View.VISIBLE);
    }

    public void hideLangPicker() {
        homeLangPickerRL.setVisibility(View.GONE);
    }


    public void initLangPicker() {
        langAdapter.updateEntries(RevConstants.getLangs());
    }


    private boolean updateResources(Context context, String languageLocaleCode) {
        try {
            /**
             *  Set device locale to use resource as per language.
             *  use language code to set locale as follows:
             *  English - en, Hindi - hi, Gujarati - gu, Punjabi - pa, Malayalam - ml,
             *  Tamil - ta, Telugu - te, Kannada - kn, Odia - or, Bengali - bn, Assamese - as, Marathi - mr
             */
            Locale locale = new Locale(languageLocaleCode);
            Locale.setDefault(locale);

            Resources resources = context.getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = locale;

            resources.updateConfiguration(configuration, resources.getDisplayMetrics());

            // call all setText of TextViews used for this activity to refresh multi-language resources
            setResources();
        }
        catch (Exception e) {
            e.printStackTrace();
            return  false;
        }

        return true;
    }


    private class LangAdapter extends BaseAdapter {
        Activity adapterActivity;

        public LangAdapter(Activity a) {
            adapterActivity = a;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = adapterActivity.getLayoutInflater();
            View view = inflater.inflate(R.layout.row_lang, null);

            TextView langTV = (TextView) view.findViewById(R.id.langTV);
            final LangModel langModel = langs.get(position);

            langTV.setText(langModel.name);

            if(langModel.id == selectedLangId) {
                langTV.setTextColor(Color.CYAN);
            }
            else {
                langTV.setTextColor(Color.WHITE);
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedLangId = langModel.id;
                    hideLangPicker();
                    updateResources(adapterActivity.getApplicationContext(), langModel.code);
                }
            });

            return view;
        }

        @Override
        public int getCount() {
            return langs.size();
        }

        @Override
        public Object getItem(int position) {
            return langs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void updateEntries(ArrayList<LangModel> result) {
            langs.clear();
            langs.addAll(result);
            notifyDataSetChanged();
        }
    }

}
