package com.example.myapplication.ui.Main;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        drawerLayout=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);

        toolbar.setTitle("dsd");
        navController = Navigation.findNavController(this, R.id.container);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.item1) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item1fragment);
        }
        if (menuItem.getItemId() == R.id.item2) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item2fragment);
        }
        if (menuItem.getItemId() == R.id.item3) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item3fragment);
        }
        if (menuItem.getItemId() == R.id.item4) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item4fragment);
        }
        if (menuItem.getItemId() == R.id.item5) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item5fragment);
        }
        if (menuItem.getItemId() == R.id.item6) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item6fragment);
        }
        if (menuItem.getItemId() == R.id.item7) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item7fragment);
        }
        if (menuItem.getItemId() == R.id.item8) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item8fragment);
        }
        if (menuItem.getItemId() == R.id.item9) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item9fragment);
        }
        if (menuItem.getItemId() == R.id.item10) {
            drawerLayout.closeDrawers();
            navController.navigate(R.id.action_accountFragment_to_item10fragment);
        }
        if (menuItem.getItemId() == R.id.item11) {
            drawerLayout.closeDrawers();
            finish();
        }
        return false;

    }
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, drawerLayout);
    }
}
