package com.example.pooja.songs;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    //video URL's
    String[] videolinks = {"https://www.youtube.com/watch?v=8ELbX5CMomE", "https://www.youtube.com/watch?v=CmLhxeBU9h0", "https://www.youtube.com/watch?v=49rraTkHFeI",
    "https://www.youtube.com/watch?v=q9ayN39xmsI","https://www.youtube.com/watch?v=DbVz0jP722g","https://www.youtube.com/watch?v=jukv9Q1eR2g"};
    // URL's of songs wiki pages
    String[] songwiki={"https://en.wikipedia.org/wiki/Sorry_(Justin_Bieber_song)","https://en.wikipedia.org/wiki/Not_Afraid","https://en.wikipedia.org/wiki/Mockingbird_(Inez_%26_Charlie_Foxx_song)",
    "https://en.wikipedia.org/wiki/A_Thousand_Years_(Christina_Perri_song)","https://en.wikipedia.org/wiki/Paradise_(Coldplay_song)","https://en.wikipedia.org/wiki/Hall_of_Fame_(song)"};
    // URL's of artists wiki pages
    String[] artistwiki={"https://en.wikipedia.org/wiki/Justin_Bieber","https://en.wikipedia.org/wiki/Eminem","https://en.wikipedia.org/wiki/Eminem",
    "https://en.wikipedia.org/wiki/Christina_Perri","https://en.wikipedia.org/wiki/Coldplay","https://en.wikipedia.org/wiki/The_Script"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView lv = (ListView) findViewById(R.id.listView);
        // songs list
        String[] songs = new String[]{"Sorry - Lyric Video", "I am not afraid", "Mocking Bird","Thousand Years","Coldplay-Paradise","Hall of Fame"};
       // artist's list
        String[] artists = new String[]{"Justin Bieber", "Eminem", " Eminem","Christian Perri","Coldplay","The Script"};
        // thumbnails
        int[] thumbnails = new int[]{R.drawable._sorry_jb, R.drawable.iam_not_afraid, R.drawable._mocking_bird,R.drawable.thousandyears,
        R.drawable._coldplay,R.drawable.halloffame};
        Songsadapter adapter = new Songsadapter(this, songs, artists, thumbnails,videolinks,songwiki,artistwiki);
        lv.setAdapter(adapter);
        // setting the listview for context menu
        registerForContextMenu(lv);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // inflating the context menu containing the three options
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Intent i;
        switch (item.getItemId()) {
            // the case for viewing video clip
            case R.id.viewvideo:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(videolinks[info.position]));
                startActivity(i);
                return true;
            // choose the song's wiki page
            case R.id.songwiki:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(songwiki[info.position]));
                startActivity(i);
                return true;
            // choose artist's wiki page
            case R.id.viewartist:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(artistwiki[info.position])); // retrieving with listitem position
                startActivity(i);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}
