package com.example.tastebud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;
    private ListView resultsListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        resultsListView = findViewById(R.id.resultsListView);

        recipeList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeList);
        resultsListView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchEditText.getText().toString();
                if (!query.isEmpty()) {
                    searchRecipes(query);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a search term", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
//                    case R.id.home:
//                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.search:
//                        Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.favorites:
//                        Toast.makeText(MainActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.profile:
//                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
//                        return true;
                }
                return false;
            }
        });
    }

    private void searchRecipes(String query) {
        // Mock search result for demonstration
        recipeList.clear();
        recipeList.add("Recipe 1 - Ingredients and Instructions");
        recipeList.add("Recipe 2 - Ingredients and Instructions");
        recipeList.add("Recipe 3 - Ingredients and Instructions");
        adapter.notifyDataSetChanged();

        // Normally you would perform an API call to fetch results here
        // Example:
        // fetchRecipesFromAPI(query);
    }

    // Example method for making API call (not implemented)
    private void fetchRecipesFromAPI(String query) {
        // Perform network request and update recipeList
    }
}
