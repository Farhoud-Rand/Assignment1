package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private List<Category> categories;
    private RecyclerView categoryRecyclerView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Switch aSwitch;
    boolean darkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch = findViewById(R.id.switchDarkMode);

        // Initialize SharedPreferences (I use shared preference in order to save the mode)
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        darkMode = sharedPreferences.getBoolean("night",false); // Light mode is the default mode

        // Check the value of the switch
        if (darkMode){
            aSwitch.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        // Update the value in shared preference according to the switch
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (darkMode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night",false);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night",true);
                }
                editor.apply();
            }
        });

        // Populate the list of categories
        categories = new ArrayList<>();
        Drawable shape1 = getResources().getDrawable(R.drawable.image1); // get the shape drawable from the resources

        categories.add(new Category("مربع",shape1, Arrays.asList(
                new Item("المساحة", getString(R.string.AreaOfSquare),1),
                new Item("المحيط", getString(R.string.PerimeterOfSquare),2)
        )));
        Drawable shape2 = getResources().getDrawable(R.drawable.image2); // get the shape drawable from the resources

        categories.add(new Category("مستطيل", shape2,Arrays.asList(
                new Item("المساحة", getString(R.string.AreaOfRectangle),3),
                new Item("المحيط", getString(R.string.PerimeterOfRectangle),4)
        )));

        Drawable shape3 = getResources().getDrawable(R.drawable.image3); // get the shape drawable from the resources

        categories.add(new Category("مثلث",shape3, Arrays.asList(
                new Item("المساحة", getString(R.string.AreaOfTriangle),5),
                new Item("المحيط", getString(R.string.PerimeterOfTriangle),6)
        )));

        Drawable shape4 = getResources().getDrawable(R.drawable.image4); // get the shape drawable from the resources

        categories.add(new Category("دائرة",shape4, Arrays.asList(
                new Item("المساحة", getString(R.string.AreaOfCircle),7),
                new Item("المحيط", getString(R.string.PerimeterOfCircle),8)
        )));

        Drawable shape5 = getResources().getDrawable(R.drawable.image5); // get the shape drawable from the resources

        categories.add(new Category("شبه منحرف",shape5, Arrays.asList(
                new Item("المساحة", getString(R.string.AreaOfTrapezoid),9),
                new Item("المحيط", getString(R.string.PerimeterOfTrapezoid),10)
        )));

        Drawable shape6 = getResources().getDrawable(R.drawable.image6); // get the shape drawable from the resources

        categories.add(new Category("معين",shape6, Arrays.asList(
                new Item("المساحة", getString(R.string.AreaOfDiamond),11),
                new Item("المحيط", getString(R.string.PerimeterOfDiamond),12)
        )));

        Drawable shape7 = getResources().getDrawable(R.drawable.image7); // get the shape drawable from the resources

        categories.add(new Category("متوازي الاضلاع",shape7, Arrays.asList(
                new Item("المساحة", getString(R.string.AreaOfParallelogram),13),
                new Item("المحيط", getString(R.string.PerimeterOfParallelogram),14)
        )));

        // Create a new instance of the CategoryAdapter and pass in the list of categories
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);

        // Get a reference to the RecyclerView in the layout and set the adapter
        categoryRecyclerView = findViewById(R.id.category_list);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
