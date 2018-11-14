package com.example.duncan.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int WillId = getResources().getIdentifier("app31", "drawable", getPackageName());
        int MarlieId = getResources().getIdentifier("app35", "drawable", getPackageName());
        int DeanId = getResources().getIdentifier("app32", "drawable", getPackageName());
        int ColinId = getResources().getIdentifier("app34", "drawable", getPackageName());
        int ToosId = getResources().getIdentifier("app33", "drawable", getPackageName());

        Friend Will = new Friend("Will", "Hoi allemaal, ik ben Will!", WillId);
        Friend Marlie = new Friend("Marlie", "Hoi allemaal, ik ben Marlie!", MarlieId);
        Friend Dean = new Friend("Dean", "Hoi allemaal, ik ben Dean!", DeanId);
        Friend Colin = new Friend("Colin", "Hoi allemaal, ik ben Colin!", ColinId);
        Friend Toos = new Friend("Toos", "Hoi allemaal, ik ben Tood!", ToosId);

        friends.add(Will);
        friends.add(Marlie);
        friends.add(Dean);
        friends.add(Colin);
        friends.add(Toos);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        GridView gv = findViewById(R.id.gridView);
        gv.setOnItemClickListener(new GridItemClickListener());
    }


    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);


        }
    }


}