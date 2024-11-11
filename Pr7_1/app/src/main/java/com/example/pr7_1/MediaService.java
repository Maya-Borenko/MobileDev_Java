package com.example.pr7_1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import com.example.pr7_1.R;

public class MediaService extends Service {
    MediaPlayer ambientMediaPlayer;
    @Override
    public void onCreate(){
        ambientMediaPlayer = MediaPlayer.create(this, R.raw.music);
        ambientMediaPlayer.setLooping(true);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        ambientMediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        ambientMediaPlayer.stop();
    }
}
