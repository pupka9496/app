package ru.jdrm.jdrmapp.design;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.jdrm.jdrmapp.AuditFragment;
import ru.jdrm.jdrmapp.ChatFragment;
import ru.jdrm.jdrmapp.DiagramFragment;
import ru.jdrm.jdrmapp.EventFragment;
import ru.jdrm.jdrmapp.R;


public class NavBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_bar_acticity);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        ChatFragment firstFragment = new ChatFragment();
        AuditFragment secondFragment = new AuditFragment();
        EventFragment thirdFragment = new EventFragment();
        DiagramFragment fourFragment = new DiagramFragment();

        @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.navFactory) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fourFragment).commit();
            return true;
        } else if (itemId == R.id.navChat) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, firstFragment).commit();
            return true;
        } else if (itemId == R.id.navAudit) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, secondFragment).commit();
            return true;
        } else if (itemId == R.id.navEvent) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, thirdFragment).commit();
            return true;
        }
        return false;
    }};
}


