package com.example.worldtvgo;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;

import com.example.worldtvgo.databinding.ActivityPlayerBinding;

public class Player extends AppCompatActivity {
    ExoPlayer exoPlayer;
    Player player;

    ActivityPlayerBinding activityPlayerBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPlayerBinding=ActivityPlayerBinding.inflate(getLayoutInflater());
        View view=activityPlayerBinding.getRoot();

        setContentView(view);

        ExoPlayer exoPlayer = new ExoPlayer.Builder(this).build();
        activityPlayerBinding.player.setPlayer(exoPlayer);

        MediaItem mediaItem = MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.play();


    }
}