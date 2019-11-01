package app.bugchain.architecturemvvm.view.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import app.bugchain.architecturemvvm.R
import app.bugchain.architecturemvvm.core.databinding.inflaters.contentView
import app.bugchain.architecturemvvm.core.view.MATCH_PARENT
import app.bugchain.architecturemvvm.core.view.WRAP_CONTENT
import app.bugchain.architecturemvvm.databinding.ActivityMainBinding
import app.bugchain.architecturemvvm.view.form.SimpleFormActivity

private val PARTS = arrayOf(
    "1. Simple From" to SimpleFormActivity::class.java,
    "2. Simple Reactive List" to SimpleFormActivity::class.java,
    "3. Dialog" to SimpleFormActivity::class.java,
    "4. Room Database" to SimpleFormActivity::class.java,
    "5. Interractive List" to SimpleFormActivity::class.java
)

class MainActivity : AppCompatActivity() {

    private val binding by contentView<ActivityMainBinding>(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.parts.removeAllViews()

        PARTS.forEach { part ->
            Button(this).let { button ->
                button.text = part.first
                button.setOnClickListener { startActivity(Intent(this, part.second)) }
                binding.parts.addView(button, MATCH_PARENT, WRAP_CONTENT)
            }
        }
    }
}
