package com.example.pooja.songs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Created by Pooja on 16-02-2016.
 */
public class Songsadapter extends BaseAdapter {
    private final Context context;
    private final String[] songs;
    private final String[] artists;
    private final int[] thumbnails;
    private final String[] videolinks;
    private final String[] songwiki;
    private final String[] artistwiki;
    private static LayoutInflater layoutInflater=null;

    public Songsadapter(Context context, String[] songs,String[] artists,int[] thumbnails,String[] videolinks,String[] songwiki,String[] artistwiki) {
        this.context = context;
        this.songs=songs;
        this.artists=artists;
        this.thumbnails=thumbnails;
        this.videolinks=videolinks;
        this.songwiki=songwiki;
        this.artistwiki=artistwiki;
        layoutInflater =(LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    //holder for rowlayout
    public class Holder
    {
        TextView songtitle;
        TextView artist;
        ImageView thumbnail;
    }


    @Override
    public int getCount() {
        return songs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowview = layoutInflater.inflate(R.layout.rowlayout, null); // inflate the rowlayout for list item's view
            holder.songtitle = (TextView) rowview.findViewById(R.id.song);
            holder.artist = (TextView) rowview.findViewById(R.id.artist);
            holder.thumbnail = (ImageView) rowview.findViewById(R.id.thumbnail);
            holder.songtitle.setText(songs[position]);// set the song name
            holder.artist.setText(artists[position]); // set the artist's name
            holder.thumbnail.setImageResource(thumbnails[position]); // set the thumbnail for video
            holder.thumbnail.setScaleType(ImageView.ScaleType.FIT_XY); // to fit accordingly as a square in center

         rowview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(videolinks[position])); // when clicked on listitem, view the corresponding browser page playing video
                context.startActivity(i);
            }
        });

        return rowview;
    }
}
