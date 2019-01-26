package com.elmartiraciplus.pc.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Selahattin on 14.12.2017.
 */
public class MainCircleActivity extends AppCompatActivity {
    private CircleMenuLayout mCircleMenuLayout;
    private String[] mItemTexts = new String[]{"Satýþ", "Hakkýnda", "Cari", "Ýletiþim", "Banka", "Hesap Oluþtur"};
    private int[] mItemImgs = new int[]{R.drawable.sales,
            R.drawable.about,
            R.drawable.customer,
            R.drawable.contact,
            R.drawable.bank,
            R.drawable.caritanimla
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);
        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        button = (ImageView) findViewById(R.id.img);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                if (mItemTexts[pos].equals("Satýþ") || mItemTexts[pos].equals("Cari"))
                    //AcikHesapDialog();
                else if (mItemTexts[pos].equals("Hakkýnda")) //Hakkinda();
                else if (mItemTexts[pos].equals("Ýletiþim")) //Iletisim();
                else if (mItemTexts[pos].equals("Banka")) //Banka();
                else if (mItemTexts[pos].equals("Hesap Oluþtur")) //FirmaHesabiAc();
            }

            @Override
            public void itemCenterClick(View view) {
               
            }
        });
        startTime();
    }
	
    public void startTime() {
        mHandler.removeCallbacks(mUpdateTimeTask);
        mHandler.postDelayed(mUpdateTimeTask, 2000);
    }

    protected void onStop() {
        super.onStop();
    }

    public Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            final Animation myAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
            button.startAnimation(myAnim);
            mHandler.postDelayed(this, 2000);
        }
    };
}
