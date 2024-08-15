package com.example.worldtvgo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import com.example.worldtvgo.databinding.ActivityMoviePlayerBinding;

public class MoviePlayer extends AppCompatActivity implements View.OnClickListener{
  ExoPlayer exoPlayer;
    private PopupWindow settingsPopupWindow;
    ActivityMoviePlayerBinding activityMoviePlayerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMoviePlayerBinding= ActivityMoviePlayerBinding.inflate(getLayoutInflater());
        View view=activityMoviePlayerBinding.getRoot();

        setContentView(view);

        exoPlayer = new ExoPlayer.Builder(this).build();
        activityMoviePlayerBinding.playerView.setPlayer(exoPlayer);
        activityMoviePlayerBinding.playerView.setKeepScreenOn(true);

        MediaItem mediaItem = MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.seekTo((int) exoPlayer.getCurrentPosition(), C.TIME_UNSET);
        exoPlayer.play();

        activityMoviePlayerBinding.playerView.findViewById(R.id.settings).setOnClickListener(this);
        activityMoviePlayerBinding.playerView.findViewById(R.id.next).setOnClickListener(this);
        activityMoviePlayerBinding.playerView.findViewById(R.id.prev).setOnClickListener(this);




//        hideSystemUI();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exoPlayer != null) {
            exoPlayer.release();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(exoPlayer.isPlaying()){
            exoPlayer.stop();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (exoPlayer == null) {
            exoPlayer = new ExoPlayer.Builder(this).build();
        }
        exoPlayer.setPlayWhenReady(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.setPlayWhenReady(false);
        exoPlayer.getPlaybackState();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.getPlaybackState();
    }


    @Override
    public void onClick(View v) {
        int id=v.getId();


        if(id==R.id.next){

            long currentPosition=exoPlayer.getCurrentPosition();
            long newPosition=currentPosition+10000;
            exoPlayer.seekTo(newPosition);

        }

        if(id==R.id.prev){
            long currentPosition=exoPlayer.getCurrentPosition();
            long newPosition=currentPosition-10000;
            exoPlayer.seekTo(newPosition);
        }

        if(id==R.id.settings){
            showMainPopupWindow(v);

        }
    }



    private void showMainPopupWindow(View anchor){
        View timeBar=activityMoviePlayerBinding.playerView.findViewById(R.id.exo_progress);

        LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView=inflater.inflate(R.layout.popup_menu,null);
        PopupWindow popupWindow=new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.setting_popup_background));

        // Measure the content view of the PopupWindow
        popupView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
        int popupHeight=popupView.getMeasuredHeight();
        int popupWidth=popupView.getMeasuredWidth();

        int[] location=new int[2];
        timeBar.getLocationOnScreen(location);

        // Define additional spacing from the screen edge
        int additionalSpacing = 53;


        DisplayMetrics displayMetrics=new DisplayMetrics();
        ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth=displayMetrics.widthPixels;

        // Calculate the position to show the PopupWindow above the time bar
        int xPos=screenWidth-popupWidth-additionalSpacing;// Position at the right end of the screen


        int spacing=1;
        int yPos=location[1]-popupHeight-spacing;// Position above the time bar

        // Show the PopupWindow
        popupWindow.showAtLocation(activityMoviePlayerBinding.playerView, Gravity.NO_GRAVITY,xPos,yPos);

