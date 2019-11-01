package app.bugchain.architecturemvvm.view.form

import android.view.View
import androidx.lifecycle.ViewModel
import app.bugchain.architecturemvvm.core.arch.livedata.SingleLiveEvent
import app.bugchain.architecturemvvm.core.arch.livedata.mediatorLiveData
import app.bugchain.architecturemvvm.core.arch.livedata.mutableLiveData
import app.bugchain.architecturemvvm.core.utils.uiThread
import java.util.*
import kotlin.concurrent.schedule

class FormViewModel : ViewModel() {

    val title = mutableLiveData("")
    val description = mutableLiveData("")
    val isPreviewShown = mutableLiveData(false)
    val isLoading = mutableLiveData(false)
    val loadingViewVisibility = mutableLiveData(View.GONE)

    val isSaveButtonEnabled = mediatorLiveData(title, isLoading) {
        !title.value.isNullOrEmpty() && isLoading.value != true
    }

    val successMessageCommand = SingleLiveEvent<Void>()

    fun handleSaveClick() {
        isLoading.value = true
        loadingViewVisibility.value = View.VISIBLE

        Timer().schedule(3000) {
            uiThread {
                isLoading.value = false
                loadingViewVisibility.value = View.GONE
                successMessageCommand.call()
            }
        }
    }
}