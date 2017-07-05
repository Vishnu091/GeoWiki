package com.example.lenovo.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView navList;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        navList=(ListView)findViewById(R.id.navlist);
        ArrayList<String> navArray= new ArrayList<String>();
        navArray.add("SOLAR SYSTEM");
        navArray.add("MERCURY");
        navArray.add("VENUS");
        navArray.add("EARTH");
        navArray.add("MARS");
        navArray.add("JUPITER");
        navArray.add("SATURN");
        navArray.add("URANUS");
        navArray.add("NEPTUNE");
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,navArray);
        navList.setAdapter(adapter);

        navList.setOnItemClickListener(this);
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        loadSelection(0);
    }

    private  void loadSelection(int i){
        navList.setItemChecked(i,true);
        switch (i){
            case 0:
                BlankFragment bf=new BlankFragment();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,bf);
                ft.commit();
                break;
            case 1:
                fragment1 f1=new fragment1();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,f1);
                ft.commit();
                break;
            case 2:
                fragment2 f2=new fragment2();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,f2);
                ft.commit();
                break;
            case 3:
                fragment3 f3=new fragment3();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,f3);
                ft.commit();
                break;
            case 4:
                fragment4 f4=new fragment4();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,f4);
                ft.commit();
                break;
            case 5:
                fragment5 f5=new fragment5();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,f5);
                ft.commit();
                break;
            case 6:
                fragment6 f6=new fragment6();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,f6);
                ft.commit();
                break;
            case 7:
                fragment7 f7=new fragment7();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,f7);
                ft.commit();
                break;
            case 8:
                fragment8 f8=new fragment8();
                ft=fm.beginTransaction();
                ft.replace(R.id.fragmentholder,f8);
                ft.commit();
                break;


        }
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id== android.R.id.home)
        {
            if(drawerLayout.isDrawerOpen(navList)){
                drawerLayout.closeDrawer(navList);
            }
            else
            {
                drawerLayout.openDrawer(navList);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        loadSelection(position);
        drawerLayout.closeDrawer(navList);
    }
}
