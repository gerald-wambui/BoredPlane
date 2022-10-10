package com.example.boredplane;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivityX extends AppCompatActivity {
    private boolean isMute;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        findViewById(R.id.play).setOnClickListener(view -> startActivity(new Intent(MainActivityX.this, GameViewx.class)));
        TextView highScoreTxt = findViewById(R.id.highScoreTxt);
        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        highScoreTxt.setText("HighScore: " + prefs.getInt("highscore", 0));
        isMute = prefs.getBoolean("isMute", false);
        final ImageView volumeCtrl = findViewById(R.id.volumeCtrl);
        if (isMute)
            volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
        else
            volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
        volumeCtrl.setOnClickListener(view -> {
            isMute = !isMute;
            if (isMute)
                volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
            else
                volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("isMute", isMute);
            editor.apply();
        });
    }
}

