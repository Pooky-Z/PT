package com.example.a13218.demo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import com.example.a13218.demo.fragment.fragment1;
import com.example.a13218.demo.fragment.fragment2;
import com.example.a13218.demo.fragment.fragment3;
import com.example.a13218.demo.fragment.tabAdapter;
import com.example.a13218.demo.fragment.tabfragment1;
import com.example.a13218.demo.fragment.tabfragment2;
import com.example.a13218.demo.fragment.tabfragment3;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        com.example.a13218.demo.fragment.fragment1.OnFragmentInteractionListener,
        com.example.a13218.demo.fragment.fragment2.OnFragmentInteractionListener,
        com.example.a13218.demo.fragment.fragment3.OnFragmentInteractionListener,
        tabfragment1.OnFragmentInteractionListener,
        com.example.a13218.demo.fragment.tabfragment2.OnFragmentInteractionListener,
        com.example.a13218.demo.fragment.tabfragment3.OnFragmentInteractionListener{
    public static final String[] stitle=new String[]{"ITEM FIRST","ITEM SECOND","ITEM THIRD"};
    private Fragment fragment1,fragment2,fragment3;
    private Fragment[] fragments;
    private BottomNavigationView bottomNavigationView;
    private int LastFragment;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<Fragment> tab_fragments=new ArrayList<>();
    List<String> titles=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        com.getbase.floatingactionbutton.FloatingActionButton fab=findViewById(R.id.action_a);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initFragment();

    }
    private void initFragment(){
        fragment1=new fragment1();
        fragment2=new fragment2();
        fragment3=new fragment3();
        fragments=new Fragment[]{fragment1,fragment2,fragment3};
        LastFragment=0;
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview,fragment1).show(fragment1).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.action1:{
                    if(LastFragment!=0){
                        switchFragment(LastFragment,0);
                        LastFragment=0;
                    }
                    return true;
                }
                case R.id.action2:{
                    if(LastFragment!=1){
                        switchFragment(LastFragment,1);
                        LastFragment=1;
                    }
                    return true;
                }
                case R.id.action3:{
                    if(LastFragment!=2){
                        switchFragment(LastFragment,2);
                        LastFragment=2;
                    }
                    return true;
                }
            }
            return false;
        }
    };
    private void switchFragment(int lastFragment,int index){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastFragment]);
        if(fragments[index].isAdded()==false){
            transaction.add(R.id.mainview,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
    public void onFragmentInteraction(Uri uri){

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
