package com.usj.android2024

// Import statements are used to import classes that the file needs to use.
import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.usj.android2024.databinding.ActivityD4Binding

// Define a global constant for use as the key to retrieve the client's name from the intent.
const val NAME_ID = "MARIO_GOMEZ"

class ActivityD4 : AppCompatActivity() {
    // Lazy initialization of the view binding for your activity to improve performance.
    private val view by lazy { ActivityD4Binding.inflate(layoutInflater) }
    // Define constants for the weights of each product.
    private val weightP1 = 115
    private val weightP2 = 17
    private val weightP3 = 83

    // The onCreate function is called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sets the view for the activity to be the root of the view from the binding.
        setContentView(view.root)

        // Retrieve the client's name from the previous activity's intent and set it to the TextView.
        val intent = intent
        view.tvName.text = intent.getStringExtra(NAME_ID)

        // Define a listener that reacts to changes in the state of the check boxes.
        val checkBoxListener = CompoundButton.OnCheckedChangeListener { _, _ -> calculateWeight()}
        // Attach the listener to each check box.
        view.cbProduct1.setOnCheckedChangeListener(checkBoxListener)
        view.cbProduct2.setOnCheckedChangeListener(checkBoxListener)
        view.cbProduct3.setOnCheckedChangeListener(checkBoxListener)

        // Initial calculation of the total weight when the activity is created.
        calculateWeight()
    }

    // Function to calculate the total weight based on the selected products.
    private fun calculateWeight() {
        // Initialize the total weight to 0.
        var total = 0

        // Add the weight of product 1 if its corresponding check box is checked.
        if(view.cbProduct1.isChecked) total += this.weightP1
        // Add the weight of product 2 if its corresponding check box is checked.
        if(view.cbProduct2.isChecked) total += this.weightP2
        // Add the weight of product 3 if its corresponding check box is checked.
        if(view.cbProduct3.isChecked) total += this.weightP3

        // Set the calculated total weight as text of the TextView.
        view.tvTotalValue.text = total.toString()
    }
}
