package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kunminx.player.DefaultPlayerManager;
import com.kunminx.player.bean.DefaultAlbum;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DefaultAlbum album = new DefaultAlbum();
        //为专辑添加作者
        DefaultAlbum.DefaultArtist defaultArtist = new DefaultAlbum.DefaultArtist();
        defaultArtist.setName("Leon");
        album.setArtist(defaultArtist);

        //为专辑添加封面
        album.setCoverImg("https://images.io/055ef18.png");

        //创建音乐实例
        List<DefaultAlbum.DefaultMusic> musics = new ArrayList<>();

        DefaultAlbum.DefaultMusic music = new DefaultAlbum.DefaultMusic();
        music.setCoverImg("https://images.io/055ef19.png");
        music.setUrl("https://files.freemusicarchive.org/storage-freemusicarchive-org/music/ccCommunity/Kai_Engel/Irsens_Tale/Kai_Engel_-_03_-_Irsens_Tale.mp3");
        music.setArtist(defaultArtist);
        music.setTitle("Music1");
        music.setMusicId("001");
        musics.add(music);

        DefaultAlbum.DefaultMusic music1 = new DefaultAlbum.DefaultMusic();
        music1.setCoverImg("https://images.io/055ef20.png");
        music1.setUrl("https://files.freemusicarchive.org/storage-freemusicarchive-org/music/ccCommunity/Kai_Engel/Irsens_Tale/Kai_Engel_-_03_-_Irsens_Tale.mp3");
        music1.setArtist(defaultArtist);
        music1.setTitle("Music2");
        music1.setMusicId("002");
        musics.add(music1);

        //将音乐添加到专辑
        album.setMusics(musics);
        //一行代码完成数据的初始化
        DefaultPlayerManager.getInstance().loadAlbum(album);

        TextView tv = findViewById(R.id.hello_tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DefaultPlayerManager.getInstance().playNext();
            }
        });

    }
}