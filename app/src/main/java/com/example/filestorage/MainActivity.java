package com.example.filestorage;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button fileStuffBtn;
    Typeface typeFaceOb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            fileStuffBtn = findViewById(R.id.btnFileStuff);
            typeFaceOb = Typeface.createFromAsset(getAssets(),"robotcon.ttf");
            fileStuffBtn.setTypeface(typeFaceOb);
            fileStuffBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        String str="";
                        StringBuffer buf = new StringBuffer();
                        InputStream is = getAssets().open("file_storage_test.txt");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                        if (is!=null)
                        {
                            while ((str = reader.readLine()) != null)
                            {
                                buf.append(str + "\n" );
                            }
                        }
                        is.close();
                        Toast.makeText(getBaseContext(), buf.toString(), Toast.LENGTH_LONG).show();
                    } catch (Exception e)
                    {

                    }

                }
            });
        } catch (Exception e)
        {

        }


    }
}
