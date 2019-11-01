package app.bugchain.architecturemvvm.view.form

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.bugchain.architecturemvvm.R
import app.bugchain.architecturemvvm.core.arch.viewmodel.viewModel
import app.bugchain.architecturemvvm.core.databinding.inflaters.contentView
import app.bugchain.architecturemvvm.databinding.ActivitySimpleFormBinding

class SimpleFormActivity : AppCompatActivity() {

    private val binding by contentView<ActivitySimpleFormBinding>(R.layout.activity_simple_form)
    private val model by viewModel<FormViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.model = model
        model.successMessageCommand.observe(this) {
            showSuccessMessage()
        }
    }

    private fun showSuccessMessage() {
        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
    }
}