        activityMoviePlayerBinding.playerView.setControllerVisibilityListener(new PlayerView.ControllerVisibilityListener() {
            @Override
            public void onVisibilityChanged(int visibility) {
                if (visibility == View.GONE && popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
            }
        });


        // Set up click listeners for the popup menu items

        TextView quality=popupView.findViewById(R.id.action_quality);
        TextView subTitle=popupView.findViewById(R.id.action_subtitles);
        TextView playBackSpeed=popupView.findViewById(R.id.action_playback_speed);

        quality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQualityDialogue(anchor);
                popupWindow.dismiss();
            }
        });

        subTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showSubtitlesDialog(anchor);
                popupWindow.dismiss();
            }
        });

        playBackSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showPlaybackSpeedDialog(anchor);
                popupWindow.dismiss();
            }
        });

    }

    private void showQualityDialogue(View anchor) {
        View timeBar=activityMoviePlayerBinding.playerView.findViewById(R.id.exo_progress);

        LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View qualityPopUpView=inflater.inflate(R.layout.popup_quality,null);

        if (qualityPopUpView == null) {
            Log.e("PopupWindow", "Error: View not inflated!");
            return;
        }
        final PopupWindow qualityPopupWindow=new PopupWindow(qualityPopUpView,
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);

        qualityPopupWindow.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.setting_popup_background));

        // Measure the content view of the PopupWindow
        qualityPopUpView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
        int popupHeight= qualityPopUpView.getMeasuredHeight();
        int popupWidth= qualityPopUpView.getMeasuredWidth();

        int[] location=new int[2];
        timeBar.getLocationOnScreen(location);

        // Define additional spacing from the screen edge
         int additionalSpacing = 53;


        DisplayMetrics displayMetrics=new DisplayMetrics();
        ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth=displayMetrics.widthPixels;

        // Calculate the position to show the PopupWindow above the time bar
        int xPos=screenWidth-popupWidth-additionalSpacing;// Position at the right end of the screen


        int spacing=1;
        int yPos=location[1]-popupHeight-spacing;// Position above the time bar


        qualityPopUpView.setFocusableInTouchMode(true);
        activityMoviePlayerBinding.playerView.setControllerVisibilityListener(new PlayerView.ControllerVisibilityListener() {
            @Override
            public void onVisibilityChanged(int visibility) {
                if (visibility == View.GONE && qualityPopupWindow != null && qualityPopupWindow.isShowing()) {
                    qualityPopupWindow.dismiss();
                }
            }
        });

        ImageView backButton = qualityPopUpView.findViewById(R.id.quality_back);

        // Check if backButton is null (for debugging purposes)
        if (backButton == null) {
            Log.e("MoviePlayer", "quality_back ImageView is null");
            return;  // Exit the method if the ImageView is not found
        }

        // Set OnClickListener for the back button
        backButton.setOnClickListener(v -> {
            // Handle the back button click
            qualityPopupWindow.dismiss();
            // Optionally, show the main settings popup again
            showMainPopupWindow(anchor);
        });
        qualityPopupWindow.showAtLocation(activityMoviePlayerBinding.playerView,Gravity.NO_GRAVITY,xPos,yPos);

    }


    private void showSubtitlesDialog(View anchor) {
        View timeBar=activityMoviePlayerBinding.playerView.findViewById(R.id.exo_progress);

        LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View subtitlePopUpView=inflater.inflate(R.layout.popup_subtitle,null);

        if (subtitlePopUpView == null) {
            Log.e("PopupWindow", "Error: View not inflated!");
            return;
        }
        final PopupWindow subtitlePopupWindow=new PopupWindow(subtitlePopUpView,
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);

        subtitlePopupWindow.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.setting_popup_background));

        // Measure the content view of the PopupWindow
        subtitlePopUpView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
        int popupHeight= subtitlePopUpView.getMeasuredHeight();
        int popupWidth= subtitlePopUpView.getMeasuredWidth();

        int[] location=new int[2];
        timeBar.getLocationOnScreen(location);

        // Define additional spacing from the screen edge
        int additionalSpacing = 53;


        DisplayMetrics displayMetrics=new DisplayMetrics();
        ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth=displayMetrics.widthPixels;

        // Calculate the position to show the PopupWindow above the time bar
        int xPos=screenWidth-popupWidth-additionalSpacing;// Position at the right end of the screen


        int spacing=1;
        int yPos=location[1]-popupHeight-spacing;// Position above the time bar


        subtitlePopUpView.setFocusableInTouchMode(true);
        activityMoviePlayerBinding.playerView.setControllerVisibilityListener(new PlayerView.ControllerVisibilityListener() {
            @Override
            public void onVisibilityChanged(int visibility) {
                if (visibility == View.GONE && subtitlePopupWindow != null && subtitlePopupWindow.isShowing()) {
                    subtitlePopupWindow.dismiss();
                }
            }
        });

        ImageView backButton = subtitlePopUpView.findViewById(R.id.quality_back);

        // Check if backButton is null (for debugging purposes)
        if (backButton == null) {
            Log.e("MoviePlayer", "quality_back ImageView is null");
            return;  // Exit the method if the ImageView is not found
        }

        // Set OnClickListener for the back button
        backButton.setOnClickListener(v -> {
            // Handle the back button click
            subtitlePopupWindow.dismiss();
            // Optionally, show the main settings popup again
            showMainPopupWindow(anchor);
        });
        subtitlePopupWindow.showAtLocation(activityMoviePlayerBinding.playerView,Gravity.NO_GRAVITY,xPos,yPos);

    }


    private void showPlaybackSpeedDialog(View anchor) {
        View timeBar=activityMoviePlayerBinding.playerView.findViewById(R.id.exo_progress);

        LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View playbackPopUpView=inflater.inflate(R.layout.popup_playback_speed,null);

        if (playbackPopUpView == null) {
            Log.e("PopupWindow", "Error: View not inflated!");
            return;
        }
        final PopupWindow playbackPopupWindow=new PopupWindow(playbackPopUpView,
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);

        playbackPopupWindow.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.setting_popup_background));

        // Measure the content view of the PopupWindow
        playbackPopUpView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
        int popupHeight= playbackPopUpView.getMeasuredHeight();
        int popupWidth= playbackPopUpView.getMeasuredWidth();

        int[] location=new int[2];
        timeBar.getLocationOnScreen(location);

        // Define additional spacing from the screen edge
        int additionalSpacing = 53; // Adjust this value as needed


        DisplayMetrics displayMetrics=new DisplayMetrics();
        ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth=displayMetrics.widthPixels;

        // Calculate the position to show the PopupWindow above the time bar
        int xPos=screenWidth-popupWidth-additionalSpacing;// Position at the right end of the screen


        int spacing=1;
        int yPos=location[1]-popupHeight-spacing;// Position above the time bar


        playbackPopUpView.setFocusableInTouchMode(true);
        activityMoviePlayerBinding.playerView.setControllerVisibilityListener(new PlayerView.ControllerVisibilityListener() {
            @Override
            public void onVisibilityChanged(int visibility) {
                if (visibility == View.GONE && playbackPopupWindow != null && playbackPopupWindow.isShowing()) {
                    playbackPopupWindow.dismiss();
                }
            }
        });

        ImageView backButton = playbackPopUpView.findViewById(R.id.quality_back);

        // Check if backButton is null (for debugging purposes)
        if (backButton == null) {
            Log.e("MoviePlayer", "quality_back ImageView is null");
            return;  // Exit the method if the ImageView is not found
        }

        // Set OnClickListener for the back button
        backButton.setOnClickListener(v -> {
            // Handle the back button click
            playbackPopupWindow.dismiss();
            // Optionally, show the main settings popup again
            showMainPopupWindow(anchor);
        });
        playbackPopupWindow.showAtLocation(activityMoviePlayerBinding.playerView,Gravity.NO_GRAVITY,xPos,yPos);

    }


}