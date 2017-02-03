package com.chootdev.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chootdev.errorlogger.ErrorLogger;
import com.chootdev.errorlogger.model.LoggerModel;

import java.util.List;

public class SampleActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        tv = (TextView) findViewById(R.id.tv);

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 30; i++) {
                    ErrorLogger.with(getApplicationContext())
                            .add(new LoggerModel("Test title " + i + 1, "Test message " + i + 1));

                    tv.setText("Insertng records to db....");

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            List<LoggerModel> loggerModels = ErrorLogger.with(getApplicationContext()).getAllRecords();
                            String s = "";
                            for (LoggerModel model : loggerModels) {
                                s = s+"Result : \n"+model.getActivityName()+" "+model.getId()+" "+model.getDate()+" "+model.getMessage()+" "+model.getTitle()+"\n";
                            }

                            tv.setText(s);
                        }
                    }, 2000);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggerModel model = ErrorLogger.with(getApplicationContext())
                                               .getLogRecord(1);
                tv.setText("Result : \n"+model.getActivityName()+" "+model.getId()+" "+model.getDate()+" "+model.getMessage()+" "+model.getTitle()+"\n");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<LoggerModel> loggerModels = ErrorLogger.with(getApplicationContext()).getAllRecords();
                String s = "";
                for (LoggerModel model : loggerModels) {
                    s = s+"Result : \n"+model.getActivityName()+" "+model.getId()+" "+model.getDate()+" "+model.getMessage()+" "+model.getTitle()+"\n";
                }

                tv.setText(s);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ErrorLogger.with(getApplicationContext()).clearLogger();
                tv.setText("All records cleared.... calling insert data....");

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 30; i++) {
                            ErrorLogger.with(getApplicationContext())
                                    .add(new LoggerModel("Test title " + i + 1, "Test message " + i + 1));

                            tv.setText("Insertng records to db....");

                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    List<LoggerModel> loggerModels = ErrorLogger.with(getApplicationContext()).getAllRecords();
                                    String s = "";
                                    for (LoggerModel model : loggerModels) {
                                        s = s+"Result : \n"+model.getActivityName()+" "+model.getId()+" "+model.getDate()+" "+model.getMessage()+" "+model.getTitle()+"\n";
                                    }

                                    tv.setText(s);
                                }
                            }, 2000);
                        }
                    }
                }, 2000);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<LoggerModel> loggerModels = ErrorLogger.with(getApplicationContext()).getMostRecent(20,true);
                String s = "";
                for (LoggerModel model : loggerModels) {
                    s = s+"Result : \n"+model.getActivityName()+" "+model.getId()+" "+model.getDate()+" "+model.getMessage()+" "+model.getTitle()+"\n";
                }

                tv.setText(s);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<LoggerModel> loggerModels = ErrorLogger.with(getApplicationContext()).getMostRecent(20,false);
                String s = "";
                for (LoggerModel model : loggerModels) {
                    s = s+"Result : \n"+model.getActivityName()+" "+model.getId()+" "+model.getDate()+" "+model.getMessage()+" "+model.getTitle()+"\n";
                }

                tv.setText(s);
            }
        });
    }
}
