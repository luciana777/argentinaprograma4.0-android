package com.example.applicacion1

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.applicacion1.databinding.ActivityMainBinding
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: ComparisonViewModel
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var btnCompare: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the views using findViewById
        editText1 = findViewById<EditText>(R.id.editText1)
        editText2 = findViewById<EditText>(R.id.editText2)
        btnCompare = findViewById<Button>(R.id.btnCompare)
        resultTextView = findViewById<TextView>(R.id.resultTextView)

        viewModel = ViewModelProvider(this).get(ComparisonViewModel::class.java)

        btnCompare.setOnClickListener {
            val str1 = editText1.text.toString()
            val str2 = editText2.text.toString()
            val areEqual = viewModel.compareStrings(str1, str2)

            resultTextView.text = if (areEqual) "Las cadenas son iguales" else "Las cadenas no son iguales"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}